package algoritmoconversor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Controlador {

    private ArrayList<Coin> tokens;

    public Controlador() {
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
        Coin myCoin = tokens.stream().filter(x -> x.getTiker().equals(token.toUpperCase())).findFirst().get();
        
        if (ars < 0) {
            throw new IndexOutOfBoundsException("El monto ingresado debe ser mayor o igual a 0");
        }

        return limitDecimals(ars / myCoin.getPrice(), myCoin.getDecimals());
    }
    
    public double limitDecimals(double number, int decimals) {
        BigDecimal bd = new BigDecimal(number).setScale(decimals, RoundingMode.HALF_UP);
        
        return bd.doubleValue();
    }

}