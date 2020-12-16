package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        ArrayList<FoodModel> arrayList = new ArrayList<>();
        arrayList.add(new FoodModel("Apple", R.drawable.apple));
        arrayList.add(new FoodModel("Banana", R.drawable.banana));
        arrayList.add(new FoodModel("Burger", R.drawable.burger));
        arrayList.add(new FoodModel("Chicken Kabab", R.drawable.kabab));
        arrayList.add(new FoodModel("Nuddles", R.drawable.nuddles));
        arrayList.add(new FoodModel("Orange", R.drawable.orange));
        arrayList.add(new FoodModel("Pijja", R.drawable.pijja));
        arrayList.add(new FoodModel("Chicken Roll", R.drawable.roll));
        arrayList.add(new FoodModel("Tomato", R.drawable.tomato));
        arrayList.add(new FoodModel("Tomato Salad", R.drawable.salad));
        arrayList.add(new FoodModel("Strawberry", R.drawable.strawberry));

        FoodAdapter adapter = new FoodAdapter(MainActivity.this, arrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
//        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}