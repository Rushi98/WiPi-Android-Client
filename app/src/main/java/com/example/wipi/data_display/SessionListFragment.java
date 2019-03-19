package com.example.wipi.data_display;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wipi.R;

import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;


/**
 * Shows list of sessions.
 */
public class SessionListFragment extends Fragment {

    public SessionListFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_session_list, container, false);
        List<String> sessions = Fake.getSessionList();
        RecyclerView sessionListRv = view.findViewById(R.id.rv_session_list);
        sessionListRv.setAdapter(new SessionListAdapter(sessions));
        return view;
    }

}
