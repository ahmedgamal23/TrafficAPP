package com.example.myapplication.db;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

public class DBhelper extends SQLiteOpenHelper {

    private static final String database_name = "ticket";
    private static final String table_name1 = "registration";
    private static final String table_name2 = "save_ticket";
    private static final int database_version = 1;
    private static final String Drop_table_u = "drop table if exists " + table_name1;
    private static final String Drop_table_t = "drop table if exists " + table_name2;
    private Context context;

    public DBhelper(Context context){
        super(context, database_name ,null,database_version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase mydb) {
        String create_table_user = "create table registration ( first_name TEXT , last_name TEXT , username TEXT PRIMARY KEY , email TEXT , password TEXT , phone_number INTEGER , Nick_name TEXT );" ;
        String create_table_ticket = "create table save_ticket (ID INTEGER PRIMARY KEY AUTOINCREMENT , user_name TEXT , check_received BOOLEAN ); ";
        mydb.execSQL(create_table_user);
        mydb.execSQL(create_table_ticket);
    }

    @Override
    public void onUpgrade(SQLiteDatabase mydb, int oldVersion, int newVersion) {
        mydb.execSQL(Drop_table_u);
        mydb.execSQL(Drop_table_t);
        onCreate(mydb);
    }

    public Boolean insertdata(String first_name , String last_name , String username , String email ,String password , int phone_num , String nick_name)
    {
        // data for user
        SQLiteDatabase mydb=this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("first_name",first_name);
        contentValues.put("last_name",last_name);
        contentValues.put("username",username);
        contentValues.put("email",email);
        contentValues.put("password",password);
        contentValues.put("phone_number",phone_num);
        contentValues.put("Nick_name",nick_name);
        long result = mydb.insert(table_name1 ,null , contentValues);
        if (result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public void save_ticket(String username , boolean check)
    {
        // data for user
        SQLiteDatabase mydb=this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username",username);
        contentValues.put("check_received",check);
        mydb.insert(table_name2 ,null , contentValues);
    }

    public Boolean checkusername(String username)
    {
        SQLiteDatabase mydb=this.getWritableDatabase();
        Cursor cursor = mydb.rawQuery("select * from registration where username=? " , new String[]{username});
        if(cursor.getCount()>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public Boolean checkusernamepassword(String username,String password)
    {
        SQLiteDatabase mydb=this.getWritableDatabase();
        Cursor cursor=mydb.rawQuery("select *from registration where username=? and password=? ",new String[]{username,password});
        if(cursor.getCount()>0)
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    //to read data from sqLite
    public Cursor getData(String usern) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from registration ", null );
        return res;
    }

    public void update_account (String user_name , String first_name , String last_name , String email , String pass , int phone , String nick_name){
        SQLiteDatabase mydb = this.getWritableDatabase();
        //mydb.execSQL("UPDATE registration SET first_name = " +first_name+ " , last_name = " +last_name+ ", email = " +email +" , password = " +pass+ " , phone_number = " +phone+ " , Nick_name = " +nick_name+ " WHERE username ="+username );
        //mydb.close();
        ContentValues contentValues = new ContentValues();
        contentValues.put("first_name" , first_name);
        contentValues.put("last_name" ,last_name );
        contentValues.put("email" , email);
        contentValues.put("password" , pass);
        contentValues.put("phone_number" , phone);
        contentValues.put("Nick_name" , nick_name);
        long result = mydb.update("registration" , contentValues , "username = ?" , new String[]{user_name});
        if(result == -1)
        {
            Toast.makeText(context , "Failed Update" , Toast.LENGTH_LONG).show();
        }else
        {
            Toast.makeText(context , "Successful Update" , Toast.LENGTH_LONG).show();
        }

    }
}