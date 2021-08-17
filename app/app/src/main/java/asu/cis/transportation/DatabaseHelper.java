package asu.cis.transportation;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String USER_TABLE = "USER_TABLE";
    public static final String USER_COLUMN_ID = "ID";
    public static final String USER_COLUMN_NAME = "NAME";
    public static final String USER_COLUMN_EMAIL = "EMAIL";
    public static final String USER_COLUMN_PASSWORD = "PASSWORD";


    public static final String TRAVELS_TABLE = "TRAVELS_TABLE";
    public static final String TRAVELS_COLUMN_ID = "ID";
    public static final String TRAVELS_COLUMN_FROM = "BEGINING";
    public static final String TRAVELS_COLUMN_TO = "DESTINATION";
    public static final String TRAVELS_COLUMN_DATE = "DATE";
    public static final String TRAVELS_COLUMN_START = "START_TIME";
    public static final String TRAVELS_COLUMN_END = "END_TIME";
    public static final String TRAVELS_COLUMN_PRICE = "PRICE";
    public static final String TRAVELS_COLUMN_AVAILABLE_SEATS = "AVAILABLE_SEATS";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "travelsApp.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createUserTable = "CREATE TABLE " + USER_TABLE + " (" + USER_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + USER_COLUMN_NAME + " TEXT, " + USER_COLUMN_EMAIL + " TEXT, " + USER_COLUMN_PASSWORD + " TEXT)";
        String createTravelsTable = "CREATE TABLE " + TRAVELS_TABLE + " (" + TRAVELS_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + TRAVELS_COLUMN_FROM + " TEXT, " + TRAVELS_COLUMN_TO + " TEXT, " + TRAVELS_COLUMN_DATE + " TEXT, " + TRAVELS_COLUMN_START + " TEXT, " + TRAVELS_COLUMN_END + " TEXT, " + TRAVELS_COLUMN_PRICE + " REAL, " + TRAVELS_COLUMN_AVAILABLE_SEATS + " INTEGER)";
        db.execSQL(createUserTable);
        db.execSQL(createTravelsTable);

    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
