package com.example.brom.listviewjsonapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Kostinfo extends AppCompatActivity {

    private static final String TAG = "Kostinfo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kostinfo2);
        TextView incomingData1 = (TextView) findViewById(R.id.textView2);
        TextView incomingData = (TextView) findViewById(R.id.textView);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent IncomingIntent = getIntent();
        String IncomingName = IncomingIntent.getStringExtra("name");
        String IncomingType = IncomingIntent.getStringExtra("type");
        String IncomingCompany = IncomingIntent.getStringExtra("company");
        int IncomingPrice = IncomingIntent.getIntExtra("price", 0);
        int IncomingSize = IncomingIntent.getIntExtra("size", 0 );
        int IncomingScoop = IncomingIntent.getIntExtra("scoop", 0);


        incomingData1.setText("Sort: " + IncomingType + "\nTillverkare: " + IncomingCompany + "\nPris: " + IncomingPrice + "kr\nStorlek:  " + IncomingSize + "g\nDoseringar " + IncomingScoop+ "st");
        incomingData.setText(IncomingName);





        };
    }

