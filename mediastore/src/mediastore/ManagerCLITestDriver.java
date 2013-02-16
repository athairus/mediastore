package mediastore;

import java.io.File;
import java.util.LinkedList;

/**
 * Name: Milton John
 * Section: 1
 * Program: Manager CLI Test Driver
 * Date: Feb 7, 2013
 */
/**
 * A class that tests the functionality of the Manager class via a text-based
 * interface.
 *
 * @author Milton John, Ryan Smith and Cole Arnold
 * @version 1.0 Feb 7, 2013
 *
 */
public class ManagerCLITestDriver {

    public static void main( String[] args ) {
        TextDatabase db = null;
        try {
            db = new TextDatabase( System.getProperty( "user.dir" ).concat( File.separator + ".." + File.separator + ".." + File.separator + "db" + File.separator ) );
        } catch ( Exception e ) {
            System.out.println( "An exception occured while parsing the database. (" + e.toString() + ")" );
            e.printStackTrace(); // this is what the @SupressWarnings is for
        }

        try {
            if ( db.customers.isEmpty() ) {
                db.writeNewCustomer( new Customer( 1, "test", "123 Fake St.", 200, new LinkedList(), db ) );
            }
            db.manager.add( new Movie( 10, "Jack Black", "Tenacious D isn't dead I swear", 104, "Documentary", 5, 300, 49.99, 200000, 2013 ), 10 );
            db.getCustomerFromID( 1 ).listCLI();
            System.out.println( "Movie id #10 has sold " + db.manager.getNumSales( 10 ) + " copies" );
            System.out.println( "Total sales in entire store: " + db.manager.getTotalNumSales() );
            System.out.println( "Customer #1: " + db.manager.getCustomerInfo( 1 ) );
            Thread.sleep( 1000L ); // some time so you can see that the item is actually present in the db
            db.manager.remove( 10 );


        } catch ( Exception e ) {
            System.out.println( "An exception occured testing the Manager class. (" + e.toString() + ")" );
            e.printStackTrace();
        }


    }
}
