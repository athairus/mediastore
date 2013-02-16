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
    
    public Media getMediaFromID( int id ) {
        for ( Media m : media ) {
            if ( id == m.getID() ) {
                return m;
            }            
        }
        return null;
    }
    
    public Customer getCustomerFromID( int id ) {
        for ( Customer c : customers ) {
            if ( id == c.getID() ) {
                return c;
            }
        }
        return null;
        
    }

    // checks the given id, if it is larger than the maxID, set maxID to it
    protected void checkCustomerID( int id ) {
        maxCustomerID = Math.max( id, maxCustomerID );
    }

    protected void checkMediaID( int id ) {
        maxMediaID = Math.max( id, maxMediaID );
    }

    protected void checkPurchaseID( int id ) {
        maxPurchaseID = Math.max( id, maxPurchaseID );
    }
    
    public abstract void writeCustomerPurchase( Customer customer, Purchase purchase ) throws java.io.IOException;
    
    public abstract void writeNewMediaItem( Media m ) throws java.io.IOException;
    
    public abstract void writeModifiedMediaItem( Media m ) throws java.io.IOException;
    
    public abstract void deleteMediaItem( Media m ) throws java.io.IOException;
    
    public abstract Media preview( Media m ) throws java.io.IOException;
}
