package com.example.wipi.data_display;

import android.view.View;

import com.example.wipi.R;
import com.example.wipi.models.Person;
import com.google.android.material.button.MaterialButton;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author Rushikesh Jogdand.
 */
public class PersonVh extends RecyclerView.ViewHolder {

    private MaterialButton nameBtn;

    public PersonVh(@NonNull final View itemView) {
        super(itemView);
        nameBtn = itemView.findViewById(R.id.btn_person_name_people_list);
    }

    public void populate(Person person) {
        nameBtn.setText(person.name);
        itemView.setOnClickListener(v -> {
            PeopleListFragmentDirections.ShowPersonDataAction action = PeopleListFragmentDirections.showPersonDataAction(person);
            Navigation.findNavController(v).navigate(action);
        });
    }
}
