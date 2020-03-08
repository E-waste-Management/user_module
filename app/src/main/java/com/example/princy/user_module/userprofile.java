package com.example.princy.user_module;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

public class userprofile extends AppCompatActivity {
         Button btnitem1 , btnquote1 ;
         Spinner cat1 , cat2 ;
         ImageView cam1 , cam2;
         EditText edtproduct ,edtquan;
         CheckBox checkitem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);
        btnitem1 = findViewById(R.id.btnitem);
        btnquote1=  findViewById(R.id.btnquote);
        cat1 = findViewById(R.id.cat);
        cat2 = findViewById(R.id.cat1);
        cam1 = findViewById(R.id.camera1);
        cam2 = findViewById(R.id.camera2);
        edtproduct = findViewById(R.id.pd);
        edtquan = findViewById(R.id.edquantity);
        checkitem = findViewById(R.id.chksave);


    }
}
