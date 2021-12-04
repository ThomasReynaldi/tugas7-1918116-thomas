package com.example.carwashticket;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "db_carwash";
    private static final String tb_mobil = "tb_mobil";
    private static final String tb_mobil_id = "id";
    private static final String tb_mobil_plat = "plat";
    private static final String tb_mobil_owner = "owner";
    private static final String CREATE_TABLE_Mobil = "CREATETABLE " +
    tb_mobil +"("
            + tb_mobil_id + " INTEGER PRIMARY KEY ,"
            + tb_mobil_plat + " TEXT ,"
            + tb_mobil_owner + " TEXT " + ")";
    private String CREATE_TABLE_MOBIL;

    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_MOBIL);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
    }
    public void CreateMobil(Mobil data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_mobil_id, data.get_id());
        values.put(tb_mobil_plat, data.get_plat());
        values.put(tb_mobil_owner, data.get_owner());
        db.insert(tb_mobil, null, values);
        db.close();
    }
    public List<Mobil> ReadMobil() {
        List<Mobil> listMbl = new ArrayList<Mobil>();
        String selectQuery = "SELECT * FROM " + tb_mobil;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Mobil data = new Mobil();
                data.set_id(cursor.getString(0));
                data.set_plat(cursor.getString(1));
                data.set_owner(cursor.getString(2));
                listMbl.add(data);
            } while (cursor.moveToNext());
        }
        db.close();
        return listMbl;
    }
    public int UpdateMobil (Mobil data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_mobil_plat, data.get_plat());
        values.put(tb_mobil_owner, data.get_owner());
        return db.update(tb_mobil, values, tb_mobil_id + " = ?",
                new String[]{String.valueOf((data.get_id()))});
    }
    public void DeleteMobil(Mobil data){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_mobil,tb_mobil_id+ " = ?",
                new String[]{String.valueOf(data.get_id())});
        db.close();
    }
}