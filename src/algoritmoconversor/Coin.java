package algoritmoconversor;

public class Coin {
    
    private String tiker;
    private double price;
    private int decimals;

    public Coin(String tiker, double precio, int decimals) {
        this.tiker = tiker;
        this.price = precio;
        this.decimals = decimals;
    }

    public String getTiker() {
        return tiker;
    }

    public double getPrice() {
        return price;
    }

    public int getDecimals() {
        return this.decimals;
    }
}
