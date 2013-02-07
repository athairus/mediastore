package mediastore;

import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;

/**
 * A class that interacts with a text-based database.
 *
 * @author Milton John
 * @version 1.0 Feb 7, 2013
 *
 */
public class TextDatabase extends Database {

    String rootDir;

    /**
     * Parses database from a given root directory.
     *
     * @param rootDir Location in the filesystem of the database
     */
    public TextDatabase( String rootDir ) { // TODO: throws some kinda exception
        this.rootDir = rootDir;

        // check that the root dir exists and is freely writable

        File customerFolder = new File( rootDir.concat( "customers" ) );

        if ( customerFolder == null ) {
            System.out.println( "customerFolder = null" );
        }

        // check for customer folder
        // if not, create one

        int customerCount = 0;
        customerCount = customerFolder.listFiles().length; // determine the number of Customers

        File[] filesInCustomerFolder = customerFolder.listFiles();
        // parse customer folder, get number of customers

        // initalize customer list
        customers = new LinkedList();

        for ( File f : filesInCustomerFolder ) {

            // parse the text file
            String id = "";
            String name = "";
            String address = "";
            double credit = 0;

            id = f.getName().substring( 0, f.getName().lastIndexOf( '.' ) );
            try {
                Scanner scanner = new Scanner( f );
                name = scanner.nextLine();
                address = scanner.nextLine();
                credit = scanner.nextDouble();
            } catch ( java.io.FileNotFoundException e ) {

                System.exit( -1 );

            } catch ( java.util.InputMismatchException e ) {

                System.out.println( "Error parsing customer information, unable to parse database. (java.util.InputMismatchException)" );
                System.exit( -1 );

            } catch ( java.util.NoSuchElementException e ) {

                System.out.println( "Error parsing customer information, unable to parse database. (java.util.NoSuchElementException)" );
                System.exit( -1 );

            }

            // parse purchase history
            LinkedList purchaseHistory = new LinkedList();

            customers.add( new Customer( id, name, address, credit, purchaseHistory, this ) );

        }

    }

    public void writeCustomerPurchase( String id, Purchase purchase ) {
        // search for filename in customer folder with given id
        // append the purchase to the customer file
        return;
    }

    public void writeMediaItem( Media m ) {
        return;
    }
}
