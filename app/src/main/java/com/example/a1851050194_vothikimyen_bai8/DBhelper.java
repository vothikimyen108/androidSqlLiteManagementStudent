package com.example.a1851050194_vothikimyen_bai8;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelper extends SQLiteOpenHelper {


    public DBhelper(Context context){
        super(context,"userdate,db",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL( "create Table Userdetail(name Text primary key,contact Text,dob Text)" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL( "drop Table if exists Userdetail" );
    }
    public boolean insterUserDate(String name, String contact, String dob){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put( "name",name );
        contentValues.put("contact",contact);
        contentValues.put("dob",dob);
        long result = DB.insert( "Userdetail",null,contentValues );
        if(result == -1)
            return false;
        else
            return true;
    }
    public boolean updateUserDate(String name, String contact, String dob){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("contact",contact);
        contentValues.put("dob",dob);
        Cursor cursor = DB.rawQuery( "select * from Userdetail where name = ? " ,new String[]{name});
        if(cursor.getCount()>=0){
            long result = DB.update( "Userdetail",contentValues,"name=?",new String[]{name});
            if(result == -1)
                return false;
            else
                return true;
        }else {
            return  false;
        }
    }
    public boolean deleteUserDate(String name){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery( "select * from Userdetail where name = ? " ,new String[]{name});
        if(cursor.getCount()>=0){
            long result = DB.delete( "Userdetail","name=?",new String[]{name});
            if(result == -1)
                return false;
            else
                return true;
        }else {
            return  false;
        }
    }
    public Cursor getData(){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery( "select * from Userdetail " ,null);
        return cursor;
    }
}
