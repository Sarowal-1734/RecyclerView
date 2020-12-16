package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.MyViewHolder> {

    Context context;
    ArrayList<FoodModel> arrayList;

    public FoodAdapter(Context context, ArrayList<FoodModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.food_item_row, parent,false); //if true the app will crash
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.foodName.setText(arrayList.get(position).foodName);
        holder.foodImage.setImageResource(arrayList.get(position).foodImage);
    }

    @Override
    public int getItemCount() {
        return arrayList.size(); //number of items in the list
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView foodName;
        ImageView foodImage;
        public MyViewHolder(View itemView){
            super(itemView);
            foodName = itemView.findViewById(R.id.foodName);
            foodImage = itemView.findViewById(R.id.foodImage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,"Food Name: "+arrayList.get(getAdapterPosition()).foodName
                            +"\nPosition: "+getAdapterPosition() +"\nTotal: "+getItemCount(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }


}
