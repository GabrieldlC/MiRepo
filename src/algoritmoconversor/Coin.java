package algoritmoconversor;

public class Coin {
    
    private String tiker;
    private double precio;

    public Coin(String tiker, double precio) {
        this.tiker = tiker;
        this.precio = precio;
    }

    public String getTiker() {
        return tiker;
    }

    public double getPrecio() {
        return precio;
    }
}
