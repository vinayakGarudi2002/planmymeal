package com.example.mealmyplan;


import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class Faadp extends FirebaseRecyclerAdapter<mode3,Faadp.viewholder> {


    public Faadp(@NonNull FirebaseRecyclerOptions<mode3> options) {
        super(options);

    }

    @Override
    protected void onBindViewHolder(@NonNull viewholder holder, int position, @NonNull mode3 model) {
        holder.tv.setText(model.getName());
        Glide.with(holder.img.getContext()).load(model.getImg()).into(holder.img);
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cdirectitem,parent,false);
        return new Faadp.viewholder(view);
    }


    class viewholder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView tv;
        @SuppressLint("CutPasteId")
        public viewholder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img1);
            tv = itemView.findViewById(R.id.t1);
        }
    }
}