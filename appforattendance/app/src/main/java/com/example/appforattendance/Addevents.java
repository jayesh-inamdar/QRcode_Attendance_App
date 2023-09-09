package com.example.appforattendance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Button;
import android.widget.TextView;
import android.text.TextUtils;
import android.widget.EditText;
import android.content.Intent;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import android.graphics.Bitmap;


public class Addevents extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addevents);
        // get reference to the string array that we just created
        FirebaseDatabase db;
        Button Update;
        EditText Accesscode, sessionname;
        String xaccesscode, xsession_name, xclub;
        DatabaseReference reference;
        ImageView imageCode = findViewById(R.id.imageCode);

        Update = findViewById(R.id.Updateevent);
        Accesscode = findViewById(R.id.Accesscode);
        sessionname = findViewById(R.id.sessionname);
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Session_names, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        String selectedcarmodel = ((Spinner) findViewById(R.id.spinner)).getSelectedItem().toString();

        Toast.makeText(this," Selected type is "+selectedcarmodel ,Toast.LENGTH_LONG).show();

              Update.setOnClickListener(new View.OnClickListener() {
                @Override
              public void onClick(View view) {
                    FirebaseDatabase db;
                    DatabaseReference reference;
                    String xaccesscode=Accesscode.getText().toString();
             String   xsession_name=sessionname.getText().toString();
            String xclub=((Spinner) findViewById(R.id.spinner)).getSelectedItem().toString();
              if(!xaccesscode.isEmpty() && !xsession_name.isEmpty() && !xclub.isEmpty()){
                        choice ch=new choice(xsession_name,xclub);
                        db=FirebaseDatabase.getInstance();
                        reference = db.getReference("Password");
                        reference.child(xaccesscode).setValue(ch).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(Addevents.this,"Success",Toast.LENGTH_SHORT).show();
                                String acc=Accesscode.getText().toString().trim();
                                //initializing MultiFormatWriter for QR code
                                MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                                try {
                                    //BitMatrix class to encode entered passcode
                                    BitMatrix bitMatrix = multiFormatWriter.encode(acc.toString(), BarcodeFormat.QR_CODE, 600, 600);
                                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                                    Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);//create bitmap for QR
                                    imageCode.setImageBitmap(bitmap);
                                    imageCode.setVisibility(View.VISIBLE);

                                } catch (WriterException e)
                                {
                                    e.printStackTrace();
                                }
                            }
                        });
                }else{
                  Toast.makeText(Addevents.this,"Fail",Toast.LENGTH_SHORT).show();
                  Intent bck=new Intent(Addevents.this,MainActivity2.class);
                  startActivity(bck);}
                }

            });

    }
}
