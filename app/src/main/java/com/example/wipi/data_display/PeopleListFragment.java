package com.example.wipi.data_display;


import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wipi.R;
import com.example.wipi.models.Person;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * {@link Fragment} to display list of all people.
 */
public class PeopleListFragment extends Fragment {

    private List<Person> people = new ArrayList<>();

    PersonAdapter personAdapter;
    RecyclerView peopleListRv;

    @SuppressLint("StaticFieldLeak")
    AsyncRequest request = new AsyncRequest() {
        @Override
        protected void onPostExecute(String s) {
            parsePeopleData(s);
            personAdapter.setPeople(people);
            Log.d("people response", String.format("onPostExecute: %s", s));
        }
    };

    public PeopleListFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_people_list, container, false);
        peopleListRv = v.findViewById(R.id.rv_people_list);
        personAdapter = new PersonAdapter(people);

        peopleListRv.setAdapter(personAdapter);
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!(request.getStatus().equals(AsyncTask.Status.FINISHED))) {
            request.execute("people");
        }
    }

    public void parsePeopleData (String peopleData) {
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(peopleData);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            for (int i=0; i<jsonArray.length(); i++) {
                JSONObject dataItem = new JSONObject(jsonArray.getString(i));
                Person person = new Person();
                person.name = dataItem.getString("name");
                person.id = dataItem.getString("bits_id");
                person.deviceMac = dataItem.getString("mac_address");
                people.add(person);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
