package com.erickogi14gmail.coinpare.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Eric on 10/30/2017.
 */

public class DbClass extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "coinpare.db";

    String createTableCountries = "CREATE TABLE `coinpare_countries` (" +
            "  `id` INTEGER PRIMARY KEY AUTOINCREMENT  ," +
            "  `name` varchar NOT NULL"

            + ")";

    String createTableRates = "CREATE TABLE `coinpare_rate` (" +
            "  `id` INTEGER PRIMARY KEY AUTOINCREMENT  ," +
            "'"+Configs.FROMSYMBOL+"' varchar,"+
            "'"+Configs.TOSYMBOL+"' varchar,"+
            "'"+Configs.MARKERT+"' varchar,"+
            "'"+Configs.PRICE+"' varchar,"+
            "'"+Configs.LASTUPDATE+"' varchar,"+
            "'"+Configs.LASTVOLUMETO+"' varchar,"+
            "'"+Configs.LASTVOLUME+"' varchar,"+
            "'"+Configs.LASTTRADEDID+"' varchar,"+
            "'"+Configs.VOLUME24HOUR+"' varchar,"+
            "'"+Configs.VOLUME24HOURTO+"' varchar,"+

            "'"+Configs.OPEN24HOUR+"' varchar,"+
            "'"+Configs.HIGH24HOUR+"' varchar,"+
            "'"+Configs.LOW24HOUR+"' varchar,"+
            "'"+Configs.LASTMARKET+"' varchar,"+
            "'"+Configs.CHANGE24HOUR+"' varchar,"+
            "'"+Configs.CHANGEPCT24HOUR+"' varchar,"+
            "'"+Configs.NAME+"' varchar"


            + ")";




    public DbClass(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTableCountries);
        db.execSQL(createTableRates);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + createTableCountries);
        db.execSQL("DROP TABLE IF EXISTS " + createTableRates);



        onCreate(db);
    }
}
