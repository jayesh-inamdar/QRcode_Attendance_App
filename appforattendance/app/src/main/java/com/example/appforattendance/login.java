package com.example.appforattendance;

import android.content.Intent;
import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class login extends AppCompatActivity {
    public EditText emailTV, passwordTV;
    public static String emmy;
    public Button loginBtn,adminbutton;
    public ProgressBar progressBar;
    public DatabaseReference reference;

    boolean x=false;
    int acces=0,val=0;
    String s1,s2;


    public FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        initializeUI();

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUserAccount();
            }
        });


        adminbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent admins=new Intent(login.this,Adminlogin.class);
                //startActivity(admins);
               String xemail = emailTV.getText().toString();
               String xpassword = passwordTV.getText().toString();
               Checkadmin(xemail,xpassword);


            }
        });

    }

    public void loginUserAccount() {
        progressBar.setVisibility(View.VISIBLE);

        String email, password;
        email = emailTV.getText().toString();
        emmy=email;
        password = passwordTV.getText().toString();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Please enter email...", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Please enter password!", Toast.LENGTH_LONG).show();
            return;
        }

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Login successful!", Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                            Intent ii=new Intent(login.this, Markattendance.class);
                            ii.putExtra("emmy", emmy);
                            startActivity(ii);

                            Intent intent = new Intent(login.this, home.class);
                            startActivity(intent);


                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Login failed! Please try again later", Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
    }

    public void initializeUI() {
        emailTV = findViewById(R.id.email);
        passwordTV = findViewById(R.id.password);
        adminbutton=findViewById(R.id.adminbutton2);
        loginBtn = findViewById(R.id.btn_login);
        progressBar = findViewById(R.id.progressBar);
    }
    public void Checkadmin(String xemail,String xpassword){
        reference = FirebaseDatabase.getInstance().getReference("admin");
        reference.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                Toast.makeText(getApplicationContext(),"Validating",Toast.LENGTH_SHORT).show();
                if (task.isSuccessful()) {
                    if (task.getResult().exists()) {
                        Toast.makeText(getApplicationContext(),"Successfully Read",Toast.LENGTH_SHORT).show();
                        x=true;
                        DataSnapshot dataSnapshot = task.getResult();
                        String memail = String.valueOf(dataSnapshot.child("email").getValue());
                        String mpassword = String.valueOf(dataSnapshot.child("password").getValue());
                        s1=memail;
                        if(memail.equals(xemail))
                        {
                            Intent admins=new Intent(login.this,Adminlogin.class);
                            startActivity(admins);
                        }
                        else{
                            Toast.makeText(login.this,"Password Doesn't Exist",Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        //acces=0;
                        Toast.makeText(login.this,"Event Doesn't Exist",Toast.LENGTH_SHORT).show();
                    }
                }else{//acces=0;
                    Toast.makeText(login.this,"Failed to read",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


//end of program
}

























