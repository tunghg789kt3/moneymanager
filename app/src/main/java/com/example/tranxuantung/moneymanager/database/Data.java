package com.example.tranxuantung.moneymanager.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.tranxuantung.moneymanager.DoiTuong.DTTaiKhoan;
import com.example.tranxuantung.moneymanager.R;

import java.util.ArrayList;

public class Data extends SQLiteOpenHelper {

    private SQLiteDatabase doc = this.getReadableDatabase();
    private SQLiteDatabase ghi = this.getWritableDatabase();
    private static final String TBTHU = "tbthu";
    private static final String TBCHI = "tbchi";
    private static final String ID = "_id";
    private static final String NGAY = "ngay";
    private static final String TAIKHOAN = "taiKhoan";
    private static final String DANHMUC = "danhMuc";
    private static final String SOTIEN = "soTien";

    public Data(Context context) {
        super(context, "thangu", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String thu = "CREATE TABLE " + TBTHU + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + NGAY + " LONG," + TAIKHOAN + " NVARCHAR," + DANHMUC + " NVARCHAR," + SOTIEN + " DOUBLE" + ");";
        String chi = "CREATE TABLE " + TBCHI + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + NGAY + " LONG," + TAIKHOAN + " NVARCHAR," + DANHMUC + " NVARCHAR," + SOTIEN + " DOUBLE" + ");";
        db.execSQL(thu);
        db.execSQL(chi);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TBTHU);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TBCHI);
        onCreate(sqLiteDatabase);
    }

    public boolean saveThu(DTTaiKhoan dtTaiKhoan) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("ngay", dtTaiKhoan.getDate());
        contentValues.put("taikhoan", dtTaiKhoan.getTaikhoan());
        contentValues.put("danhmuc", dtTaiKhoan.getDanhmuc());
        contentValues.put("sotien", dtTaiKhoan.getSotien());
        long kt = ghi.insert(TBTHU, null, contentValues);
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
        long kt = ghi.insert(TBCHI, null, contentValues);
        if (kt != 0)
            return true;
        else return false;
    }

//    public String updateThu(DTTaiKhoan dtTaiKhoan){
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("thu", dtTaiKhoan.getDate());
//
//        return ghi.update("thu", contentValues, dtTaiKhoan)
//    }

    public ArrayList<DTTaiKhoan> getDataThu() {
        ArrayList<DTTaiKhoan> arrayList = new ArrayList<DTTaiKhoan>();
        String ctv = "SELECT * FROM "+TBTHU;
        Cursor cursor = doc.rawQuery(ctv, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            int id = cursor.getInt(0);
            long date = cursor.getLong(1);
            String taikhoan = cursor.getString(2);
            String danhmuc = cursor.getString(3);
            double sotien = cursor.getDouble(4);
            DTTaiKhoan dtTaiKhoan = new DTTaiKhoan(id, date, taikhoan, danhmuc, sotien);
            arrayList.add(dtTaiKhoan);
            cursor.moveToNext();
        }
        return arrayList;
    }

        public ArrayList<DTTaiKhoan> getDataChi(){
        ArrayList<DTTaiKhoan> arrayList = new ArrayList<DTTaiKhoan>();
        String ctv = "SELECT * FROM "+TBCHI;
        Cursor cursor = doc.rawQuery(ctv, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int id = cursor.getInt(0);
            long date = cursor.getLong(1);
            String taikhoan = cursor.getString(2);
            String danhmuc = cursor.getString(3);
            double sotien = cursor.getDouble(4);
            DTTaiKhoan dtTaiKhoan = new DTTaiKhoan(id, date, taikhoan, danhmuc, sotien);
            arrayList.add(dtTaiKhoan);
            cursor.moveToNext();
        }
        return arrayList;
    }
    public void deleteNote(DTTaiKhoan note) {
        SQLiteDatabase gh = this.getWritableDatabase();
        gh.delete(TBTHU,ID+"=?",new String[]{String.valueOf(note.getId())});
        gh.close();
    }

    public void deleteChi(DTTaiKhoan note) {
        SQLiteDatabase gh = this.getWritableDatabase();
        gh.delete(TBCHI,ID+"=?",new String[]{String.valueOf(note.getId())});
        gh.close();
    }
    public boolean updateNote(DTTaiKhoan note) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TAIKHOAN, note.getTaikhoan());
        values.put(DANHMUC, note.getDanhmuc());
        values.put(SOTIEN, note.getSotien());
        int kt = db.update(TBTHU,values,ID+"=?",new String[]{String.valueOf(note.getId())});
        if(kt!=0)
            return true;
        else return false;
    }
    public boolean updateChi(DTTaiKhoan note) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TAIKHOAN, note.getTaikhoan());
        values.put(DANHMUC, note.getDanhmuc());
        values.put(SOTIEN, note.getSotien());
        int kt = db.update(TBCHI,values,ID+"=?",new String[]{String.valueOf(note.getId())});
        if(kt!=0)
            return true;
        else return false;
    }
}
