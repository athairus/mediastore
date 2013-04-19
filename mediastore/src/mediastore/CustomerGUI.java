package mediastore;

/**
 * @author Milton John, Ryan Smith
 * @version 1.0 Mar 16, 2013
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.SQLException;
import mediastore.helpers.GBC;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerGUI extends JFrame implements ActionListener {

    private JLabel searchLabel;                 //label for search bar
    private JTextField searchField;             //search bar text field
    private MediaTabbedPaneGUI tabs;            //tabs object
    private JPanel searchPanel;                 //panel for search bar
    private JLabel managerLabel;                //label for displaying total sales
    private JButton purchaseHistoryButton;      //button allowing customer to view purchase history
    private JPanel bottomPanel;                 //panel for bottom of GUI
    private boolean managerMode;

    public CustomerGUI() {
        this( false, 1 );
    }

    public CustomerGUI( boolean managerMode, int id ) {

        super( "Mediastore" );

        this.managerMode = managerMode;



        addWindowListener( new CustomerGUIExitHandler( managerMode ) );

        setLayout( new BorderLayout() );                //set up layout


        searchLabel = new JLabel( "Search: " );
        searchLabel.setHorizontalAlignment( JLabel.LEADING );

        searchField = new JTextField( 10 );
        searchField.addActionListener( this );


        tabs = new MediaTabbedPaneGUI( managerMode );


        //set up search panel
        if( !managerMode ) {
            searchPanel = new JPanel();
            searchPanel.add( new JLabel( String.format( "$%.2f  |  ", MediaStoreGUI.db.getCustomerFromID( id ).getBalance() ) ) );
            searchPanel.add( searchLabel );
            searchPanel.add( searchField );
        }


        JPanel topPanel = new JPanel();                     //set up top panel
        topPanel.setLayout( new GridBagLayout() );

        topPanel.add( tabs, new GBC( 0, 1 )
                .setWeight( 1, 1 )
                .setFill( GBC.BOTH ) );
        if( !managerMode ) {
            topPanel.add( searchPanel,
                    new GBC( 0, 0 )
                    .setWeight( 0, 0 )
                    .setAnchor( GBC.NORTHEAST ) );
        }

        purchaseHistoryButton = new JButton( "View Purchase History" );
        purchaseHistoryButton.addActionListener( this );


        bottomPanel = new JPanel();                                     //set up bottom panel
        bottomPanel.setLayout( new BorderLayout() );
        bottomPanel.add( purchaseHistoryButton, BorderLayout.WEST );





        if( managerMode ) {                                //added when manager is logged in

            managerLabel = new JLabel( "Manager mode | Total sales in entire store: " + MediaStoreGUI.db.manager.getTotalNumSales() );
            bottomPanel.add( managerLabel, BorderLayout.WEST );
        }

        add( topPanel, BorderLayout.NORTH );                //add top panel to GUI
        add( bottomPanel, BorderLayout.SOUTH );             //add bottom panel to GUI

    }

    @Override
    public void actionPerformed( ActionEvent ae ) {

        if( ae.getSource() == searchField ) {
            try {
                MediaStoreGUI.searchGUI( false, searchField.getText() );
            } catch( SQLException ex ) {
                Logger.getLogger( CustomerGUI.class.getName() ).log( Level.SEVERE, null, ex );
            } catch( IOException ex ) {
                Logger.getLogger( CustomerGUI.class.getName() ).log( Level.SEVERE, null, ex );
            }
        }
        if( ae.getSource() == purchaseHistoryButton ) {
            MediaStoreGUI.customerPurchaseHistoryScreen( managerMode );
        }
    }

    private class CustomerGUIExitHandler extends WindowAdapter {

        private boolean managerMode;

        public CustomerGUIExitHandler( boolean managerMode ) {
            this.managerMode = managerMode;
        }

        @Override
        public void windowClosing( WindowEvent e ) {
            if( managerMode ) {
                MediaStoreGUI.managerScreen();
            }
        }
    }
}
