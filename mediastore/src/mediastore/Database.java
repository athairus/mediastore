package mediastore;

import java.util.LinkedList;

/**
 * A class that represents a generic database.
 *
 * @author Milton John, Ryan Smith and Cole Arnold
 * @version 1.0 Feb 7, 2013
 *
 */
public abstract class Database {
    
    protected LinkedList<Customer> customers;
    protected LinkedList<Media> media;
    protected Manager manager;
    protected int customerCount;
    protected int mediaCount;
    protected int movieCount;
    protected int albumCount;
    protected int audiobookCount;
    protected int maxMediaID;
    protected int maxCustomerID;
    protected int maxPurchaseID;
    
    public Media getFromID( int id ) {
        for ( Media m : media ) {
            if ( id == m.getID() ) {
                return m;
            } else {
                return null;
            }
        }
        return null;
    }

    // checks the given id, if it is larger than the maxID, set maxID to it
    protected abstract void checkCustomerID( int id );
    
    public abstract void writeCustomerPurchase( int id, Purchase purchase );
    
    public abstract void writeNewMediaItem( Media m ) throws java.io.IOException;
    
    public abstract void writeModifiedMediaItem( Media m ) throws java.io.IOException;
}
