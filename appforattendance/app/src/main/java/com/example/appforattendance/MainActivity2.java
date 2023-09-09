package com.example.appforattendance;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appforattendance.databinding.ActivityMain2Binding;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appforattendance.databinding.ActivityMain2Binding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.widget.TextView;
import android.text.TextUtils;
import android.widget.EditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity2 extends AppCompatActivity {
    String userstat;
    String scannedNumber;
    static String scnum,datte,mail,club_name;
    private ActivityMain2Binding binding;

    String s1,s2;
    boolean x=false;
    Button btscan, btMark, btval;
    TextView textView, clubtext, currentdate;
    TextView useremail;
    FirebaseDatabase db;
    DatabaseReference reference;
    int acces=0,val=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_main2);
        setContentView(binding.getRoot());
        btscan = findViewById(R.id.button);//1
        btMark = findViewById(R.id.btMark);//2

        clubtext=findViewById(R.id.clubtext);//5
        clubtext.setText(classAsub.clubname.toString());



        btMark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iii= new Intent(MainActivity2.this,Markattendance.class);
                startActivity(iii);

            }
        });

        currentdate = findViewById(R.id.currentdate);//3
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String currentDateandTime = sdf.format(new Date());
        currentdate.setText(currentDateandTime);
        datte=currentDateandTime;

        useremail = findViewById(R.id.useremail);//4

        useremail.setText(login.emmy.toString());
        mail=login.emmy.toString();

        club_name=getIntent().getStringExtra("clubs");

        binding.btval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                club_name=getIntent().getStringExtra("clubs");
                if (val!=0) {
                    if (!club_name.isEmpty()) {
                        mainActivity2(club_name);
                    } else {
                        Toast.makeText(getApplicationContext(), "Enter valid Event", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Please Mark Attendance", Toast.LENGTH_SHORT).show();

                }

            }
        });

            btMark.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(acces!=0){
                        if(x){
                        Intent iii = new Intent(MainActivity2.this, Markattendance.class);
                        iii.putExtra("scnum",scannedNumber);
                        iii.putExtra("date",datte);
                        iii.putExtra("email",mail);
                        startActivity(iii);
                    }else {
                      Toast.makeText(getApplicationContext(), "Enter valid QR code", Toast.LENGTH_SHORT).show();

                        }
                    }else {
                        Toast.makeText(getApplicationContext(), "Scan QR to get access", Toast.LENGTH_SHORT).show();
                    }
                    }

            });


        btscan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator intentIntegrator = new IntentIntegrator(MainActivity2.this);
                intentIntegrator.setPrompt("For flash,use volume keys");
                intentIntegrator.setBeepEnabled(true);
                intentIntegrator.setOrientationLocked(true);
                intentIntegrator.setCaptureActivity(Capture.class);
                intentIntegrator.initiateScan();
            }
        });


    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (intentResult.getContents() != null) {
            acces=1;
            val=1;
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this);
            builder.setTitle("QR");
            scannedNumber = intentResult.getContents().toString();
            builder.setMessage(scannedNumber);
            scannedNumber = intentResult.getContents().toString();//6
            scnum=scannedNumber.toLowerCase();
            Intent ik=new Intent(MainActivity2.this, Markattendance.class);
            ik.putExtra("scnum",scannedNumber);

            TextView barcodeTextView = findViewById(R.id.barcodeTextView);
            barcodeTextView.setText(scannedNumber);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            builder.show();
        } else {
            acces=0;
            val=1;
            Toast.makeText(getApplicationContext(), "Try again...........", Toast.LENGTH_SHORT).show();
        }
    }

    public void mainActivity2(String club_name){
        // club_name=getIntent().getStringExtra("clubs");
        reference = FirebaseDatabase.getInstance().getReference("Password");
        reference.child(scnum.toString()).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                Toast.makeText(getApplicationContext(),"Validating",Toast.LENGTH_SHORT).show();

                if (task.isSuccessful()) {
                    if (task.getResult().exists()) {
                        Toast.makeText(getApplicationContext(),"Successfully Read",Toast.LENGTH_SHORT).show();
                        x=true;
                        DataSnapshot dataSnapshot = task.getResult();
                        String session_name = String.valueOf(dataSnapshot.child("session_name").getValue());
                       String access = String.valueOf(dataSnapshot.child("club").getValue());
                        s1=session_name;
                        if(access.equals(club_name))
                        {   acces=1;
                            val=1;
                            s2 = access;
                            clubtext.setText(session_name);
                        }else{
                            acces=0;
                            Toast.makeText(MainActivity2.this,"Password Doesn't Exist",Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        acces=0;
                        Toast.makeText(MainActivity2.this,"Event Doesn't Exist",Toast.LENGTH_SHORT).show();
                    }
                }else{acces=0;
                    Toast.makeText(MainActivity2.this,"Failed to read",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}