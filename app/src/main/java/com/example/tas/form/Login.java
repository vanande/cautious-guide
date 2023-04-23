package com.example.tas.form;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tas.R;

public abstract class Login extends AppCompatActivity {
    protected Button employee_button;
    protected Button company_button;
    protected Button prestataire_button;
    protected Button login_btn;
    protected TextView signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_form);

        employee_button = findViewById(R.id.employee_button);
        company_button = findViewById(R.id.company_button);
        prestataire_button = findViewById(R.id.prestataire_button);
        login_btn = findViewById(R.id.login_btn);
        signup = findViewById(R.id.signup);

        employee_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToForm(Login_form_employee.class);
            }
        });

        company_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToForm(Login_form_company.class);
            }
        });

        prestataire_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToForm(Login_form_prestataire.class);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, getSignupClass());
                startActivity(intent);
            }
        });
    }

    protected void switchToForm(Class<Login> formClass) {
        Intent intent = new Intent(this, formClass);
        startActivity(intent);
    }

    protected abstract Class<? extends Signup> getSignupClass();
}
