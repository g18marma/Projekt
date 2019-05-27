package com.example.g18marma.projekt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView aboutText = (TextView)findViewById(R.id.textView3);
        TextView aboutText2 = (TextView)findViewById(R.id.textView4);
        aboutText.setText("Kost till Skott är en app som låter användaren upptäcka olika kosttillskott och granska deras näringsvärden. Appen är riktad till alla träningsintresserade i alla åldrar. ");
        aboutText2.setText("Kost till Skott är skapad av Martin Magnusson 2019");
        //123
    }

}
