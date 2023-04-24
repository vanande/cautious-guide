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

public class Login_form_prestataire extends AppCompatActivity {
    private Button employee_button;
    private Button company_button;
    private Button prestataire_button;
    private EditText email;
    private EditText password;
    private Button login_btn;
    private TextView signup;
    private TextView error_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_form_prestataire);

        employee_button = (Button) findViewById(R.id.employee_button);
        company_button = (Button) findViewById(R.id.company_button);
        prestataire_button = (Button) findViewById(R.id.prestataire_button);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        login_btn = (Button) findViewById(R.id.login_btn);
        signup = (TextView) findViewById(R.id.signup);
        error_view = (TextView) findViewById(R.id.error);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "localhost:9000/auth/LoginSalary";

        employee_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_form_prestataire.this, Login_form_employee.class);
                startActivity(intent);
            }
        });

        company_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_form_prestataire.this, Login_form_company.class);
                startActivity(intent);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_form_prestataire.this, Signup_form_prestataire.class);
                startActivity(intent);
            }
        });

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
