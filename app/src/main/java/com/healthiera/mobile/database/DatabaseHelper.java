package com.healthiera.mobile.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.healthiera.mobile.entity.Profile;

/**
 * Created by yengibar on 8/3/16.
 */

//public class DatabaseHelper extends SQLiteOpenHelper {


    // Logcat tag
//    private static final String LOG = "DatabaseHelper";
//
//    // Database Version
//    private static final int DATABASE_VERSION = 1;
//
//    // Database Name
//    private static final String DATABASE_NAME = "healthiera";
//
//    // Table Create Statements
//    // Todo table create statement
//    private static final String CREATE_TABLE_PROFILE = "CREATE TABLE \"profile\" (\n" +
//            "  \"id\"        INTEGER PRIMARY KEY  NOT NULL  CHECK (typeof(\"id\") = 'integer'),\n" +
//            "  \"user_name\" VARCHAR(15)          NOT NULL,\n" +
//            "  \"password\"  VARCHAR(20)          NOT NULL,\n" +
//            "  \"name\"      VARCHAR(20)          NOT NULL,\n" +
//            "  \"last_name\" VARCHAR(30)          NOT NULL,\n" +
//            "  \"sex\"       BOOL                 NOT NULL,\n" +
//            "  \"birthday\"  DATETIME,\n" +
//            "  \"zip_code\"  NUMERIC,\n" +
//            "  \"email\"     VARCHAR(30)          NOT NULL,\n" +
//            "  \"image\"     VARCHAR(20)\n" +
//            ");";
//
//    public DatabaseHelper(Context context) {
//        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        // creating required tables
//        db.execSQL(CREATE_TABLE_PROFILE);
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        // on upgrade drop older tables
//        db.execSQL("DROP TABLE IF EXISTS PROFILE");
//        // create new tables
//        onCreate(db);
//    }
//
//    public long createProfile(Profile profile) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//       // values.put("id", profile.getId());
//        values.put("user_name", profile.getUserName());
//        values.put("password", profile.getPassword());
//        values.put("name", profile.getName());
//        values.put("last_name", profile.getLastName());
//        values.put("sex", profile.getSex());
//        values.put("birthday", profile.getBirthday());
//        values.put("email", profile.getEmail());
//        values.put("image", profile.getImage());
//
//        // insert row
//        long prof_id = db.insert("profile", null, values);
//
//        return prof_id;
//    }
//
//    public Profile getProfile(long prof_id) {
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        String selectQuery = "SELECT  * FROM profile WHERE id = " + prof_id;
//
//        //Log.e(LOG, selectQuery);
//
//        Cursor c = db.rawQuery(selectQuery, null);
//
//        if (c != null)
//            c.moveToFirst();
//
//        Profile pr = new Profile();
//        pr.setId(c.getLong(c.getColumnIndex("id")));
//        pr.setUserName(c.getString(c.getColumnIndex("user_name")));
//        pr.setPassword(c.getString(c.getColumnIndex("password")));
//        pr.setName(c.getString(c.getColumnIndex("name")));
//        pr.setLastName(c.getString(c.getColumnIndex("last_name")));
//        pr.setSex(c.getInt(c.getColumnIndex("sex"))> 0);
//        pr.setBirthday(c.getString(c.getColumnIndex("birthday")));
//        pr.setEmail(c.getString(c.getColumnIndex("email")));
//        pr.setImage(c.getString(c.getColumnIndex("image")));
//
//        return pr;
//    }
//}