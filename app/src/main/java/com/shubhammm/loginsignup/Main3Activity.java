package com.shubhammm.loginsignup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Main3Activity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser()== null)
        {
            // LOGIN ACTIVITY
            finish();
            startActivity(new Intent(getApplicationContext(),Main4Activity.class));
        }

    }




     public void profilee(View view)
    {

        Intent i = new Intent(this,Main5Activity.class);
        startActivity(i);


    }

    public void upcompany(View view)
    {

        Intent i = new Intent(this,ShowData.class);
        startActivity(i);


    }

    public void plastats(View view)
    {

        Intent i = new Intent(this,ShowDatap.class);
        startActivity(i);


    }

    public void interexp(View view)
    {

        Intent i = new Intent(this,ViewExperiences.class);
        startActivity(i);


    }

    public void share(View view)
    {

        Intent i = new Intent(this,ShareExperience.class);
        startActivity(i);


    }

    public void knowtpo(View view)
    {

        Intent i = new Intent(this,KnowTpo.class);
        startActivity(i);


    }

    public void aboutus(View view)
    {

        Intent i = new Intent(this,AboutUs.class);
        startActivity(i);


    }

    public void logout(View view)
    {
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(this,Main4Activity.class));


    }


}
