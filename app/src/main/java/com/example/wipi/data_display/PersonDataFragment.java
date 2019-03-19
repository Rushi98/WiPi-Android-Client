package com.example.wipi.data_display;


import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wipi.R;

import androidx.fragment.app.Fragment;


/**
 * {@link Fragment} to display all data for a single person.
 */
public class PersonDataFragment extends Fragment {


    public PersonDataFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_person_data, container, false);
        return v;
    }

}
