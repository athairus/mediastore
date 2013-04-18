package mediastore;

import java.io.IOException;
import java.net.URL;
import javax.swing.ImageIcon;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A class that interacts with a SQL-based database.
 *
 * @author Milton John, Ryan Smith and Cole Arnold
 * @version 1.0 April 14, 2013
 */
public class SQLDatabase extends Database {

    Connection dbConn;
    Statement stmt;
    ResultSet results;
    final String driver = "org.apache.derby.jdbc.EmbeddedDriver";

    public SQLDatabase( String url, String username, String password ) throws SQLException {
        try {
            Class.forName( driver ).newInstance();
        } catch ( Exception ex ) {
            Logger.getLogger( SQLDatabase.class.getName() ).log( Level.SEVERE, null, ex );
        }
        String protocol = "jdbc:derby:";
        String dbName = "MediaStore";   // the default database name
        dbConn = DriverManager.getConnection( protocol + dbName + ";create=true" );
        stmt = dbConn.createStatement();

        DatabaseMetaData dbMeta = dbConn.getMetaData();
        String[] tableTypes = { "customer", "purchase", "customer_purchase", "manager", "media" };
        results = dbMeta.getTables( null, null, "%", tableTypes );

        if ( !results.next() ) {
            System.out.println( "Database not found. Attemping to create empty database..." );
        }
    }

    @Override
    public void writeNewCustomer( Customer customer ) throws IOException, SQLException {
    }

    @Override
    public void writeModifiedCustomer( Customer customer ) throws IOException, SQLException {
    }

    @Override
    public void writeCustomerPurchase( Customer customer, Purchase purchase ) throws IOException, SQLException {
    }

    @Override
    public void writeNewMediaItem( Media m ) throws IOException, SQLException {
    }

    @Override
    public void writeNewMediaItem( Media m, int id ) throws IOException, SQLException {
    }

    @Override
    public void writeModifiedMediaItem( Media m ) throws IOException, SQLException {
    }

    @Override
    public void deleteMediaItem( Media m ) throws IOException, SQLException {
    }

    // don't bother implementing these
    @Override
    public Media preview( Media m ) throws IOException, SQLException {
        return null;
    }

    @Override
    public ImageIcon viewCoverImage( Media m ) throws IOException, SQLException {
        return null;
    }

    @Override
    public String bgFileLocation( Media m ) throws IOException, SQLException {
        return null;
    }
}
