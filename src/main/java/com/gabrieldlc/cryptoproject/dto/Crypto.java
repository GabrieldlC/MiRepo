package com.gabrieldlc.cryptoproject.dto;

public class Crypto {

    private static final double USD_ARS = 182;
    
    private String ticker;
    private double price;
    private int decimals;

    public Crypto(String ticker, double price, int decimals) {
        this.ticker = ticker;
        this.price = price;
        this.decimals = decimals;
    }

    public String getTicker() {
        return ticker;
    }

    public double getPrice() { return price; }

    public int getDecimals() {
        return this.decimals;
    }
}
