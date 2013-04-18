package mediastore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
    String sql;

    public SQLDatabase( String dbName, String username, String password ) throws IOException, SQLException {
        try {
            Class.forName( driver ).newInstance();
        } catch ( Exception ex ) {
            Logger.getLogger( SQLDatabase.class.getName() ).log( Level.SEVERE, null, ex );
        }
        String protocol = "jdbc:derby:";
        //String dbName = "MediaStore";   // the default database name
        dbConn = DriverManager.getConnection( protocol + dbName + ";create=true" );
        stmt = dbConn.createStatement();

        DatabaseMetaData dbMeta = dbConn.getMetaData();
        String[] tableTypes = { "customer", "purchase", "customer_purchase", "manager", "media" };
        results = dbMeta.getTables( null, null, "%", tableTypes );

        if ( !results.next() ) {
            System.out.println( "Database not found. Creating an empty database..." );

            InputStream is = SQLDatabase.class.getResourceAsStream( "initDB.sql" );
            InputStreamReader isr = new InputStreamReader( is );
            BufferedReader br = new BufferedReader( isr );
            StringBuilder sb = new StringBuilder();
            String line;
            line = br.readLine();
            while ( line != null ) {
                sb.append( line );
                if ( line.contains( ";" ) ) {
                    sql = sb.toString();
                    sb = new StringBuilder();
                    // executeQuery cannot process ; so remove it from sql
                    sql = sql.substring( 0, sql.indexOf( ';' ) );
                    // run sql here
                    if ( sql.toUpperCase().contains( "SELECT" ) ) {
                        // SELECT statement
                        stmt.executeQuery( sql );
                    } else {
                        // All ohter type of statements
                        stmt.execute( sql );
                    }
                }
                line = br.readLine();
            }
        }
        
        // parse customer database
        
        // parse media database
        
        // parse manager database
        
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
