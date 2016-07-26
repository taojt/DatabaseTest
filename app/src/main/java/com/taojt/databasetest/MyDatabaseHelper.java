package com.taojt.databasetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by taojt on 2016/7/26.
 */
public class MyDatabaseHelper extends SQLiteOpenHelper {
    public static final String CREATE_BOOK = "create table Book(" + "id integer primary key autoincrement, author text, price real, pages integer, name text )";
    public static final String CREATE_CATEGRORY = "create table Category(" + "id integer primary key autoincrement, " + "category_name text, " + "category_code integer)";
    private Context myContext;


    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        myContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_BOOK);
        sqLiteDatabase.execSQL(CREATE_CATEGRORY);
        Toast.makeText(myContext, "Createed succeeded.", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists Book ");
        sqLiteDatabase.execSQL("drop table if exists Category");
        onCreate(sqLiteDatabase);


    }
}
