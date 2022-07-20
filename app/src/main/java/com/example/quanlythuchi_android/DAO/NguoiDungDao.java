package com.example.quanlythuchi_android.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.quanlythuchi_android.DATABASE.DatabaseHelper;
import com.example.quanlythuchi_android.Models.NguoiDung;

import java.util.ArrayList;
import java.util.List;

public class NguoiDungDao {
  private SQLiteDatabase database;
  private DatabaseHelper databaseHelper;

  public static final String TB_NAME = "NguoiDung";
  public static final String SQL_NGUOI_DUNG = "CREATE TABLE \"NguoiDung\" (\n" +
          "\t\"userName\"\tTEXT UNIQUE,\n" +
          "\t\"passWord\"\tTEXT NOT NULL,\n" +
          "\t\"tenND\"\tTEXT,\n" +
          "\t\"gioiTinh\"\tTEXT,\n" +
          "\t\"phone\"\tTEXT,\n" +
          "\t\"tongSoTien\"\tTEXT,\n" +
          "\tPRIMARY KEY(\"userName\")\n" +
          ");" ;

 public static final String TAG = "NguoiDungDao";

 public NguoiDungDao(Context context){
    databaseHelper = new DatabaseHelper(context);
    database = databaseHelper.getWritableDatabase();
 }
 public int insertNguoiDung(NguoiDung nguoiDung){
     ContentValues values = new ContentValues();
     values.put("username",nguoiDung.getUserName());
     values.put("password",nguoiDung.getPassword());

     values.put("tenND", nguoiDung.getHoTen());
     values.put("gioiTinh", nguoiDung.getGioiTinh());
     values.put("phone", nguoiDung.getPhone());
     values.put("tongSoTien", nguoiDung.getTongSoTien());

     try {
         if ( checkLogin(nguoiDung.getUserName() , nguoiDung.getPassword()) > 0 ){
             return -1;
         } else if ( database.insert(TB_NAME, null, values) == -1) {
             return -1;
         }
     } catch (Exception ex) {
         Log.e(TAG + "Error db  :", ex.toString());
     }
     return 1;
 }

    //check login
    public int checkLogin(String username, String password) {
        int result = 0;
//        get all data for to list
        List<NguoiDung> dsNguoiDung = new ArrayList<>();

        Cursor c = database.query(TB_NAME, null, null, null, null, null, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {

            NguoiDung ee = new NguoiDung();
            ee.setUserName(c.getString(0));
            ee.setPassword(c.getString(1));

            ee.setHoTen(c.getString(2));
            ee.setGioiTinh(c.getString(3));
            ee.setPhone(c.getString(4));

//            if ( username.equals(c.getString(0)) ){
//                c.close();
//                return 1;
//            } else
            if (  username.equals(c.getString(0))
                    && password.equals(c.getString(1)) ){
                c.close();
//                Log.e("-kiem tra login -------" , "----------thanh cong roi nha");
                return 1;
            }
//            get data add list
            dsNguoiDung.add(ee);
            Log.d(TAG + "//===== \t\t","Error function checkLogin" + ee.toString());
            c.moveToNext();
        }
        c.close();


//        int result = db.delete(TABLE_NAME, "username=? AND password=?", new String[]{username, password});
        if (result == 0)
            return -1;
        return 1;
    }

}
