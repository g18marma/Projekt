package com.example.brom.listviewjsonapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Kostinfo extends AppCompatActivity {

    private static final String TAG = "Kostinfo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kostinfo);

        TextView incomingData = (TextView) findViewById(R.id.list_item_textview);

        Intent incomingIntent = getIntent();
        String incomingName = incomingIntent.getStringExtra("" );

        incomingData.setText(incomingName);
    }
}
