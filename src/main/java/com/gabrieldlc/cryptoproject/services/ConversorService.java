package com.gabrieldlc.cryptoproject.services;

import com.gabrieldlc.cryptoproject.dto.Coin;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ConversorService {

    private ArrayList<Coin> tokens;

    public ConversorService() {
        tokens = new ArrayList<>();
        agregarToken("USDT", 190, 2);
        agregarToken("BTC", 8000000, 8);
        agregarToken("ETH", 550000, 5);
        agregarToken("ADA", 390, 3);
        agregarToken("BNB", 64000, 4);
    }

    private void agregarToken(String tiker, double price, int decimals) {
        tokens.add(new Coin(tiker, price, decimals));
    }

    public double valorEnCripto(double ars, String token) {
        Coin myCoin;

        try {
            myCoin = tokens.stream().filter(x -> x.getTiker().equals(token.toUpperCase())).findFirst().get();

            if (ars < 0) {
                throw new IndexOutOfBoundsException("El monto ingresado debe ser mayor o igual a 0");
            }

            return limitDecimals(ars / myCoin.getPrice(), myCoin.getDecimals());
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("El token ingresado no existe");
        } catch (Exception e) {
            throw new RuntimeException("Error inesperado");
        }

    }

    public double limitDecimals(double number, int decimals) {
        BigDecimal bd = new BigDecimal(number).setScale(decimals, RoundingMode.HALF_UP);

        return bd.doubleValue();
    }

}
