package com.example.a.theohabittraker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.a.theohabittraker.data.DbHelper;
import com.example.a.theohabittraker.data.HabitContract;

public class MainActivity extends AppCompatActivity {
    private DbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //creating the object
        mDbHelper = new DbHelper(this);

    }

    public void inserHabit() {
        //accessing or creating the database to write
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        //Create the contentView and put values into it
        ContentValues habitValues = new ContentValues();
        habitValues.put(HabitContract.HabitEntry.COLUMN_NAME, "Full Time Job");
        habitValues.put(HabitContract.HabitEntry.COLUMN_HOURS, 24);
        habitValues.put(HabitContract.HabitEntry.COLUMN_FREQUENCY, HabitContract.HabitEntry.FREQUENCY_DAILY);
        //Insert the new row and get the primary key value of the new row
        long newRowId = db.insert(HabitContract.HabitEntry.TABLE_NAME, null, habitValues);
        Toast.makeText(this, "Poor you! The id is: " + newRowId, Toast.LENGTH_SHORT).show();
    }
    public Cursor readHabits(){
        // Create and/or open a database to read from it
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        //setting the columns that we are interested in
        String[] projection =
                {
                        HabitContract.HabitEntry._ID,
                        HabitContract.HabitEntry.COLUMN_NAME,
                        HabitContract.HabitEntry.COLUMN_HOURS,
                        HabitContract.HabitEntry.COLUMN_FREQUENCY,
                };
        String selectionClause = null;
        String[] selectionArgs = null;
        //create the cursor to display the database values
        Cursor c = db.query(
                HabitContract.HabitEntry.TABLE_NAME,
                projection,
                selectionClause,
                selectionArgs,
                null,
                null,
                null
        );
        return c;
    }
}
