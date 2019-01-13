package com.shubhammm.loginsignup;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Profile_Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {



    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference myRef;
    private  String userID;
    private ArrayAdapter<String> adapter;
    private ListView mListView;
    List<String> itemlist;
    FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        user = mAuth.getCurrentUser();
        userID = user.getUid();
        myRef = mFirebaseDatabase.getReference();
        mListView = (ListView)findViewById(R.id.listview);



        itemlist = new ArrayList<>();

/*
    myRef.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            itemlist.clear();

            String user_name =  dataSnapshot.child(userID).child("name").getValue(String.class);
            String user_branch =  dataSnapshot.child(userID).child("branch").getValue(String.class);
            String user_cpi =  dataSnapshot.child(userID).child("cpi").getValue(String.class);
            String user_registration =  dataSnapshot.child(userID).child("registration").getValue(String.class);
            String user_email =  dataSnapshot.child(userID).child("yearop").getValue(String.class);

            itemlist.add(user_name);
            itemlist.add(user_branch);
            itemlist.add(user_cpi);
            itemlist.add(user_registration);
            itemlist.add(user_email);


            adapter = new ArrayAdapter<String>(Profile_Activity.this,android.R.layout.simple_list_item_1,itemlist){
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    // Get the Item from ListView
                    View view = super.getView(position, convertView, parent);

                    // Initialize a TextView for ListView each Item
                    TextView tv = (TextView) view.findViewById(android.R.id.text1);

                    // Set the text color of TextView (ListView Item)
                    tv.setTextColor(Color.WHITE);
                    tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP,20);
                    // Generate ListView Item using TextView
                    return view;
                }



            };
            mListView.setAdapter(adapter);

        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });


*/

    }







    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.profile_, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent i = new Intent(this,Main5Activity.class);
            startActivity(i);
        } else if (id == R.id.nav_gallery) {
           Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.mnnit.ac.in/tnp/"));
            startActivity(browser);
        } else if (id == R.id.nav_slideshow) {
            Intent i = new Intent(this,ShareExperience.class);
            startActivity(i);
        } else if (id == R.id.nav_manage) {
            mAuth.signOut();
            finish();
            startActivity(new Intent(this,Main4Activity.class));
        } else if (id == R.id.nav_share) {
            Intent i = new Intent(this,KnowTpo.class);
            startActivity(i);
        } else if (id == R.id.nav_send) {
            Intent i = new Intent(this,AboutUs.class);
            startActivity(i);
        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void upcompany(View view)
    {

        Intent i = new Intent(this,Fetch_from_firebase.class);
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
}
