package com.example.wipi.data_display;


import android.os.Bundle;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wipi.R;
import com.example.wipi.models.Attendance;
import com.example.wipi.models.Person;

import java.util.List;
import java.util.Locale;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;


/**
 * {@link Fragment} to display all data for a single person.
 */
public class PersonDataFragment extends Fragment {

    private Person subject;
    private List<Attendance> attendanceList;
    private float attendance;

    private TextView nameTv;
    private TextView attendanceTv;
    private TextView deviceTv;
    private RecyclerView attendanceListRv;


    public PersonDataFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle args = getArguments();

        assert args != null;

        subject = PersonDataFragmentArgs.fromBundle(args).getPerson();

        final View v = inflater.inflate(R.layout.fragment_person_data, container, false);

        nameTv = v.findViewById(R.id.tv_person_name);
        attendanceTv = v.findViewById(R.id.tv_attendance);
        deviceTv = v.findViewById(R.id.tv_device);
        attendanceListRv = v.findViewById(R.id.rv_attendance_single_person);

        nameTv.setText(subject.name);
        deviceTv.setText(subject.deviceModel);
        attendanceTv.setText(String.format(Locale.getDefault(), "%.0f%%", Fake.attendance() * 100));

        attendanceList = Fake.generateAttendance(subject);
        attendanceListRv.setAdapter(new AttendanceListAdapter(attendanceList));
        return v;
    }

}
