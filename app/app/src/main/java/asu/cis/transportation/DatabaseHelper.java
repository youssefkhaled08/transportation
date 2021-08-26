package asu.cis.transportation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String USER_TABLE = "USER_TABLE";
    public static final String USER_COLUMN_ID = "ID";
    public static final String USER_COLUMN_NAME = "NAME";
    public static final String USER_COLUMN_EMAIL = "EMAIL";
    public static final String USER_COLUMN_PASSWORD = "PASSWORD";


    public static final String TRAVELS_TABLE = "TRAVELS_TABLE";
    //public static final String TRAIN_TRAVELS_COLUMN_ID = "ID";
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
        String createUserTable = "CREATE TABLE " + USER_TABLE + " (" + USER_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + USER_COLUMN_NAME + " TEXT PRIMARY KEY, " + USER_COLUMN_EMAIL + " TEXT, " + USER_COLUMN_PASSWORD + " TEXT)";
        String createTravelsTable = "CREATE TABLE " + TRAVELS_TABLE + " ( " + TRAVELS_COLUMN_FROM + " TEXT, " + TRAVELS_COLUMN_TO + " TEXT, " + TRAVELS_COLUMN_DATE + " TEXT, " + TRAVELS_COLUMN_START + " TEXT, " + TRAVELS_COLUMN_END + " TEXT, " + TRAVELS_COLUMN_PRICE + " REAL, " + TRAVELS_COLUMN_AVAILABLE_SEATS + " INTEGER,  PRIMARY KEY( " + TRAVELS_COLUMN_DATE +" , " + TRAVELS_COLUMN_FROM +" , "+ TRAVELS_COLUMN_TO + " , "+ TRAVELS_COLUMN_START + " , "+ TRAVELS_COLUMN_END +" ))" ;
        db.execSQL(createUserTable);
        db.execSQL(createTravelsTable);

    }
    public boolean AddOneTrainTravelModel(TravelsModel newTravelModel)
    {
        //Adding one travel
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TRAVELS_COLUMN_DATE, newTravelModel.getDate());
        cv.put(TRAVELS_COLUMN_FROM, newTravelModel.getFrom());
        cv.put(TRAVELS_COLUMN_TO, newTravelModel.getTo());
        cv.put(TRAVELS_COLUMN_START, newTravelModel.getStart());
        cv.put(TRAVELS_COLUMN_END, newTravelModel.getEnd());
        cv.put(TRAVELS_COLUMN_AVAILABLE_SEATS, newTravelModel.getAvailableSeats());
        cv.put(TRAVELS_COLUMN_PRICE, newTravelModel.getPrice());

        long insert = db.insert(TRAVELS_TABLE, null, cv);
        if (insert == -1) {
            return false;
        }
        else {

            return true;
        }
    }
    public boolean AddOneUserModel(UserModel newUserModel)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(USER_COLUMN_NAME , newUserModel.getName());
        cv.put(USER_COLUMN_EMAIL , newUserModel.getEmail());
        cv.put(USER_COLUMN_PASSWORD , newUserModel.getPassword());
        long insert = db.insert(USER_TABLE, null, cv);
        if (insert == -1) {
            return false;
        }
        else {

            return true;
        }

    }


    public List<TravelsModel> getEveryTravel()
    {//Get Every Travel
        List<TravelsModel>returnList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selectStatment = "SELECT * FROM "+ TRAVELS_TABLE;
        Cursor cursor = db.rawQuery(selectStatment, null);
        if (cursor.moveToFirst())
        {
            do {
                String from = cursor.getString(0);
                String to = cursor.getString(1);
                String date = cursor.getString(2);
                String start = cursor.getString(3);
                String end = cursor.getString(4);
                float price = cursor.getFloat(5);
                int availableSeats = cursor.getInt(6);
                TravelsModel newModel = new TravelsModel(from , to , date , start , end , price , availableSeats);
                returnList.add(newModel);
            }while(cursor.moveToNext());
        }
        else
        {
            //i don't have to return something here
        }
        cursor.close();
        db.close();
        return returnList;

    }
    public List<UserModel>getEveryUser()
    {// get every User
        List<UserModel>returnList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selectStatment = "SELECT * FROM "+ USER_TABLE;
        Cursor cursor = db.rawQuery(selectStatment, null);
        if (cursor.moveToFirst())
        {
            do {
                int id  = cursor.getInt(0);
                String name = cursor.getString(1);
                String email = cursor.getString(2);
                String password = cursor.getString(3);
               UserModel newModel = new UserModel(name , email , id , password);
                returnList.add(newModel);
            }while(cursor.moveToNext());
        }
        else
        {
            //i don't have to return something here
        }
        cursor.close();
        db.close();
        return returnList;
    }
    public boolean CheckUserInformation(String name , String password)
    {
        List<UserModel>everyUser = getEveryUser();
        boolean found = false;
        for (int i = 0 ; i < everyUser.size(); i++)
        {
            if (everyUser.get(i).getName().equals(name) && everyUser.get(i).getPassword().equals(password))
            {
                found = true;
                break;
            }
        }
        return found;

    }
    public int CheckUserEmailorUserNameAlreadyTaken(String email ,String userName)
    {
        List<UserModel>everyUser = getEveryUser();

        for (int i = 0 ; i < everyUser.size(); i++)
        {
            if (everyUser.get(i).getName().equals(userName))
            {
                return 2;
            }
            if (everyUser.get(i).getEmail().equals(email))
            {
                return 1;
            }
        }
        return 0;
    }
    public boolean DeleteTravelRow()
    {//delete travel row
        SQLiteDatabase dp = this.getWritableDatabase();
        String DeleteQuery = "DELETE FROM "+ TRAVELS_TABLE + " WHERE "+ TRAVELS_COLUMN_PRICE + " ISNULL";
        Cursor cursor = dp.rawQuery(DeleteQuery , null);
        if (cursor.moveToFirst())
        {
            return true;
        }
        else
        {
            return false;
        }

    }
    public boolean TravelUpdateRowAvailableSeat(String date , String from , String to , String start , String end_time , int AvailableSeat)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TRAVELS_COLUMN_DATE , date);
        contentValues.put(TRAVELS_COLUMN_FROM , from);
        contentValues.put(TRAVELS_COLUMN_TO, to);
        contentValues.put(TRAVELS_COLUMN_START , start);
        contentValues.put(TRAVELS_COLUMN_END , end_time);
        contentValues.put(TRAVELS_COLUMN_AVAILABLE_SEATS , AvailableSeat);
        db.update(TRAVELS_TABLE , contentValues , "DATE = ? AND BEGINING = ? AND DESTINATION = ? AND START_TIME = ? AND END_TIME = ?",new String[]{date , from , to , start , end_time});
        return true;
    }
    public int TravelCheckForAvailableSeat(String date , String from , String to , String start , String end_time )
    {
        List<TravelsModel>everyTravel = getEveryTravel();
        int number = -1;
        for (int i = 0 ; i < everyTravel.size(); i++)
        {
            if (everyTravel.get(i).getDate().equals(date)  && everyTravel.get(i).getFrom().equals(from)  && everyTravel.get(i).getTo().equals(to) && everyTravel.get(i).getStart().equals(start)  && everyTravel.get(i).getEnd().equals(end_time))
            {
                number = everyTravel.get(i).getAvailableSeats();
                break;
            }
        }
        return number;
    }
    public List<TravelsModel> GetTravelsFromToAtDate(String date , String from , String to)
    {
        List<TravelsModel>everyTravel = getEveryTravel();
        List<TravelsModel>returnList = new ArrayList<>();
        for (int i = 0 ; i < everyTravel.size(); i++)
        {
            if (everyTravel.get(i).getDate().equals(date)  && everyTravel.get(i).getFrom().equals(from)  && everyTravel.get(i).getTo().equals(to))
            {
                returnList.add(everyTravel.get(i));
            }
        }
        return returnList;
    }
    public List<String> GetAllCities()
    {
        List<TravelsModel>everyTravel = getEveryTravel();
        List<String>returnList = new ArrayList<>();
        for (int i = 0 ; i < everyTravel.size(); i++)
        {
                returnList.add(everyTravel.get(i).getFrom());
            returnList.add(everyTravel.get(i).getTo());

        }
        return returnList;
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
