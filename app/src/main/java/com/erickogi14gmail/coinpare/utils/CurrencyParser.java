package com.erickogi14gmail.coinpare.utils;

import android.util.Log;

import com.erickogi14gmail.coinpare.Data.coinPojo;
import com.erickogi14gmail.coinpare.Data.pojo;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Eric on 10/27/2017.
 */

public class CurrencyParser
{
    private static LinkedList<pojo> pojos=new LinkedList<>();


   public static LinkedList<pojo> parseData(String response) {

        JSONObject display = null;
        pojo model = null;

        JSONObject jObj = null;
        try {
            jObj = new JSONObject(response);

            display = jObj.getJSONObject("DISPLAY");


            JSONObject jsonBTC=display.getJSONObject("BTC");
            JSONObject jsonETH=display.getJSONObject("ETH");





            LinkedList<coinPojo> coinPojosBTC=new LinkedList<>();
            LinkedList<coinPojo> coinPojosETH=new LinkedList<>();

            pojo pojob=new pojo();
            pojo pojoc=new pojo();

             Iterator<String>  K =jsonBTC.keys();
                while (K.hasNext()){
                    String key=K.next();
                    JSONObject innerObject=jsonBTC.getJSONObject(key);
                    Log.d("inn",innerObject.toString());

                    String gsong=innerObject.toString();

                    Gson gson = new Gson();
                    coinPojo coinPojo=new coinPojo();



                    coinPojo = gson.fromJson(gsong, coinPojo.class);
                    coinPojo.setNAME(key);
                    coinPojosBTC.add(coinPojo);

                }
                pojob.setCoinName("BTC");

                pojob.setCoinPojos(coinPojosBTC);

                pojos.add(pojob);

            Iterator<String>  ETHK=jsonETH.keys();
            while (ETHK.hasNext()){
                String key=ETHK.next();
                JSONObject innerObject=jsonETH.getJSONObject(key);
                Log.d("inn",innerObject.toString());

                String gsong=innerObject.toString();

                Gson gson = new Gson();
                coinPojo coinPojo=new coinPojo();

                coinPojo = gson.fromJson(gsong, coinPojo.class);
                coinPojo.setNAME(key);
                coinPojosETH.add(coinPojo);

            }
            pojoc.setCoinName("ETH");

            pojoc.setCoinPojos(coinPojosETH);
            Log.d("inn",pojos.get(0).getCoinName());

            pojos.add(pojoc);
            Log.d("inns",pojos.get(0).getCoinName()+"  2"+pojos.get(1).getCoinName());









        } catch (JSONException e) {
            e.printStackTrace();
        }


        return pojos;

    }
}
