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
    //for use onItemClickListener from MainActivity
    private OnItemClickListener listener;
    int position;

    Context context;
    ArrayList<FoodModel> foods;

    public FoodAdapter(Context context, ArrayList<FoodModel> arrayList) {
        this.context = context;
        this.foods = arrayList;
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
        holder.foodName.setText(foods.get(position).foodName);
        holder.foodImage.setImageResource(foods.get(position).foodImage);
    }

    @Override
    public int getItemCount() {
        return foods.size(); //number of items in the list
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView foodName;
        ImageView foodImage;
        public MyViewHolder(View itemView){
            super(itemView);
            foodName = itemView.findViewById(R.id.foodName);
            foodImage = itemView.findViewById(R.id.foodImage);

            //for use onItemClickListener from MainActivity
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    position = getAdapterPosition();
                    if(listener != null && position != -1) {
                        listener.onItemClick(foods.get(position));
                    }
                }
            });
        }
    }

    //for use onItemClickListener from MainActivity
    public interface OnItemClickListener {
        void onItemClick(FoodModel food);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

}
