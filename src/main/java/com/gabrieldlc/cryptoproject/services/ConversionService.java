package com.gabrieldlc.cryptoproject.services;

import com.gabrieldlc.cryptoproject.dto.Crypto;
import com.gabrieldlc.cryptoproject.dto.Fiat;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ConversionService {
    private static final String MSG_NEGATIVE_NUM = "El monto ingresado debe ser mayor o igual a 0";
    private static final String MSG_NO_TOKEN_EXIST = "El token ingresado no existe";
    private static final String MSG_ERROR = "Error inesperado";

    private ArrayList<Crypto> tokens;
    private ArrayList<Fiat> currencys;

    public ConversionService() {
        tokens = new ArrayList<>();
        addToken("USDT", 1.01, 2);
        addToken("BTC", 64000, 8);
        addToken("ETH", 4200, 5);
        addToken("ADA", 2.3, 3);
        addToken("BNB", 490, 4);

        addCurrency("USD", 1);
        addCurrency("ARS", 197);
    }

    private void addToken(String ticker, double price, int decimals) { tokens.add(new Crypto(ticker, price, decimals)); }

    private void addCurrency(String ticker, double price) { currencys.add(new Fiat(ticker, price)); }

    public double fiatToCrypto(String currency, double value, String token) {
        Fiat myCash;
        Crypto myCoin;

        try {
            myCash = currencys.stream().filter(x -> x.getTicker().equals(currency.toUpperCase())).findFirst().get();
            myCoin = tokens.stream().filter(x -> x.getTicker().equals(token.toUpperCase())).findFirst().get();

            if (value < 0) {
                throw new IndexOutOfBoundsException(MSG_NEGATIVE_NUM);
            }

            return limitDecimals(value / myCash.getPrice() / myCoin.getPrice(), myCoin.getDecimals());
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(MSG_NO_TOKEN_EXIST);
        } catch (Exception e) {
            throw new RuntimeException(MSG_ERROR);
        }
    }

    public double cryptoToFiat(String token, double value, String currency) {
        Fiat myCash;
        Crypto myCoin;

        try {
            myCash = currencys.stream().filter(x -> x.getTicker().equals(currency.toUpperCase())).findFirst().get();
            myCoin = tokens.stream().filter(x -> x.getTicker().equals(token.toUpperCase())).findFirst().get();

            if (value < 0) {
                throw new IndexOutOfBoundsException(MSG_NEGATIVE_NUM);
            }

            return limitDecimals(myCoin.getPrice() * value * myCash.getPrice(), myCoin.getDecimals());
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(MSG_NO_TOKEN_EXIST);
        } catch (Exception e) {
            throw new RuntimeException(MSG_ERROR);
        }
    }

    public double cryptoToCrypto(String token1, double value, String token2) {
        Crypto crypto1;
        Crypto crypto2;

        try {
            crypto1 = tokens.stream().filter(x -> x.getTicker().equals(token1.toUpperCase())).findFirst().get();
            crypto2 = tokens.stream().filter(x -> x.getTicker().equals(token2.toUpperCase())).findFirst().get();

            if (value < 0) {
                throw new IndexOutOfBoundsException(MSG_NEGATIVE_NUM);
            }

            return limitDecimals(crypto1.getPrice() * value / crypto2.getPrice(), crypto2.getDecimals());
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(MSG_NO_TOKEN_EXIST);
        } catch (Exception e) {
            throw new RuntimeException(MSG_ERROR);
        }
    }

    public double limitDecimals(double number, int decimals) {
        BigDecimal bd = new BigDecimal(number).setScale(decimals, RoundingMode.HALF_UP);

        return bd.doubleValue();
    }

}
