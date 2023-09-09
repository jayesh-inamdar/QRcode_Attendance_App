package com.example.appforattendance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appforattendance.databinding.ActivityMarkattendanceBinding;
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


public class Markattendance extends AppCompatActivity {
String xName,xclassName,xdate1,xusermail,xQrcode,xclubname;
static String cdt;
//String clubnames;
Button Gobtn;
private ActivityMarkattendanceBinding binding;
EditText clubnames;
TextView Qrcode;
TextView usermail;
FirebaseDatabase db;
DatabaseReference reference;

EditText Name,className,date1;
//EditText usermail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMarkattendanceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Gobtn=findViewById(R.id.GoBtn);

        Qrcode=findViewById(R.id.Qrcode);
        Qrcode.setText(getIntent().getStringExtra("scnum"));

        Name=findViewById(R.id.Name);
        className=findViewById(R.id.className);

        clubnames=findViewById(R.id.clubnames);
      //  clubnames.setText(classAsub.clubname.toString());

        date1=findViewById(R.id.date1);
        date1.setText(getIntent().getStringExtra("date"));
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String currentDateandTime = sdf.format(new Date());
        date1.setText(currentDateandTime);
        //cdt=currentDateandTime;
        usermail=findViewById(R.id.usermail);
        usermail.setText(getIntent().getStringExtra("email"));




       binding.GoBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               xName=binding.Name.getText().toString();
               xclassName=binding.className.getText().toString();
               xdate1=binding.date1.getText().toString();
               xusermail=binding.usermail.getText().toString();
               xQrcode=binding.Qrcode.getText().toString();
               xclubname=binding.clubnames.getText().toString();

               if(!xName.isEmpty() && !xusermail.isEmpty() && !xclassName.isEmpty() && !xdate1.isEmpty() && !xclubname.isEmpty() && !xQrcode.isEmpty()){
                   Users users=new Users(xName,xclubname,xclassName,xdate1,xusermail,xQrcode);
                   db=FirebaseDatabase.getInstance();
                   reference = db.getReference("Users");
                   reference.child(xdate1).setValue(users).addOnCompleteListener(new OnCompleteListener<Void>() {
                       @Override
                       public void onComplete(@NonNull Task<Void> task) {
                           binding.Name.setText("");
                           binding.className.setText("");
                         //  binding.date1.setText("");
                         //  binding.usermail.setText("");
                           Toast.makeText(Markattendance.this,"Success",Toast.LENGTH_SHORT).show();
                           Intent bck=new Intent(Markattendance.this,MainActivity2.class);
                           startActivity(bck);
                       }
                   });



               }else{
               Toast.makeText(Markattendance.this,"Fail",Toast.LENGTH_SHORT).show();
               Intent bck=new Intent(Markattendance.this,MainActivity2.class);
               startActivity(bck);}
           }
       });


    }
}