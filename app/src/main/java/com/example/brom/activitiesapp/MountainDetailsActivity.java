package com.example.brom.activitiesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MountainDetailsActivity extends AppCompatActivity {


   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_mountaindetails);
       TextView incomingData = (TextView) findViewById(R.id.text_message);


       Intent incomingIntent = getIntent();
       String incomingname = incomingIntent.getStringExtra("name");
       String incomingheight = incomingIntent.getStringExtra("height");
       String incominglocation = incomingIntent.getStringExtra("location");

       incomingData.setText ("namn: "+ (incomingname)+"\n Höjd: "+(incomingheight)+"\n Plats: "+(incominglocation));

   }

}
