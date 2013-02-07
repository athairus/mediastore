package mediastore;

import java.util.LinkedList;

/**
 * A class that represents a generic database.
 *
 * @author Milton John
 * @version 1.0 Feb 7, 2013
 *
 */
public abstract class Database {

    LinkedList<Customer> customers;
    LinkedList<Media> media;

    public Media getFromID( String id ) {
        for ( Media m : media ) {
            if ( id.equals( m.getID() ) ) {
                return m;
            } else {
                return null;
            }
        }
        return null;
    }
    
    public abstract void writeCustomerPurchase( String id, Purchase purchase );
    
    public abstract void writeMediaItem( Media m );
    
}
