package com.example.movies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<Helper> list;
    Context context;

    public MyAdapter(Context context, List<Helper> list) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.row_design,parent,false);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        //Toast.makeText(context,list.size()+" Movies",Toast.LENGTH_LONG).show();
        return  myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Helper helper = list.get(position);

        holder.movieId.setText(helper.getId());
        holder.movieActor.setText(helper.getActor());
        holder.movieName.setText(helper.getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
