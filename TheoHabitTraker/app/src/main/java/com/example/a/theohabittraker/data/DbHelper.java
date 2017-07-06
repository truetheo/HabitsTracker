package com.example.a.theohabittraker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by a on 06-Jul-17.
 */

public class DbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "habits.db";
    public static final int DATABASE_VERSION = 1;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCreateTable = "CREATE TABLE "
                + HabitContract.HabitEntry.TABLE_NAME
                + " ("
                + HabitContract.HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HabitContract.HabitEntry.COLUMN_NAME + " TEXT NOt NULL, "
                + HabitContract.HabitEntry.COLUMN_HOURS + " INTEGER NOT NULL DEFAULT 0, "
                + HabitContract.HabitEntry.COLUMN_FREQUENCY + " INTEGER NOT NULL"
                + ");";
        db.execSQL(sqlCreateTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
