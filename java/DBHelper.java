package com.example.manasi;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "Login.db", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase myDB) {
        myDB.execSQL("create Table users( Email Text primary key,password Text)");
        myDB.execSQL("create Table ProgressReport( projectName Text,ActivityName Text,Location Text,period Integer,ActivityDoneBy Text,Amount Integer,Status Integer)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase myDb, int oldversion, int newVersion) {
        myDb.execSQL("drop table if exists users");
        myDb.execSQL("drop table if exists ProgressReport");
    }
    public Boolean insertData( String Email, String Password) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Email", Email);
        contentValues.put("password", Password);

        long result = myDB.insert("users", null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean checkEmail(String Email) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from users where Email=?", new String[]{Email});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean checkEmailPassword(String Email, String Password) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from users where Email=? and password=?", new String[]{Email, Password});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public int updatepass(String Email, String new_pass) {
        SQLiteDatabase myDB = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("password", new_pass);
        return myDB.update("users", contentValues, "Email=?", new String[]{Email});
    }

    public Boolean insert1(String projectName , String ActivityName,String Location,String period ,String ActivityDoneBy ,String Amount,int Status) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("projectName",projectName);
        contentValues.put("ActivityName",ActivityName);
        contentValues.put("Location",Location);
        contentValues.put("period",period);
        contentValues.put("ActivityDoneBy",ActivityDoneBy);
        contentValues.put("Amount",Amount);
        contentValues.put("Status",Status);
        long result = myDB.insert("ProgressReport", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
}