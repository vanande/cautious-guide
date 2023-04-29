package com.example.tas.form;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.tas.HomeActivity;
import com.example.tas.MySingleton;
import com.example.tas.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.text.Collator;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;


public class Login_form_employee extends AppCompatActivity {
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

                            JSONObject jsonResponse = new JSONObject(response);

                            int idc = jsonResponse.getInt("idc");
                            int ide = jsonResponse.getInt("ide");
                            int idp = jsonResponse.getInt("idp");

                            Intent intent = new Intent(Login_form_employee.this, HomeActivity.class);
                            intent.putExtra("token", token.getText().toString());
                            intent.putExtra("idc", idc);
                            intent.putExtra("ide", ide);
                            intent.putExtra("idp", idp);
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
                            error_view.setText(error.toString());
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
