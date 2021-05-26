package com.example.womensafety;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;
public class DatabaseHelper extends SQLiteOpenHelper {
    public static String DATABASE_NAME = "user_database";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_USER = "users";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "gname";
    private static final String KEY_MOB1 = "gmob1";
    private static final String KEY_MOB2 = "gmob2";
    private static final String KEY_EMAIL = "gemail";


    private static final String CREATE_TABLE_WOMENSAFETY
            = "CREATE TABLE "
            + TABLE_USER + "(" + KEY_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_NAME + " TEXT, " + KEY_MOB1 + "" + " TEXT, " + KEY_MOB2 + "" +" TEXT," + KEY_EMAIL + "" +" TEXT);";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null,
                DATABASE_VERSION);
        Log.d("table", CREATE_TABLE_WOMENSAFETY);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(CREATE_TABLE_WOMENSAFETY);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db,
                          int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS '"
                + TABLE_USER + "'");
        onCreate(db);
    }
    public long addUserDetail(String name, String gmob1, String gmob2, String gemail) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, name);
        values.put(KEY_MOB1, gmob1);
        values.put(KEY_MOB2, gmob2);
        values.put(KEY_EMAIL, gemail);

        long insert = db.insert(TABLE_USER,
                null, values);
        return insert;
    }

    public ArrayList<UserModel> getAllUsers() {

        ArrayList<UserModel> userModelArrayList =
                new ArrayList<UserModel>();
        String selectQuery = "SELECT * FROM " + TABLE_USER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        if (c.moveToFirst()) {
            do {
                UserModel userModel = new UserModel();
                userModel.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                userModel.setName(c.getString(c.getColumnIndex(KEY_NAME)));
                userModel.setGmob1(c.getString(c.getColumnIndex(KEY_MOB1)));
                userModel.setGmob2(c.getString(c.getColumnIndex(KEY_MOB2)));
                userModel.setGemail(c.getString(c.getColumnIndex(KEY_EMAIL)));
// adding to women_safety list
                userModelArrayList.add(userModel);
            } while (c.moveToNext());
        }
        return userModelArrayList;
    }

    public ArrayList<String> getAllNumbers()
    {
        ArrayList<String> numberlist = new ArrayList<String>();
        String selectQuery = "SELECT * FROM " + TABLE_USER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.moveToFirst()) {
            do {
                numberlist.add(c.getString(c.getColumnIndex(KEY_MOB1)));
                numberlist.add(c.getString(c.getColumnIndex(KEY_MOB2)));
//                emaillist.add(c.getString(c.getColumnIndex(KEY_EMAIL)));
            }while (c.moveToNext());
            }

        return numberlist;
    }

    public ArrayList<String> getAllEmail()
    {
        ArrayList<String> emaillist = new ArrayList<String>();
        String selectQuery = "SELECT * FROM " + TABLE_USER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.moveToFirst()) {
            do {
                emaillist.add(c.getString(c.getColumnIndex(KEY_EMAIL)));
            }while (c.moveToNext());
        }

        return emaillist;
    }

    public int updateUser(int id, String name, String gmob1, String gmob2, String gemail) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, name);
        values.put(KEY_MOB1, gmob1);
        values.put(KEY_MOB2, gmob2);
        values.put(KEY_EMAIL, gemail);
        return db.update(TABLE_USER, values, KEY_ID + " = ?",
                new String[]{String.valueOf(id)});
    }
    public void deleteUSer(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USER, KEY_ID + " = ?",
                new String[]{String.valueOf(id)});
    }
}