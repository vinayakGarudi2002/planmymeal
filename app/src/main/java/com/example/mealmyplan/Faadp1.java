package com.example.mealmyplan;


import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.ArrayList;

public class Faadp1 extends FirebaseRecyclerAdapter<mode3,Faadp1.viewholder> {

    ArrayList<mode3> list = new ArrayList<>();
    public Faadp1(@NonNull FirebaseRecyclerOptions<mode3> options) {
        super(options);

    }

    @Override
    protected void onBindViewHolder(@NonNull viewholder holder, int position, @NonNull mode3 model) {
        holder.tv.setText(model.getName());


        holder.tcal.setText(model.getCal());
        holder.tvit.setText(model.getVitamin());
        holder.tfat.setText(model.getFat());
        holder.tprot.setText(model.getProt());
        holder.tcarb.setText(model.getCarb());


        Glide.with(holder.img.getContext()).load(model.getImg()).into(holder.img);
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int pos) {
                CheckBox chk = (CheckBox) v;

                if(chk.isChecked()){

                    list.add(new mode3(model.getName(), model.getImg(), model.getCal(), model.getProt(), model.getCarb(),model.getFat(), model.getVitamin()));
                }else
                if(!chk.isChecked()){
                    list.remove(new mode3(model.getName(), model.getImg(), model.getCal(), model.getProt(), model.getCarb(),model.getFat(), model.getVitamin()));
                }
            }
        });

    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.obca,parent,false);
        return new Faadp1.viewholder(view);
    }


    class viewholder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView img;
        TextView tv,tcal,tprot,tcarb,tvit,tfat;
        CheckBox chk;

        ItemClickListener itemClickListener;


        @SuppressLint("CutPasteId")
        public viewholder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img1);
            tv = itemView.findViewById(R.id.t1);

            tcal = itemView.findViewById(R.id.tcal);
            tprot = itemView.findViewById(R.id.tprot);
            tcarb = itemView.findViewById(R.id.tcarb);
            tfat = itemView.findViewById(R.id.tfat);
            tvit = itemView.findViewById(R.id.tvit);



            chk = itemView.findViewById(R.id.chk);
            chk.setOnClickListener(this);
        }
        public void setItemClickListener(ItemClickListener ic){
            this.itemClickListener=ic;
        }

        @Override
        public void onClick(View v) {
            this.itemClickListener.onItemClickListener(v,getLayoutPosition());
        }
    }
}
