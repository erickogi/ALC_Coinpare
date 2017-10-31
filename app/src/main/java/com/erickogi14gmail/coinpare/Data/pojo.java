package com.erickogi14gmail.coinpare.Data;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Created by Eric on 10/27/2017.
 */

public class pojo implements Serializable {
    private LinkedList<coinPojo> coinPojos;
    private String coinName;

    public LinkedList<coinPojo> getCoinPojos() {
        return coinPojos;
    }

    public void setCoinPojos(LinkedList<coinPojo> coinPojos) {
        this.coinPojos = coinPojos;
    }

    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }
}
