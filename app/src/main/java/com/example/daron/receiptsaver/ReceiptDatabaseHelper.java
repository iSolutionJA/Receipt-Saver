package com.example.daron.receiptsaver;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ReceiptDatabaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "ReceiptInfo"; // the name of our database
    public static final int DB_VERSION = 1; // the version of the database
    public static final String TABLE_NAME = "RECEIPTINFO"; // table name

    ReceiptDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        updateMyDatabase(db, 0, DB_VERSION);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDatabase(db, oldVersion, newVersion);
    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 1) {
            db.execSQL("CREATE TABLE RECEIPTINFO (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "CATEGORY TEXT, "
                    + "DATE TEXT, "
                    + "TOTAL REAL, "
                    + "DESCRIPTION TEXT, "
                    + "FILENAME TEXT);");
        }
    }
}