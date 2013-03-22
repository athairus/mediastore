package mediastore;

/**
 * @author Milton John, Ryan Smith
 * @version 1.0 Mar 16, 2013
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import mediastore.helpers.GBC;
import java.util.LinkedList;

public class CustomerGUI extends JFrame implements ActionListener {

    private JLabel searchLabel;                 //label for search bar
    private JTextField searchField;             //search bar text field
    private MediaTabbedPaneGUI tabs;            //tabs object
    private JPanel searchPanel;                 //panel for search bar
    private JLabel managerLabel;                //label for displaying total sales
    private JButton purchaseHistoryButton;      //button allowing customer to view purchase history
    private JPanel bottomPanel;                 //panel for bottom of GUI

    public CustomerGUI() {
        this( false, 1 );
    }

    public CustomerGUI( boolean managerMode, int id ) {

        super( "Mediastore" );

        setLayout( new BorderLayout() );                //set up layout


        searchLabel = new JLabel( "Search: " );
        searchLabel.setHorizontalAlignment( JLabel.LEADING );

        searchField = new JTextField( 10 );
        searchField.addActionListener( this );


        tabs = new MediaTabbedPaneGUI();


        //set up search panel
        searchPanel = new JPanel();
        searchPanel.add( new JLabel( String.format( "$%.2f  |  ", MediaStoreGUI.db.getCustomerFromID( id ).getBalance() ) ) );
        searchPanel.add( searchLabel );
        searchPanel.add( searchField );


        JPanel topPanel = new JPanel();                     //set up top panel
        topPanel.setLayout( new GridBagLayout() );

        topPanel.add( tabs, new GBC( 0, 1 )
                .setWeight( 1, 1 )
                .setFill( GBC.BOTH ) );

        topPanel.add( searchPanel,
                new GBC( 0, 0 )
                .setWeight( 0, 0 )
                .setAnchor( GBC.NORTHEAST ) );

        purchaseHistoryButton = new JButton( "View Purchase History" );
        purchaseHistoryButton.addActionListener( this );
        
        
        bottomPanel = new JPanel();                                     //set up bottom panel
        bottomPanel.setLayout( new BorderLayout());
        bottomPanel.add( purchaseHistoryButton, BorderLayout.WEST );
        
        
        
        
        
        if ( managerMode ) {                                //added when manager is logged in

            managerLabel = new JLabel( "Total sales in entire store: " + MediaStoreGUI.db.manager.getTotalNumSales() );
            bottomPanel.add( managerLabel, BorderLayout.WEST );
        }

        add( topPanel, BorderLayout.NORTH );                //add top panel to GUI
        add( bottomPanel, BorderLayout.SOUTH );             //add bottom panel to GUI

    }

    @Override
    public void actionPerformed( ActionEvent ae ) {

        if ( ae.getSource() == searchField ) {
            JOptionPane.showMessageDialog( this, "Search functionality is not implemented yet.", "", JOptionPane.ERROR_MESSAGE );
        }
        if ( ae.getSource() == purchaseHistoryButton ) {
            MediaStoreGUI.customerPurchaseHistoryScreen();
        }
    }
}
