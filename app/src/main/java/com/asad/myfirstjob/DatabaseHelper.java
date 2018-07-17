package com.asad.myfirstjob;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "users.db";
    private static final String TABLE_NAME = "users";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_UNAME = "uname";
    private static final String COLUMN_PASS = "pass";

    SQLiteDatabase db;

    private static final String TABLE_CREATE =  "CREATE TABLE " + TABLE_NAME + " (" +
            "id integer primary key autoincrement not null, " +
            "name text not null, " +
            "email text not null, " +
            "uname text not null, " +
            "pass text not null);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(TABLE_CREATE);
        this.db = db;

    }

    public void insertUser(User u)
    {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();

        values.put(COLUMN_ID, count);
        values.put(COLUMN_NAME, u.getName());
        values.put(COLUMN_EMAIL, u.getEmail());
        values.put(COLUMN_UNAME, u.getUname());
        values.put(COLUMN_PASS, u.getPass());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public String searchPass(String email)
    {
        db = this.getReadableDatabase();
        String query = "select email, pass, uname from " +TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);

        String a, b;
        b = "not found";
        if (cursor.moveToFirst())
        {
            do {
                a = cursor.getString(0);
                b = cursor.getString(1);

                if (a.equals(email))
                {
                    b = cursor.getString(1);
                    break;
                }

            }
            while (cursor.moveToNext());
        }
        return b;
    }

    public String searchPass1(String email)
    {
        db = this.getReadableDatabase();
        String query = "select email, uname from " +TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);

        String a, b;
        b = "not found";
        if (cursor.moveToFirst())
        {
            do {
                a = cursor.getString(0);
                b = cursor.getString(1);

                if (a.equals(email))
                {
                    b = cursor.getString(1);
                    break;
                }

            }
            while (cursor.moveToNext());
        }
        return b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);

    }
}
