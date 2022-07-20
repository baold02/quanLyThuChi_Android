package com.example.quanlythuchi_android.DATABASE;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.quanlythuchi_android.DAO.NguoiDungDao;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "dbChiTieu";
    public static final int VESION = 1;
    public DatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, VESION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(NguoiDungDao.SQL_NGUOI_DUNG);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("Drop table if exists" +NguoiDungDao.TB_NAME);
        onCreate(db);

    }
}
