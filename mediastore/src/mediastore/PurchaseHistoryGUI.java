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
import mediastore.helpers.GBC;
import java.util.LinkedList;
import java.util.Vector;

public class PurchaseHistoryGUI extends JFrame implements ActionListener {

    private JLabel headerLabel;
    private Font headerFont;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JButton backButton;
    private JTable purchaseTable;
    private Vector<Vector> purchaseVector;

    public PurchaseHistoryGUI() {

        setLayout( new BorderLayout() );
        setVisible( true );


        headerFont = new Font( "Sans", Font.PLAIN, 36 );
        headerLabel = new JLabel( "Customer Purchase History" );
        headerLabel.setFont( headerFont );

        backButton = new JButton( "Back" );
        backButton.addActionListener( this );

        topPanel = new JPanel();
        topPanel.add( headerLabel );

        bottomPanel = new JPanel();
        bottomPanel.add( backButton );


        //for( Media m :)


        add( topPanel, BorderLayout.NORTH );
        add( bottomPanel, BorderLayout.SOUTH);

    }

    @Override
    public void actionPerformed( ActionEvent ae ) {
        if ( ae.getSource() == backButton ) {
            MediaStoreGUI.customerScreen();
        }
    }
}
