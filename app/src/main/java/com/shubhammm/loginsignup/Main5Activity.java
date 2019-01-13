package com.shubhammm.loginsignup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main5Activity extends AppCompatActivity {



    EditText name, registration, contact, cpi, yearop, branch;
    // private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        firebaseAuth = FirebaseAuth.getInstance();

        FirebaseUser user = firebaseAuth.getCurrentUser();

        databaseReference = FirebaseDatabase.getInstance().getReference();

        name = (EditText) findViewById(R.id.name);
        registration = (EditText) findViewById(R.id.registration);
        branch = (EditText) findViewById(R.id.branch);
        yearop = (EditText) findViewById(R.id.yearop);
        cpi = (EditText) findViewById(R.id.cpi);
        contact = (EditText) findViewById(R.id.contact);

    }

    public void updated(View view) {

        String str_name = name.getText().toString().trim();
        String str_registration = registration.getText().toString().trim();
        String str_contact = contact.getText().toString().trim();
        String str_branch = branch.getText().toString().trim();
        String str_yearop = yearop.getText().toString().trim();
        String str_cpi = cpi.getText().toString().trim();


        UserInformation userInformation = new UserInformation(str_name,str_registration,str_branch,str_yearop,str_cpi,str_contact);

        FirebaseUser user = firebaseAuth.getCurrentUser();

        databaseReference.child(user.getUid()).setValue(userInformation);

        Toast.makeText(this,"Information Updated ...",Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(Main5Activity.this,Profile_Activity.class);
        intent.putExtra("NAME",str_name);
        intent.putExtra("REGISTRATION",str_registration);
        intent.putExtra("EMAIL",str_yearop);
        intent.putExtra("BRANCH",str_branch);
        intent.putExtra("CPI",str_cpi);
        startActivity(intent);

    }



}
