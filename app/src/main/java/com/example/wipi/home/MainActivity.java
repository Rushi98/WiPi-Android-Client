package com.example.wipi.home;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.wipi.R;
import com.example.wipi.map.MapModeActivity;
import com.example.wipi.sessions.SessionsActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvIsConnected;
    private TextView tvIsScanning;

    private Button btnConnect;
    private Button btnScan;
    private Button btnMaP;
    private Button btnSessions;

    private boolean isConnected;
    private boolean isScanning;
    private List<String> wipiList;

    private String connectedWipiName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isConnected = false;
        isScanning = false;
        wipiList = new ArrayList<>();

        tvIsConnected = findViewById(R.id.tv_is_connected);
        tvIsScanning = findViewById(R.id.tv_is_scanning);

        btnConnect = findViewById(R.id.btn_connect);
        btnMaP = findViewById(R.id.btn_MaP);
        btnSessions = findViewById(R.id.btn_sessions);
        btnScan = findViewById(R.id.btn_scan);

        toggleButtonsVisibility(isConnected);

        btnConnect.setOnClickListener(this);
        btnMaP.setOnClickListener(this);
        btnSessions.setOnClickListener(this);
        btnScan.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.btn_connect):
                if (!isConnected) {
                    showWipiListDialog();
                } else {
                    showDisconnectDialog();
                }
                break;
            case (R.id.btn_sessions):
                Intent sessionIntent = new Intent(MainActivity.this,
                        SessionsActivity.class);
                startActivity(sessionIntent);
                break;
            case (R.id.btn_scan):
                if (!isScanning) {
                    isScanning = true;
                    btnScan.setText(getString(R.string.stop_scan));
                    btnMaP.setVisibility(View.INVISIBLE);

                    String display_text = connectedWipiName+" : "+getString(R.string.scanning);
                    tvIsScanning.setText(display_text);
                } else {
                    isScanning = false;
                    btnScan.setText(getString(R.string.start_scan));
                    btnMaP.setVisibility(View.VISIBLE);

                    String display_text = connectedWipiName+" : "+getString(R.string.not_scanning);
                    tvIsScanning.setText(display_text);
                }
                break;
            case (R.id.btn_MaP):
                Intent mapIntent = new Intent(MainActivity.this,
                        MapModeActivity.class);
                startActivity(mapIntent);
                break;
        }
    }

    public void toggleButtonsVisibility (boolean condition) {
        if (condition) {
            btnMaP.setVisibility(View.VISIBLE);
            btnSessions.setVisibility(View.VISIBLE);
            btnScan.setVisibility(View.VISIBLE);
            btnConnect.setText(getString(R.string.disconnect));
        } else {
            btnMaP.setVisibility(View.INVISIBLE);
            btnSessions.setVisibility(View.INVISIBLE);
            btnScan.setVisibility(View.INVISIBLE);
            btnConnect.setText(getString(R.string.connect));
        }
    }

    public void scanWipiNetworks () {
        wipiList.clear();
        Random random = new Random();
        int wipiCount = random.nextInt(5)+4;
        for (int i=0; i<wipiCount; i++) {
            wipiList.add(i, "WiPi #"+(i+1));
        }
    }

    public void modifyLayoutOnConnected () {
        boolean success = true;
        if (success) {
            isConnected = true;
            toggleButtonsVisibility(isConnected);
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
        scanWipiNetworks();

        CharSequence[] wipis = wipiList.toArray(new String[wipiList.size()]);
        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(
                MainActivity.this);
        dialogBuilder.setTitle(getString(R.string.wipi_list));
        dialogBuilder.setItems(wipis, (dialog, which) -> {
            connectedWipiName = wipis[which].toString();
            dialog.dismiss();
            modifyLayoutOnConnected();
        });

        AlertDialog wipiDialog = dialogBuilder.create();
        wipiDialog.show();
    }

    public void showDisconnectDialog () {
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Are you sure you want to disconnect?")
                .setPositiveButton("Yes", (dialog, which) -> {
                    isScanning = false;
                    isConnected = false;
                    toggleButtonsVisibility(isConnected);
                    tvIsConnected.setText(getString(R.string.not_connected));
                    tvIsScanning.setText("");
                })
                .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
