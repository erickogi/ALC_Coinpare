package com.erickogi14gmail.coinpare.volley;

import com.android.volley.VolleyError;

/**
 * Created by Eric on 10/27/2017.
 */

public interface IResult {
    void notifySuccess(String requestType, String response);

    void notifyError(String requestType, VolleyError error);
}
