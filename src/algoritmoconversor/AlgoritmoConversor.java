package algoritmoconversor;

public class AlgoritmoConversor {

    public static void main(String[] args) {
        Controlador conversor = new Controlador();
        
        conversor.agregarToken("USDT", 190);
        conversor.agregarToken("BTC", 800000);
        conversor.agregarToken("ETH", 550000);
        conversor.agregarToken("ADA", 390);
        conversor.agregarToken("BNB", 64000);
        
        double ars = 50000;
        String token = "BNB";
        
        try {
            double valor = conversor.valorEnCripto(ars, token);
            System.out.println("Su conversion de $" + ars + " a " + token + " es de " + valor);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
        
    }

}
