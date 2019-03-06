package com.example.wipi.map;

import android.view.View;
import android.widget.TextView;

import com.example.wipi.R;
import com.example.wipi.models.MapJoins;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author Omkar Kanade.
 */
public class MapJoinsViewHolder extends RecyclerView.ViewHolder {

    private TextView tvPersonName;

    public MapJoinsViewHolder(@NonNull View itemView) {
        super(itemView);
        tvPersonName = itemView.findViewById(R.id.tv_person_name);
    }

    public void populate (MapJoins mapJoins) {
        tvPersonName.setText(mapJoins.getPersonName());
    }
}
