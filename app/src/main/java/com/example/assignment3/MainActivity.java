package com.example.assignment3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.assignment3.Patient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private EditText name, surname, sex,  day, years;
    private Button button, button2;
    private Patient patient;

    private FirebaseDatabase db=FirebaseDatabase.getInstance();
    private DatabaseReference root=db.getReference().child("Patients");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=(EditText) findViewById(R.id.FirstName);
        surname=(EditText) findViewById(R.id.LastName);
       day=(EditText) findViewById(R.id.Date);
       sex=(EditText) findViewById(R.id.Gender);
       years=(EditText) findViewById(R.id.Age);
       button=(Button) findViewById(R.id.button);
       button2=(Button) findViewById(R.id.button2);
       patient=new Patient();


       button.setOnClickListener((v)->{
           String FirstName=name.getText().toString();
           String LastName=surname.getText().toString();
           String Age=years.getText().toString();
           String Gender=sex.getText().toString();
           String Date=day.getText().toString();

           HashMap<String, String> patient=new HashMap<>();

           patient.put("FirstName", FirstName);
           patient.put("LastName", LastName);
           patient.put("Age", Age);
           patient.put("Gender", Gender);
           patient.put("Date",Date);

           root.push().setValue(patient).addOnCompleteListener((task) ->{
                   Toast.makeText(MainActivity.this, "Data saved well", Toast.LENGTH_LONG).show();
           });
       });
         button2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 startActivity(new Intent(MainActivity.this, PatientForm.class));
             }
         });
    }
}