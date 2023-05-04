package com.example.tas;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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

public class MyProfile extends AppCompatActivity {
    private TextView nom;
    private TextView prenom;
    private TextView company;
    private ListView lv_i;
    private ImageView icone;
    private Spinner spinner;
    private Button submit;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        this.lv_i = findViewById(R.id.lv);
        this.icone = findViewById(R.id.icone);
        this.submit = findViewById(R.id.submit);
        this.nom = findViewById(R.id.first_name);
        nom.setText(getIntent().getStringExtra("nom"));
        this.prenom = findViewById(R.id.last_name);
        prenom.setText(getIntent().getStringExtra("prenom"));
        this.company = findViewById(R.id.company);
        lookForCompany();

        this.spinner = findViewById(R.id.spinner);

        InfoAdapter ia = new InfoAdapter(getSalaryInfos(), MyProfile.this);
        this.lv_i.setAdapter(ia);


        this.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String info_nom = spinner.getSelectedItem().toString();
                String info_id = LookForInfoID(info_nom);
                Toast.makeText(MyProfile.this, "" + info_id, Toast.LENGTH_SHORT).show();
            }
        });

        this.lv_i.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Info info = (Info) adapterView.getAdapter().getItem(i);
                Toast.makeText(MyProfile.this, info.getNom(), Toast.LENGTH_SHORT).show();
            }
        });

        icone.setOnClickListener(v -> {
            Intent intent = new Intent(MyProfile.this, HomeActivity.class);
            intent.putExtra("idp", getIntent().getIntExtra("idp", -1));
            intent.putExtra("idc", getIntent().getIntExtra("idc", -1));
            intent.putExtra("nom", getIntent().getStringExtra("nom"));
            intent.putExtra("prenom", getIntent().getStringExtra("prenom"));
            startActivity(intent);
        });
    }

    public void lookForCompany() {
        String url = "https://togetherandstronger.fr:9000/lookfor/LookForCompany";
        JSONObject jsonBody = new JSONObject();
        try {
            int idc = getIntent().getIntExtra("idc", -1);
            //String idc_string = Integer.toString(idc);
            String idc_string = "35";
            jsonBody.put("idc", idc_string);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                response -> {
                    try {
                        JSONObject jsonResponse = new JSONObject(response);
                        JSONObject data = jsonResponse.getJSONObject("data");
                        String company_name = data.getString("nom");
                        company.setText(company_name);
                        Log.d("company name data", "lookForCompany: " + company_name);
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                },
                error -> {
                    Log.e("Volley Error", error.toString());
                }
        ) {
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

        return;
    }


    public String LookForInfoID(String nom) {
        List<Info> li = getInfoList();
        Log.i("LI CONTENT", "LookForInfoID: " + li.size());
        String id = "";
        for (Info info : li) {
            Log.i("idi", "LookForInfoID: " + info.getNom() + " " + info.getId() );
        }
        return id;
    }

    public List<Info> getInfoList(){
        List<Info> infoList = new ArrayList<>();
        String url = "https://togetherandstronger.fr:9000/list/infos";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                response -> {
                    try {
                        JSONObject jsonResponse = new JSONObject(response);
                        JSONArray dataArray = jsonResponse.getJSONArray("data");
                        for (int i = 0; i < dataArray.length(); i++) {
                            JSONObject info = dataArray.getJSONObject(i);
                            String id = info.getString("idINFO");
                            String name = info.getString("nom");
                            infoList.add(new Info(id, name));
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                error -> {
                    Log.e("Volley Error", error.toString());
                }
        );
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);

        return infoList;
    }

    public List<Info> getSalaryInfos(){
        List<Info> li = new ArrayList<>();
        String url = "https://togetherandstronger.fr:9000/salary/getInfos";
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
                        for(int i = 0; i < data.length(); i++){
                            JSONObject info = data.getJSONObject(i);
                            String id = info.getString("ID");
                            String name = info.getString("Name");
                            li.add(new Info(id, name));
                        }
                        InfoAdapter ia = new InfoAdapter(li, MyProfile.this);
                        lv_i.setAdapter(ia);
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
        return li;
    }
}

