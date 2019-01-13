package com.shubhammm.loginsignup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Shubhamm Arora on 03-10-2017.
 */

public class ViewExperiences extends AppCompatActivity {

    RecyclerView recyclerView;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference myRef;
    private FirebaseRecyclerAdapter<ShowDataItems, ViewExperiences.ShowDataViewHolder> mFirebaseAdapter;

    public ViewExperiences() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_data_layout);
        firebaseDatabase = FirebaseDatabase.getInstance();
        myRef = firebaseDatabase.getReference("User_Detailse");
        myRef = FirebaseDatabase.getInstance().getReference("User_Detailse");


        recyclerView = (RecyclerView) findViewById(R.id.show_data_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(ViewExperiences.this));
        Toast.makeText(ViewExperiences.this, "please Wait ! Loading...", Toast.LENGTH_SHORT).show();


    }


    @Override
    public void onStart() {
        super.onStart();
        //Log.d("LOGGED", "IN onStart ");
        mFirebaseAdapter = new FirebaseRecyclerAdapter<ShowDataItems, ViewExperiences.ShowDataViewHolder>(ShowDataItems.class, R.layout.show_data_single_item, ViewExperiences.ShowDataViewHolder.class, myRef) {


            public void populateViewHolder(final ViewExperiences.ShowDataViewHolder viewHolder, ShowDataItems model, final int position) {
                // viewHolder.Image_URL(model.getImage_URL());
                viewHolder.Image_Title(model.getImage_Title());


                //OnClick Item


            }
        };


        recyclerView.setAdapter(mFirebaseAdapter);
    }


    public static class ShowDataViewHolder extends RecyclerView.ViewHolder {
        private final TextView image_title;
        //  private final ImageView image_url;


        public ShowDataViewHolder(final View itemView) {
            super(itemView);
            //  image_url = (ImageView) itemView.findViewById(R.id.fetch_image);
            image_title = (TextView) itemView.findViewById(R.id.fetch_image_title);


        }

        private void Image_Title(String title) {
            image_title.setText(title);
        }

    }

}
