package com.example.princy.user_module;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class help extends AppCompatActivity {
    ImageView imgcall;
    ImageView imgemail;
    ImageView imgfb, imginsta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        imgcall = findViewById(R.id.imgconta);
        imgemail = findViewById(R.id.imggmail);
        imgfb = findViewById(R.id.imgfb);
        imginsta = findViewById(R.id.imginsta);
        imgemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_TEXT, "GET MY CONTENT");
                i.putExtra(Intent.EXTRA_SUBJECT, "FEEDBACK ");
                i.putExtra(Intent.EXTRA_EMAIL, new String[]{"princystalinnadar123@gmail.com"});
                startActivity(i);
            }
        });
        imgfb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/?_rdr"));
                startActivity(i);

            }
        });
        imginsta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/" +
                        "_learnwithmindscript_/?utm_source=ig_profile_share&igshid=1v5n1l0id9m3w"));
                startActivity(i);

            }
        });

    }
}







