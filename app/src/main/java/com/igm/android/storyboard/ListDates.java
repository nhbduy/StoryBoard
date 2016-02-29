package com.igm.android.storyboard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.igm.android.storyboard.Details.Details1827;
import com.igm.android.storyboard.Details.Details1830;
import com.igm.android.storyboard.Details.Details1847;
import com.igm.android.storyboard.Details.Details1857;
import com.igm.android.storyboard.Details.Details1870;
import com.igm.android.storyboard.Details.Details1871;
import com.igm.android.storyboard.Details.Details1881;
import com.igm.android.storyboard.Details.Details1902;
import com.igm.android.storyboard.Details.Details1945;
import com.igm.android.storyboard.Details.Details1954;
import com.igm.android.storyboard.Details.Details1962;
import com.igm.android.storyboard.Details.DetailsDepartColons;
import com.igm.android.storyboard.Details.DetailsOuvertureDemo;
import com.igm.android.storyboard.Details.DetailsPrem;

public class ListDates extends Activity {
    ListView listView;
    String[] values;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datesprojets);

        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.listdates);

        // Defined Array values to show in ListView
        values = new String[]{"1827: Affaire de l'eventail",
                "14 juin 1830: Conquéte du port de sidi fredj",
                "Reddition d'Abd El-Kader (1847)",
                "Conquête de la Kabylie (1857)",
                "Décrets Crémieux (1870)",
                "Révoltes de 1871",
                "Code de l'indigénat (1881)",
                "Conquête du Sahara (1902)",
                "28 juillet 1914 :Première Guerre mondiale",
                "Le massacre du 8 mai 1945",
                "La Révolution algérienne (1954 à 1962)",
                "Le départ des colons européens",
                "Période du parti unique:1962",
                "L'ouverture démocratique"
        };

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);


        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // ListView Item Click Listener
        listView.setLongClickable(true);
        listView.setOnItemLongClickListener(new OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int position, long id) {
                // TODO Auto-generated method stub


                if (position == 0 || position == 1 || position == 2 || position == 3 || position == 4 || position == 5 || position == 6 || position == 7 || position == 8 || position == 9 || position == 10 || position == 11 || position == 12 || position == 13 || position == 14) {


                    final Intent MessIntent = new Intent(Intent.ACTION_SEND);
                    MessIntent.setType("text/plain");
                    MessIntent.putExtra(Intent.EXTRA_TEXT, values[position]);
                    ListDates.this.startActivity(Intent.createChooser(MessIntent, "Partager avec..."));

                }


                return false;
            }
        });


        listView.setOnItemClickListener(new OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition = position;

                // ListView Clicked item value
                String itemValue = (String) listView.getItemAtPosition(position);

                // Show Alert
                if (position == 0) {
                    Intent intent = new Intent(ListDates.this, Details1827.class);
                    startActivity(intent);
                } else if (position == 1) {
                    Intent intent = new Intent(ListDates.this, Details1830.class);
                    startActivity(intent);
                } else if (position == 2) {
                    Intent intent = new Intent(ListDates.this, Details1847.class);
                    startActivity(intent);
                } else if (position == 3) {
                    Intent intent = new Intent(ListDates.this, Details1857.class);
                    startActivity(intent);
                } else if (position == 4) {
                    Intent intent = new Intent(ListDates.this, Details1870.class);
                    startActivity(intent);
                } else if (position == 5) {
                    Intent intent = new Intent(ListDates.this, Details1871.class);
                    startActivity(intent);
                } else if (position == 6) {
                    Intent intent = new Intent(ListDates.this, Details1881.class);
                    startActivity(intent);
                } else if (position == 7) {
                    Intent intent = new Intent(ListDates.this, Details1902.class);
                    startActivity(intent);
                } else if (position == 8) {
                    Intent intent = new Intent(ListDates.this, DetailsPrem.class);
                    startActivity(intent);
                } else if (position == 9) {
                    Intent intent = new Intent(ListDates.this, Details1945.class);


                    startActivity(intent);
                } else if (position == 10) {
                    Intent intent = new Intent(ListDates.this, Details1954.class);


                    startActivity(intent);
                } else if (position == 11) {
                    Intent intent = new Intent(ListDates.this, DetailsDepartColons.class);


                    startActivity(intent);
                } else if (position == 12) {
                    Intent intent = new Intent(ListDates.this, Details1962.class);


                    startActivity(intent);
                } else if (position == 13) {
                    Intent intent = new Intent(ListDates.this, DetailsOuvertureDemo.class);


                    startActivity(intent);
                }


            }


        });


    }


}