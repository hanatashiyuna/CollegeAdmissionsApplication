package com.example.collegeadmissionsapplication.Database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.collegeadmissionsapplication.Models.Student;

public class AccountModify {

    public static final String QUERY_CREATE_TABLE_ACCOUNT = "create table account(\n"+
            "\tnameId int,\n"+
            "\tname varchar(150),\n"+
            "\tpassword varchar(150),\n"+
            "\temail varchar(200),\n"+
            ")";

    public static Cursor findTheFirst() {
        String sql = "SELECT * FROM accountstulist LIMIT 1";
        SQLiteDatabase sqLiteDatabase = DatabaseHelper.getInstance(null).getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        return cursor;
    }

    public static boolean searchDatabase(){
        boolean reValue;
        int count = 0;
        String name = "";
        String sql = "SELECT * FROM accountstulist LIMIT 1";
        SQLiteDatabase sqLiteDatabase = DatabaseHelper.getInstance(null).getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            name = cursor.getString(1);

            if (name != "") {
                count += 1;
            }
            cursor.moveToNext();
        }
        if (count >= 1){
            reValue = true;
        }else {
            reValue = false;
        }
        return reValue;
    }

    public static void insert(Student student) {
        SQLiteDatabase sqLiteDatabase = DatabaseHelper.getInstance(null).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nameId", student.getNameId());
        values.put("name", student.getName());
        values.put("password", student.getPassword());
        values.put("email", student.getEmail());

        sqLiteDatabase.insert("account", null, values);
    }

    public static void delete(int id) {
        SQLiteDatabase sqLiteDatabase = DatabaseHelper.getInstance(null).getWritableDatabase();
        sqLiteDatabase.delete("account"," nameId="+id,null);
    }
}
