package com.example.wudc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class RecordDBHelper extends SQLiteOpenHelper {
    static final String DATABASE_NAME = "record.db";

    //생성자
    public RecordDBHelper(Context context,  int version) {
        super(context, DATABASE_NAME, null, version);
    }

    //테이블을 생성합니다.
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Record ( date TEXT, name TEXT, table_name TEXT, contents TEXT, impression TEXT)");
    }

    //버전이 업데이트되면 DB를 다시 만듭니다.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Record");
        onCreate(db);
    }

    //Record Table 데이터 입력
    public void insert(String date, String name, String table_name, String contents, String impression) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO Record VALUES('" + date + "','" + name + "' ,'"
                + table_name + "', '" + contents + "','" + impression + "')");
        db.close();
    }

    //Record Table 데이터 수정
    public void Update(String name, String table_name, String contents, String impression) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE Record SET table_name = " + table_name + ", contents = '" + contents +
                ", impression = '" + impression + "'" + " WHERE NAME = '" + name + "'");
        db.close();
    }

    //Record Table 데이터 삭제
    public void Delete(String name) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE Record WHERE NAME = '" + name + "'");
        db.close();
    }

    //Record Table 조회
    public String getResult_check() {
        SQLiteDatabase db = getReadableDatabase();
        String result = "";
        Cursor cursor = db.rawQuery("SELECT * FROM Record ", null);
        while (cursor.moveToNext()){
            result += cursor.getString(0);
        }
        return result;
    }
    public String getResult() {
        SQLiteDatabase db = getReadableDatabase();
        String result = "";
        Cursor cursor = db.rawQuery("SELECT * FROM Record ", null);
        while (cursor.moveToNext()){
            result += cursor.getString(0) + " " + cursor.getString(1)+"\n";
        }
        return result;
    }
    public String getResult_class() {
        SQLiteDatabase db = getReadableDatabase();
        String result = "";
        Cursor cursor = db.rawQuery("SELECT * FROM Record WHERE TABLE_NAME = 'class' ORDER BY DATE", null);
        while (cursor.moveToNext()){
            result += cursor.getString(0) + " " + cursor.getString(1)+"\n";
        }
        return result;
    }
    public String getResult_club() {
        SQLiteDatabase db = getReadableDatabase();
        String result = "";
        Cursor cursor = db.rawQuery("SELECT * FROM Record WHERE TABLE_NAME = 'club' ORDER BY DATE", null);
        while (cursor.moveToNext()){
            result += cursor.getString(0) + " " + cursor.getString(1)+"\n";
        }
        return result;
    }
    public String getResult_contest() {
        SQLiteDatabase db = getReadableDatabase();
        String result = "";
        Cursor cursor = db.rawQuery("SELECT * FROM Record WHERE TABLE_NAME = 'contest' ORDER BY DATE", null);
        while (cursor.moveToNext()){
            result += cursor.getString(0) + " " + cursor.getString(1)+"\n";
        }
        return result;
    }
    public String getResult_day() {
        SQLiteDatabase db = getReadableDatabase();
        String result = "";
        Cursor cursor = db.rawQuery("SELECT * FROM Record WHERE TABLE_NAME = 'day' ORDER BY DATE", null);
        while (cursor.moveToNext()){
            result += cursor.getString(0) + " " + cursor.getString(1)+"\n";
        }
        return result;
    }
}




