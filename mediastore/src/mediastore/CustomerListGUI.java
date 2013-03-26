package mediastore;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.border.EmptyBorder;
import mediastore.helpers.GBC;

public class CustomerListGUI extends JFrame implements ActionListener, MouseListener {

    JPanel mainPanel;
    final int PADDING = 16;
    ArrayList<String> customerArrayList;
    JList customerList;
    JButton okButton;
    JButton cancelButton;
    boolean managerMode;

    public CustomerListGUI( boolean managerMode ) {
        this.managerMode = managerMode;
        customerArrayList = new ArrayList<String>();
        for ( Customer c : MediaStoreGUI.db.customers ) {
            customerArrayList.add( c.getName() );
        }
        addWindowListener( new CustomerListGUIExitHandler( managerMode ) );

        mainPanel = new JPanel();
        mainPanel.setBorder( new EmptyBorder( PADDING, PADDING, PADDING, PADDING ) );
        mainPanel.setLayout( new BorderLayout() );

        String message = "Choose a customer to log in as:";
        if ( managerMode ) {
            message = "Choose a customer to view:";
        }
        mainPanel.add( new JLabel( message ), BorderLayout.NORTH );
        customerList = new JList( customerArrayList.toArray() );
        customerList.addMouseListener(  this );
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
            if ( !managerMode ) {
                MediaStoreGUI.welcomeScreen();
            } else {
                MediaStoreGUI.managerScreen();
            }
        }

        if ( e.getSource() == okButton ) {
            if ( customerList.getSelectedIndex() == -1 ) {
                JOptionPane.showMessageDialog( null, "Please choose a customer.", "", JOptionPane.ERROR_MESSAGE );
                return;
            }
            MediaStoreGUI.loggedInCustomer = (Customer) MediaStoreGUI.db.customers.toArray()[customerList.getSelectedIndex()];
            if ( !managerMode ) {
                MediaStoreGUI.customerScreen( managerMode );
            } else {
                MediaStoreGUI.customerPurchaseHistoryScreen( true );
            }
        }
    }

    @Override
    public void mouseClicked( MouseEvent me ) {
    }

    @Override
    public void mousePressed( MouseEvent me ) {
        if ( me.getClickCount() > 1 ) {

            if ( customerList.getSelectedIndex() == -1 ) {
                JOptionPane.showMessageDialog( null, "Please choose a customer.", "", JOptionPane.ERROR_MESSAGE );
                return;
            }
            MediaStoreGUI.loggedInCustomer = (Customer) MediaStoreGUI.db.customers.toArray()[customerList.getSelectedIndex()];
            if ( !managerMode ) {
                MediaStoreGUI.customerScreen( managerMode );
            } else {
                MediaStoreGUI.customerPurchaseHistoryScreen( true );
            }
        }


    }

    @Override
    public void mouseReleased( MouseEvent me ) {
    }

    @Override
    public void mouseEntered( MouseEvent me ) {
    }

    @Override
    public void mouseExited( MouseEvent me ) {
    }

    private class CustomerListGUIExitHandler extends WindowAdapter {

        boolean managerMode;

        public CustomerListGUIExitHandler( boolean managerMode ) {
            this.managerMode = managerMode;
        }

        @Override
        public void windowClosing( WindowEvent e ) {
            if ( !managerMode ) {
                MediaStoreGUI.welcomeScreen();
            } else {
                MediaStoreGUI.managerScreen();
            }
        }
    }
}
