package com.shubhammm.loginsignup;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class Fetch_from_firebase extends AppCompatActivity {
    private RecyclerView post_list;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_from_firebase);
        mDatabase = FirebaseDatabase.getInstance().getReference("User_Details");
      //  mDatabase = FirebaseDatabase.getInstance().getReference("User_Details");


        mDatabase.keepSynced(true);

        post_list = (RecyclerView) findViewById(R.id.recyclerView);
        post_list.setHasFixedSize(true);
        post_list.setLayoutManager(new LinearLayoutManager(Fetch_from_firebase.this));

        Toast.makeText(Fetch_from_firebase.this, "please Wait ! Loading...", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onStart(){
        super.onStart();


        FirebaseRecyclerAdapter<post_firebase,PostHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter
                <post_firebase,PostHolder>
                (post_firebase.class,R.layout.firebase_post,PostHolder.class,mDatabase){

            public void populateViewHolder(final PostHolder viewHolder, final post_firebase model ,int position){
                viewHolder.setTitle(model.getTitle());
                viewHolder.setDesc(model.getDesc());
                viewHolder.setImage(getApplicationContext(),model.getImage());

            }
        };

        post_list.setAdapter(firebaseRecyclerAdapter);
        Toast.makeText(Fetch_from_firebase.this, "keep calm...", Toast.LENGTH_SHORT).show();
    }




    public static class PostHolder extends RecyclerView.ViewHolder {
        View mView;

        public PostHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }


        public void setTitle(String title) {
            TextView post_title = (TextView) mView.findViewById(R.id.post_title);
            post_title.setText(title);
        }

        public void setDesc(String desc) {
            TextView post_desc = (TextView) mView.findViewById(R.id.post_desc);
            post_desc.setText(desc);
        }

        public void setImage(Context ctx, String image) {
            ImageView post_Image = (ImageView) mView.findViewById(R.id.post_image);
            Picasso.with(ctx).load(image).into(post_Image);
        }

    }
}
