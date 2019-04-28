package com.example.wipi.data_display;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wipi.R;
import com.example.wipi.home.MainActivity;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * Shows list of sessions.
 */
public class SessionListFragment extends Fragment {

    List<String> sessions = new ArrayList<>();
    RecyclerView sessionListRv;
    SessionListAdapter sessionListAdapter;

//    MainActivity.SessionRequest sessionRequest;

    @SuppressLint("StaticFieldLeak")
    AsyncRequest request = new AsyncRequest() {
        @Override
        protected void onPostExecute(String s) {
//            parse the json object s and update sessions
            parseSessions(s);
//            sessions.add(s);
            sessionListAdapter.setSessionList(sessions);
            Log.d("list response", String.format("onPostExecute: %s", s));
        }
    };;

    public SessionListFragment() {
    }


    @SuppressLint("StaticFieldLeak")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_session_list, container, false);
//        sessions = new ArrayList<>();
//        sessions = Fake.getSessionList();
        sessionListAdapter = new SessionListAdapter(sessions);
        sessionListRv = view.findViewById(R.id.rv_session_list);

//        request = new AsyncRequest() {
//            @Override
//            protected void onPostExecute(String s) {
//                sessions.add(s);
////            sessions = Fake.getSessionList();
//                sessionListAdapter.setSessionList(sessions);
//                Log.d("response", String.format("onPostExecute: %s", s));
//            }
//        };


//        sessions = Fake.getSessionList();
//        new MainActivity.SessionRequest(this).execute("sessions");

        /*request = new AsyncRequest(result -> {
            sessions = (List<String>) result;
        }) {
            @Override
            protected void onPostExecute(String s) {
//                Log.e("session data", s);
                Object result = null;
                asyncResponse.processResult(result);
            }
        };*/


//        sessions = Fake.getSessionList();

//        sessionListRv = view.findViewById(R.id.rv_session_list);
        sessionListRv.setAdapter(sessionListAdapter);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!(request.getStatus().equals(AsyncTask.Status.FINISHED))){
            request.execute("sessions");
        }
    }

    public void parseSessions (String sessList) {
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(sessList);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                String data = jsonArray.getString(i);
                Log.e("session items", data);
                sessions.add(data);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
