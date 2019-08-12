package com.amriksinghpadam.multi_recycler_view1;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewClass extends AppCompatActivity {
    ListView listView;
    MyDatabase db;
    String[] ar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_class);

        listView = findViewById(R.id.listViewId);

        db = new MyDatabase(this);
        Cursor allData = db.getAllData();
        int count = allData.getCount();
        final String[] val = new String[count];
        int i =0;
        while (allData.moveToNext())
        {
            val[i]=allData.getString(0)+"- "+allData.getString(1);
            i++;
        }
        ArrayAdapter cursorAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,val);
        listView.setAdapter(cursorAdapter);

    }
}
