package mediastore;

import java.io.IOException;
import java.util.LinkedList;
import javax.swing.ImageIcon;

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
    
    /**
     * Retrieves a Media object from a given id.
     * @param id The id to search for
     * @return The first Media instance found that has the given id, null if none found
     */
    public Media getMediaFromID( int id ) {
        for ( Media m : media ) {
            if ( id == m.getID() ) {
                return m;
            }            
        }
        return null;
    }
    
    /**
     * Retrieves a Customer object from a given id.
     * @param id The id to search for
     * @return The first Customer instance found that has the given id, null if none found
     */
    public Customer getCustomerFromID( int id ) {
        for ( Customer c : customers ) {
            if ( id == c.getID() ) {
                return c;
            }
        }
        return null;
        
    }

    
    /**
     * Computes the maximum between the given id and the current maximum.
     * @param id The id being presented
     */
    protected void checkCustomerID( int id ) {
        maxCustomerID = Math.max( id, maxCustomerID );
    }

    /**
     * Computes the maximum between the given id and the current maximum.
     * @param id The id being presented
     */
    protected void checkMediaID( int id ) {
        maxMediaID = Math.max( id, maxMediaID );
    }

    /**
     * Computes the maximum between the given id and the current maximum.
     * @param id The id being presented
     */
    protected void checkPurchaseID( int id ) {
        maxPurchaseID = Math.max( id, maxPurchaseID );
    }
    
    /**
     * Writes a Customer to the database.
     * @param customer The customer to commit to the database
     * @throws java.io.IOException 
     */
    public abstract void writeNewCustomer( Customer customer ) throws java.io.IOException ;
    
    /**
     * Appends a customer Purchase to the database entry for the given Customer.
     * @param customer
     * @param purchase
     * @throws java.io.IOException 
     */
    public abstract void writeCustomerPurchase( Customer customer, Purchase purchase ) throws java.io.IOException;
    
    /**
     * Writes a new Media item to the database, generating a new id in the process.
     * @param m The Media item to commit to the database
     * @throws java.io.IOException 
     */
    public abstract void writeNewMediaItem( Media m ) throws java.io.IOException;
    
    /**
     * Writes a new Media item to the database.
     * @param m The Media item to commit to the database
     * @param id The id of this new Media item
     * @throws java.io.IOException 
     */
    public abstract void writeNewMediaItem( Media m, int id ) throws java.io.IOException;
    
    /**
     * Overwrites an existing Media entry in the database with a modified copy of it.
     * @param m The Media item to commit to the database
     * @throws java.io.IOException 
     */
    public abstract void writeModifiedMediaItem( Media m ) throws java.io.IOException;
    
    /**
     * Removes a Media item from the database.
     * @param m The Media item to remove from the database
     * @throws java.io.IOException 
     */
    public abstract void deleteMediaItem( Media m ) throws java.io.IOException;
    
    /**
     * Preview a Media item.
     * @param m The item to preview
     * @return m is returned if the operation was successful, null otherwise
     * @throws java.io.IOException 
     */
    public abstract Media preview( Media m ) throws java.io.IOException;
    
    /**
     * View the cover art in the a JFrame
     * @param m the item to view
     * @return an image is returned to view in GUI
     * @throws java.io.IOException
     */
    public abstract ImageIcon viewCoverImage ( Media m ) throws java.io.IOException;
    public abstract String bgFileLocation ( Media m ) throws java.io.IOException;
}

