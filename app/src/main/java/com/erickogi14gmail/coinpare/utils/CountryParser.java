package com.erickogi14gmail.coinpare.utils;

import com.erickogi14gmail.coinpare.Data.CountriesPojo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;

/**
 * Created by Eric on 10/30/2017.
 */

public class CountryParser {
    private static LinkedList<CountriesPojo> countriesPojos=new LinkedList<>();
    public static LinkedList<CountriesPojo> parseData(String response) {
        try {
            JSONArray jsonArray=new JSONArray(response);
            for(int a=0;a<jsonArray.length();a++){

                CountriesPojo countriesPojo=new CountriesPojo();
                JSONObject jsonObject=jsonArray.getJSONObject(a);

                countriesPojo.setName(jsonObject.getString("name"));
                countriesPojo.setFlag_url(jsonObject.getString("flag"));

                JSONArray jsonArrayCurrency=jsonObject.getJSONArray("currencies");
                JSONObject jsonObjectCurrency=jsonArrayCurrency.getJSONObject(0);
                countriesPojo.setCurrency(jsonObjectCurrency.getString("code"));

                countriesPojos.add(countriesPojo);


            }






        } catch (JSONException e) {
            e.printStackTrace();
        }


        return countriesPojos;

    }
}
