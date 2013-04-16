
package mediastore;

import java.io.IOException;
import java.net.URL;
import javax.swing.ImageIcon;
import java.sql.*;  

/**
A class that interacts with a SQL-based database.
 *
 * @author Milton John, Ryan Smith and Cole Arnold
 * @version 1.0 April 14, 2013
 */
public class SQLDatabase extends Database {

   Connection myConnection; 

    public SQLDatabase() throws SQLException {
        this.myConnection = DriverManager.getConnection( "jdbc:derby://localhost:1527/MediaStore", "media" , "asdf" );
    }
    

    @Override
    public void writeNewCustomer(Customer customer) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writeModifiedCustomer(Customer customer) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writeCustomerPurchase(Customer customer, Purchase purchase) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writeNewMediaItem(Media m) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writeNewMediaItem(Media m, int id) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writeModifiedMediaItem(Media m) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteMediaItem(Media m) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Media preview(Media m) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ImageIcon viewCoverImage(Media m) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String bgFileLocation(Media m) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
