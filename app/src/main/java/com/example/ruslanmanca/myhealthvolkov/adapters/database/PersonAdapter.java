package com.example.ruslanmanca.myhealthvolkov.adapters.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ruslanmanca.myhealthvolkov.models.database.Person;

import java.util.ArrayList;

/**
 * Created by RuslanManca on 17/11/2017.
 */

public class PersonAdapter {
    public static final String TABLE = "person";

    private SQLiteDatabase db = null;

    public PersonAdapter(SQLiteDatabase db) {
        this.db = db;
    }

    public ArrayList<Person> getAll(){
        Cursor cursor = db.query(TABLE, //table
                new String[]{"idPerson", "nomPerson", "prenomPerson", "agePerson", "poidsPerson", "dateMajPerson", "loginPerson"}, //colonnes
                null, //selection (where)
                null, //paramètres de sélection
                null, //order
                null, //group
                null); //limit

        ArrayList<Person> persons = new ArrayList<Person>();
        persons = this.fillPersonList(cursor);

        return persons;
    }

    public Person getById(long id){
        Cursor cursor = db.query(TABLE, //table
                new String[]{"idPerson", "nomPerson", "prenomPerson", "agePerson", "poidsPerson", "dateMajPerson", "loginPerson"}, //colonnes
                "idPerson LIKE ?", //selection (where)
                new String[]{String.valueOf(id)}, //paramètres de sélection
                null, //order
                null, //group
                null); //limit

        Person person = new Person();

        if (cursor.moveToFirst()){
            person.setIdPerson(cursor.getLong(0));
            person.setNomPerson(cursor.getString(1));
            person.setPrenomPerson(cursor.getString(2));
            person.setAgePerson(cursor.getLong(3));
            person.setPoidsPerson(cursor.getFloat(4));
            person.setDateMajPerson(cursor.getString(5));
            person.setLoginPerson(cursor.getString(6));
        }

        cursor.close();

        return person;
    }

    private ArrayList<Person> fillPersonList(Cursor cursor){
        ArrayList<Person> result = new ArrayList<Person>();
        while (cursor.moveToNext()){
            Person person = new Person();
            int idPersonColumnIndex = cursor.getColumnIndex("idPerson");
            int nomPersonColumnIndex = cursor.getColumnIndex("nomPerson");
            int prenomPersonColumnIndex = cursor.getColumnIndex("prenomPerson");
            int agePersonColumnIndex = cursor.getColumnIndex("agePerson");
            int poidsPersonColumnIndex = cursor.getColumnIndex("poidsPerson");
            int dateMajPersonColumnIndex = cursor.getColumnIndex("dateMajPerson");
            int loginPersonColumnIndex = cursor.getColumnIndex("loginPerson");

            person.setIdPerson(cursor.getLong(idPersonColumnIndex));
            person.setNomPerson(cursor.getString(nomPersonColumnIndex));
            person.setPrenomPerson(cursor.getString(prenomPersonColumnIndex));
            person.setAgePerson(cursor.getLong(agePersonColumnIndex));
            person.setPoidsPerson(cursor.getFloat(poidsPersonColumnIndex));
            person.setDateMajPerson(cursor.getString(dateMajPersonColumnIndex));
            person.setLoginPerson(cursor.getString(loginPersonColumnIndex));

            result.add(person);
        }

        return result;
    }
}
