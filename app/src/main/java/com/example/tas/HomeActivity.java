package com.example.tas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private Button my_activities;
    private Button my_profile;
    private ListView list_activities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        my_activities = (Button) findViewById(R.id.my_activities_button);
        my_profile = (Button) findViewById(R.id.my_profile_button);
        list_activities = (ListView) findViewById(R.id.list_tb);

        ActiviteAdapter activiteAdapter = new ActiviteAdapter(getActivites(), this);
        list_activities.setAdapter(activiteAdapter);
    }

    public List<Activite> getActivites() {
        List<Activite> la = new ArrayList<>();
        String[] tags = {"Stratégie", "Combat"};
        la.add(new Activite("1 vs 1 Samuraï", "Armez vous et participer à l'évènement le plus meurtrier de cette année !", tags , "img1"));
        String[] tags2 = {"Stratégie", "Réflexion"};
        la.add(new Activite("Escape Game", "Vous avez 60 minutes pour vous échapper de la pièce !", tags2, "img2"));
        String[] tags3 = {"Jeux d'équipe", "Sportif"};
        la.add(new Activite("Tournoi de foot", "Participez à un tournoi de foot en salle !", tags3, "img3"));
        return la;
    }
}

