package mediastore;

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

        // check for customer folder
        // if not, create one
        int customerCount = 0;
        // parse customer folder, get number of customers

        // initalize customer list
        customers = new Customer[ customerCount ];

        int iterator = 0;
        /*
         for( file f : filesInCustomerFolder ) {
            
         // parse the text file
         * String ID;
         String name;
         String address;
         // Purchase History
         int credit;
         int startingSize = 50; // starting size of Media arrays
         Album[] albumsOwned;
         AudioBooks[] audioBooksOwned;
         Movie[] moviesOwned;

         customer[iterator] = new Customer(...);
          
         iterator++;
         }
         */
    }

    
}
