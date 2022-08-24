package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DBHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "FITNESSAPP.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "my_app";
    private static final String Id = "ID";
    private static final String COLUMN_mBMI = "mBMI";
    private static final String COLUMN_HEIGHT = "height";
    private static final String COLUMN_WEIGHT = "weight";
    private static final String COLUMN_DATE = "age";
    private static final String COLUMN_GENDER = "gender";
    Date Currenttime = Calendar.getInstance().getTime();
    SimpleDateFormat sdf =new SimpleDateFormat("yyyy/LL/dd");
    String simple = sdf.format(Currenttime);

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String query = "CREATE TABLE " + TABLE_NAME + " (" + Id + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_GENDER + " TEXT, " +
                COLUMN_HEIGHT + " TEXT, " +
                COLUMN_WEIGHT + " TEXT, " +
                COLUMN_DATE + " TEXT, " +
                COLUMN_mBMI + " TEXT); ";
        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);

    }

    void insert(String gender, String height, String weight, String age, String mBMI){
        SQLiteDatabase db = this.getWritableDatabase();//to write in our table
        ContentValues cv = new ContentValues();//store our data from our app in database table
        cv.put(COLUMN_GENDER, gender);
        cv.put(COLUMN_HEIGHT, height);
        cv.put(COLUMN_WEIGHT, weight);
        cv.put(COLUMN_DATE, simple);
        cv.put(COLUMN_mBMI, mBMI);

        long res = db.insert(TABLE_NAME, null, cv);//insert data in our database table
        if (res == -1){ //our Application Failed
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context, "Added successfully", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME; //select all data from our database table
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null){ //our database table not empty
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
////////
    void DeleteOneRow (String Row_ID) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result=  db.delete(TABLE_NAME,"Id"+ "=" +Row_ID,null) ;
        if (result==-1){
            Toast.makeText(context, "Faild To Delete", Toast.LENGTH_SHORT).show();

        }
        else {
            Toast.makeText(context, "Deleted successfully", Toast.LENGTH_SHORT).show();

        }


    }

    void DeleteALlData () {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME);

    }
////////
}
