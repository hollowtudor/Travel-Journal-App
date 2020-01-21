package com.example.traveljournal;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
    public class GalleryActivity extends AppCompatActivity {

        private static final String TAG = "GalleryActivity";

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_gallery);
            Log.d(TAG, "onCreate: started.");

            getIncomingIntent();
        }

        private void getIncomingIntent(){
            Log.d(TAG, "getIncomingIntent: checking for incoming intents.");

            if(getIntent().hasExtra("Id") && getIntent().hasExtra("description")){
                Log.d(TAG, "getIncomingIntent: found intent extras.");

                int imageUrl = getIntent().getIntExtra("Id",0);
                String imageName = getIntent().getStringExtra("description");
                setImage(imageUrl, imageName);
               // Log.d("Description",imageName);
            }
        }


        private void setImage(int imageUrl, String imageName){
            Log.d(TAG, "setImage: setting te image and name to widgets.");

            TextView name = findViewById(R.id.image_description);
            name.setText(imageName);

            ImageView image = findViewById(R.id.image);
            Glide.with(this)
                    //.asBitmap()
                    .load(imageUrl)
                    .into(image);
        }

    }



