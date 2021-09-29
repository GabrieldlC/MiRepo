package algoritmoconversor;

public class AlgoritmoConversor {

    public static void main(String[] args) {
        double usdt = 190;
        double ada = 390;
        double btc = 8000000;
        double eth = 550000;
        double bnb = 64000;

        double result = valorEnCripto(50000, usdt);

        System.out.println(result);
    }

    private static double valorEnCripto(int ars, double cripto) {
        return ars / cripto;
    }

}
