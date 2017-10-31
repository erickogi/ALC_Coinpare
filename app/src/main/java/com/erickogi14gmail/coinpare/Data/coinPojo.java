package com.erickogi14gmail.coinpare.Data;

import java.io.Serializable;

/**
 * Created by Eric on 10/27/2017.
 */

public class coinPojo implements Serializable {
    private String FROMSYMBOL;
    private String TOSYMBOL;
    private String MARKERT;
    private String PRICE;
    private String LASTUPDATE;
    private String LASTVOLUMETO;
    private String LASTVOLUME;
    private String LASTTRADEDID;
    private String VOLUME24HOUR;
    private String VOLUME24HOURTO;
    private String OPEN24HOUR;
    private String HIGH24HOUR;
    private String LOW24HOUR;
    private String LASTMARKET;
    private String CHANGE24HOUR;
    private String CHANGEPCT24HOUR;
    private String NAME;

    public coinPojo(String FROMSYMBOL, String TOSYMBOL, String MARKERT, String PRICE, String LASTUPDATE, String LASTVOLUMETO, String LASTVOLUME, String LASTTRADEDID, String VOLUME24HOUR, String VOLUME24HOURTO, String OPEN24HOUR, String HIGH24HOUR, String LOW24HOUR, String LASTMARKET, String CHANGE24HOUR, String CHANGEPCT24HOUR) {
        this.FROMSYMBOL = FROMSYMBOL;
        this.TOSYMBOL = TOSYMBOL;
        this.MARKERT = MARKERT;
        this.PRICE = PRICE;
        this.LASTUPDATE = LASTUPDATE;
        this.LASTVOLUMETO = LASTVOLUMETO;
        this.LASTVOLUME = LASTVOLUME;
        this.LASTTRADEDID = LASTTRADEDID;
        this.VOLUME24HOUR = VOLUME24HOUR;
        this.VOLUME24HOURTO = VOLUME24HOURTO;
        this.OPEN24HOUR = OPEN24HOUR;
        this.HIGH24HOUR = HIGH24HOUR;
        this.LOW24HOUR = LOW24HOUR;
        this.LASTMARKET = LASTMARKET;
        this.CHANGE24HOUR = CHANGE24HOUR;
        this.CHANGEPCT24HOUR = CHANGEPCT24HOUR;
    }

    public coinPojo() {

    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getFROMSYMBOL() {
        return FROMSYMBOL;
    }

    public void setFROMSYMBOL(String FROMSYMBOL) {
        this.FROMSYMBOL = FROMSYMBOL;
    }

    public String getTOSYMBOL() {
        return TOSYMBOL;
    }

    public void setTOSYMBOL(String TOSYMBOL) {
        this.TOSYMBOL = TOSYMBOL;
    }

    public String getMARKERT() {
        return MARKERT;
    }

    public void setMARKERT(String MARKERT) {
        this.MARKERT = MARKERT;
    }

    public String getPRICE() {
        return PRICE;
    }

    public void setPRICE(String PRICE) {
        this.PRICE = PRICE;
    }

    public String getLASTUPDATE() {
        return LASTUPDATE;
    }

    public void setLASTUPDATE(String LASTUPDATE) {
        this.LASTUPDATE = LASTUPDATE;
    }

    public String getLASTVOLUMETO() {
        return LASTVOLUMETO;
    }

    public void setLASTVOLUMETO(String LASTVOLUMETO) {
        this.LASTVOLUMETO = LASTVOLUMETO;
    }

    public String getLASTVOLUME() {
        return LASTVOLUME;
    }

    public void setLASTVOLUME(String LASTVOLUME) {
        this.LASTVOLUME = LASTVOLUME;
    }

    public String getLASTTRADEDID() {
        return LASTTRADEDID;
    }

    public void setLASTTRADEDID(String LASTTRADEDID) {
        this.LASTTRADEDID = LASTTRADEDID;
    }

    public String getVOLUME24HOUR() {
        return VOLUME24HOUR;
    }

    public void setVOLUME24HOUR(String VOLUME24HOUR) {
        this.VOLUME24HOUR = VOLUME24HOUR;
    }

    public String getVOLUME24HOURTO() {
        return VOLUME24HOURTO;
    }

    public void setVOLUME24HOURTO(String VOLUME24HOURTO) {
        this.VOLUME24HOURTO = VOLUME24HOURTO;
    }

    public String getOPEN24HOUR() {
        return OPEN24HOUR;
    }

    public void setOPEN24HOUR(String OPEN24HOUR) {
        this.OPEN24HOUR = OPEN24HOUR;
    }

    public String getHIGH24HOUR() {
        return HIGH24HOUR;
    }

    public void setHIGH24HOUR(String HIGH24HOUR) {
        this.HIGH24HOUR = HIGH24HOUR;
    }

    public String getLOW24HOUR() {
        return LOW24HOUR;
    }

    public void setLOW24HOUR(String LOW24HOUR) {
        this.LOW24HOUR = LOW24HOUR;
    }

    public String getLASTMARKET() {
        return LASTMARKET;
    }

    public void setLASTMARKET(String LASTMARKET) {
        this.LASTMARKET = LASTMARKET;
    }

    public String getCHANGE24HOUR() {
        return CHANGE24HOUR;
    }

    public void setCHANGE24HOUR(String CHANGE24HOUR) {
        this.CHANGE24HOUR = CHANGE24HOUR;
    }

    public String getCHANGEPCT24HOUR() {
        return CHANGEPCT24HOUR;
    }

    public void setCHANGEPCT24HOUR(String CHANGEPCT24HOUR) {
        this.CHANGEPCT24HOUR = CHANGEPCT24HOUR;
    }
}
