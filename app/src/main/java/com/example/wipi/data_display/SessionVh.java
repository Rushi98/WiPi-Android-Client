package com.example.wipi.data_display;

import android.view.View;
import android.widget.TextView;

import com.example.wipi.R;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author Rushikesh Jogdand.
 */
public class SessionVh extends RecyclerView.ViewHolder {

    private TextView startTimeTv;

    public SessionVh(@NonNull final View itemView) {
        super(itemView);
        startTimeTv = itemView.findViewById(R.id.tv_session_start_time);
    }

    public void populate(String startTime) {
        startTimeTv.setText(startTime);
        itemView.setOnClickListener(v -> {
            SessionListFragmentDirections.ShowSessionDataAction action = SessionListFragmentDirections.showSessionDataAction(startTime);
            Navigation.findNavController(v).navigate(action);
        });
    }
}
