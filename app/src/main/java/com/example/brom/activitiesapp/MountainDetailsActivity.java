package com.example.brom.activitiesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MountainDetailsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mountaindetails);
        TextView incomingData = (TextView) findViewById(R.id.text_message);
        TextView header=(TextView) findViewById(R.id.text_header);

        Intent incomingIntent = getIntent();
        String incomingname = incomingIntent.getStringExtra("name");
        String incomingheight = incomingIntent.getStringExtra("height");
        String incominglocation = incomingIntent.getStringExtra("location");

        header.setText(" "+(incomingname));
        incomingData.setText(" Namn: " + (incomingname) + "\n Höjd: " + (incomingheight) + "\n Plats: " + (incominglocation));

        ImageView bild = findViewById(R.id.bild);

        if (incomingname.equals("Matterhorn")) {
            bild.setImageResource(R.drawable.matterhorntest);

        }
        else if(incomingname.equals("Denali")){
            bild.setImageResource(R.drawable.denali);
        }
        else if(incomingname.equals("Mont Blanc")){
            bild.setImageResource(R.drawable.montblanc);
        }
    }
}
