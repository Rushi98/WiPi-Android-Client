package com.example.wipi.data_display;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.wipi.R;
import com.example.wipi.models.Attendance;

import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author Rushikesh Jogdand.
 */
public class AttendanceVh extends RecyclerView.ViewHolder {

    private TextView personNameTv;

    private TextView macTv;

//    private TextView lastHitTv;
//
//    private TextView distanceTv;
//
//    private TextView confidenceTv;

    private TextView numberOfHitsTv;

    private Group detailsGroup;

    public AttendanceVh(@NonNull final View itemView) {
        super(itemView);
        personNameTv = itemView.findViewById(R.id.tv_person_name);
//        lastHitTv = itemView.findViewById(R.id.tv_last_hit);
//        distanceTv = itemView.findViewById(R.id.tv_distance);
//        confidenceTv = itemView.findViewById(R.id.tv_confidence);
        numberOfHitsTv = itemView.findViewById(R.id.tv_number_of_hits);
        detailsGroup = itemView.findViewById(R.id.group_details);
        macTv = itemView.findViewById(R.id.tv_mac);
    }

    public void populate(Attendance attendance) {
        final String personName;
        final String mac;
        if (attendance.personName != null) {
            personName = attendance.personName;
            mac = "";
        } else {
            personName = "Unknown Person";
            mac = String.format("(%s)", attendance.macAddress);
        }
        personNameTv.setText(personName);
        macTv.setText(mac);
//        lastHitTv.setText(attendance.lastHit);
//        distanceTv.setText(String.format(Locale.ENGLISH, "~ %.2f m", attendance.distance));
//        confidenceTv.setText(String.format(Locale.ENGLISH, "%.0f %%", attendance.confidence * 100));
        numberOfHitsTv.setText(String.valueOf(attendance.numberOfHits));
        itemView.setOnClickListener(v -> toggleDetailsVisibility());
    }

    private void toggleDetailsVisibility() {
        final int visibilityTo;
        if (detailsGroup.getVisibility() == View.GONE) {
            visibilityTo = View.VISIBLE;
        } else {
            visibilityTo = View.GONE;
        }
        detailsGroup.setVisibility(visibilityTo);
    }
}
