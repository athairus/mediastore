package mediastore;

import java.util.Calendar;

/**
 * A class that encapsulates a single purchase made by a Customer.
 *
 * @author Milton John, Ryan Smith and Cole Arnold
 * @version 1.0 Feb 7, 2013
 *
 */
public class Purchase {

    private int id; // id of the product purchased.
    private double price;
    private long purchaseUnixTime;

    //Default Constructor
    Purchase() {
        id = 0;
        price = 0.00;
        purchaseUnixTime = 0;
    }

    /**
     * Initializer Constructor
     * 
     * @param id
     * @param price
     * @param date 
     */
    Purchase( int id, double price, long date ) {
        this.id = id;
        this.price = price;
        this.purchaseUnixTime = date;
    }

    /**
     * returns the id of the purchase
     * @return id
     */
    public int getID() {
        return id;
    }

    /**
     * Sets the id of the purchase to the id in the parameter
     * @param id 
     */
    public void setID( int id ) {
        this.id = id;
    }

    /**
     * returns the price of the purchase 
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * returns the time the purchase was made 
     * @return purchaseUnixTime
     */
    public long getPurchaseUnixTime() {
        return purchaseUnixTime;
    }

    /**
     * returns all the information of purchase order
     * @return toTextDB
     */
    public String toTextDB() {
        return "" + id + '\n' + price + '\n' + purchaseUnixTime + '\n';
    }

    /**
     * returns the toString that lists all data members of the purchase
     * @return toString
     */
    public String toString() {
        Calendar myDate = Calendar.getInstance();
        myDate.setTimeInMillis( purchaseUnixTime );
        return "Item ID: " + id + " Item Price: " + price + " Date: " + myDate.get( Calendar.MONTH ) + "." + myDate.get( Calendar.DAY_OF_MONTH ) + "." + myDate.get( Calendar.YEAR );
    }
}
