package com.example.wipi.map;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wipi.R;
import com.example.wipi.home.MainActivity;
import com.example.wipi.models.MapJoins;
import com.example.wipi.sessions.Fake;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @author Omkar Kanade.
 */
public class MapModeActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnEndMap;
    RecyclerView newJoinsRv;
    RecyclerView allJoinsRv;

    private TextView tv_new_join;
    private TextView tv_all_join;
    private LinearLayout rvLayoutNew;
    private LinearLayout rvLayoutAll;

    List<MapJoins> newJoins;
    List<MapJoins> allJoins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_mode);

        btnEndMap = findViewById(R.id.btn_end_map);
        rvLayoutNew = findViewById(R.id.rv_layout_new);
        rvLayoutAll = findViewById(R.id.rv_layout_all);
        tv_new_join = findViewById(R.id.tv_new_joins);
        tv_all_join = findViewById(R.id.tv_all_joins);

        btnEndMap.setOnClickListener(this);
        tv_new_join.setOnClickListener(this);
        tv_all_join.setOnClickListener(this);

        newJoinsRv = findViewById(R.id.rv_new_joins);
        newJoins = Fake.getJoins(true);
        newJoinsRv.setAdapter(new MapJoinsAdapter(newJoins));

        allJoinsRv = findViewById(R.id.rv_all_joins);
        allJoins = Fake.getJoins(false);
        allJoins.addAll(newJoins);
        allJoinsRv.setAdapter(new MapJoinsAdapter(allJoins));

        toggleListVisibility(rvLayoutAll);
    }

    @Override
    protected void onResume() {
        super.onResume();
        tv_new_join.setText(String.format(Locale.ENGLISH,
                "%s (%d)",getString(R.string.new_joins), newJoins.size()));
        tv_all_join.setText(String.format(Locale.ENGLISH,
                "%s (%d)",getString(R.string.all_joins), allJoins.size()));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.btn_end_map):
                // turn off MaP mode
                onBackPressed();
                break;
            case (R.id.tv_new_joins):
                toggleListVisibility(rvLayoutNew);
                break;
            case (R.id.tv_all_joins):
                toggleListVisibility(rvLayoutAll);
                break;
        }
    }

    public void toggleListVisibility (LinearLayout layout) {
        int visibility;
        if (layout.getVisibility() == View.GONE) {
            visibility = View.VISIBLE;
        } else {
            visibility = View.GONE;
        }
        layout.setVisibility(visibility);
    }
}
