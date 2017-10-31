package com.erickogi14gmail.coinpare.volley;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by Eric on 10/27/2017.
 */

public class volley {


    static RequestQueue queue;
    private Context context;

    public volley(Context context) {
        this.context = context;
    }

    public String response(String response) {
        String res = response;


        return res;
    }

    public void requestDataSources(String uri) {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, uri,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        if (response != null || !response.isEmpty()) {


                        } else {

                        }

                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {


                    }
                });
        queue = Volley.newRequestQueue(context);
        queue.add(stringRequest);

    }



}
