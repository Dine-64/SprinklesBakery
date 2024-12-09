package com.example.sprinklesbakery;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class OrderDB extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "OrderDB.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME_ORDERS = "orders";
    private static final String COL_ID = "id";
    private static final String COL_NAME = "name";
    private static final String COL_EMAIL = "email";
    private static final String COL_CONTACT_NUMBER = "contact_number";
    private static final String COL_ADDRESS = "address";
    private static final String COL_AMOUNT = "amount";
    private static final String COL_QUANTITY = "quantity";

    public OrderDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_NAME_ORDERS + " ("
                + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_NAME + " TEXT, "
                + COL_EMAIL + " TEXT, "
                + COL_CONTACT_NUMBER + " TEXT, "
                + COL_ADDRESS + " TEXT, "
                + COL_AMOUNT + " REAL, "
                + COL_QUANTITY + " INTEGER)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_ORDERS);
        onCreate(db);
    }

    public boolean insertOrder(String name, String email, String contactNumber, String address, double amount, int quantity) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME, name);
        contentValues.put(COL_EMAIL, email);
        contentValues.put(COL_CONTACT_NUMBER, contactNumber);
        contentValues.put(COL_ADDRESS, address);
        contentValues.put(COL_AMOUNT, amount); // Corrected to put double value directly
        contentValues.put(COL_QUANTITY, quantity);
        long result = db.insert(TABLE_NAME_ORDERS, null, contentValues);
        return result != -1;
    }

    public Cursor getAllOrders() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(TABLE_NAME_ORDERS, null, null, null, null, null, null);
    }
}
