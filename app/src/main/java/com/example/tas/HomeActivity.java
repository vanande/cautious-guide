package com.example.tas;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
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

        ActiviteAdapter aa = new ActiviteAdapter(getActivities(), HomeActivity.this);
        this.lv_a.setAdapter(aa);

        this.my_activities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivities();
                //Intent intent = new Intent(HomeActivity.this, MyActivities.class);
                //startActivity(intent);
            }
        });

        this.my_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MyProfile.class);
                intent.putExtra("idp", getIntent().getIntExtra("idp", -1));
                intent.putExtra("idc", getIntent().getIntExtra("idc", -1));
                intent.putExtra("nom", getIntent().getStringExtra("nom"));
                intent.putExtra("prenom", getIntent().getStringExtra("prenom"));
                startActivity(intent);
            }
        });
    }

    public List<Activite> getActivities(){
        List<Activite> la = new ArrayList<>();
        String url = "https://togetherandstronger.fr:9000/salary/getActivities";
        JSONObject jsonBody = new JSONObject();
        try {
            Log.i("idp", "getidp: " + getIntent().getIntExtra("idp", -1));
            Log.i("idp", "getidc: " + getIntent().getIntExtra("idc", -1));
            String idp_string = Integer.toString(getIntent().getIntExtra("idp", -1));
            String idc_string = Integer.toString(getIntent().getIntExtra("idc", -1));

            jsonBody.put("idc", idc_string);
            jsonBody.put("idp", idp_string);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                response -> {
                    try {
                        JSONObject jsonResponse = new JSONObject(response);
                        JSONArray data = jsonResponse.getJSONArray("data");
                        for(int i=0; i<data.length(); i++){
                            JSONObject activity = data.getJSONObject(i);
                            String nom = activity.getString("Nom");
                            String description = activity.getString("Description");
                            String image = activity.getString("Image");
                            la.add(new Activite(nom, description, image));
                        }
                        ActiviteAdapter aa = new ActiviteAdapter(la, HomeActivity.this);
                        lv_a.setAdapter(aa);
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                },
                error -> {
                    Log.e("Volley Error", error.toString());
                }
        ){
            @Override
            public byte[] getBody() {
                return jsonBody.toString().getBytes(StandardCharsets.UTF_8);
            }

            @Override
            public String getBodyContentType() {
                return "application/json";
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
        return la;
    }
}

