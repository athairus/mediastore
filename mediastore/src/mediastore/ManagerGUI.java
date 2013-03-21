package mediastore;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ManagerGUI extends JFrame implements ActionListener {

    private JLabel managerOptionsLabel;
    private JButton listContentButton;
    private JButton addContentButton;
    private JButton removeContentButton;
    private JButton viewCustomerButton;

    public ManagerGUI() {
        /*
         * A manager should be able to:
         * list content
         * add content
         * remove content
         * view any customer's history
         */
        setLayout( new GridLayout( 5, 0, 10, 10 ) );

        managerOptionsLabel = new JLabel( "Manager options:" );
        managerOptionsLabel.setHorizontalAlignment( JLabel.CENTER );
        add( managerOptionsLabel );

        listContentButton = new JButton( "List all items" );
        addContentButton = new JButton( "Add an item" );
        removeContentButton = new JButton( "Remove an item" );
        viewCustomerButton = new JButton( "View Customer history" );

        listContentButton.addActionListener( this );
        addContentButton.addActionListener( this );
        removeContentButton.addActionListener( this );
        viewCustomerButton.addActionListener( this );

        add( listContentButton );
        add( addContentButton );
        add( removeContentButton );
        add( viewCustomerButton );

    }

    @Override
    public void actionPerformed( ActionEvent e ) {
        if ( e.getSource() == listContentButton ) {
        }
        if ( e.getSource() == addContentButton ) {
            MediaStoreGUI.managerAddContentScreen();
        }
        if ( e.getSource() == removeContentButton ) {
        }
        if ( e.getSource() == viewCustomerButton ) {
        }
    }
}
