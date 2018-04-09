package com.example.tranxuantung.moneymanager.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.tranxuantung.moneymanager.DoiTuong.DTTaiKhoan;

import java.util.ArrayList;

public class Data extends SQLiteOpenHelper {

    private SQLiteDatabase doc = this.getReadableDatabase();
    private SQLiteDatabase ghi = this.getWritableDatabase();

    public Data(Context context) {
        super(context, "dulieu", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String thu = "CREATE TABLE thu(ngay long,taikhoan string,danhmuc string,sotien double,doituong string,ghichu string);";
        sqLiteDatabase.execSQL(thu);
        String chi = "CREATE TABLE chi(ngay long,taikhoan string,danhmuc string,sotien double,doituong string,ghichu string);";
        sqLiteDatabase.execSQL(chi);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS thu");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS chi");
        onCreate(sqLiteDatabase);
    }

    public boolean saveThu(DTTaiKhoan dtTaiKhoan) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("ngay", dtTaiKhoan.getDate());
        contentValues.put("taikhoan", dtTaiKhoan.getTaikhoan());
        contentValues.put("danhmuc", dtTaiKhoan.getDanhmuc());
        contentValues.put("sotien", dtTaiKhoan.getSotien());
        contentValues.put("doituong", dtTaiKhoan.getDoituong());
        contentValues.put("ghichu", dtTaiKhoan.getGhichu());
        long kt = ghi.insert("thu", null, contentValues);
        if (kt != 0)
            return true;
        else return false;
    }

    public boolean saveChi(DTTaiKhoan dtTaiKhoan) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("ngay", dtTaiKhoan.getDate());
        contentValues.put("taikhoan", dtTaiKhoan.getTaikhoan());
        contentValues.put("danhmuc", dtTaiKhoan.getDanhmuc());
        contentValues.put("sotien", dtTaiKhoan.getSotien());
        contentValues.put("doituong", dtTaiKhoan.getDoituong());
        contentValues.put("ghichu", dtTaiKhoan.getGhichu());
        long kt = ghi.insert("chi", null, contentValues);
        if (kt != 0)
            return true;
        else return false;
    }

    public ArrayList<DTTaiKhoan> getDataThu(){
        ArrayList<DTTaiKhoan> arrayList = new ArrayList<DTTaiKhoan>();
        String ctv = "SELECT * FROM thu";
        Cursor cursor = doc.rawQuery(ctv, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            long date = cursor.getLong(0);
            String taikhoan = cursor.getString(1);
            String danhmuc = cursor.getString(2);
            double sotien = cursor.getDouble(3);
            String doituong = cursor.getString(4);
            String ghichu = cursor.getString(5);
            DTTaiKhoan dtTaiKhoan = new DTTaiKhoan(date, taikhoan, danhmuc, sotien, doituong, ghichu);
            arrayList.add(dtTaiKhoan);
            cursor.moveToNext();
        }
        return arrayList;
    }

    public ArrayList<DTTaiKhoan> getDataChi(){
        ArrayList<DTTaiKhoan> arrayList = new ArrayList<DTTaiKhoan>();
        String ctv = "SELECT * FROM chi";
        Cursor cursor = doc.rawQuery(ctv, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            long date = cursor.getLong(0);
            String taikhoan = cursor.getString(1);
            String danhmuc = cursor.getString(2);
            double sotien = cursor.getDouble(3);
            String doituong = cursor.getString(4);
            String ghichu = cursor.getString(5);
            DTTaiKhoan dtTaiKhoan = new DTTaiKhoan(date, taikhoan, danhmuc, sotien, doituong, ghichu);
            arrayList.add(dtTaiKhoan);
            cursor.moveToNext();
        }
        return arrayList;
    }
}
