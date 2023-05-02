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
    private ListView lv_b;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        this.my_activities = findViewById(R.id.my_activities);
        this.my_profile = findViewById(R.id.my_profile);

        this.lv_b = findViewById(R.id.lv);

        BurgerAdapter ba = new BurgerAdapter(getMenu(), HomeActivity.this);
        this.lv_b.setAdapter(ba);

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

    public List<Burger> getMenu(){
        List<Burger> lb = new ArrayList<>();
        lb.add(new Burger("Big Mac", "Pain, viande, salade, tomate, oignon, sauce", 5.5f));
        lb.add(new Burger("Mc Chicken", "Pain, poulet, salade, tomate, oignon, sauce", 4.5f));
        lb.add(new Burger("Royal Cheese", "Pain, viande, salade, tomate, oignon, sauce, fromage", 6.5f));
        lb.add(new Burger("Mc Double", "Pain, viande x2, salade, tomate, oignon, sauce, fromage", 4.5f));lb.add(new Burger("Big Mac", "Pain, viande, salade, tomate, oignon, sauce", 5.5f));
        return lb;
    }
}

