package com.example.princy.user_module;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



    public class dbhelper extends SQLiteOpenHelper {
        String create_table= "create table " + keys.TBL_NAME + "(" + keys.Col_ID + " integer primary key autoincrement, " +
                keys.Col_NAME + " text not null, " + keys.Col_EMAIL + " text not null, " + keys.Col_PHONE + " text not null, " +
                keys.Col_PASS + " text not null, " + keys.Col_STREET + " text not null, " + keys.Col_ADDRESS + " text not null, " + keys.Col_CITY+ " number not null,"+ keys.Col_PIN + " text not null);";

        public dbhelper (Context context){
            super(context, keys.DB_NAME,null, keys.DB_VERSION);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.i("princy",create_table);
            db.execSQL(create_table);
            Log.i("princy","Table created");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
            onCreate(db);
        }
    }


