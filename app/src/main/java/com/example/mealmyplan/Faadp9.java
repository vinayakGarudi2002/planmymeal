package com.example.mealmyplan;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class Faadp9 extends FirebaseRecyclerAdapter<mode8, Faadp9.viewholder> {


    public Faadp9(@NonNull FirebaseRecyclerOptions<mode8> options) {
        super(options);

    }

    @Override
    protected void onBindViewHolder(@NonNull viewholder holder, int position, @NonNull mode8 model) {
        holder.tv.setText(model.getName());
        holder.ta.setText(model.getAddress());
        holder.tp.setText(model.getPhoneno());
        holder.tos.setText(model.getOstate());
        holder.tr.setText(model.getRegion());
        holder.tb.setText(model.getBreakfastTime());
        holder.tl.setText(model.getLunchTime());
        holder.td.setText(model.getDinnerTime());
        holder.texp.setText(model.getExpDate());

        holder.tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(v.getContext(),CustomBreakfastPlan.class);
                i.putExtra("phoneno",model.getPhoneno());
                i.putExtra("Time","Bf");
                v.getContext().startActivity(i);
            }
        });
        holder.tl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(v.getContext(),CustomBreakfastPlan.class);
                i.putExtra("phoneno",model.getPhoneno());
                i.putExtra("Time","L");
                v.getContext().startActivity(i);
            }
        });
        holder.td.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(v.getContext(),CustomBreakfastPlan.class);
                i.putExtra("phoneno",model.getPhoneno());
                i.putExtra("Time","D");
                v.getContext().startActivity(i);
            }
        });




    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.citem,parent,false);
        return new Faadp9.viewholder(view);
    }


    class viewholder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView tv,tp,ta,tos,tr,tb,texp,tl,td;
        @SuppressLint("CutPasteId")
        public viewholder(@NonNull View itemView) {
            super(itemView);
            //  img = itemView.findViewById(R.id.img1);
            tv = itemView.findViewById(R.id.tn);
            tp = itemView.findViewById(R.id.tp);
            ta = itemView.findViewById(R.id.ta);
            tos = itemView.findViewById(R.id.tost);
            tr=itemView.findViewById(R.id.tr);
            tb=itemView.findViewById(R.id.tb1);
            tl=itemView.findViewById(R.id.tl1);
            td=itemView.findViewById(R.id.td1);
            texp=itemView.findViewById(R.id.texp);

        }
    }
}