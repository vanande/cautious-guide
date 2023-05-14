package com.example.tas;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class Login_form extends AppCompatActivity {
    private EditText token;
    private Button login_btn;
    private TextView error_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_form);

        token = (EditText) findViewById(R.id.token);
        login_btn = (Button) findViewById(R.id.login_btn);
        error_view = (TextView) findViewById(R.id.error);
        RequestQueue queue = Volley.newRequestQueue(this);


        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONObject jsonBody = new JSONObject();
                try {
                    jsonBody.put("token", token.getText().toString());
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

                String url = "https://www.togetherandstronger.fr:9000/auth/LoginSalary";
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        response -> {
                            Log.d("Response", response);

                            JSONObject jsonResponse = null;
                            try {
                                jsonResponse = new JSONObject(response);
                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }

                            int idc = 0;
                            try {
                                idc = jsonResponse.getInt("idc");
                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }
                            int idp = 0;
                            try {
                                idp = jsonResponse.getInt("idp");
                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }
                            String nom = null;
                            try {
                                nom = jsonResponse.getString("nom");
                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }
                            String prenom = null;
                            try {
                                prenom = jsonResponse.getString("prenom");
                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }

                            Intent intent = new Intent(Login_form.this, HomeActivity.class);
                            intent.putExtra("token", token.getText().toString());
                            intent.putExtra("idc", idc);
                            intent.putExtra("idp", idp);
                            intent.putExtra("nom", nom);
                            intent.putExtra("prenom", prenom);
                            startActivity(intent);
                        },
                        error -> {
                            if (error.networkResponse != null) {
                                Log.d("VolleyError", "Status code: " + error.networkResponse.statusCode);
                                if (error.networkResponse.data != null) {
                                    String errorBody = new String(error.networkResponse.data);
                                    Log.d("VolleyError", "Error body: " + errorBody);
                                }
                            }
                            error_view.setText("Mauvais token");
                        }
                ) {
                    @Override
                    public byte[] getBody() {
                        return jsonBody.toString().getBytes();
                    }

                    @Override
                    public String getBodyContentType() {
                        return "application/json";
                    }
                };

                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(stringRequest);
            }
        });
    }
}
