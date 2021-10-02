package algoritmoconversor;

public class AlgoritmoConversor {

    public static void main(String[] args) {
        Controlador conversor = new Controlador();

        double ars = 100000;
        String token = "ada";

        try {
            double valor = conversor.valorEnCripto(ars, token);
            System.out.println("Su conversion de $" + ars + " a " + token.toUpperCase() + " es de " + valor);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
