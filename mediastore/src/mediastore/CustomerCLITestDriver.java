package mediastore;

import java.io.File;
import java.util.LinkedList;

/**
 * Name: Milton John
 * Section: 1
 * Program: Customer Test Driver
 * Date: Feb 6, 2013
 */
/**
 * A class that tests the functionality of the Customer class via a text-based
 * interface.
 *
 * @author Milton John, Ryan Smith and Cole Arnold
 */
public class CustomerCLITestDriver {

    @SuppressWarnings( "CallToThreadDumpStack" )
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
            db.manager.add( new Movie( 1, "asdf", "title", 300, "genre", 5, 3234, 20, 50, 2013), 1 );
            db.getCustomerFromID( 1 ).listCLI();
            db.getCustomerFromID( 1 ).displayInfoCLI( 1 );
            
           
            db.getCustomerFromID( 1 ).buy( 1 );
            System.out.print("Customer purchased: " + db.getCustomerFromID( 1 ).getPurchaseHistory() );
            

        } catch ( Exception e ) {
            System.out.println( "An exception occured testing customer functionality. (" + e.toString() + ")" );
            e.printStackTrace(); // this is what the @SupressWarnings is for
        }
    }
}
