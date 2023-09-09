package com.example.appforattendance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Adminlogin extends AppCompatActivity {

    Button adUser,adevent,lgout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);
        adUser=findViewById(R.id.aduser);
        adevent=findViewById(R.id.adevent);
        lgout=findViewById(R.id.lgout);

        adevent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Adminlogin.this, Addevents.class);
                startActivity(intent);
            }
        });

        adUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Adminlogin.this, addnewuser.class);
                startActivity(intent);
            }
        });

        lgout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Adminlogin.this, login.class);
                startActivity(intent);
            }
        });
    }
}