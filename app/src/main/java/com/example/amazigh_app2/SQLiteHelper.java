package com.example.amazigh_app2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "ProjectDB";
    public static final String TABLE_NAME = "Categorien";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "CATEGORIE";
    public static final String COL_3 = "AFBEEDING";
    public static final String COL_4 = "SOUND";

    public SQLiteHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, CATEGORIE TEXT, AFBEELDING TEXT, SOUND TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(db);
    }
    public boolean insertDate(String categorie, String afbeelding, String sound){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,categorie);
        contentValues.put(COL_3,afbeelding);
        contentValues.put(COL_4,sound);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;


    }


}


