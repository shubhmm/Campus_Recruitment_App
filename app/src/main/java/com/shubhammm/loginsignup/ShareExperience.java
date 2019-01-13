package com.shubhammm.loginsignup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ShareExperience extends AppCompatActivity {

    EditText message ;
    // private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_experience);

        firebaseAuth = FirebaseAuth.getInstance();

        FirebaseUser user = firebaseAuth.getCurrentUser();

        databaseReference = FirebaseDatabase.getInstance().getReference();

        message = (EditText) findViewById(R.id.message);
    }

    public void share(View view) {

        String str_message = message.getText().toString().trim();


        ExperienceMessage experienceMessage = new ExperienceMessage(str_message);

        FirebaseUser user = firebaseAuth.getCurrentUser();

        databaseReference.child(user.getUid()).child("FeedBack").push().setValue(experienceMessage);

        Toast.makeText(this,"Successfully Submitted ...",Toast.LENGTH_SHORT).show();




    }

}
