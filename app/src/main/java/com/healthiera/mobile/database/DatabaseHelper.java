package com.healthiera.mobile.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by yengibar on 8/3/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "healthiera";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // creating required tables
        db.execSQL("CREATE TABLE \"profile\" (\n" +
                "  \"id\"        INTEGER PRIMARY KEY  NOT NULL  CHECK (typeof(\"id\") = 'integer'),\n" +
                "  \"user_name\" VARCHAR(15)          NOT NULL,\n" +
                "  \"password\"  VARCHAR(20)          NOT NULL,\n" +
                "  \"name\"      VARCHAR(20)          NOT NULL,\n" +
                "  \"last_name\" VARCHAR(30)          NOT NULL,\n" +
                "  \"sex\"       BOOL                 NOT NULL,\n" +
                "  \"birthday\"  DATETIME,\n" +
                "  \"zip_code\"  NUMERIC,\n" +
                "  \"email\"     VARCHAR(30)          NOT NULL,\n" +
                "  \"image\"     VARCHAR(20)\n" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
    }
}
