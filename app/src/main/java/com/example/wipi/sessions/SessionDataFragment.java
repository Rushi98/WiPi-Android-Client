package com.example.wipi.sessions;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wipi.R;

import androidx.fragment.app.Fragment;


/**
 * Shows data collected in particular session.
 */
public class SessionDataFragment extends Fragment {


    public SessionDataFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_session_data, container, false);
    }

}
