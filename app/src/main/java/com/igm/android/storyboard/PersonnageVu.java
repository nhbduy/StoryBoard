package com.igm.android.storyboard;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PersonnageVu extends Activity {

    private ListView list_lv;
    private static int RESULT_LOAD_IMAGE = 1;

    private ImageView imageV;

    private Button sub_btn;// ajouter

    private Button event_btn;// ajouter

    private DbClass db;

    private ArrayList<String> titrelist;
    private ArrayList<String> nomlist;
    private ArrayList<String> prenomlist;
    private ArrayList<String> imagelist;

    private ArrayList<String> biolist;
    private ArrayList<String> actionslist;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personnagevu);
        titrelist = new ArrayList<String>();
        nomlist = new ArrayList<String>();
        prenomlist = new ArrayList<String>();

        imagelist = new ArrayList<String>();
        biolist = new ArrayList<String>();
        actionslist = new ArrayList<String>();

        items();
        getData();
    }

    private void items() {
        sub_btn = (Button) findViewById(R.id.submit_btn);

        event_btn = (Button) findViewById(R.id.event_btn);


        list_lv = (ListView) findViewById(R.id.dblist);


        sub_btn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonnageVu.this, Personnage.class);
                startActivity(intent);
            }
        });


        event_btn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {


/************************************************************************************************/
                Intent intent = new Intent(PersonnageVu.this, MainVu.class);
                startActivity(intent);


            }
        });
    }


    public void getData() {
        titrelist.clear();
        nomlist.clear();
        prenomlist.clear();

        imagelist.clear();
        biolist.clear();

        actionslist.clear();


        db = new DbClass(this);
        try {
            db.open();
            Cursor cur = db.getAllTitlesPersonne();
            while (cur.moveToNext()) {
                String valueoftitre = cur.getString(1);
                String valueofnom = cur.getString(2);

                String valueofprenom = cur.getString(3);
                String valueofimage = cur.getString(4);
                String valueofbio = cur.getString(5);

                String valueofactions = cur.getString(6);


                titrelist.add(valueoftitre);
                nomlist.add(valueofnom);
                prenomlist.add(valueofprenom);
                imagelist.add(valueofimage);
                biolist.add(valueofbio);
                actionslist.add(valueofactions);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
        setDataIntoListPersonne();
    }

    private void printList() {
        for (int i = 0; i < titrelist.size(); i++) {
            Log.e("***************",
                    titrelist.get(i) + " --- " + nomlist.get(i));
        }
    }

    private void setDataIntoListPersonne() {

        // create the list item mapping   imageV.setImageBitmap(BitmapFactory.decodeFile(picturePath));
        String[] from = new String[]{"titre", "nom", "prenom", "image", "imageV", "bio", "actions"};
        int[] to = new int[]{R.id.titreP, R.id.nomP, R.id.prenomP, R.id.image, R.id.imagePV, R.id.bioP, R.id.actionsP};

        // prepare the list of all records
        List<HashMap<String, String>> fillMaps = new ArrayList<HashMap<String, String>>();


        for (int i = 0; i < titrelist.size(); i++) {

            HashMap<String, String> map = new HashMap<String, String>();
            map.put("titre", titrelist.get(i));
            map.put("nom", nomlist.get(i));
            map.put("prenom", prenomlist.get(i));
            map.put("image", imagelist.get(i));
            map.put("imageV", imagelist.get(i));
            map.put("bio", biolist.get(i));
            map.put("action", actionslist.get(i));


            fillMaps.add(map);
        }

        // fill in the grid_item layout
        SimpleAdapter adapter = new SimpleAdapter(this, fillMaps,
                R.layout.elmentlistpers, from, to);

        list_lv.setAdapter(adapter);
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Uri selectedImage = data.getData();
        String[] filePathColumn = {MediaStore.Images.Media.DATA};

        Cursor cursor = getContentResolver().query(selectedImage,
                filePathColumn, null, null, null);
        cursor.moveToFirst();

        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
        String picturePath = cursor.getString(columnIndex);
        cursor.close();

        //	imageV.setImageBitmap(BitmapFactory.decodeFile(picturePath));


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}