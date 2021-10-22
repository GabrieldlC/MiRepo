package com.gabrieldlc.cryptoproject.dto;

public class Coin {

    private static final double USD_ARS = 182;
    
    private String tiker;
    private double priceArs;
    private double priceUsd;
    private int decimals;

    public Coin(String tiker, double priceUsd, int decimals) {
        this.tiker = tiker;
        this.priceUsd = priceUsd;
        this.decimals = decimals;
        this.priceArs = priceUsd * USD_ARS;
    }

    public String getTiker() {
        return tiker;
    }

    public double getPriceArs() {
        return priceArs;
    }

    public double getPriceUsd() { return  priceUsd; }

    public int getDecimals() {
        return this.decimals;
    }
}
