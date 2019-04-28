package com.example.wipi.data_display;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public abstract class AsyncRequest extends AsyncTask<String, Void, String> {
//
//    public interface AsyncResponse {
//        void processResult (Object result);
//    }
//
//    public AsyncResponse asyncResponse;
//    public AsyncRequest (AsyncResponse asyncResponse) {
//        this.asyncResponse = asyncResponse;
//    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            URL url = new URL("http://192.168.12.1/" + strings[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder result = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null)
//                Log.e("new data", inputLine);
                result.append(inputLine).append("\n");

            in.close();
            connection.disconnect();
            Log.e("data", result.toString());
            return result.toString();
        }
        catch (IOException e) {
            Log.e("TAG", String.format("doInBackground: %s", e.getMessage()), e);
        }

        return null;
    }

    @Override
    protected abstract void onPostExecute(String s);
}
