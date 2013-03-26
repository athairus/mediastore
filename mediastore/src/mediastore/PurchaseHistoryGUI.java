package mediastore;

/**
 * A class that implements the GUI of a customer's
 * purchase history
 *
 * @author Ryan Smith
 * @version 1.0 Mar 21, 2013
 *
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Calendar;
import mediastore.helpers.GBC;
import java.util.LinkedList;
import java.util.Vector;

public class PurchaseHistoryGUI extends JFrame implements ActionListener {

    private JLabel headerLabel;
    private Font headerFont;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JButton backButton;
    private JButton rateButton;
    private JTable purchaseTable;
    private Vector<Vector> purchaseHistoryVector;
    private boolean managerMode;
    private JScrollPane purchaseScrollPane;
    private MouseAdapter tableMouseAdapter;

    public PurchaseHistoryGUI( boolean managerMode ) {
        this.managerMode = managerMode;

        setLayout( new BorderLayout() );
        setVisible( true );
        addWindowListener( new PurchaseHistoryGUIExitHandler( managerMode ) );

        headerFont = new Font( "Sans", Font.PLAIN, 20 );
        headerLabel = new JLabel( "Customer Purchase History" );
        headerLabel.setFont( headerFont );

        backButton = new JButton( "Back" );
        backButton.addActionListener( this );
        rateButton = new JButton( "Rate Item" );
        rateButton.addActionListener( this );


        topPanel = new JPanel();
        topPanel.add( headerLabel );

        bottomPanel = new JPanel();
        if ( !managerMode ) {
            bottomPanel.add( rateButton );
        }
        bottomPanel.add( backButton );

        Vector<String> purchaseHistoryColumns = new Vector<String>();
        purchaseHistoryColumns.addElement( "Date" );
        purchaseHistoryColumns.addElement( "Title" );
        purchaseHistoryColumns.addElement( "Author/Director" );
        purchaseHistoryColumns.addElement( "Price" );
        purchaseHistoryColumns.addElement( "ID" );

        purchaseHistoryVector = new Vector<Vector>();

        for ( Purchase p : MediaStoreGUI.loggedInCustomer.getPurchaseHistory() ) {

            Calendar myDate = Calendar.getInstance();
            myDate.setTimeInMillis( p.purchaseUnixTime );
            String date = "" + myDate.get( Calendar.MONTH ) + "." + myDate.get( Calendar.DAY_OF_MONTH ) + "." + myDate.get( Calendar.YEAR );
            Vector<String> tempVector = new Vector<String>();
            tempVector.addElement( date );
            tempVector.addElement( MediaStoreGUI.db.getMediaFromID( p.getID() ).title );
            tempVector.addElement( MediaStoreGUI.db.getMediaFromID( p.getID() ).author );
            tempVector.addElement( String.format( "$%.2f", MediaStoreGUI.db.getMediaFromID( p.getID() ).price ) );
            tempVector.addElement( Integer.toString( p.getID() ) );

            purchaseHistoryVector.add( tempVector );
        }

        purchaseTable = new JTable( purchaseHistoryVector, purchaseHistoryColumns ) {
            public boolean isCellEditable( int data, int columns ) {
                return false;
            }
        };
        purchaseTable.setPreferredScrollableViewportSize( new Dimension( 350, 100 ) );
        purchaseTable.setFillsViewportHeight( true );
        purchaseTable.setAutoCreateRowSorter( true );
        purchaseTable.getTableHeader().setReorderingAllowed( false );
        purchaseTable.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        purchaseTable.addMouseListener( tableMouseAdapter );
        purchaseTable.setShowGrid( false );
        purchaseTable.setIntercellSpacing( new Dimension( 0, 0 ) );

        purchaseScrollPane = new JScrollPane( purchaseTable );





        add( topPanel, BorderLayout.NORTH );
        add( purchaseScrollPane, BorderLayout.CENTER );
        add( bottomPanel, BorderLayout.SOUTH );

    }

    @Override
    public void actionPerformed( ActionEvent ae ) {
        if ( ae.getSource() == backButton ) {
            if ( managerMode ) {
                MediaStoreGUI.managerCustomerListScreen();
            } else {
                MediaStoreGUI.customerScreen( managerMode );
            }
        }
        if ( ae.getSource() == rateButton ) {
            MediaStoreGUI.customerRatingScreen( MediaStoreGUI.db.getMediaFromID( Integer.parseInt( (String) purchaseTable.getValueAt( purchaseTable.getSelectedRow(), 4 ) ) ) );
        }
    }

    private class PurchaseHistoryGUIExitHandler extends WindowAdapter {

        private boolean managerMode;

        public PurchaseHistoryGUIExitHandler( boolean managerMode ) {
            this.managerMode = managerMode;
        }

        @Override
        public void windowClosing( WindowEvent e ) {
            if ( managerMode ) {
                MediaStoreGUI.managerCustomerListScreen();
            } else {
                MediaStoreGUI.customerScreen( managerMode );
            }
        }
    }
}
