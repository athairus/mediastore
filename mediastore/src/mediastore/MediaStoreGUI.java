package mediastore;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.api.skin.GraphiteAquaSkin;

@SuppressWarnings( "CallToThreadDumpStack" )
/**
 * A class that serves as an entry point for the Mediastore's GUI.
 *
 * @author Milton John
 * @version 1.0 Mar 20, 2013
 *
 */
// note: you need to fix the build.xml file if you want to rename this class
public class MediaStoreGUI {

    private static final int defaultWidth = 800;                      //width of JFrame
    private static final int defaultHeight = 480;                     //height of JFrame
    private static JFrame frame;
    public static SQLDatabase db;
    public static Customer loggedInCustomer;

    public static void main( String[] args ) {

        // initialize the DB
        db = null;
        try {
            Class.forName( "org.apache.derby.jdbc.ClientDriver" ).newInstance();
            
            
            db = new SQLDatabase( "jdbc:derby://localhost:1527/MediaStore", "root", "toor" );

            if ( db.getCustomerFromID( 1 ) == null ) {
                System.out.println( "WARNING: Missing customer #1, creating a default customer in this slot..." );
                db.writeNewCustomer( new Customer( 1, "Default", "Default", 100, new LinkedList(), db ) );
            }
        } catch ( Exception e ) {
            System.out.println( "An exception occured while parsing the database. (" + e.toString() + ")" );
            e.printStackTrace(); // this is what the @SupressWarnings is for
            System.exit( -1 );
        }
        loggedInCustomer = db.getCustomerFromID( 1 );

        // initalize the substance theme and the welcome screen
        SwingUtilities.invokeLater( new Runnable() {
            @Override
            public void run() { // Substance (the look and feel theme this program uses) refuses to run unless the frame is created in this manner
                GraphiteAquaSkin skin;
                try {
                    skin = new GraphiteAquaSkin();
                    SubstanceLookAndFeel.setSkin( skin );

                } catch ( Exception e ) {
                    e.printStackTrace();
                }
                welcomeScreen();
                /*try {
                 mediaViewerScreen(db.getMediaFromID( 1 ),db.getCustomerFromID( 1 ) );
                 } catch ( IOException ex ) {
                 Logger.getLogger( MediaStoreGUI.class.getName() ).log( Level.SEVERE, null, ex );
                 }*/
            }
        } );
    }

    public static void reloadDB() {
        db = null;
        System.out.println( "Database modified. Reloading..." );
        try {
            
            db = new SQLDatabase( "jdbc:derby://localhost:1527/MediaStore", "root", "toor" );

            if ( db.getCustomerFromID( 1 ) == null ) {
                System.out.println( "WARNING: Missing customer #1, creating a default customer in this slot..." );
                db.writeNewCustomer( new Customer( 1, "Default", "Default", 100, new LinkedList(), db ) );
            }
        } catch ( Exception e ) {
            System.out.println( "An exception occured while parsing the database. (" + e.toString() + ")" );
            e.printStackTrace(); // this is what the @SupressWarnings is for
            System.exit( -1 );
        }
    }

    public static void welcomeScreen() {
        if ( frame != null ) {
            frame.dispose();
        }
        frame = new WelcomeWindowGUI();

        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frameDefaults();
    }

    public static void loginScreen() {
        if ( frame != null ) {
            frame.dispose();
        }
        //((WelcomeWindowGUI)frame).active = false;
        frame = new ManagerPasswordGUI();

        frame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        frameHalfSize();
    }

    public static void managerScreen() {
        if ( frame != null ) {
            frame.dispose();
        }
        frame = new ManagerGUI();

        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frameHalfSize();
    }

    public static void customerScreen( boolean managerMode ) {
        if ( frame != null ) {
            frame.dispose();
        }
        frame = new CustomerGUI( managerMode, loggedInCustomer.getID() );

        frame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        frameDefaults();
    }

    public static void mediaViewerScreen( Media m, Customer c, boolean managerMode ) throws IOException, SQLException {
        if ( frame != null ) {
            frame.dispose();
        }
        //          MediaViewerGUI( Media m, Customer c 
        frame = new MediaViewerGUI( m, c, managerMode );
        frame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        frameDefaults();
    }

    public static void managerAddContentScreen() {
        if ( frame != null ) {
            frame.dispose();
        }
        frame = new ManagerAddContentGUI();

        frame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        frameTall();
    }

    public static void managerRemoveContentScreen() {
        if ( frame != null ) {
            frame.dispose();
        }
        frame = new ManagerRemoveContentGUI();

        frame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        frameDefaults();
    }

    public static void customerPurchaseHistoryScreen( boolean managerMode ) {
        if ( frame != null ) {
            frame.dispose();
        }
        frame = new PurchaseHistoryGUI( managerMode );

        frame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        frameDefaults();
    }

    public static void customerListScreen() {
        if ( frame != null ) {
            frame.dispose();
        }
        frame = new CustomerListGUI( false );

        frame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        frameHalfSize();
    }

    public static void managerCustomerListScreen() {
        if ( frame != null ) {
            frame.dispose();
        }
        frame = new CustomerListGUI( true );

        frame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        frameHalfSize();
    }

    public static void managerCustomerScreen() {
        if ( frame != null ) {
            frame.dispose();
        }
        frame = new CustomerGUI( true, 0 );

        frame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        frameDefaults();
    }

    public static void customerRatingScreen( Media m ) {
        if ( frame != null ) {
            frame.dispose();
        }
        frame = new CustomerRatingGUI( m );

        frame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        frameHalfSize();
    }

    public static void frameDefaults() {
        frame.setSize( defaultWidth, defaultHeight );
        frame.setMinimumSize( new Dimension( defaultWidth, defaultHeight ) );
        //frame.pack();
        frame.setVisible( true );
        frame.setLocationRelativeTo( null );
    }

    public static void frameHalfSize() {
        frame.setSize( defaultWidth / 2, defaultHeight / 2 );
        frame.setMinimumSize( new Dimension( defaultWidth / 2, defaultHeight / 2 ) );
        frame.setResizable( false );
        //frame.pack();
        frame.setVisible( true );
        frame.setLocationRelativeTo( null );
    }

    public static void frameTall() {
        frame.setSize( defaultWidth / 2, defaultHeight );
        frame.setMinimumSize( new Dimension( defaultWidth / 2, defaultHeight ) );
        frame.setResizable( false );
        //frame.pack();
        frame.setVisible( true );
        frame.setLocationRelativeTo( null );
    }
}