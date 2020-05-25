package com.enginegroupsolutions.pokemonfirst;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDbHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "pokemon.db";
    private static final String TABLE_POKEMONS = "pokemons";
    private static final String COLUMNA_ID = "_id";
    private static final String COLUMNA_NOMBRE = "_pName";

    public MyDbHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCreate = "CREATE TABLE " + TABLE_POKEMONS
                        + " (" + COLUMNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + COLUMNA_NOMBRE + " TEXT " + "); ";

        db.execSQL(queryCreate);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String queryUpgrate = "DROP TABLE IF EXISTS " + TABLE_POKEMONS + "";

        db.execSQL(queryUpgrate);
        onCreate(db);
    }

    public void addPokemon (Pokemon pokemon){
        ContentValues values = new ContentValues();

        values.put(COLUMNA_NOMBRE,pokemon.get_pName());
        SQLiteDatabase db = getWritableDatabase();

        db.insert(TABLE_POKEMONS, null, values);
        db.close();
    }
    public void deletePokemon (Pokemon pokemonName){
        String deleteQuery = "DELETE FROM " + TABLE_POKEMONS + " WHERE " + COLUMNA_NOMBRE + "=\"" + pokemonName + "\";";
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(deleteQuery);
    }

    public String databaseToString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();

        String querySelect = "SELECT * FROM " + TABLE_POKEMONS + " WHERE 1;";
        Cursor c = db.rawQuery(querySelect, null);
        c.moveToFirst();

        while(!c.isAfterLast()){
            if(c.getString(c.getColumnIndex("_pName")) != null) {
                dbString += c.getString(c.getColumnIndex("_pName"));
                dbString += "\n";
            }
            c.moveToNext();
        }
        db.close();
        return dbString;
    }

}
