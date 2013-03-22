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
    private JPanel managerPanel;                //panel that displays only in manager mode
    private JLabel managerLabel;                //label for displaying total sales
    private JButton purchaseHistoryButton;      //button allowing customer to view purchase history

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

        purchaseHistoryButton = new JButton( "View Purchase History" );
        add( purchaseHistoryButton, BorderLayout.SOUTH );

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


        add( topPanel, BorderLayout.NORTH );                //add top panel to GUI

        if ( managerMode ) {                                //added when manager is logged in

            managerPanel = new JPanel();
            managerLabel = new JLabel( "Total sales in entire store: " + MediaStoreGUI.db.manager.getTotalNumSales() );
            managerPanel.add( managerLabel );
            add( managerPanel, BorderLayout.SOUTH );
        }


    }

    @Override
    public void actionPerformed( ActionEvent ae ) {

        if ( ae.getSource() == searchField ) {
            JOptionPane.showMessageDialog( this, "Search functionality is not implemented yet.", "", JOptionPane.ERROR_MESSAGE );
        }
        if ( ae.getSource() == purchaseHistoryButton ) {
        }
    }
}
