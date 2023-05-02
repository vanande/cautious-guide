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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Intent intent = getIntent();
        //String message = "Bienvenue " + intent.getStringExtra("prenom") + " !";
        //Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();

        //my_activities = (Button) findViewById(R.id.my_activities_button);
        //my_profile = (Button) findViewById(R.id.my_profile_button);
        lv_a = (ListView) findViewById(R.id.list_tb);

        ActiviteAdapter activiteAdapter = new ActiviteAdapter(  getActivites(), HomeActivity.this);
        lv_a.setAdapter(activiteAdapter);
    }

    public List<Activite> getActivites() {
        List<Activite> la = new ArrayList<>();

        la.add(new Activite("1 vs 1 Samuraï", "Armez vous et participer à l'évènement le plus meurtrier de cette année !", "Stratégie, Combat"));
        la.add(new Activite("Escape Game", "Vous avez 60 minutes pour vous échapper de la pièce !","Stratégie, Réflexion"));
        la.add(new Activite("Tournoi de foot", "Participez à un tournoi de foot en salle !", "Jeux d'équipe, Sportif"));
        return la;
    }
}

