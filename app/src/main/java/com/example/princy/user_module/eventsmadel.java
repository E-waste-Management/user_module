package com.example.princy.user_module;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.princy.user_module.dbhelper;

public class eventsmadel {
    static SQLiteDatabase database;
    public static dbhelper dbhelper1;
    public static dbhelper getInstance(Context context)
    {
        if (dbhelper1==null) {
            dbhelper1=new dbhelper(context);
        }
        return dbhelper1;
    }
    public static void open()
    {
        database=dbhelper1.getWritableDatabase();
    }
    public static void close()
    {

        database.close();
    }
    public static void add(String name, String email, String phone, String pass, String street, String address,String city,String pin)
    {
        ContentValues cv=new ContentValues();
        cv.put(keys.Col_NAME,name);
        cv.put(keys.Col_EMAIL, email);
        cv.put(keys.Col_PHONE, phone);
        cv.put(keys.Col_PASS, pass);
        cv.put(keys.Col_STREET, street);
        cv.put(keys.Col_ADDRESS,address);
        cv.put(keys.Col_CITY,city);
        cv.put(keys.Col_PIN,pin);

        database.insertOrThrow(keys.TBL_NAME,null,cv);
        Log.i("princy","Record Inserted Successfully");
    }

}
