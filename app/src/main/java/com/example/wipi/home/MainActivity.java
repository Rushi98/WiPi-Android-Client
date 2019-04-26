package com.example.wipi.home;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wipi.R;
import com.example.wipi.data_display.PeopleActivity;
import com.example.wipi.data_display.SessionsActivity;
import com.example.wipi.map.MapModeActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvIsConnected;
    private TextView tvIsScanning;

    private String networkSsid = "wipi";

    private Button btnConnect;
    private Button btnScan;
    private Button btnMaP;
    private Button btnSessions;
    private Button peopleBtn;

    private boolean connectedStatus;
    private boolean isConnected;
    private boolean isScanning;
    private List<String> wipiList;

    private List<String> sessionData;

    WifiManager manager;
//    WifiConfiguration configuration;
//
//    IntentFilter networkFilter;
//
//    int netId;
//    BroadcastReceiver networkReceiver;

    private String connectedWipiName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        networkFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        manager = (WifiManager) getApplicationContext().
                getSystemService(Context.WIFI_SERVICE);
//
//        configuration = new WifiConfiguration();
//        configuration.SSID = String.format("\"%s\"", networkSsid);
//
//        netId = manager.addNetwork(configuration);

        connectedStatus = false;
        isConnected = false;
        isScanning = false;
        wipiList = new ArrayList<>();

        tvIsConnected = findViewById(R.id.tv_is_connected);
        tvIsScanning = findViewById(R.id.tv_is_scanning);

        btnConnect = findViewById(R.id.btn_connect);
        btnMaP = findViewById(R.id.btn_MaP);
        btnSessions = findViewById(R.id.btn_sessions);
        peopleBtn = findViewById(R.id.btn_people);
        btnScan = findViewById(R.id.btn_scan);

        toggleButtonsVisibility(isConnected);

        btnConnect.setOnClickListener(this);
        btnMaP.setOnClickListener(this);
        btnSessions.setOnClickListener(this);
        peopleBtn.setOnClickListener(this);
        btnScan.setOnClickListener(this);
    }

    public void toggleButtonsVisibility(boolean condition) {
        if (condition) {
            btnMaP.setVisibility(View.VISIBLE);
            btnSessions.setVisibility(View.VISIBLE);
            peopleBtn.setVisibility(View.VISIBLE);
            btnScan.setVisibility(View.VISIBLE);
            btnConnect.setText(getString(R.string.disconnect));
        } else {
            btnMaP.setVisibility(View.INVISIBLE);
            btnSessions.setVisibility(View.INVISIBLE);
            peopleBtn.setVisibility(View.GONE);
            btnScan.setVisibility(View.INVISIBLE);
            btnConnect.setText(getString(R.string.connect));
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.btn_connect):
                if (!connectedStatus) {
                    showWipiListDialog();
//                    connectedWipiName = "wipi";
//                    modifyLayoutOnConnected();
                } else {
                    showDisconnectDialog();
                }
                break;
            case (R.id.btn_sessions): {
                Intent sessionIntent = new Intent(MainActivity.this,
                        SessionsActivity.class);
                startActivity(sessionIntent);
            } break;
            case R.id.btn_people: {
                Intent peopleIntent = new Intent(this, PeopleActivity.class);
                startActivity(peopleIntent);
            } break;
            case (R.id.btn_scan):
                if (!isScanning) {
                    isScanning = true;
                    btnScan.setText(getString(R.string.stop_scan));
                    btnMaP.setVisibility(View.INVISIBLE);

                    String display_text = connectedWipiName+" : "+getString(R.string.scanning);
                    tvIsScanning.setText(display_text);

                    new ScanRequest().execute("startScan");
                } else {
                    isScanning = false;
                    btnScan.setText(getString(R.string.start_scan));
                    btnMaP.setVisibility(View.VISIBLE);

                    String display_text = connectedWipiName+" : "+getString(R.string.not_scanning);
                    tvIsScanning.setText(display_text);

                    new ScanRequest().execute("stopScan");
                }
                break;
            case (R.id.btn_MaP):
                Intent mapIntent = new Intent(MainActivity.this,
                        MapModeActivity.class);
                new ScanRequest().execute("startMap");
                startActivity(mapIntent);
                break;
        }
    }

    public boolean scanWipiNetworks() {
//        WifiManager manager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        assert manager != null;
        if (!manager.isWifiEnabled()) {
            Toast.makeText(this, "Please enable wifi", Toast.LENGTH_SHORT).show();
            return false;
        }
        List<ScanResult> lastScanRes = manager.getScanResults();
        wipiList.clear();
        for (ScanResult res : lastScanRes) {
            if (res.SSID.startsWith("wipi")) {
                wipiList.add(res.SSID);
            }
        }
        return true;
    }

    public void modifyLayoutOnConnected () {
        boolean success = true;
        if (success) {
            connectedStatus = true;
            toggleButtonsVisibility(connectedStatus);
            tvIsConnected.setText(getString(R.string.connected));
            String display_text = connectedWipiName+" : "+getString(R.string.not_scanning);
            tvIsScanning.setText(display_text);
            btnScan.setText(getString(R.string.start_scan));
        } else {
            // show error
            Log.e("connection error", "Could not connect to the WiPi network");
        }
    }

    public void showWipiListDialog () {
        // scan and update the wipiList
        if (!scanWipiNetworks()) {
            return;
        }

        CharSequence[] wipis = wipiList.toArray(new String[wipiList.size()]);
        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(
                MainActivity.this);
        dialogBuilder.setTitle(getString(R.string.wipi_list));
        dialogBuilder.setItems(wipis, (dialog, which) -> {
            connectedWipiName = wipis[which].toString();
            dialog.dismiss();
//            manager.disconnect();
            if (connectToWifi()) {
                modifyLayoutOnConnected();
            } else {
                Toast.makeText(getApplicationContext(), "Could not connect",
                        Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog wipiDialog = dialogBuilder.create();
        wipiDialog.show();
    }

    public void showDisconnectDialog () {
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Are you sure you want to disconnect?")
                .setPositiveButton("Yes", (dialog, which) -> {
                    manager.disconnect();
                    isScanning = false;
                    connectedStatus = false;
                    toggleButtonsVisibility(isConnected);
                    tvIsConnected.setText(getString(R.string.not_connected));
                    tvIsScanning.setText("");
                })
                .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public boolean connectToWifi () {
        WifiConfiguration configuration = new WifiConfiguration();
        configuration.SSID = String.format("\"%s\"", connectedWipiName);

        manager = (WifiManager) getApplicationContext().
                getSystemService(Context.WIFI_SERVICE);

        int netId = manager.addNetwork(configuration);
        manager.disconnect();
        manager.enableNetwork(netId, true);
        manager.reconnect();
        if (manager.reconnect()) {
            return true;
        }
        return false;
//        WifiInfo wifiInfo = manager.getConnectionInfo();
//        String ssid = wifiInfo.getSSID();
//
//        if (ssid.equals(connectedWipiName)) {
//            return true;
//        }
//        return connectToWifi();
//        return false;
    }


    private static class ScanRequest extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL("http://192.168.12.1/" + strings[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder result = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null)
                    result.append(inputLine).append("\n");

                in.close();
                connection.disconnect();
                return result.toString();
            }
            catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }

    public static class SessionRequest extends AsyncTask<String, Void, String> {

//        public interface AsyncResponse {
//            void processResponse (Object response);
//        }
//
//        public AsyncResponse asyncResponse;
//
//        public SessionRequest (AsyncResponse asyncResponse) {
//            this.asyncResponse = asyncResponse;
//        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL("http://192.168.12.1/" + strings[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder result = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null)
                    result.append(inputLine).append("\n");

                in.close();
                connection.disconnect();
                return result.toString();
            }
            catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
//            parse the JSON object & update sessionData

            Object result = null;
//            asyncResponse.processResponse(result);
        }
    }
}
