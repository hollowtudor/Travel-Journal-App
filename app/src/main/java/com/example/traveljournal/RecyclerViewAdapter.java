package com.example.traveljournal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;

import de.hdodenhof.circleimageview.CircleImageView;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";
    private List<Integer> mImagesUrl = new ArrayList<>();
    private List<String> mNames = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(List<Integer> mImagesUrl, List<String> mNames, Context mContext) {
        this.mImagesUrl = mImagesUrl;
        this.mNames = mNames;
        this.mContext = mContext;
    }

    public RecyclerViewAdapter(Main3Activity main3Activity, ArrayList<String> mNames, ArrayList<String> mImageUrls) {

    }

    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_listitem, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called. ");
        final int i = mImagesUrl.get(position);
        Glide.with(mContext)
                .load(i)
                .into(holder.image);
        holder.imageName.setText(mNames.get(position));
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on: " + mImagesUrl.get(position));
                Intent intent = new Intent(mContext, GalleryActivity.class);
                intent.putExtra("Id", mImagesUrl.get(position));
                intent.putExtra("description", mNames.get(position));

                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImagesUrl.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView image;
        TextView imageName;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_name);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }

    }
}
