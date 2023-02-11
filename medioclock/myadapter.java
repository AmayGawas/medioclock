package com.example.medioclock;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class myadapter extends FirebaseRecyclerAdapter<model,myadapter.myviewholder>


{
    public myadapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull model model) {

        holder.name.setText(model.getName());
        holder.used_for.setText(model.getUsed_for());
        holder.side_effects.setText(model.getSide_effects());
        holder.product_form.setText(model.getProduct_form());
        holder.habit_forming.setText(model.getHabit_forming());
        holder.group.setText(model.getGroup());
        holder.category.setText(model.getCategory());
        holder.age_group.setText(model.getAge_group());
        holder.administration_route.setText(model.getAdministration_route());

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder{
        TextView administration_route,age_group,category,group,habit_forming,name,product_form,side_effects,used_for;

        public myviewholder(@NonNull View itemView) {

            super(itemView);
            administration_route=(TextView)itemView.findViewById(R.id.administration_route);
           age_group=(TextView)itemView.findViewById(R.id.age_group);
            category=(TextView)itemView.findViewById(R.id.category);
        group=(TextView)itemView.findViewById(R.id.group);
           habit_forming=(TextView)itemView.findViewById(R.id.habit_forming);
            name=(TextView)itemView.findViewById(R.id.name);
            product_form=(TextView)itemView.findViewById(R.id.product_form);
        side_effects=(TextView)itemView.findViewById(R.id.side_effects);
        used_for=(TextView)itemView.findViewById(R.id.used_for);
        }
    }
}
