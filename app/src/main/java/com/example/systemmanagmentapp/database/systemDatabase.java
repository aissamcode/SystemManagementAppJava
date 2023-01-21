package com.example.systemmanagmentapp.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class systemDatabase extends SQLiteOpenHelper
{

    public systemDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    //@aissamcode

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //add table user to database
        String queryuser="CREATE TABLE IF NOT EXISTS user (login TEXT , password TEXT , name TEXT , firstname TEXT , role INT)";
        sqLiteDatabase.execSQL(queryuser);
        //add table former to database
        String queryformer="CREATE TABLE IF NOT EXISTS former (registrationnumber TEXT , diploma TEXT , speciality TEXT , recruitmentdate TEXT , name TEXT, firstname TEXT)";
        sqLiteDatabase.execSQL(queryformer);
        // add table intern to database
        String queryintern = "CREATE TABLE IF NOT EXISTS intern (name TEXT , firstname TEXT ,gender TEXT,bacgrades REAL,field TEXT, finalgrades REAL)";
        sqLiteDatabase.execSQL(queryintern);
        //add table field to database
        String queryfield = "CREATE TABLE IF NOT EXISTS field (name TEXT,description TEXT)";
        sqLiteDatabase.execSQL(queryfield);
        sqLiteDatabase.execSQL("INSERT INTO user (login,password,name,firstname,role)VALUES('aissamcode','aissamcode','belmeskine','aissam',1)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
onCreate(sqLiteDatabase);
    }

    //function that allow us to login to userinterface
    // return the role of each user ( director = 1 || former = 2 || intern ==3 ) if the user is not found return 0 by default
    public int mainlogin(String login, String password)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        String[] userinfo = new String[]{login,password};
        Cursor c=db.rawQuery("select * from user where login = ? and password = ? ",userinfo);
        int count = c.getCount();
        c.moveToFirst();
        if (c!=null&& count>0)
        {
            int v= c.getInt(4);
            c.close();
            return v;
        }
        else
            return 0;
    }
    //function to ADD USER
    public void adduser(String login,String password,String name,String firstname,Integer role)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("insert into user(login,password,name,firstname,role)values('"+login+"','"+password+"','"+name+"','"+firstname+"','"+role+"')");
    }
    //function to ADD FORMER
    public void addfromer(String registrationnumber,String diploma,String speciality,String recruitmentdate,String name,String firstname)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL ("insert into former(registrationnumber,diploma,speciality,recruitmentdate,name,firstname)values('"+registrationnumber+"','"+diploma+"','"+speciality+"','"+recruitmentdate+"','"+name+"','"+firstname+"')");

    }
    public void addfield(String name,String description)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL ("insert into field(name,description)values('"+name+"','"+description+"')");

    }
    public void addintern(String name,String firstname,String gender,Double bacgrades,String field,Double finalgrades)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("insert into intern(name,firstname,gender,bacgrades,field,finalgrades)values('"+name+"','"+firstname+"','"+gender+"','"+bacgrades+"','"+field+"','"+finalgrades+"')");
    }
    public ArrayList<String> getDataFormer()
    {
        ArrayList<String> lsf=new ArrayList<String>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery("select * from former ",null);
        c.moveToFirst();
        while ( c.isAfterLast()==false){
            String getregistrationnumber=c.getString(c.getColumnIndexOrThrow("registrationnumber"));
            String getdiploma=c.getString(c.getColumnIndexOrThrow("diploma"));
            String getspeciality=c.getString(c.getColumnIndexOrThrow("speciality"));
            String getrecruitmentdate=c.getString(c.getColumnIndexOrThrow("recruitmentdate"));
            String getname=c.getString(c.getColumnIndexOrThrow("name"));
            String getfirstname=c.getString(c.getColumnIndexOrThrow("firstname"));
            lsf.add("Registration number : "+ getregistrationnumber+" : "+getname+" "+getfirstname+" \n "+ getdiploma+" "+getspeciality+"\nrecruitment date : "+getrecruitmentdate);
            c.moveToNext();
        }
        return lsf;
    }
    public ArrayList<String> getDataintern()
    {
        ArrayList<String> lss=new ArrayList<String>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery("select * from intern ",null);
        c.moveToFirst();
        while ( c.isAfterLast()==false){
            String getname=c.getString(c.getColumnIndexOrThrow("name"));
            String getfirstname=c.getString(c.getColumnIndexOrThrow("firstname"));
            String getgender=c.getString(c.getColumnIndexOrThrow("gender"));
            String getbacgrades=c.getString(c.getColumnIndexOrThrow("bacgrades"));
            String getfield=c.getString(c.getColumnIndexOrThrow("field"));
            String getfinalgrades=c.getString(c.getColumnIndexOrThrow("finalgrades"));
            lss.add("Full name : "+getname+"  "+getfirstname+"\nsexe : "+getgender+"\nNote Bac : "+getbacgrades+"\nFilier : "+getfield+"\ngrades : "+getfinalgrades);
            c.moveToNext();
        }
        return lss;
    }
    public ArrayList<String> getDatainternspinner()
    {
        ArrayList<String> lss=new ArrayList<String>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery("select * from intern ",null);
        c.moveToFirst();
        while ( c.isAfterLast()==false){
            String getname=c.getString(c.getColumnIndexOrThrow("name"));
            String getfirstname=c.getString(c.getColumnIndexOrThrow("firstname"));
            lss.add("Full name : /"+getname+"/"+getfirstname);
            c.moveToNext();
        }
        return lss;
    }
    public ArrayList<String> getDatafield()
    {
        ArrayList<String> lss=new ArrayList<String>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery("select * from field ",null);
        c.moveToFirst();
        while ( c.isAfterLast()==false){
            String getname=c.getString(c.getColumnIndexOrThrow("name"));
            String getdescription=c.getString(c.getColumnIndexOrThrow("description"));
            lss.add("filed name : "+getname+"  "+getdescription);
            c.moveToNext();
        }
        return lss;
    }
    public ArrayList<String> getdatainfo(String login, String password)
    {
        ArrayList<String> lss=new ArrayList<String>();
        SQLiteDatabase db=this.getReadableDatabase();
        String[] userinfo = new String[]{login,password};
        Cursor c=db.rawQuery("select * from user where login = ? and password = ? ",userinfo);

        c.moveToFirst();
        while ( c.isAfterLast()==false){
            String getname=c.getString(c.getColumnIndexOrThrow("name"));
            String getFirstname=c.getString(c.getColumnIndexOrThrow("firstname"));
            String getlogin=c.getString(c.getColumnIndexOrThrow("login"));
            String getpassword=c.getString(c.getColumnIndexOrThrow("password"));
            lss.add(getname);
            lss.add(getFirstname);
            lss.add(getlogin);
            lss.add(getpassword);
            c.moveToNext();
        }
        return lss;
    }
    public int getnumberintern()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor numberinern= db.rawQuery("select * from intern" ,null);

        int count= numberinern.getCount();
        numberinern.close();
        return count;
    }
    public int getnumberformer()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor numberinern= db.rawQuery("select * from former" ,null);

        int count= numberinern.getCount();
        numberinern.close();
        return count;
    }
    public void updategrades(String name,String firstname,Double grade)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String[] info = new String[]{name,firstname};
        db.execSQL("UPDATE intern SET finalgrades='"+grade+"' WHERE name= ? and firstname= ?",info);

    }
    // intern (name TEXT , firstname TEXT ,gender TEXT,bacgrades REAL,field TEXT, finalgrades REAL)";
    public ArrayList<String> getdatainfointern(String name, String firstname)
    {
        ArrayList<String> lss=new ArrayList<String>();
        SQLiteDatabase db=this.getReadableDatabase();
        String[] userinfo = new String[]{name,firstname};
        Cursor c=db.rawQuery("select * from intern where name = ? and firstname = ? ",userinfo);

        c.moveToFirst();
        while ( c.isAfterLast()==false){
            String getname=c.getString(c.getColumnIndexOrThrow("name"));
            String getFirstname=c.getString(c.getColumnIndexOrThrow("firstname"));
            String getgender=c.getString(c.getColumnIndexOrThrow("gender"));
            String getfield=c.getString(c.getColumnIndexOrThrow("field"));
            String getfinalgrades=c.getString(c.getColumnIndexOrThrow("finalgrades"));
            lss.add(getname);
            lss.add(getFirstname);
            lss.add(getgender);
            lss.add(getfield);
            lss.add(getfinalgrades);
            c.moveToNext();
        }
        return lss;
    }
}
