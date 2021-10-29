package com.gabrieldlc.cryptoproject.dto;

public class Fiat {
    private String ticker;
    private double price;
    private int decimals;

    public Fiat(String ticker, double price) {
        this.ticker = ticker;
        this.price = price;
        this.decimals = 2;
    }

    public String getTicker() {
        return ticker;
    }

    public double getPrice() {
        return price;
    }

    public int getDecimals() {
        return decimals;
    }
}
