package mediastore;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.border.EmptyBorder;
import mediastore.helpers.GBC;

public class CustomerListGUI extends JFrame implements ActionListener {

    JPanel mainPanel;
    final int PADDING = 16;
    ArrayList<String> customerArrayList;
    JList customerList;
    JButton okButton;
    JButton cancelButton;

    public CustomerListGUI() {
        customerArrayList = new ArrayList<String>();
        for ( Customer c : MediaStoreGUI.db.customers ) {
            customerArrayList.add( c.getName() );
        }
        addWindowListener( new CustomerListGUIExitHandler() );

        mainPanel = new JPanel();
        mainPanel.setBorder( new EmptyBorder( PADDING, PADDING, PADDING, PADDING ) );
        mainPanel.setLayout( new BorderLayout() );

        mainPanel.add( new JLabel( "Choose a customer to log in as:" ), BorderLayout.NORTH );
        customerList = new JList( customerArrayList.toArray() );
        mainPanel.add( customerList, BorderLayout.CENTER );

        okButton = new JButton( "OK" );
        cancelButton = new JButton( "Cancel" );

        okButton.addActionListener( this );
        cancelButton.addActionListener( this );

        JPanel buttonPanel = new JPanel();
        buttonPanel.add( okButton );
        buttonPanel.add( cancelButton );

        add( buttonPanel, BorderLayout.SOUTH );

        add( mainPanel );
    }

    @Override
    public void actionPerformed( ActionEvent e ) {

        if ( e.getSource() == cancelButton ) {
            MediaStoreGUI.welcomeScreen();
        }

        if ( e.getSource() == okButton ) {
            MediaStoreGUI.loggedInCustomer = (Customer) MediaStoreGUI.db.customers.toArray()[customerList.getSelectedIndex()];
            MediaStoreGUI.customerScreen();
        }
    }

    private class CustomerListGUIExitHandler extends WindowAdapter {

        @Override
        public void windowClosing( WindowEvent e ) {
            MediaStoreGUI.welcomeScreen();
        }
    }
}
