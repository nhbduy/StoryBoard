package com.igm.android.storyboard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbClass {

    public static final String KEY_ROWID = "_id";
    public static final String KEY_COL1 = "col1";
    public static final String KEY_COL2 = "col2";
    public static final String KEY_TITRE = "titre";
    public static final String KEY_DATE = "dateEvent";
    public static final String KEY_DESC = "desc";
    public static final String KEY_AUDIO = "audio";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_VIDEO = "video";
    public static final String KEY_LAT = "lat";
    public static final String KEY_LON = "lon";
    public static final String KEY_VILLE = "ville";

    private static final String DATABASE_NAME = "mydb";
    private static final String DATABASE_TABLE = "mytable";
    private static final String DATABASE_TABLE2 = "personneTable";
    private static final int DATABASE_VERSION = 1;

    private final Context ourContext;
    private DbHelper dbh;
    private SQLiteDatabase odb;


    public static final String PER_ID = "_id";
    public static final String PER_TITRE = "titre";
    public static final String PER_NOM = "nom";
    public static final String PER_PRENOM = "prenom";
    public static final String PER_IMAGE = "image";
    public static final String PER_BIO = "bio";
    public static final String PER_ACTIONS = "actions";

    private static final String USER_MASTER_CREATE =
            "CREATE TABLE IF NOT EXISTS " + DATABASE_TABLE + "("
                    + KEY_ROWID + " INTEGER PRIMARY KEY,"
                    + KEY_COL1 + " VARCHAR(15) UNIQUE, "
                    + KEY_COL2 + " VARCHAR(15), "
                    + KEY_TITRE + " TEXT, "
                    + KEY_DESC + " TEXT, "  /***************/
                    + KEY_DATE + " TEXT, "


                    + KEY_AUDIO + " TEXT, "
                    + KEY_IMAGE + " TEXT, "
                    + KEY_VIDEO + " TEXT, "
                    + KEY_LAT + " TEXT, "
                    + KEY_LON + " TEXT, "
                    + KEY_VILLE + " TEXT "

                    + ")";

    private static final String USER_MASTER_CREATE2 =
            "CREATE TABLE IF NOT EXISTS " + DATABASE_TABLE2 + "("
                    + PER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + PER_TITRE + " TEXT, "
                    + PER_NOM + " VARCHAR(15), "
                    + PER_PRENOM + " TEXT, "
                    + PER_IMAGE + " TEXT, "
                    + PER_BIO + " TEXT, "  /***************/

                    + PER_ACTIONS + " TEXT "


                    + ")";

    private static class DbHelper extends SQLiteOpenHelper {

        public DbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(USER_MASTER_CREATE);
            db.execSQL(USER_MASTER_CREATE2);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // if DATABASE VERSION changes
            // Drop old tables and call super.onCreate()
        }
    }

    public DbClass(Context c) {
        ourContext = c;
        dbh = new DbHelper(ourContext);
    }

    public DbClass open() throws SQLException {
        odb = dbh.getWritableDatabase();
        return this;
    }

    public void close() {
        dbh.close();
    }

    public long insertMaster(String col1, String col2, String titre, String dateEvent, String desc, String audio, String image, String video, String lat, String lon, String ville) throws SQLException {
        Log.d("", col1);
        Log.d("", col2);
        Log.d("", titre);
        Log.d("", dateEvent);
        Log.d("", desc);

        Log.d("", audio);
        Log.d("", image);
        Log.d("", video);
        Log.d("", lat);
        Log.d("", lon);
        Log.d("", ville);
        ContentValues IV = new ContentValues();

        IV.put(KEY_COL1, col1);
        IV.put(KEY_COL2, col2);
        IV.put(KEY_TITRE, titre);
        IV.put(KEY_DATE, dateEvent);
        IV.put(KEY_DESC, desc);

        IV.put(KEY_AUDIO, audio);
        IV.put(KEY_IMAGE, image);
        IV.put(KEY_VIDEO, video);
        IV.put(KEY_LAT, lat);
        IV.put(KEY_LON, lon);
        IV.put(KEY_VILLE, ville);

        return odb.insert(DATABASE_TABLE, null, IV);
        // returns a number >0 if inserting data is successful
    }


    public long insertMasterPersonne(String titre, String nom, String prenom, String image, String bio, String actions) throws SQLException {
        Log.d("", titre);
        Log.d("", nom);
        Log.d("", prenom);
        Log.d("", image);
        Log.d("", bio);

        Log.d("", actions);

        ContentValues IV = new ContentValues();

        IV.put(PER_TITRE, titre);
        IV.put(PER_NOM, nom);
        IV.put(PER_PRENOM, prenom);
        IV.put(PER_IMAGE, image);
        IV.put(PER_BIO, bio);

        IV.put(PER_ACTIONS, actions);

        return odb.insert(DATABASE_TABLE2, null, IV); // dans la table personne
        // returns a number >0 if inserting data is successful
    }

    /************************************************************************************************/


    public void updateRow(long rowID, String col1, String col2, String titre, String dateEvent, String desc, String audio, String image, String video, String lat, String lon, String ville) {
        ContentValues values = new ContentValues();
        values.put(KEY_COL1, col1);
        values.put(KEY_COL2, col2);
        values.put(KEY_TITRE, titre);
        values.put(KEY_DATE, dateEvent);
        values.put(KEY_DESC, desc);

        values.put(KEY_AUDIO, audio);
        values.put(KEY_IMAGE, image);
        values.put(KEY_VIDEO, video);
        values.put(KEY_LAT, lat);
        values.put(KEY_LON, lon);
        values.put(KEY_VILLE, ville);


        try {
            odb.update(DATABASE_TABLE, values, KEY_ROWID + "=" + rowID, null);
        } catch (Exception e) {
        }
    }

    public int delete(String titre) {
        odb.execSQL("DELETE FROM " + DATABASE_TABLE);
        //odb.execSQL("UPDATE "+DATABASE_TABLE+"set "+ KEY_DESC + "= 'MEHDI'");
        //odb.delete(DATABASE_TABLE,KEY_COL1 + "=" + titre, null);
        return 0;//odb.delete(DATABASE_TABLE, KEY_ROWID + "=" + 10 , null);
    }

    public int deletePersonne(String nom) {
        odb.execSQL("DELETE FROM " + DATABASE_TABLE2);
        //odb.execSQL("UPDATE "+DATABASE_TABLE+"set "+ KEY_DESC + "= 'MEHDI'");
        //odb.delete(DATABASE_TABLE,KEY_COL1 + "=" + titre, null);
        return 0;//odb.delete(DATABASE_TABLE, KEY_ROWID + "=" + 10 , null);
    }

    public Cursor getAllTitles() {
        // using simple SQL query
        return odb.rawQuery("select * from " + DATABASE_TABLE, null);
    }

    public Cursor getAllTitlesPersonne() {
        // using simple SQL query
        return odb.rawQuery("select * from " + DATABASE_TABLE2, null);
    }

    public Cursor getallCols(String id) throws SQLException {
        Cursor mCursor = odb.query(DATABASE_TABLE, new String[]{KEY_COL1,
                KEY_COL2, KEY_TITRE, KEY_DATE, KEY_DESC, KEY_AUDIO, KEY_IMAGE, KEY_VIDEO, KEY_LAT, KEY_LON, KEY_VILLE}, null, null, null, null, null);
        Log.e("getallcols zmv", "opening successfull");
        return mCursor;
    }

    public Cursor getColsById(String id) throws SQLException {
        Cursor mCursor = odb.query(DATABASE_TABLE, new String[]{KEY_COL1,
                KEY_COL2, KEY_TITRE, KEY_DATE, KEY_DESC, KEY_AUDIO, KEY_IMAGE, KEY_VIDEO, KEY_LAT, KEY_LON, KEY_VILLE}, KEY_ROWID + " = " + id, null, null, null, null);
        Log.e("getallcols zmv", "opening successfull");
        return mCursor;
    }
}