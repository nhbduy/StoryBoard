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

public class MainVu extends Activity {
    private static int RESULT_LOAD_IMAGE = 1;
    private static int RESULT_LOAD_AUDIO = 2;
    private static int RESULT_LOAD_VIDEO = 3;
    private ListView list_lv;

    private ImageView imageV;


    private Button sub_btn;// ajouter
    // supprimer
    private Button pers_btn;
    private Button event_btn;
    private DbClass db;

    private ArrayList<String> collist_1;
    private ArrayList<String> collist_2;
    private ArrayList<String> descrlist;

    private ArrayList<String> audiolist;
    private ArrayList<String> imagelist;
    private ArrayList<String> videolist;

    private ArrayList<String> latlist;
    private ArrayList<String> lonlist;
    private ArrayList<String> villelist;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainvu);
        collist_1 = new ArrayList<String>();
        collist_2 = new ArrayList<String>();
        descrlist = new ArrayList<String>();

        audiolist = new ArrayList<String>();
        imagelist = new ArrayList<String>();
        videolist = new ArrayList<String>();


        latlist = new ArrayList<String>();
        lonlist = new ArrayList<String>();
        villelist = new ArrayList<String>();


        items();
        getData();
    }

    private void items() {
        sub_btn = (Button) findViewById(R.id.submit_btn);

        pers_btn = (Button) findViewById(R.id.pers_btn);
        event_btn = (Button) findViewById(R.id.event_btn);

        imageV = (ImageView) findViewById(R.id.imageEV);


        list_lv = (ListView) findViewById(R.id.dblist);


        sub_btn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainVu.this, Main.class);
                startActivity(intent);
            }
        });


        pers_btn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {


/************************************************************************************************/
                Intent intent = new Intent(MainVu.this, PersonnageVu.class);
                startActivity(intent);


            }
        });
    }


    public void getData() {
        collist_1.clear();
        collist_2.clear();
        descrlist.clear();

        audiolist.clear();
        imagelist.clear();
        videolist.clear();

        latlist.clear();
        lonlist.clear();
        videolist.clear();


        db = new DbClass(this);
        try {
            db.open();
            Cursor cur = db.getAllTitles();
            while (cur.moveToNext()) {
                String valueofcol1 = cur.getString(1);
                String valueofcol2 = cur.getString(2);
                String valueoftitre = cur.getString(3);
                String valueofdate = cur.getString(4);

                String valueofdesc = cur.getString(5);
                String valueofaudio = cur.getString(6);

                String valueofimage = cur.getString(7);
                String valueofvideo = cur.getString(8);

                String valueoflat = cur.getString(9);
                String valueoflon = cur.getString(10);
                String valueofville = cur.getString(11);


                collist_1.add(valueofcol1);
                collist_2.add(valueofcol2);
                descrlist.add(valueofdesc);
                audiolist.add(valueofaudio);
                imagelist.add(valueofimage);
                videolist.add(valueofvideo);
                latlist.add(valueoflat);
                lonlist.add(valueoflon);
                villelist.add(valueofville);


            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
        printList();
        setDataIntoList();
    }

    private void printList() {
        for (int i = 0; i < collist_1.size(); i++) {
            Log.e("***************",
                    collist_1.get(i) + " --- " + collist_2.get(i));
        }
    }

    private void setDataIntoList() {

        // create the list item mapping
        String[] from = new String[]{"col_1", "col_2", "desc", "audio", "image", "imageV", "video"/*"lat","lon"*/, "ville"};
        int[] to = new int[]{R.id.col1tv, R.id.col2tv, R.id.desctv, R.id.audio, R.id.image, R.id.imageEV, R.id.video,/*R.id.lat,R.id.lon,*/R.id.ville};

        // prepare the list of all records
        List<HashMap<String, String>> fillMaps = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < collist_1.size(); i++) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("col_1", collist_1.get(i));
            map.put("col_2", collist_2.get(i));
            map.put("desc", descrlist.get(i));

            map.put("audio", audiolist.get(i));
            map.put("image", imagelist.get(i));
            map.put("imageV", imagelist.get(i));

            map.put("video", videolist.get(i));
        
          /*  map.put("lat", latlist.get(i));
            map.put("lon", lonlist.get(i));
          */
            map.put("ville", villelist.get(i));

            fillMaps.add(map);
        }

        // fill in the grid_item layout
        SimpleAdapter adapter = new SimpleAdapter(this, fillMaps,
                R.layout.custom, from, to);
        list_lv.setAdapter(adapter);
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            //	imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));*/

        }


        if (requestCode == RESULT_LOAD_AUDIO && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

			/*ImageView imageView = (ImageView) findViewById(R.id.imgView);
			imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));*/

        }


        if (requestCode == RESULT_LOAD_VIDEO && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
			
			/*ImageView imageView = (ImageView) findViewById(R.id.imgView);
			imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));*/

        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}