package com.example.breezil.loginsystem;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText eUsername = (EditText) findViewById(R.id.Username);
        final EditText ePassword = (EditText) findViewById(R.id.Password);
        final Button eLoginbtn = (Button) findViewById(R.id.LoginBtn);

        final TextView eCreate = (TextView) findViewById(R.id.createAcct);


        eCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regIntent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(regIntent);
            }
        });

        eLoginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String username = eUsername.getText().toString();
                final String password = ePassword.getText().toString();
                Response.Listener<String> listener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObjectresp =new JSONObject(response);
                            boolean success = jsonObjectresp.getBoolean("success");
                            if(success){
                                String name = jsonObjectresp.getString("name");
                                int age = jsonObjectresp.getInt("age");
                                Intent intent = new Intent(LoginActivity.this,UsersArea.class);
                                intent.putExtra("name",name);
                                intent.putExtra("age",age);
                                intent.putExtra("username",username);
                                startActivity(intent);


                            }else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                builder.setMessage("Login Failed")
                                        .setNegativeButton("Retry",null)
                                        .create().show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                LoginRequest loginRequest = new LoginRequest(username,password,listener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);
            }
        });
    }
}
