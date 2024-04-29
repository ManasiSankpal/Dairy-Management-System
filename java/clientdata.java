package com.example.manasi;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

        import androidx.annotation.Nullable;

        import java.sql.Date;

public class clientdata extends SQLiteOpenHelper {
    /* private static final String achieve2 = "ach";

     private static final String Id = "id";
     private static final String Date = "date";
     private static final String Achievements = "achievements";
 */
    public clientdata(Context context) {
        super(context, "Client1.db", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase myDB) {
        myDB.execSQL("create Table client(Client_No Text primary key,Name Text,Address Text,Milk_Type Text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase myDB, int i, int i1) {
        myDB.execSQL("drop table if exists client");

    }
    public Boolean insertData(String Client_No, String Name , String Address,String Milk_Type) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("client No: ",Client_No);
        contentValues.put("Name : ", Name);
        contentValues.put("Address : ", Address);
        contentValues.put("Milk Type: ", Milk_Type);
        long result= myDB.insert("client", null, contentValues);
        if(result == -1){
            return false;
        }else {
            return true;
        }
    }
    public Cursor getdata(){
        SQLiteDatabase myDB=this.getWritableDatabase();
        Cursor cursor= myDB.rawQuery("Select * from client",null);
        return cursor;
    }
   /*public String getData() {
        SQLiteDatabase myDB= this.getReadableDatabase();
        String[] columns = new String[]{Client_No, Name , Address, Milk_Type};
        Cursor cursor =myDB.query(client1, columns,null,null, null, null, null);

        int iNo = cursor.getColumnIndex(Client_No);
        int iName = cursor.getColumnIndex(Date);
        int iAddress = cursor.getColumnIndex(Achievements);
        String res= "";

        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            res = res +
                    "ID: " + cursor.getString(iId) + "\n" +
                    "DATE: " + cursor.getString(iDate) + "\n" +
                    "ACHIEVEMENT: " + cursor.getString(iAchieve) + "\n\n";
        }
        myDB.close();
        return res;
    }*/
}