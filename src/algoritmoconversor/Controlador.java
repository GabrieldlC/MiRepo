package algoritmoconversor;

import java.util.ArrayList;

public class Controlador {

    private ArrayList<Coin> tokens;

    public Controlador() {
        tokens = new ArrayList<>();
    }

    public void agregarToken(String tiker, double precio) {
        tokens.add(new Coin(tiker, precio));
    }

    public double valorEnCripto(double ars, String token) {
        Coin usado = buscarToken(token);

        if (usado == null) {
            throw new IllegalArgumentException("El token buscado no existe");
        }
        if (ars < 0) {
            throw new IndexOutOfBoundsException("El monto ingresado debe ser mayor o igual a 0");
        }

        return ars / usado.getPrecio();
    }

    private Coin buscarToken(String token) {
        Coin buscado = null;

        int i = 0;

        while (buscado == null && i < tokens.size()) {
            if (token.equals(tokens.get(i).getTiker())) {
                buscado = tokens.get(i);
            }

            i++;
        }

        return buscado;
    }
}
