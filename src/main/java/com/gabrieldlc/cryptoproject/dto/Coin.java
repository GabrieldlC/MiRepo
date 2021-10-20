package com.gabrieldlc.cryptoproject.dto;

public class Coin {
    
    private String tiker;
    private double price;
    private int decimals;

    public Coin(String tiker, double price, int decimals) {
        this.tiker = tiker;
        this.price = price;
        this.decimals = decimals;
    }

    public String getTiker() {
        return tiker;
    }

    public double getPrice() {
        return price;
    }

    public int getDecimals() {
        return this.decimals;
    }
}
