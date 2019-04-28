package com.example.wipi.data_display;


import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wipi.R;
import com.example.wipi.models.Attendance;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * Shows data collected in particular session.
 */
public class SessionDataFragment extends Fragment {

    List<Attendance> attendanceList = new ArrayList<>();
    RecyclerView attendanceListRv;
    AttendanceListAdapter attendanceListAdapter;

    String startTime;

    @SuppressLint("StaticFieldLeak")
    AsyncRequest request = new AsyncRequest() {
        @Override
        protected void onPostExecute(String s) {
            parseSessionData(s);
            attendanceListAdapter.setAttendanceList(attendanceList);
            Log.d("data response", String.format("onPostExecute: %s", s));
        }
    };

    public SessionDataFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle args = getArguments();
        assert args != null;
        startTime = SessionDataFragmentArgs.fromBundle(args).getStartTime();

        View view = inflater.inflate(R.layout.fragment_session_data, container, false);
        attendanceListRv = view.findViewById(R.id.rv_attendance_list);
        attendanceListAdapter = new AttendanceListAdapter(attendanceList);

        attendanceListRv.setAdapter(attendanceListAdapter);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!(request.getStatus().equals(AsyncTask.Status.FINISHED))){
            request.execute("sessions/"+startTime);
        }
    }

    public void parseSessionData (String sessData) {
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(sessData);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            for (int i=0; i<jsonArray.length(); i++) {
                JSONObject dataItem = new JSONObject(jsonArray.getString(i));
                Attendance attendance = new Attendance(dataItem.getString("name"),
                        dataItem.getString("mac_address"), dataItem.getInt("hits"));
                Log.e("attendance data", dataItem.getString("name")+" "
                        +dataItem.getInt("hits"));
                attendanceList.add(attendance);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
