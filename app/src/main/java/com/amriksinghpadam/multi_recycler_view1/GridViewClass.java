package com.amriksinghpadam.multi_recycler_view1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class GridViewClass extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayout layout;
    ArrayList<String> imgList = new ArrayList<>();
    ArrayList<String> textList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_class);

        MyDatabase db = new MyDatabase(this);
        Cursor data = db.getAllData();

        while(data.moveToNext()){
            imgList.add("https://image.shutterstock.com/image-vector/business-man-icon-260nw-1009389559.jpg");
            textList.add(data.getString(1));
        }
            recyclerView = findViewById(R.id.recyclerViewId);
            layout = findViewById(R.id.layoutId);
            AdapterClass adapter = new AdapterClass(imgList,textList,this);
            recyclerView.setAdapter(adapter);
            //recyclerView.setLayoutManager(new GridLayoutManager(this,2));
            recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));



    }
}
