package mediastore;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

/**
 * A class that interacts with a text-based database.
 *
 * @author Milton John, Ryan Smith and Cole Arnold
 * @version 1.0 Feb 7, 2013
 *
 */
public class TextDatabase extends Database {

    private String rootDir;

    /**
     * Parses a text database from a given root directory.
     *
     * @param rootDir Location in the file system of the database
     */
    public TextDatabase( String rootDir ) throws java.io.IOException, java.io.FileNotFoundException, java.util.InputMismatchException, java.util.InputMismatchException {
        this.rootDir = rootDir;

        // check that the root dir exists
        File rootDirFile = new File( rootDir );
        if ( !rootDirFile.exists() ) {
            System.out.println( "WARNING: \"" + rootDirFile.getCanonicalPath() + "\" is missing, intializing an empty master database at this location..." );
            rootDirFile.mkdir();
        }

        // <editor-fold defaultstate="collapsed" desc="parse customer database">

        // check that the customer folder exists
        File customerFolder = new File( rootDir.concat( "Customers" ) );
        if ( !customerFolder.exists() ) {
            System.out.println( "WARNING: \"" + customerFolder.getCanonicalPath() + "\" is missing, initalizing an empty customer database at this location..." );
            customerFolder.mkdir();
        }

        // get number of customers
        File[] filesInCustomerFolder = customerFolder.listFiles();
        customerCount = filesInCustomerFolder.length;


        // initalize customer list
        customers = new LinkedList();


        for ( File f : filesInCustomerFolder ) {

            // strip the '.txt' from the filename to get the customer id
            int id = Integer.parseInt( f.getName().substring( 0, f.getName().lastIndexOf( '.' ) ) );

            if ( id == 0 ) {
                throw new java.util.InputMismatchException( "Invalid customer ID 0 present." );
            }

            // parse the customer's information
            LineNumberReader in = new LineNumberReader( new FileReader( f ) );
            String name = in.readLine();
            String address = in.readLine();
            double credit = Double.parseDouble( in.readLine() );

            // parse the customer's purchase history
            LinkedList purchaseHistory = new LinkedList();
            while ( in.ready() ) {
                int purchaseID = Integer.parseInt( in.readLine() );
                double purchasePrice = Double.parseDouble( in.readLine() );
                long purchaseDate = Long.parseLong( in.readLine() );

                purchaseHistory.add( new Purchase( purchaseID, purchasePrice, purchaseDate ) );
            }

            checkID( id );
            customers.add( new Customer( id, name, address, credit, purchaseHistory, this ) );

        }
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="parse media databases">        

        // a filter that only lets directories through
        class DirectoryChecker implements FileFilter {

            public boolean accept( File f ) {
                return f.isDirectory();
            }
        }

        DirectoryChecker filter = new DirectoryChecker();

        media = new LinkedList();

        // <editor-fold defaultstate="collapsed" desc="parse movie database">
        File movieFolder = new File( rootDir.concat( "Movies" ) );
        if ( !movieFolder.exists() ) {
            System.out.println( "WARNING: \"" + movieFolder.getCanonicalPath() + "\" is missing, initalizing an empty movie database at this location..." );
            movieFolder.mkdir();
        }

        // get number of movies
        File[] filesInMovieFolder = movieFolder.listFiles( filter ); // determine the number of movies
        movieCount = filesInMovieFolder.length;



        // parse movie database
        for ( File fdir : filesInMovieFolder ) {
            // strip the '.txt' from the filename to get the id
            int id = Integer.parseInt( fdir.getName() );

            File f = null;

            // parse metadata
            f = new File( fdir.getCanonicalPath().concat( File.separator + "metadata.txt" ) );
            if ( !f.exists() ) {
                System.out.println( "Error parsing database: Movie id " + id + " is missing metadata.txt" );
                throw new java.io.FileNotFoundException();
            }
            LineNumberReader in = new LineNumberReader( new FileReader( f ) );
            String author = in.readLine();
            String title = in.readLine();
            int duration = Integer.parseInt( in.readLine() );
            String genre = in.readLine();
            int ranking = Integer.parseInt( in.readLine() );
            double price = Double.parseDouble( in.readLine() );
            int releaseYear = Integer.parseInt( in.readLine() );

            media.add( new Movie( author, title, duration, genre, price, releaseYear ) );

            // check for presence of cover, background, and trailer
            // warn if missing
            f = new File( fdir.getCanonicalPath().concat( File.separator + "cover.png" ) );
            if ( !f.exists() ) {
                System.out.println( "WARNING: Movie id " + id + " is missing cover.png" );
            }

            f = new File( fdir.getCanonicalPath().concat( File.separator + "background.png" ) );
            if ( !f.exists() ) {
                System.out.println( "WARNING: Movie id " + id + " is missing background.png" );
            }

            f = new File( fdir.getCanonicalPath().concat( File.separator + "trailer.mp4" ) );
            if ( !f.exists() ) {
                System.out.println( "WARNING: Movie id " + id + " is missing trailer.mp4" );
            }

        }




        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="parse music album database">

        // just so there's no confusion, in comments and output strings these are refered to as "music albums"
        // in code they're refered to as "album" or "albums"
        // the folder name is "Music"


        File albumFolder = new File( rootDir.concat( "Music" ) );
        if ( !albumFolder.exists() ) {
            System.out.println( "WARNING: \"" + albumFolder.getCanonicalPath() + "\" is missing, initalizing an empty music album database at this location..." );
            albumFolder.mkdir();
        }

        // get number of music albums
        File[] filesInAlbumFolder = albumFolder.listFiles( filter ); // determine the number of music albums
        albumCount = filesInAlbumFolder.length;



        // parse music albums database
        for ( File fdir : filesInAlbumFolder ) {
            // strip the '.txt' from the filename to get the id
            int id = Integer.parseInt( fdir.getName() );

            File f = null;

            // parse metadata
            f = new File( fdir.getCanonicalPath().concat( File.separator + "metadata.txt" ) );
            if ( !f.exists() ) {
                System.out.println( "Error parsing database: Album id " + id + " is missing metadata.txt" );
                throw new java.io.FileNotFoundException();
            }
            LineNumberReader in = new LineNumberReader( new FileReader( f ) );
            String author = in.readLine();
            String title = in.readLine();
            int duration = Integer.parseInt( in.readLine() );
            String genre = in.readLine();
            double price = Double.parseDouble( in.readLine() );
            int releaseYear = Integer.parseInt( in.readLine() );

            media.add( new Album( author, title, duration, genre, price, releaseYear ) );

            // check for presence of cover, background, and preview
            // warn if missing
            f = new File( fdir.getCanonicalPath().concat( File.separator + "cover.png" ) );
            if ( !f.exists() ) {
                System.out.println( "WARNING: Album id " + id + " is missing cover.png" );
            }

            f = new File( fdir.getCanonicalPath().concat( File.separator + "background.png" ) );
            if ( !f.exists() ) {
                System.out.println( "WARNING: Album id " + id + " is missing background.png" );
            }

            f = new File( fdir.getCanonicalPath().concat( File.separator + "preview.mp3" ) );
            if ( !f.exists() ) {
                System.out.println( "WARNING: Album id " + id + " is missing preview.mp3" );
            }

        }

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="parse audiobooks database">     

        // the 'b' in audiobook is always lowercase

        File audiobookFolder = new File( rootDir.concat( "Audiobooks" ) );
        if ( !audiobookFolder.exists() ) {
            System.out.println( "WARNING: \"" + audiobookFolder.getCanonicalPath() + "\" is missing, initalizing an empty audiobook database at this location..." );
            audiobookFolder.mkdir();
        }

        // get number of audiobooks
        File[] filesInAudiobookFolder = audiobookFolder.listFiles( filter ); // determine the number of audiobooks
        audiobookCount = filesInAudiobookFolder.length;



        // parse audiobooks database
        for ( File fdir : filesInAudiobookFolder ) {
            // strip the '.txt' from the filename to get the id
            int id = Integer.parseInt( fdir.getName() );

            File f = null;

            // parse metadata
            f = new File( fdir.getCanonicalPath().concat( File.separator + "metadata.txt" ) );
            if ( !f.exists() ) {
                System.out.println( "Error parsing database: Audiobook id " + id + " is missing metadata.txt" );
                throw new java.io.FileNotFoundException();
            }
            LineNumberReader in = new LineNumberReader( new FileReader( f ) );
            String author = in.readLine();
            String title = in.readLine();
            int duration = Integer.parseInt( in.readLine() );
            String genre = in.readLine();
            double price = Double.parseDouble( in.readLine() );
            int releaseYear = Integer.parseInt( in.readLine() );

            media.add( new Audiobook( author, title, duration, genre, price, releaseYear ) );

            // check for presence of cover, background, and preview
            // warn if missing
            f = new File( fdir.getCanonicalPath().concat( File.separator + "cover.png" ) );
            if ( !f.exists() ) {
                System.out.println( "WARNING: Audiobook id " + id + " is missing cover.png" );
            }

            f = new File( fdir.getCanonicalPath().concat( File.separator + "background.png" ) );
            if ( !f.exists() ) {
                System.out.println( "WARNING: Audiobook id " + id + " is missing background.png" );
            }

            f = new File( fdir.getCanonicalPath().concat( File.separator + "preview.mp3" ) );
            if ( !f.exists() ) {
                System.out.println( "WARNING: Audiobook id " + id + " is missing preview.mp3" );
            }

        }

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="parse manager configuration">

        // check that the manager config file exists
        File managerFile = new File( rootDir.concat( "Manager.txt" ) );
        if ( !managerFile.exists() ) {
            System.out.println( "WARNING: \"" + managerFile.getCanonicalPath() + "\" is missing, intializing with the default manager password \"asdf\"..." );
            FileWriter fw = new FileWriter( managerFile );
            BufferedWriter out = new BufferedWriter( new OutputStreamWriter( new FileOutputStream( managerFile ), "UTF-8" ) );
            out.write( "asdf" );
            out.close();
        }

        // parse manager config file
        LineNumberReader in = new LineNumberReader( new FileReader( managerFile ) );
        String password = in.readLine();
        manager = new Manager( password );

        // </editor-fold>

    }

    protected void checkID( int id ) {
        //maxID = Math.max( id, maxID );
    }

    public void writeCustomerPurchase( int id, Purchase purchase ) {
        // search for filename in customer folder with given id
        // append the purchase to the customer file
        return;
    }
    
    public void writeNewMediaItem( Media m ) throws java.io.IOException {
        File newFile;

        // increment media count
        mediaCount++;
        if ( m instanceof Movie ) {
            // increment movie count
            movieCount++;

            // generate a new ID
            maxMediaID++;

            // create a new .txt entry
            // fill it with data
            newFile = new File( rootDir.concat( Integer.toString( maxMediaID ) ).concat( ".txt" ) );
            FileWriter fw = new FileWriter( newFile );
            BufferedWriter out = new BufferedWriter( new OutputStreamWriter( new FileOutputStream( newFile ), "UTF-8" ) );
            out.write( ( (Movie) m ).toString() );
            out.close();

            return;
        }

        if ( m instanceof Album ) {
            return;
        }

        if ( m instanceof Audiobook ) {
            return;
        }
        return;
    }
}