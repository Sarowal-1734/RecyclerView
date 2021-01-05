package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        ArrayList<FoodModel> foods = new ArrayList<>();
        foods.add(new FoodModel("Apple", R.drawable.apple));
        foods.add(new FoodModel("Banana", R.drawable.banana));
        foods.add(new FoodModel("Burger", R.drawable.burger));
        foods.add(new FoodModel("Chicken Kabab", R.drawable.kabab));
        foods.add(new FoodModel("Nuddles", R.drawable.nuddles));
        foods.add(new FoodModel("Orange", R.drawable.orange));
        foods.add(new FoodModel("Pijja", R.drawable.pijja));
        foods.add(new FoodModel("Chicken Roll", R.drawable.roll));
        foods.add(new FoodModel("Tomato", R.drawable.tomato));
        foods.add(new FoodModel("Tomato Salad", R.drawable.salad));
        foods.add(new FoodModel("Strawberry", R.drawable.strawberry));

        FoodAdapter adapter = new FoodAdapter(MainActivity.this, foods);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
//        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new FoodAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(FoodModel food) {
                Toast.makeText(MainActivity.this,"Food Name: "+food.getFoodName()
                        +"\nPosition: "+adapter.position +"\nTotal: "+adapter.getItemCount(), Toast.LENGTH_LONG).show();
            }
        });
    }
}