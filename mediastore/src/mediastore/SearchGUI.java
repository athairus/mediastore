package mediastore;

/**
 * Name: Milton John
 * Section: 1
 * Program: Lab
 * Date: Apr 18, 2013
 */
/**
 * A class that displays the results of a search
 *
 * @author Milton John, Cole Arnold, Ryan Smith
 * @version 1.0 Apr 18, 2013
 *
 */
import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;


public class SearchGUI extends JFrame implements MouseListener {

    private JTable searchList;
    private JPanel tabelPanel;                 //panel for search bar
    private boolean managerMode;
    private Statement stmt;
    private ResultSet results;
    private static final String[] COLS = {"author", "price"};
    private Object[][] data = new Object[20][20];
    private int row = 0;
    
    
    
    public SearchGUI() throws SQLException, IOException {
        this( false, "" );
    }

    public SearchGUI(boolean managerMode, String query ) throws SQLException, IOException {

        super( "MediaStore" );
        
        this.managerMode = managerMode;
        
        addWindowListener( new SearchGUIExitHandler( managerMode ) );
        
        setLayout( new BorderLayout() );                //set up layout
        
        searchList = new JTable(data, COLS);

        results = MediaStoreGUI.db.searchItem( query );

        while(results.next()) {
            searchList.setValueAt(results.getString("author"), row, 0);
            searchList.setValueAt(results.getString("price"), row, 1);
            row++;
        }
        
        tabelPanel.add( searchList.getTableHeader(), BorderLayout.NORTH );
        tabelPanel.add( searchList, BorderLayout.CENTER );
        add( tabelPanel, BorderLayout.CENTER );
        validate();
        
        tabelPanel.addMouseListener( this );
        add(tabelPanel);

    }

    @Override
    public void mousePressed( MouseEvent e ) {
        if ( e.getClickCount() > 1 ) {
            Point p = e.getPoint();
            JTable target = (JTable) e.getSource();
            int mouseRow = target.rowAtPoint( new Point( e.getX(), e.getY() ) );
            if ( mouseRow == -1 ) {
                return;
            }
            int col = 2;

            Object valueAt = target.getValueAt( mouseRow, col );
            Media media = MediaStoreGUI.db.getMediaFromID( Integer.parseInt( (String) target.getValueAt( mouseRow, col ) ) );

            try {
                MediaStoreGUI.mediaViewerScreen( media, MediaStoreGUI.loggedInCustomer, managerMode );
            } catch ( IOException ex ) {
                Logger.getLogger( MediaTabbedPaneGUI.class.getName() ).log( Level.SEVERE, null, ex );
            } catch ( SQLException ex ) {
                Logger.getLogger( MediaTabbedPaneGUI.class.getName() ).log( Level.SEVERE, null, ex );
            }
        }
    }

    @Override
    public void mouseClicked( MouseEvent e ) {
        throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased( MouseEvent e ) {
        throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered( MouseEvent e ) {
        throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited( MouseEvent e ) {
        throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }



    private class SearchGUIExitHandler extends WindowAdapter {

        private boolean managerMode;
        
        public SearchGUIExitHandler( boolean managerMode ) {
            this.managerMode = managerMode;
        }
        
        @Override
        public void windowClosing( WindowEvent e ) {
            MediaStoreGUI.customerScreen( rootPaneCheckingEnabled );
            
        }
    }
}
