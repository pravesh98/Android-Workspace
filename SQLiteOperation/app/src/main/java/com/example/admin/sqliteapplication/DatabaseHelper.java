package com.example.admin.sqliteapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Admin on 10/20/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="student.db";
    public static final String TABLE_NAME="student_table";
    public static final String COL_1="ID";
    public static final String COL_2="FIRST_NAME";
    public static final String COL_3="LAST_NAME";
    public static final String COL_4="MARKS";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME +"(ID INTEGER PRIMARY KEY AUTOINCREMENT, FIRST_NAME TEXT , LAST_NAME TEXT , MARKS INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String firstName,String lastName,String marks)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_2,firstName);
        contentValues.put(COL_3,lastName);
        contentValues.put(COL_4,marks);
        long result=db.insert(TABLE_NAME,null,contentValues);
        if(result==-1)//if statement doesnot executed successfully
            return false;
        else
            return true;
    }

    public Cursor getAllData()
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        Cursor result=sqLiteDatabase.rawQuery("select * from "+TABLE_NAME,null);
        return result;
    }

    public int deleateData(String id)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
//        return sqLiteDatabase.delete(TABLE_NAME,COL_1+"="+id,null);
        return sqLiteDatabase.delete(TABLE_NAME,"ID = ?",new String[] {id});
    }
    public boolean updateData(String id,String fName,String lName,String marks)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_2,fName);
        contentValues.put(COL_3,lName);
        contentValues.put(COL_4,marks);
        int result=sqLiteDatabase.update(TABLE_NAME,contentValues,"ID="+id,null);
        if (result>0)
            return true;
        else
            return false;
    }
}