package mediastore;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Encapsulates a single customer.
 *
 * @author Milton John, Ryan Smith and Cole Arnold
 */
public class Customer {

    private int id;
    private String name;
    private String address;
    private double credits;
    private LinkedList<Purchase> purchaseHistory;
    private Database db; // the Database this instance is a member of

    public Customer() {
        // TODO: Unsure of default values check for validity.
        credits = 0;
        name = "";
        address = "";
        id = 0; // Not sure how long each Id should be. Correct later to correct length
        purchaseHistory = null;
        db = null;

    }

    public Customer( int id, String name, String address, double credits, LinkedList purchaseHistory, Database db ) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.credits = credits;
        this.db = db;
        this.purchaseHistory = purchaseHistory;
    }

    public void buy( int id ) {
        Media object = db.getMediaFromID( id );
        double price = object.getPrice();
        if ( credits < price ) {
            // not enough money
            return;
        }
        credits -= price;

        Purchase purchase = new Purchase( id, price, System.currentTimeMillis() );
        db.writeCustomerPurchase( this, purchase );
        purchaseHistory.add( purchase );

        class RankingComparator implements Comparator<Media> {

            @Override
            public int compare( Media m1, Media m2 ) {

                if ( m1.getNumSold() < m2.getNumSold() ) {
                    return -1;
                }
                if ( m1.getNumSold() == m2.getNumSold() ) {
                    return 0;
                }
                if ( m1.getNumSold() > m2.getNumSold() ) {
                    return 1;
                }
                return 0;
            }
        }
        Collections.sort( db.media, new RankingComparator() );
        // recalculate ranking
        int i = 1;
        for ( Media m : db.media ) {
            m.setRanking( i++ );
        }
        i = 0;
    }

    public Media search( String query ) {
        Media media = null;
        for ( Media m : db.media ) {
            if ( m.title.equals( query ) ) {
                media = m;
            }
        }
        return media;
    }
    
    public void listText (){
        for ( Media m : db.media) {
            System.out.println( m.id + "." + m.title);
        }
    }
    
    public String getName() {
        return name;
    }

    public int getID() {
        return id;
    }

    public void setDB( Database db ) {
        this.db = db;
    }

    public String toTextDB() {
        return name + '\n' + address + '\n' + credits + '\n' + purchaseHistory;
    }

    //also iterate through linked list and append each at end of string
    public String toString() {
        return "Customer ID: " + id + '\n' + "Name: " + name + '\n' + "Address: " + address + '\n' + "Credit Balance: " + credits + '\n';
    }
}
