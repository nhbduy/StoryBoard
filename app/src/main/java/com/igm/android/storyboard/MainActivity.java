package com.igm.android.storyboard;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static int RESULT_LOAD_IMAGE = 1;
    private static int RESULT_LOAD_AUDIO = 2;
    private static int RESULT_LOAD_VIDEO = 3;
    private ListView list_lv;
    private EditText col1_ed;
    private EditText col2_ed;
    private EditText titre_ed;
    private EditText dateEvent_ed;
    private EditText desc_ed;
    private EditText audio_ed;
    private EditText image_ed;
    private EditText video_ed;
    private EditText lat_ed;
    private EditText lon_ed;
    private EditText ville_ed;
    private ImageView imageV;


    private Button sub_btn;// ajouter
    private Button ref_btn;// supprimer
    private Button pers_btn;
    private Button event_btn;
    private Button voir_btn;
    private DBclass db;

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        ref_btn = (Button) findViewById(R.id.refresh_btn);
        pers_btn = (Button) findViewById(R.id.pers_btn);
        voir_btn = (Button) findViewById(R.id.voir_btn);

        event_btn = (Button) findViewById(R.id.event_btn);
        col1_ed = (EditText) findViewById(R.id.ed1);
        col2_ed = (EditText) findViewById(R.id.ed2);
        desc_ed = (EditText) findViewById(R.id.ed3);

        audio_ed = (EditText) findViewById(R.id.ed4);
        image_ed = (EditText) findViewById(R.id.ed5);
        imageV = (ImageView) findViewById(R.id.imageEV);
        video_ed = (EditText) findViewById(R.id.ed6);

        lat_ed = (EditText) findViewById(R.id.ed7);
        lon_ed = (EditText) findViewById(R.id.ed8);
        ville_ed = (EditText) findViewById(R.id.ed9);

        list_lv = (ListView) findViewById(R.id.dblist);

        image_ed.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, RESULT_LOAD_IMAGE);


            }
        });


        audio_ed.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
                //	   RESULT_LOAD_AUDIO=1;
                startActivityForResult(i, RESULT_LOAD_AUDIO);


            }
        });

        video_ed.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
                // 	RESULT_LOAD_VIDEO=1;
                startActivityForResult(i, RESULT_LOAD_VIDEO);


            }
        });

        ref_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                /************ action supprimer**********/
                db.open();
                String a = col1_ed.getText().toString();
                db.delete(a);
                db.close();
                getData();
            }
        });

        sub_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                submitData();
            }
        });


        pers_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


/************************************************************************************************/
                Intent intent = new Intent(MainActivity.this, personnage.class);
                startActivity(intent);


            }
        });


        voir_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


/************************************************************************************************/
                Intent intent = new Intent(MainActivity.this, mainvu.class);
                startActivity(intent);


            }
        });
    }

    protected void submitData() {

        String a = col1_ed.getText().toString();
        String b = col2_ed.getText().toString();
        String desc = desc_ed.getText().toString();

        String audio = audio_ed.getText().toString();
        String image = image_ed.getText().toString();
        String video = video_ed.getText().toString();


        String lat = lat_ed.getText().toString();
        String lon = lon_ed.getText().toString();
        String ville = ville_ed.getText().toString();


        db = new DBclass(this);
        long num = 1;
        try {
            db.open();                    //titre, date,desc.....


            num = db.insertmaster(a, b, a, b, desc, audio, image, video, lat, lon, ville);

            db.close();
        } catch (SQLException e) {
            num = -5;
        } finally {
            getData();
        }
        if (num > 0)
            Toast.makeText(this, "Evenement Ajouté ", 2000).show();
        else if (num == -1)
            Toast.makeText(this, "Error Duplicate value", 4000).show();
        else
            Toast.makeText(this, "Error while inserting", 2000).show();
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


        db = new DBclass(this);
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
            image_ed.setText(picturePath);

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
            audio_ed.setText(picturePath);
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
            video_ed.setText(picturePath);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
