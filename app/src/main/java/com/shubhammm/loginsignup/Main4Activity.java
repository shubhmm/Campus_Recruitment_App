package com.shubhammm.loginsignup;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Main4Activity extends AppCompatActivity {


    EditText email,password;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser()!= null)
        {
            // LOGIN ACTIVITY
            // finish();
            startActivity(new Intent(getApplicationContext(),Profile_Activity.class));
        }


        email=(EditText) findViewById(R.id.email);
        password=(EditText) findViewById(R.id.password);


    }

    public void login(View view)
    {

        String  str_email= email.getText().toString() + "@gmail.com";
        String  str_password= password.getText().toString();


        progressDialog.setMessage("Logging in....");
        progressDialog.show();


        firebaseAuth.signInWithEmailAndPassword(str_email,str_password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful())
                {
                    Toast.makeText(Main4Activity.this,"Logged In Successfully",Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(new Intent(getApplicationContext(),Profile_Activity.class));
                }
            }
        });

    }

    public void signup(View view)
    {

        Intent i = new Intent(this,Main2Activity.class);
        startActivity(i);


    }


}
