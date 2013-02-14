package mediastore;

import java.io.File;

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
        System.exit( 0 );
        
        // choose a customer to act as
        if( db.customers.isEmpty() ) {
            System.out.println( "Error: Customer database is empty." );
            System.exit( -1 );
        }
        for( Customer c : db.customers ) {
            // list customers
        }
        // prompt for customers

        // ask what the user wants to test
    }
}
