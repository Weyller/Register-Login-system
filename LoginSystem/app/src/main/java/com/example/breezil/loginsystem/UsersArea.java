package com.example.breezil.loginsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class UsersArea extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_area);

        final TextView eUsername = (TextView) findViewById(R.id.Username);
        final TextView eAge = (TextView) findViewById(R.id.Age);
        final TextView eName = (TextView) findViewById(R.id.welcomeMessage);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String username = intent.getStringExtra("username");
        int age = intent.getIntExtra("age",-1);

        String message = "welcome " + name;
        eName.setText(message);
        eUsername.setText(username);
        eAge.setText(age + "");

    }
}
