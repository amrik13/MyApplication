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
    RecyclerView recyclerView,recyclerView2;
    LinearLayout layout;
    ArrayList<String> imgList = new ArrayList<>();
    ArrayList<String> textList = new ArrayList<>();

    ArrayList<String> imgList2 = new ArrayList<>();
    ArrayList<String> textList2 = new ArrayList<>();

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

        imgList2.add("https://static.thenounproject.com/png/183640-200.png");
        textList2.add("User 1");
        imgList2.add("https://static.thenounproject.com/png/183640-200.png");
        textList2.add("User 2");
        imgList2.add("https://static.thenounproject.com/png/183640-200.png");
        textList2.add("User 3");
        imgList2.add("https://static.thenounproject.com/png/183640-200.png");
        textList2.add("User 4");
        imgList2.add("https://static.thenounproject.com/png/183640-200.png");
        textList2.add("User 5");
        imgList2.add("https://static.thenounpro ject.com/png/183640-200.png");
        textList2.add("User 6");
        imgList2.add("https://static.thenounproject.com/png/183640-200.png");
        textList2.add("User 7");
        imgList2.add("https://static.thenounproject.com/png/183640-200.png");
        textList2.add("User 8");
        imgList2.add("https://static.thenounproject.com/png/183640-200.png");
        textList2.add("User 9");

            recyclerView = findViewById(R.id.recyclerViewId);
            recyclerView2 = findViewById(R.id.recyclerViewId2);
            layout = findViewById(R.id.layoutId);
            AdapterClass adapter = new AdapterClass(imgList,textList,this);
            recyclerView.setAdapter(adapter);
            //recyclerView.setLayoutManager(new GridLayoutManager(this,2));
            recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

            AdapterClass adapter2 = new AdapterClass(imgList2,textList2,this);
            recyclerView2.setAdapter(adapter2);
            //recyclerView.setLayoutManager(new GridLayoutManager(this,2));
            recyclerView2.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));


    }
}
