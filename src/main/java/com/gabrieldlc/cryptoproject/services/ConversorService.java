package com.gabrieldlc.cryptoproject.services;

import com.gabrieldlc.cryptoproject.dto.Coin;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ConversorService {
    private static final String MSG_NEGATIVE_NUM = "El monto ingresado debe ser mayor o igual a 0";
    private static final String MSG_NO_TOKEN_EXIST = "El token ingresado no existe";
    private static final String MSG_ERROR = "Error inesperado";

    private ArrayList<Coin> tokens;

    public ConversorService() {
        tokens = new ArrayList<>();
        addToken("USDT", 1.01, 2);
        addToken("BTC", 64000, 8);
        addToken("ETH", 4200, 5);
        addToken("ADA", 2.3, 3);
        addToken("BNB", 490, 4);
    }

    private void addToken(String tiker, double price, int decimals) {
        tokens.add(new Coin(tiker, price, decimals));
    }

    public double arsToCrypto(double ars, String token) {
        Coin myCoin;

        try {
            myCoin = tokens.stream().filter(x -> x.getTiker().equals(token.toUpperCase())).findFirst().get();

            if (ars < 0) {
                throw new IndexOutOfBoundsException(MSG_NEGATIVE_NUM);
            }

            return limitDecimals(ars / myCoin.getPriceUsd(), myCoin.getDecimals());
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(MSG_NO_TOKEN_EXIST);
        } catch (Exception e) {
            throw new RuntimeException(MSG_ERROR);
        }
    }

    public double usdToCrypto(double usd, String token) {
        Coin myCoin;

        try {
            myCoin = tokens.stream().filter(x -> x.getTiker().equals(token.toUpperCase())).findFirst().get();

            if (usd < 0) {
                throw new IndexOutOfBoundsException(MSG_NEGATIVE_NUM);
            }

            return limitDecimals(usd / myCoin.getPriceUsd(), myCoin.getDecimals());
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

    public double cryptoToArs(String token, double value) {
        Coin myCoin;

        try {
            myCoin = tokens.stream().filter(x -> x.getTiker().equals(token.toUpperCase())).findFirst().get();

            if (value < 0) {
                throw new IndexOutOfBoundsException(MSG_NEGATIVE_NUM);
            }

            return limitDecimals(myCoin.getPriceUsd() * value, myCoin.getDecimals());
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(MSG_NO_TOKEN_EXIST);
        } catch (Exception e) {
            throw new RuntimeException(MSG_ERROR);
        }
    }

    public double cryptoToUsd(String token, double value) {
        Coin myCoin;

        try {
            myCoin = tokens.stream().filter(x -> x.getTiker().equals(token.toUpperCase())).findFirst().get();

            if (value < 0) {
                throw new IndexOutOfBoundsException(MSG_NEGATIVE_NUM);
            }

            return limitDecimals(myCoin.getPriceArs() * value, myCoin.getDecimals());
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(MSG_NO_TOKEN_EXIST);
        } catch (Exception e) {
            throw new RuntimeException(MSG_ERROR);
        }
    }

    public double cryptoToCrypto(String token1, double value, String token2) {
        Coin coin1;
        Coin coin2;

        try {
            coin1 = tokens.stream().filter(x -> x.getTiker().equals(token1.toUpperCase())).findFirst().get();
            coin2 = tokens.stream().filter(x -> x.getTiker().equals(token2.toUpperCase())).findFirst().get();

            if (value < 0) {
                throw new IndexOutOfBoundsException(MSG_NEGATIVE_NUM);
            }

            return limitDecimals(coin1.getPriceUsd() * value / coin2.getPriceUsd(), coin2.getDecimals());
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(MSG_NO_TOKEN_EXIST);
        } catch (Exception e) {
            throw new RuntimeException(MSG_ERROR);
        }
    }

}
