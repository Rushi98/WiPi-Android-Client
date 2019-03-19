package com.example.wipi.data_display;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wipi.R;

import androidx.fragment.app.Fragment;


/**
 * {@link Fragment} to display list of all people.
 */
public class PeopleListFragment extends Fragment {


    public PeopleListFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_people_list, container, false);
        return v;
    }

}
