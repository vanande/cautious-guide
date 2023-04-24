package com.example.tas.form;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.tas.R;

import org.json.JSONException;
import org.json.JSONObject;


public class Login_form_employee extends AppCompatActivity {
    private Button employee_button;
    private Button company_button;
    private Button prestataire_button;
    private EditText token;
    private Button login_btn;
    private TextView error_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_form);

        employee_button = (Button) findViewById(R.id.employee_button);
        company_button = (Button) findViewById(R.id.company_button);
        prestataire_button = (Button) findViewById(R.id.prestataire_button);
        token = (EditText) findViewById(R.id.token);
        login_btn = (Button) findViewById(R.id.login_btn);
        error_view = (TextView) findViewById(R.id.error);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://10.0.2.2:9000/auth/LoginSalary";
        String jsonBody = "{\"token\":\"111\"}";
        try {
            JSONObject requestBody = new JSONObject(jsonBody);
        } catch (JSONException e) {
            System.err.println("Error creating JSON object");
        }

        company_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_form_employee.this, Login_form_company.class);
                startActivity(intent);
            }
        });

        prestataire_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_form_employee.this, Login_form_prestataire.class);
                startActivity(intent);
            }
        });

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Request a string response from the provided URL.
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                // Display the first 500 characters of the response string.
                                error_view.setText("Response is: " + response.substring(0,500));
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error_view.setText("That didn't work!" + error.toString());
                    }
                });
                queue.add(stringRequest);
            }
        });


    }
}
