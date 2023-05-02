package com.example.tas;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private Button my_activities;
    private Button my_profile;
    private ListView lv_a;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        this.my_activities = findViewById(R.id.my_activities);
        this.my_profile = findViewById(R.id.my_profile);
        this.lv_a = findViewById(R.id.lv);

        ActiviteAdapter aa = new ActiviteAdapter(getActivites(), HomeActivity.this);
        this.lv_a.setAdapter(aa);

        this.my_activities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MyActivities.class);
                startActivity(intent);
            }
        });

        this.my_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MyProfile.class);
                startActivity(intent);
            }
        });
    }

    public List<Activite> getActivites() {
        List<Activite> la = new ArrayList<>();
        la.add(new Activite("Paintball", "Jeu de tir en équipe"));
        la.add(new Activite("Bowling", "Jeu de quilles"));
        la.add(new Activite("Karting", "Course de kart"));
        return la;
    }
}

