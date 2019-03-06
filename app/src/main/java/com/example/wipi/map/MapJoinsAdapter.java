package com.example.wipi.map;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wipi.R;
import com.example.wipi.models.MapJoins;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MapJoinsAdapter extends RecyclerView.Adapter<MapJoinsViewHolder> {

    private List<MapJoins> joinsList;

    public MapJoinsAdapter (final List<MapJoins> joinsList) {
        this.joinsList = joinsList;
    }

    @NonNull
    @Override
    public MapJoinsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.view_holder_map_join, parent, false);
        return new MapJoinsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MapJoinsViewHolder holder, int position) {
        holder.populate(joinsList.get(position));
    }

    @Override
    public int getItemCount() {
        return joinsList.size();
    }
}
