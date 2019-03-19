package com.example.wipi.data_display;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wipi.R;
import com.example.wipi.models.Attendance;

import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;


/**
 * Shows data collected in particular session.
 */
public class SessionDataFragment extends Fragment {


    public SessionDataFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle args = getArguments();
        assert args != null;
        String startTime = SessionDataFragmentArgs.fromBundle(args).getStartTime();
        View view = inflater.inflate(R.layout.fragment_session_data, container, false);
        RecyclerView attendanceListRv = view.findViewById(R.id.rv_attendance_list);
        List<Attendance> attendanceList = Fake.getAttendance(startTime);
        attendanceListRv.setAdapter(new SessionDataAdapter(attendanceList));
        return view;
    }

}
