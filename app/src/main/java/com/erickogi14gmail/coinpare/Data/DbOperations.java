package com.erickogi14gmail.coinpare.Data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Eric on 10/30/2017.
 */

public class DbOperations {
    private Context context;
    private DbClass dbHandler;
    private boolean successful = false;

    public DbOperations(Context context) {
        dbHandler = new DbClass(context);
        this.context = context;
    }
    public ArrayList<CountriesPojo> getAllCountries() {
        //Open connection to read only
        SQLiteDatabase db = dbHandler.getReadableDatabase();


        ArrayList<CountriesPojo> data = new ArrayList<>();
        String QUERY = null;
        ///if(!search.equals("")) {
        //     QUERY= "SELECT * FROM  mduka_items_stock WHERE item_quantity > 0 AND item_category LIKE '%" + search + "%'  AND item_name LIKE '%" + search + "%'";

        // }else {
        QUERY = "SELECT * FROM  coinpare_countries ";

        // }

        Cursor cursor = db.rawQuery(QUERY, null);

        if (!cursor.isLast()) {

            while (cursor.moveToNext()) {
                CountriesPojo pojo = new CountriesPojo();
               pojo.setName(cursor.getString(1));

                data.add(pojo);

            }
        }
        db.close();
        // looping through all rows and adding to list

        if (cursor == null) {
            return null;
        } else if (!cursor.moveToFirst()) {
            cursor.close();
            return null;
        }
        return data;


    }
    public LinkedList<pojo> getSavedData() {
        //Open connection to read only
        SQLiteDatabase db = dbHandler.getReadableDatabase();


        LinkedList<pojo> data=new LinkedList<>();
        String QUERY1 = null;
        String QUERY2 = null;


        String eths="Ξ";
        String bitcoin="BTC";
        QUERY1 = "SELECT * FROM  coinpare_rate WHERE FROMSYMBOL ='"+bitcoin+"'";
        QUERY2 = "SELECT * FROM  coinpare_rate WHERE FROMSYMBOL ='"+eths+"'";

        // }

        Cursor cursor1 = db.rawQuery(QUERY1, null);

        if (!cursor1.isLast()) {

            LinkedList<coinPojo> coinPojosBTC=new LinkedList<>();

            pojo pojob=new pojo();
            pojo pojoc=new pojo();

            while (cursor1.moveToNext()) {
                coinPojo pojo = new coinPojo();
                pojo.setFROMSYMBOL(cursor1.getString(1));
                pojo.setTOSYMBOL(cursor1.getString(2));
                pojo.setMARKERT(cursor1.getString(3));
                pojo.setPRICE(cursor1.getString(4));
                pojo.setLASTUPDATE(cursor1.getString(5));
                pojo.setLASTVOLUMETO(cursor1.getString(6));
                pojo.setLASTVOLUME(cursor1.getString(7));
                pojo.setLASTTRADEDID(cursor1.getString(8));
                pojo.setVOLUME24HOUR(cursor1.getString(9));
                pojo.setVOLUME24HOURTO(cursor1.getString(10));
                pojo.setOPEN24HOUR(cursor1.getString(11));
                pojo.setHIGH24HOUR(cursor1.getString(12));
                pojo.setLOW24HOUR(cursor1.getString(13));
                pojo.setLASTMARKET(cursor1.getString(14));
                pojo.setCHANGE24HOUR(cursor1.getString(15));
                pojo.setCHANGEPCT24HOUR(cursor1.getString(16));
                pojo.setNAME(cursor1.getString(17));

                //coinPojo = gson.fromJson(gsong, coinPojo.class);
               // coinPojo.setNAME(key);
                coinPojosBTC.add(pojo);


            }
            pojob.setCoinName("BTC");

            pojob.setCoinPojos(coinPojosBTC);

            data.add(pojob);
        }

        Cursor cursor2 =db.rawQuery(QUERY2, null);

        if (!cursor2.isLast()) {
            LinkedList<coinPojo> coinPojosETH=new LinkedList<>();


            pojo pojob=new pojo();
            pojo pojoc=new pojo();

            while (cursor2.moveToNext()) {
                coinPojo pojo = new coinPojo();
                pojo.setFROMSYMBOL(cursor2.getString(1));
                pojo.setTOSYMBOL(cursor2.getString(2));
                pojo.setMARKERT(cursor2.getString(3));
                pojo.setPRICE(cursor2.getString(4));
                pojo.setLASTUPDATE(cursor2.getString(5));
                pojo.setLASTVOLUMETO(cursor2.getString(6));
                pojo.setLASTVOLUME(cursor2.getString(7));
                pojo.setLASTTRADEDID(cursor2.getString(8));
                pojo.setVOLUME24HOUR(cursor2.getString(9));
                pojo.setVOLUME24HOURTO(cursor2.getString(10));
                pojo.setOPEN24HOUR(cursor2.getString(11));
                pojo.setHIGH24HOUR(cursor2.getString(12));
                pojo.setLOW24HOUR(cursor2.getString(13));
                pojo.setLASTMARKET(cursor2.getString(14));
                pojo.setCHANGE24HOUR(cursor2.getString(15));
                pojo.setCHANGEPCT24HOUR(cursor2.getString(16));
                pojo.setNAME(cursor2.getString(17));

                //coinPojo = gson.fromJson(gsong, coinPojo.class);
                // coinPojo.setNAME(key);
                coinPojosETH.add(pojo);


            }
            pojoc.setCoinName("ETH");

            pojoc.setCoinPojos(coinPojosETH);

            data.add(pojoc);
        }
        db.close();
        // looping through all rows and adding to list

        if (cursor1 == null) {
            return null;
        } else if (!cursor1.moveToFirst()) {
            cursor1.close();
            return null;
        }
        if (cursor2 == null) {
            return null;
        } else if (!cursor2.moveToFirst()) {
            cursor2.close();
            return null;
        }
        return data;


    }

    public boolean deleteCountry(String name) {
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        if (db.delete("coinpare_countries", "name" + "= '" + name + "' ", null) > 0) {
            successful = true;
        } else {
            successful = false;
        }
        db.close();
        return successful;
    }
    public boolean deleteCurrency(String name) {
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        if (db.delete("coinpare_rate", "name" + "= '" + name + "' ", null) > 0) {
            successful = true;
        } else {
            successful = false;
        }
        db.close();
        return successful;
    }

}
