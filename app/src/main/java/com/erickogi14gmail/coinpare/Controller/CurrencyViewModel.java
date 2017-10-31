package com.erickogi14gmail.coinpare.Controller;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.erickogi14gmail.coinpare.Data.Configs;
import com.erickogi14gmail.coinpare.Data.CountriesPojo;
import com.erickogi14gmail.coinpare.Data.coinPojo;
import com.erickogi14gmail.coinpare.Data.pojo;
import com.erickogi14gmail.coinpare.MyApplication;
import com.erickogi14gmail.coinpare.utils.CountryParser;
import com.erickogi14gmail.coinpare.utils.CurrencyParser;

import java.util.LinkedList;

/**
 * Created by Eric on 10/30/2017.
 */

public class CurrencyViewModel extends ViewModel {


    private MutableLiveData<LinkedList<coinPojo>> pojoBTC;
    private MutableLiveData<LinkedList<coinPojo>> pojoETH;

    private LinkedList<pojo> pojos=new LinkedList<>();
    private LinkedList<CountriesPojo> countries=new LinkedList<>();


    public LiveData<LinkedList<coinPojo>> getBTC() {
        if (pojoBTC == null) {
            pojoBTC = new MutableLiveData<LinkedList<coinPojo>>();
            pojoETH=new MutableLiveData<LinkedList<coinPojo>>();
            insertItems(1);
        }
       return pojoBTC;
    }
    public LiveData<LinkedList<coinPojo>> getETH() {
        if (pojoETH == null) {
            pojoBTC = new MutableLiveData<LinkedList<coinPojo>>();
            pojoETH=new MutableLiveData<LinkedList<coinPojo>>();

            insertItems(2);
        }
       return pojoETH;
    }

    public LinkedList<CountriesPojo> getCountries(){
        if(countries==null){
            getCountrys();
        }else {
            return countries;
        }
        return countries;
    }


    public void clear(){
        insertItems(1);

    }
    private void insertItems(int coin) {

        StringRequest strReq = new StringRequest(Request.Method.GET,
                Configs.KEY_API_URL+"USD,EUR,KES,NGN,CNY,GBP,JPY,CAD,SGD,AUD,CHF,KWD,EGP,ZAR,AED,UGX,INR,TZS", response -> {

            pojos= CurrencyParser.parseData(response);


            pojoBTC.setValue(pojos.get(0).getCoinPojos());
            Log.d("btcc",pojos.get(0).getCoinName());
            pojoETH.setValue(pojos.get(1).getCoinPojos());
            Log.d("btch",pojos.get(1).getCoinName());

        }, error -> {

        }) ;


        MyApplication.getInstance().addToRequestQueue(strReq);






    }
    private void getCountrys(){
        StringRequest strReq = new StringRequest(Request.Method.GET,
                Configs.KEY_COUNTRIES_URL, response -> {

            countries= CountryParser.parseData(response);



        }, error -> {

        }) ;


        MyApplication.getInstance().addToRequestQueue(strReq);


    }


}
