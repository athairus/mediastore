package mediastore;

import java.io.IOException;
import java.net.URL;
import javax.swing.ImageIcon;
import java.sql.*;

/**
 * A class that interacts with a SQL-based database.
 *
 * @author Milton John, Ryan Smith and Cole Arnold
 * @version 1.0 April 14, 2013
 */
public class SQLDatabase extends Database {

    Connection connection;

    public SQLDatabase( String url, String username, String password ) throws SQLException {
        Connection myConnection = DriverManager.getConnection( url, username, password );
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
