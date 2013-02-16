package mediastore;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
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
        purchaseHistory = new LinkedList();
        db = null;

    }

    public Customer( int id, String name, String address, double credits, LinkedList purchaseHistory, Database db ) {
        this();
        this.id = id;
        this.name = name;
        this.address = address;
        this.credits = credits;
        this.db = db;
        this.purchaseHistory = purchaseHistory;
    }

    public int buy( int id ) throws java.io.IOException {
        Media object = db.getMediaFromID( id );
        double price = object.getPrice();
        if ( credits < price ) {
            // not enough money
            return -1;
        }
        credits -= price;

        Purchase purchase = new Purchase( 0, price, System.currentTimeMillis() );
        db.writeCustomerPurchase( this, purchase );
        purchaseHistory.add( purchase );

        object.numSold++;

        recalculateRanking();

        return purchase.getID();
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

    public void listCLI() {
        System.out.println( "Movies: " );
        for ( Media m : db.media ) {
            if ( m instanceof Movie ) {
                System.out.println( "\t" + m.id + "." + m.title );
            }
        }
        System.out.println( "Music: " );
        for ( Media m : db.media ) {
            if ( m instanceof Album ) {
                System.out.println( "\t" + m.id + "." + m.title );
            }
        }
        System.out.println( "Audiobooks: " );
        for ( Media m : db.media ) {
            if ( m instanceof Audiobook ) {
                System.out.println( "\t" + m.id + "." + m.title );
            }
        }
    }

    public void displayInfoCLI( int id ) throws java.io.IOException {
        int maxWidth = 100;
        int padding = 0;
        String padString = "";
        Media m = db.getMediaFromID( id );
        System.out.println( ( (TextDatabase) db ).generateCoverASCII( m, maxWidth, (int) ( maxWidth * ( 7.0 / 15.0 ) ) ) );
        String info = "";
        info += m.getTitle() + " | ";
        info += m.getAuthor() + " | ";
        info += m.getGenre() + " | ";
        info += ( m.getDuration() / 60 ) + " min. | ";
        for ( int i = 0; i < (int) m.getRating(); i++ ) {
            info += '*';
        }
        for ( int i = (int) m.getRating(); i < 5; i++ ) {
            info += ' ';
        }
        info += "(" + m.totalReviews + ") | ";
        recalculateRanking();
        info += "#" + m.getRanking() + " in ";
        if ( m instanceof Movie ) {
            info += "Movies | ";
        }
        if ( m instanceof Album ) {
            info += "Albums | ";
        }
        if ( m instanceof Audiobook ) {
            info += "Audiobooks | ";
        }
        info += '$' + String.format( "%.2f", m.getPrice() );
        padding = maxWidth - info.length();
        if ( padding > 0 ) {
            for ( int i = 0; i < padding / 2; i++ ) {
                padString += ' ';
            }
            info = padString + info;
        }

        System.out.println( info );
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

        String customerInfo = name + '\n' + address + '\n' + credits + '\n';
        for ( Purchase p : purchaseHistory ) {
            customerInfo += p.toTextDB() + '\n';
        }
        return customerInfo;
    }

    //also iterate through linked list and append each at end of string
    public String toString() {

        String s = "Customer ID: " + id + '\n' + "Name: " + name + '\n' + "Address: " + address + '\n' + "Credit Balance: " + credits + '\n';
        for ( Purchase p : purchaseHistory ) {
            s += p.toString() + '\n';
        }
        return s;
    }

    public void rate( int id, int rating ) throws java.io.IOException {
        // clamp rating from 1 to 5
        if ( rating < 1 ) {
            rating = 1;
        }
        if ( rating > 5 ) {
            rating = 5;
        }
        Media m = db.getMediaFromID( id );
        m.rating = ( ( ( m.rating * (double) m.totalReviews ) + (double) rating ) / ( (double) m.totalReviews + 1.0 ) );
        m.totalReviews++;
        db.writeModifiedMediaItem( m );
    }

    private void recalculateRanking() throws java.io.IOException {
        class RankingComparator implements Comparator<Media> {

            @Override
            public int compare( Media m1, Media m2 ) {

                if ( m1.getNumSold() < m2.getNumSold() ) {
                    return 1;
                }
                if ( m1.getNumSold() == m2.getNumSold() ) {
                    return 0;
                }
                if ( m1.getNumSold() > m2.getNumSold() ) {
                    return -1;
                }
                return 0;
            }
        }

        // segregate database into 3 different lists
        LinkedList<Media> movies = new LinkedList();
        LinkedList<Media> albums = new LinkedList();
        LinkedList<Media> audiobooks = new LinkedList();
        for ( Media m : db.media ) {
            if ( m instanceof Movie ) {
                movies.add( m );
            }
            if ( m instanceof Album ) {
                albums.add( m );
            }
            if ( m instanceof Audiobook ) {
                audiobooks.add( m );
            }
        }

        // sort these lists
        Collections.sort( movies, new RankingComparator() );
        Collections.sort( albums, new RankingComparator() );
        Collections.sort( audiobooks, new RankingComparator() );

        int i = 1;
        for ( Media m : movies ) {
            m.setRanking( i++ );
            db.writeModifiedMediaItem( m );
        }

        i = 1;
        for ( Media m : albums ) {
            m.setRanking( i++ );
            db.writeModifiedMediaItem( m );
        }

        i = 1;
        for ( Media m : audiobooks ) {
            m.setRanking( i++ );
            db.writeModifiedMediaItem( m );
        }
    }

    public void preview( int id ) throws IOException {
        Media m = db.getMediaFromID( id );
        Media result = db.preview( m );
        if( result == null ){
            System.out.println( "ERROR: Preview/trailer missing or OS not supported!" );
        }
    }
}
