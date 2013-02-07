package mediastore;

/**
 * A class that encapsulates a single purchase made by a Customer.
 *
 * @author Milton John and Ryan Smith
 * @version 1.0 Feb 7, 2013
 *
 */
public class Purchase {

    private String id; // id of the product purchased.
    private double price;
    private long date;

    Purchase() {
        id = "";
        price = 0.00;
        date = 0;
    }

    Purchase( String id, double price, long date ) {
        this.id = id;
        this.price = price;
        this.date = date;
    }

    public String getID() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public long getDate() {
        return date;
    }
    
    public String toString(){
        return "Item ID: " + id + "\nItem Price: " + price + "\nDate: " + System.currentTimeMillis();
    }
}
