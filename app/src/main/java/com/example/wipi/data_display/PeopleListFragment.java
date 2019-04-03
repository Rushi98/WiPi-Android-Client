package com.example.wipi.data_display;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wipi.R;
import com.example.wipi.models.Person;

import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;


/**
 * {@link Fragment} to display list of all people.
 */
public class PeopleListFragment extends Fragment {

    private List<Person> people = Fake.getPeopleList();

    public PeopleListFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_people_list, container, false);
        final RecyclerView peopleListRv = v.findViewById(R.id.rv_people_list);
        peopleListRv.setAdapter(new PersonAdapter(people));
        return v;
    }

}
