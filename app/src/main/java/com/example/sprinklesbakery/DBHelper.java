package com.example.sprinklesbakery;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "sprinkles.db";
    private static final String TABLE_NAME_USERS = "users";
    private static final String COL_UID = "uid";
    private static final String COL_NAME = "name";
    private static final String COL_EMAIL = "email";
    private static final String COL_PASSWORD = "password";

    private static final String TABLE_NAME_ORDERS = "orderTable";
    private static final String COL_ID = "id";
    private static final String COL_ONAME = "name"; // Corrected column name
    private static final String COL_CONTACT_NUMBER = "contact_number";
    private static final String COL_ADDRESS = "address";
    private static final String COL_AMOUNT = "amount";
    private static final String COL_QUANTITY = "quantity"; // Corrected column name

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("CREATE TABLE " + TABLE_NAME_USERS + " ("
                + COL_UID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_NAME + " TEXT, "
                + COL_EMAIL + " TEXT, "
                + COL_PASSWORD + " TEXT)");

        MyDB.execSQL("CREATE TABLE " + TABLE_NAME_ORDERS + " ("
                + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_ONAME + " TEXT, "
                + COL_EMAIL + " TEXT, "
                + COL_CONTACT_NUMBER + " TEXT, "
                + COL_ADDRESS + " TEXT, "
                + COL_AMOUNT + " REAL, "
                + COL_QUANTITY + " INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        MyDB.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_USERS);
        MyDB.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_ORDERS);
        onCreate(MyDB);
    }

    public boolean insertData(String username, String password) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME, username);
        contentValues.put(COL_PASSWORD, password);
        long result = MyDB.insert(TABLE_NAME_USERS, null, contentValues);
        return result != -1;
    }

    public boolean checkUsername(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("SELECT * FROM " + TABLE_NAME_USERS + " WHERE " + COL_NAME + " = ?", new String[]{username});
        return cursor.getCount() > 0;
    }

    public boolean checkUsernamePassword(String username, String password) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("SELECT * FROM " + TABLE_NAME_USERS + " WHERE " + COL_NAME + " = ? AND " + COL_PASSWORD + " = ?", new String[]{username, password});
        return cursor.getCount() > 0;
    }

    public boolean insertOrder(String name, String email, String contactNumber, String address, String amount, String quantity) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_ONAME, name);
        contentValues.put(COL_EMAIL, email);
        contentValues.put(COL_CONTACT_NUMBER, contactNumber);
        contentValues.put(COL_ADDRESS, address);
        contentValues.put(COL_AMOUNT, amount);
        contentValues.put(COL_QUANTITY, quantity);
        long result = db.insert(TABLE_NAME_ORDERS, null, contentValues);
        return result != -1;
    }

    public Cursor getOrderData() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME_ORDERS, null);
    }
}
