package com.example.wipi.data_display;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wipi.R;
import com.example.wipi.models.Person;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author Rushikesh Jogdand.
 */
public class PersonAdapter extends RecyclerView.Adapter<PersonVh> {

    private List<Person> people;

    public PersonAdapter(final List<Person> people) {
        this.people = people;
    }

    private void setPeople(final List<Person> people) {
        this.people = people;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PersonVh onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.vh_person_people_list, parent, false);
        return new PersonVh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PersonVh holder, final int position) {
        holder.populate(people.get(position));
    }

    @Override
    public int getItemCount() {
        return people.size();
    }
}
