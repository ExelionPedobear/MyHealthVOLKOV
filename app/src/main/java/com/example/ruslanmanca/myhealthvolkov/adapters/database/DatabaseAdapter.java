package com.example.ruslanmanca.myhealthvolkov.adapters.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by RuslanManca on 17/11/2017.
 */

public class DatabaseAdapter extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "myhealth.db";

    Context newContext;

    public DatabaseAdapter(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.newContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE person(" +
                "idPerson INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nomPerson VARCHAR NOT NULL, " +
                "prenomPerson VARCHAR NOT NULL, " +
                "agePerson VARCHAR NOT NULL, " +
                "poidsPerson FLOAT NOT NULL, " +
                "dateMajPerson DATE NOT NULL," +
                "loginPerson FLOAT NOT NULL )");

        db.execSQL("INSERT INTO \"person\" VALUES(1,'Meiller','Kévin',34,120, datetime(),'kéké'); ");
        db.execSQL("INSERT INTO \"person\" VALUES(2,'Lafont','Antoine',24,75, datetime(),'manène'); ");
        db.execSQL("INSERT INTO \"person\" VALUES(3,'Daclin','Vincent',22,75, datetime(),'Jura'); ");
        db.execSQL("INSERT INTO \"person\" VALUES(4,'Bidault','Guillaume',72,33, datetime(),'StringJohanne'); ");
        db.execSQL("INSERT INTO \"person\" VALUES(5,'Dereims','Léonard',24,93, datetime(),'Zidane'); ");
        db.execSQL("INSERT INTO \"person\" VALUES(6,'Walter','Maxime',23,65, datetime(),'MisterWalt'); ");
        db.execSQL("INSERT INTO \"person\" VALUES(7,'Barthélémy','Maxime',23,90, datetime(),'Wasmax'); ");
        db.execSQL("INSERT INTO \"person\" VALUES(8,'Cloup','Valentin',23,76, datetime(),'Jimmy'); ");
        db.execSQL("INSERT INTO \"person\" VALUES(9,'Kiene','Benjamin',22,60, datetime(),'Benny'); ");
        db.execSQL("INSERT INTO \"person\" VALUES(10,'Volkov','Ruslan',22,75, datetime(),'ExelionPedobear'); ");
        db.execSQL("INSERT INTO \"person\" VALUES(11,'Fernandez','Thomas',22,67, datetime(),'Trouelle'); ");
        db.execSQL("INSERT INTO \"person\" VALUES(12,'Revenu','Simon',22,78, datetime(),'KFC'); ");
        db.execSQL("INSERT INTO \"person\" VALUES(13,'Potherat','Léonard',31,92, datetime(),'DjLeop'); ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch (newVersion) {
            case 2:

        }
    }
}
