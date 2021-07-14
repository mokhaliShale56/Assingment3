package com.example.assignment3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<Patient> list;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View v= LayoutInflater.from(context).inflate(R.layout.item, parent,false);
         return new MyViewHolder(v);
    }

    public MyAdapter(Context context, ArrayList<Patient> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Patient patient= list.get(position);
        holder.firstName.setText(patient.getFirstName());
        holder.lastName.setText(patient.getLastName());
        holder.age.setText(patient.getAge());
        holder.gender.setText(patient.getGender());
        holder.date.setText(patient.getDate());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView firstName, lastName, age, gender, date;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            firstName=itemView.findViewById(R.id.tvFirstName);
           lastName=itemView.findViewById(R.id.tvLastName);
            age=itemView.findViewById(R.id.tvAge);
            gender=itemView.findViewById(R.id.tvGender);
            date=itemView.findViewById(R.id.tvDate);
        }
    }
}
