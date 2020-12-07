package com.example.movies;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView movieId, movieName, movieActor;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        movieId = itemView.findViewById(R.id.mId);
        movieName = itemView.findViewById(R.id.mName);
        movieActor = itemView.findViewById(R.id.mActor);
    }
}
