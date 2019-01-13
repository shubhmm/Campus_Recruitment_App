package com.shubhammm.loginsignup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Shubhamm Arora on 01-10-2017.
 */

public class ShowDatap extends AppCompatActivity {

    RecyclerView recyclerView;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference myRef;
    private FirebaseRecyclerAdapter<ShowDataItems,ShowDatap.ShowDataViewHolder> mFirebaseAdapter;

    public ShowDatap() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_data_layout);
        firebaseDatabase = FirebaseDatabase.getInstance();
        myRef = firebaseDatabase.getReference("User_Detailsp");
        myRef = FirebaseDatabase.getInstance().getReference("User_Detailsp");


        recyclerView = (RecyclerView)findViewById(R.id.show_data_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(ShowDatap.this));
        Toast.makeText(ShowDatap.this, "please Wait ! Loading...", Toast.LENGTH_SHORT).show();


    }


    /**
     *
     */
    @Override
    public void onStart() {
        super.onStart();
        //Log.d("LOGGED", "IN onStart ");
        mFirebaseAdapter = new FirebaseRecyclerAdapter<ShowDataItems, ShowDatap.ShowDataViewHolder>
                (ShowDataItems.class, R.layout.show_data_single_item, ShowDatap.ShowDataViewHolder.class, myRef) {




            public void populateViewHolder(final ShowDatap.ShowDataViewHolder viewHolder, ShowDataItems model, final int position) {
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

        //  public void Image_URL(Context ctx ,  String image) {
        // image_url.setImageResource(R.drawable.loading);
        // ImageView image_url = (ImageView)itemView.findViewById(R.id.fetch_image);
        //   Picasso.with(ctx).load(image).into(image_url);
        //}


        // public void Image_URL(Context ctx , String image_url) {
        //   ImageView image_urll = (ImageView)itemView.findViewById(R.id.fetch_image);
        //   Picasso.with(ctx).load(image_url).into(image_urll);

        //}
    }

}
