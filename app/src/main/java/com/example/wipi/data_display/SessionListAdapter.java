package com.example.wipi.data_display;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wipi.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author Rushikesh Jogdand.
 */
public class SessionListAdapter extends RecyclerView.Adapter<SessionVh> {

    private List<String> sessionList;

    public void setSessionList(List<String> sessionList) {
        this.sessionList = sessionList;
        notifyDataSetChanged();
    }

    public SessionListAdapter(final List<String> sessionList) {
        this.sessionList = sessionList;
    }


    @NonNull
    @Override
    public SessionVh onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.view_holder_session, parent, false);
        return new SessionVh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SessionVh holder, final int position) {
        holder.populate(sessionList.get(position));
    }

    @Override
    public int getItemCount() {
        return sessionList.size();
    }
}
