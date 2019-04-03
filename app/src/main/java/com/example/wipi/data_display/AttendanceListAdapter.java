package com.example.wipi.data_display;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wipi.R;
import com.example.wipi.models.Attendance;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author Rushikesh Jogdand.
 */
public class AttendanceListAdapter extends RecyclerView.Adapter<AttendanceVh> {

    private List<Attendance> attendanceList;

    public AttendanceListAdapter(final List<Attendance> attendanceList) {
        this.attendanceList = attendanceList;
    }

    @NonNull
    @Override
    public AttendanceVh onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.view_holder_attendance, parent, false);
        return new AttendanceVh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final AttendanceVh holder, final int position) {
        holder.populate(attendanceList.get(position));
    }

    @Override
    public int getItemCount() {
        return attendanceList.size();
    }
}
