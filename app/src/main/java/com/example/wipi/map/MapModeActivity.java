package com.example.wipi.map;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.wipi.R;
import com.example.wipi.models.MapJoins;
import com.example.wipi.sessions.Fake;
import com.google.android.material.button.MaterialButton;

import java.util.List;
import java.util.Locale;

/**
 * @author Omkar Kanade.
 */
public class MapModeActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnEndMap;
    RecyclerView newJoinsRv;
    RecyclerView allJoinsRv;

    private MaterialButton newJoinsBtn;
    private MaterialButton allJoinsBtn;

    List<MapJoins> newJoins;
    List<MapJoins> allJoins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_mode);

        btnEndMap = findViewById(R.id.btn_end_map);
        newJoinsBtn = findViewById(R.id.btn_new_joins);
        allJoinsBtn = findViewById(R.id.btn_all_joins);

        btnEndMap.setOnClickListener(this);
        newJoinsBtn.setOnClickListener(this);
        allJoinsBtn.setOnClickListener(this);

        newJoinsRv = findViewById(R.id.rv_new_joins);
        newJoins = Fake.getJoins(true);
        newJoinsRv.setAdapter(new MapJoinsAdapter(newJoins));

        allJoinsRv = findViewById(R.id.rv_all_joins);
        allJoins = Fake.getJoins(false);
        allJoins.addAll(newJoins);
        allJoinsRv.setAdapter(new MapJoinsAdapter(allJoins));
    }

    @Override
    protected void onResume() {
        super.onResume();
        newJoinsBtn.setText(String.format(Locale.ENGLISH,
                "%s (%d)",getString(R.string.new_joins), newJoins.size()));
        allJoinsBtn.setText(String.format(Locale.ENGLISH,
                "%s (%d)",getString(R.string.all_joins), allJoins.size()));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.btn_end_map):
                // turn off MaP mode
                onBackPressed();
                break;
            case (R.id.btn_new_joins):
                toggleListVisibility(newJoinsRv);
                break;
            case (R.id.btn_all_joins):
                toggleListVisibility(allJoinsRv);
                break;
        }
    }

    public static void toggleListVisibility(View view) {
        int visibility;
        if (view.getVisibility() == View.GONE) {
            visibility = View.VISIBLE;
        } else {
            visibility = View.GONE;
        }
        view.setVisibility(visibility);
    }
}
