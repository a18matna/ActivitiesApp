package com.example.brom.activitiesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class MainActivity extends AppCompatActivity {

    private TextView mMessageEditText;
    private String[] mountainNames = {"Matterhorn","Mont Blanc","Denali"};
    private String[] mountainLocations = {"Alps","Alps","Alaska"};
    private int[] mountainHeights ={4478,4808,6190};
    private ArrayList<Mountain>mountainArrayList=new ArrayList<>();


    // Create ArrayLists from the raw data above and use these lists when populating your ListView.


    private static final String LOG_TAG =
            MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE =
            "com.example.brom.activitiesapp.extra.MESSAGE";
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditText = findViewById(R.id.text_message);
        mountainArrayList.add(new Mountain("Matterhorn","Alps",4478));
        mountainArrayList.add(new Mountain("Mont Blanc","Alps",4808));
        mountainArrayList.add(new Mountain("Denali","Alaska",6190));

        //skapa en array


        // Skapa ett List-objekt med din array som in-data
        List<String> listData =new ArrayList<String>(Arrays.asList(mountainNames));


        //skapa en ArrayAdapter som kopplar samman
        // list_item_textview, my_item_textview, och listan med rådata
        //ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),R.layout.list_item_textview,R.id.my_item_textview,listData);
        ArrayAdapter<Mountain> adapter=new ArrayAdapter<Mountain>(this,R.layout.list_item_textview,R.id.my_item_textview,mountainArrayList);
        //Koppla samman ListView med ArrayAdapter
        ListView my_ListView = (ListView)findViewById(R.id.my_listview);
        my_ListView.setAdapter(adapter);

        // se att vi kan lägga till element i adaptern
        // som automatiskt blir uppdaterat i ListView:n
       // adapter.add("tillagd med adapter.add");



        my_ListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){

                Log.d(LOG_TAG, "Button clicked!");
               // Toast.makeText(getApplicationContext(), mountainArrayList.get(position).info(),Toast.LENGTH_SHORT.show());
                Intent intent = new Intent(getApplicationContext(), MountainDetailsActivity.class);
                //String message = mMessageEditText.getText().toString();
              //  intent.putExtra("Berg", "namn: " +mountainNames[position] + "\n höjd: "+mountainHeights [position] +"\n plats: "+mountainLocations[position]);
               intent.putExtra("name", mountainNames[position]);
                intent.putExtra("height", ""+ mountainHeights[position]);
                intent.putExtra("location", mountainLocations[position]);
                startActivity(intent);
            }
        });

        // 1. Create a ListView as in previous assignment
        // 2. Create a new activity named "MountainDetailsActivity
        // 3. Create a new Layout file for the MountainDetailsActivity called
        //    "activity_mountaindetails". MountainDetailsActivity must have MainActivity as its
        //    ´parent activity.
        // 4. The layout file created in step 3 must have a LinearLayout
        // 5. The layout file created in step 3 must be able to display
        //    * Mountain Name
        //    * Mountain Location
        //    * Mountain Height
        // 6. When tapping on a list item: create an Intent that includes
        //    * Mountain Name
        //    * Mountain Location
        //    * Mountain Height
        // 7. Display the MountainDetailsActivity with the data from the Intent created in step
        //    6
        // 8. From the MountainDetailsActivity you should have an option to "go back" using an
        //    left arro button. This is done by letting the MainActivity be the parent activity to
        //    MountainDetailsActivity.

    }

}
