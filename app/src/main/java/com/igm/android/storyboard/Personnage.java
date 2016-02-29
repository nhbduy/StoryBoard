package com.igm.android.storyboard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class Personnage extends Activity {

    private ListView list_lv;
    private static int RESULT_LOAD_IMAGE = 1;
    private EditText titre_event;
    private EditText nom_ed;
    private EditText prenom_ed;
    private EditText image_ed;
    private EditText bio_ed;
    private EditText actions_ed;
    private ImageView imageV;

    private Button sub_btn;// ajouter
    private Button ref_btn;// supprimer
    private Button event_btn;// ajouter
    private Button voir_btn;
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
        setContentView(R.layout.personnage);
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
        ref_btn = (Button) findViewById(R.id.refresh_btn);
        event_btn = (Button) findViewById(R.id.event_btn);
        voir_btn = (Button) findViewById(R.id.voir_btn);

        titre_event = (EditText) findViewById(R.id.p1);
        nom_ed = (EditText) findViewById(R.id.p2);
        prenom_ed = (EditText) findViewById(R.id.p3);

        image_ed = (EditText) findViewById(R.id.p4);
        imageV = (ImageView) findViewById(R.id.imagePV);
        bio_ed = (EditText) findViewById(R.id.p5);
        actions_ed = (EditText) findViewById(R.id.p6);


        list_lv = (ListView) findViewById(R.id.dblist);


        image_ed.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, RESULT_LOAD_IMAGE);


            }
        });


        ref_btn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {


                /************ action supprimer**********/
                db.open();
                String a = nom_ed.getText().toString();
                db.deletePersonne(a);
                db.close();
                getData();
            }
        });

        sub_btn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                submitData();
            }
        });


        event_btn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {


/************************************************************************************************/
                Intent intent = new Intent(Personnage.this, Main.class);
                startActivity(intent);


            }
        });


        voir_btn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {


/************************************************************************************************/
                Intent intent = new Intent(Personnage.this, PersonnageVu.class);
                startActivity(intent);


            }
        });
    }


    protected void submitData() {

        String a = titre_event.getText().toString();
        String b = nom_ed.getText().toString();
        String prenom = prenom_ed.getText().toString();

        String image = image_ed.getText().toString();
        String bio = bio_ed.getText().toString();
        String actions = actions_ed.getText().toString();


        db = new DbClass(this);
        long num = 1;
        try {
            db.open();                    //titre, date,desc.....
            num = db.insertMasterPersonne(a, b, prenom, image, bio, actions);

            db.close();
        } catch (SQLException e) {
            num = -5;
        } finally {
            getData();
        }
        if (num > 0)
            Toast.makeText(this, "Personnage Ajouté ", Toast.LENGTH_SHORT).show();

        else if (num == -1)
            Toast.makeText(this, "Error Duplicate value", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "Error while inserting", Toast.LENGTH_SHORT).show();
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
        image_ed.setText(picturePath);

        //	imageV.setImageBitmap(BitmapFactory.decodeFile(picturePath));


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}