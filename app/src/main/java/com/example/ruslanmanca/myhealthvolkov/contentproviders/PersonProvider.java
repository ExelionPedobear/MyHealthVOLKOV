package com.example.ruslanmanca.myhealthvolkov.contentproviders;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.provider.BaseColumns;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.example.ruslanmanca.myhealthvolkov.adapters.database.DatabaseAdapter;
import com.example.ruslanmanca.myhealthvolkov.adapters.database.PersonAdapter;
import com.example.ruslanmanca.myhealthvolkov.models.database.Person;

import java.net.URI;
import java.util.ArrayList;

/**
 * Created by RuslanManca on 17/11/2017.
 */

public class PersonProvider extends ContentProvider {

    // The Authority
    public static final String AUTHORITY = "ruslanauthority";//package de la classe provider est préconisé (utilise des .)
    // The path to the data… and explain
    public static final String PATH_TO_DATA = "ruslandata"; //Vous pouvez déclarer plusieurs paths (les paths utilisent les /)

    public static final String PATH_TO_LOGIN = "ruslanlogin";

    public PersonAdapter personAdapter = null;
    public SQLiteDatabase myDb = null;

    public class PersonsData implements BaseColumns {
        // The URI and explain, with example if you want
        public final Uri CONTENT_URI = Uri.parse("content://" + PersonProvider.AUTHORITY + "/" + PersonProvider.PATH_TO_DATA);

        // Mon MIME type
        // My Column ID and the associated explanation
        public static final String MIME_COLLECTION = "vnd.android.cursor.dir/vnd.myCompany.contentType";

        // My Column ID and the associated explanation
        public static final String MIME_ITEM = "vnd.android.cursor.item/vnd.myCompany.contentType";

        // Noms de colonnes
        //  /!\Si vous utilisez une base de données, les noms des colonnes sont les mêmes que ceux de votre base, de même pour les index.
        public static final String KEY_COL_ID_PERSON = "idPerson"; // Mandatory
        public static final String KEY_COL_NOM_PERSON = "nomPerson";
        public static final String KEY_COL_PRENOM_PERSON = "prenomPerson";
        public static final String KEY_COL_AGE_PERSON = "agePerson";
        public static final String KEY_COL_POIDS_PERSON = "poidsPerson";
        public static final String KEY_COL_DATE_MAJ_PERSON = "dateMajPerson";
        public static final String KEY_COL_LOGIN_PERSON = "loginPerson";

        // Index des colonnes
        public static final int ID_PERSON_COLUMN = 1;
        public static final int NOM_PERSON_COLUMN = 2;
        public static final int PRENOM_PERSON_COLUMN = 3;
        public static final int AGE_PERSON_COLOR_COLUMN = 4;
        public static final int POIDS_PERSON_COLOR_COLUMN = 5;
        public static final int DATE_MAJ_PERSON_COLUMN = 6;
        public static final int LOGIN_PERSON_COLUMN = 7;
    }

    @Override
    public boolean onCreate() {
        try {
            /*DatabaseAdapter dbAdapter = new DatabaseAdapter(getContext());
            SQLiteDatabase db = dbAdapter.getWritableDatabase();
            personAdapter = new PersonAdapter(db);
            return true;*/

            DatabaseAdapter dbHelper = new DatabaseAdapter(getContext());
            myDb = dbHelper.getWritableDatabase();
            return (myDb == null) ? false : true;
        }
        catch (Exception ex){
            return false;
        }
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sort) {
    //public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {
        /*ArrayList<Person> persons;
        persons = personAdapter.getAll();
        return persons;*/
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        qb.setTables("person");
        // S'il s'agit d'une requête sur une ligne, on limite le résultat.
        switch (uriMatcher.match(uri)) {
            case ITEM:
                qb.appendWhere(PersonsData.KEY_COL_ID_PERSON + "=" + uri.getPathSegments().get(1));
                break;
            case LOGIN:
                qb.appendWhere(PersonsData.KEY_COL_LOGIN_PERSON + " like '" + uri.getPathSegments().get(1) + "'");
                break;
            default:
                break;
        }

        // Si aucun ordre de tri n'est spécifié, tri par date/heure
        String orderBy;
        if (TextUtils.isEmpty(sort)) {
            orderBy = PersonsData.KEY_COL_NOM_PERSON;
        } else {
            orderBy = sort;
        }

        // Applique la requête à la base.
        Cursor c = qb.query(myDb, projection, selection, selectionArgs, null, null, orderBy);

        // Enregistre le ContextResolver pour qu'il soit averti
        // si le résultat change.
        c.setNotificationUri(getContext().getContentResolver(), uri);

        // Renvoie un curseur.
        return c;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    private static final int ITEM = 1;

    private static final int COLLECTION = 2;

    private static final int LOGIN = 3;

    private static final UriMatcher uriMatcher;

    // Alloue l'objet UriMatcher.
    // Une URI terminée par myPathToData correspondra à une requête sur une collection.
    // Une URI terminée par'/[rowID]' correspondra à un item.
    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(PersonProvider.AUTHORITY, PersonProvider.PATH_TO_DATA, COLLECTION);
        uriMatcher.addURI(PersonProvider.AUTHORITY, PersonProvider.PATH_TO_DATA + "/#", ITEM);
        uriMatcher.addURI(PersonProvider.AUTHORITY, PersonProvider.PATH_TO_LOGIN + "/*", LOGIN);
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        throw new UnsupportedOperationException();
    }
}
