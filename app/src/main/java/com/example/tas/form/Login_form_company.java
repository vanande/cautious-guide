package com.example.tas.form;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tas.R;

public class Login_form_company extends AppCompatActivity {
    private Button employee_button;
    private Button company_button;
    private Button prestataire_button;
    private EditText email;
    private EditText password;
    private TextView signup;
    private Button login_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_form_company);

        employee_button = (Button) findViewById(R.id.employee_button);
        company_button = (Button) findViewById(R.id.company_button);
        prestataire_button = (Button) findViewById(R.id.prestataire_button);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        signup = (TextView) findViewById(R.id.signup);
        login_btn = (Button) findViewById(R.id.login_btn);

        employee_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_form_company.this, Login_form_employee.class);
                startActivity(intent);
            }
        });

        prestataire_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_form_company.this, Login_form_prestataire.class);
                startActivity(intent);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_form_company.this, Signup_form_company.class);
                startActivity(intent);
            }
        });
    }
}
