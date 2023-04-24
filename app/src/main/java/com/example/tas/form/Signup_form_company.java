package com.example.tas.form;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tas.R;

public class Signup_form_company extends AppCompatActivity {
    private Button employee_button;
    private Button company_button;
    private Button prestataire_button;
    private EditText name;
    private EditText email;
    private EditText password;
    private EditText tel;
    private Spinner type_company;
    private EditText raison_sociale;
    private Button signup_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_form_company);

        employee_button = (Button) findViewById(R.id.employee_button);
        company_button = (Button) findViewById(R.id.company_button);
        prestataire_button = (Button) findViewById(R.id.prestataire_button);
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        tel = (EditText) findViewById(R.id.tel);
        type_company = (Spinner) findViewById(R.id.company_type);
        raison_sociale = (EditText) findViewById(R.id.raison_sociale);
        signup_btn = (Button) findViewById(R.id.signup_btn);

        employee_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Signup_form_company.this, Login_form_employee.class);
                startActivity(intent);
            }
        });

        prestataire_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Signup_form_company.this, Login_form_prestataire.class);
                startActivity(intent);
            }
        });

    }
}
