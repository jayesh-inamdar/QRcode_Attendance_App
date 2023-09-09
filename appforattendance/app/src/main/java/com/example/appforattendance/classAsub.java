package com.example.appforattendance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.Button;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Objects;
import android.view.View;
public class classAsub extends AppCompatActivity {
    public static String clubname;
    Button sub1,sub2,sub3,sub4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_asub);
        sub1=findViewById(R.id.sub1);
        sub2=findViewById(R.id.sub2);
        sub3=findViewById(R.id.sub3);
        sub4=findViewById(R.id.sub4);
        sub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(classAsub.this,MainActivity2.class);
                clubname="seminars";
                i.putExtra("clubs",clubname);
                startActivity(i);

            }
        });
        sub2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i1= new Intent(classAsub.this,MainActivity2.class);
                clubname="workshop";
                i1.putExtra("clubs",clubname);
                startActivity(i1);

            }
        });
        sub3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent ie= new Intent(classAsub.this,MainActivity2.class);
                clubname="experttalk";
                ie.putExtra("clubs",clubname);
                startActivity(ie);
            }
        });
        sub4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i4= new Intent(classAsub.this,MainActivity2.class);
                clubname="sports";
                i4.putExtra("clubs",clubname);
                startActivity(i4);
            }
        });

    }



}