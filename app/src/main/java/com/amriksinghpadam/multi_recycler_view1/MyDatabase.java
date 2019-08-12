package com.amriksinghpadam.multi_recycler_view1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabase extends SQLiteOpenHelper {
    private static final String DB_NAME = "MY_DATABASE";
    private static final String TABLE_NAME = "MY_TABLE";
    private static final int VERSION = 1;
    private static final String COL0 = "id";
    private static final String COL1 = "name";
    private static final String COL2 = "age";
    private static final String COL3 = "image";
    private static final String COL4 = "description";
    private SQLiteDatabase db;

    MyDatabase(Context context)
    {
        super(context,DB_NAME,null,VERSION);
        db  = getWritableDatabase();
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+" ( "+COL0+" INTEGER PRIMARY KEY AUTOINCREMENT, "+COL1+" TEXT, "+COL2+" INTEGER,"+COL3+" TEXT, "+COL4+" TEXT ) ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
    public boolean insetData(String name,String age,String description){
        ContentValues content = new ContentValues();
        content.put(COL1,name);
        content.put(COL2,age);
        content.put(COL4,description);
        db = getWritableDatabase();

        long result = db.insert(TABLE_NAME,null, content);

        if(result==-1) {
            return false;
        }else{
            return true;
        }

    }
    public Cursor getAllData(){
        Cursor data = db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        return data;
    }
}
