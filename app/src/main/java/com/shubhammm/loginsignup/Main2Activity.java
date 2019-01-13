package com.shubhammm.loginsignup;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Main2Activity extends AppCompatActivity {

    EditText email,password;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser()!= null)
        {
            // LOGIN ACTIVITY
            finish();
            startActivity(new Intent(getApplicationContext(),Profile_Activity.class));
        }




        email=(EditText) findViewById(R.id.email);
        password=(EditText) findViewById(R.id.password);





    }


    public void signup(View view)
    {


        String  str_email= email.getText().toString() + "@gmail.com";
        String  str_password= password.getText().toString();




        if(TextUtils.isEmpty(str_email)){
            Toast.makeText(this,"Please enter email",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(str_password)){
            Toast.makeText(this,"Please enter password",Toast.LENGTH_LONG).show();
            return;
        }

        progressDialog.setMessage("Registering User....");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(str_email,str_password).addOnCompleteListener(this,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(Main2Activity.this,"Registered Successfully",Toast.LENGTH_SHORT).show();

                        finish();
                        startActivity(new Intent(getApplicationContext(),Main5Activity.class));

                }
                else
                {
                    Toast.makeText(Main2Activity.this,"TRY Again",Toast.LENGTH_SHORT).show();
                }
                progressDialog.dismiss();

            }
        });



    }
}
