package mediastore;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ManagerGUI extends JFrame implements ActionListener {

    private JLabel managerOptionsLabel;
    private JButton listContentButton;
    private JButton addContentButton;
    private JButton removeContentButton;
    private JButton viewCustomerButton;
    private JPanel mainPanel;
    final int PADDING = 16;

    public ManagerGUI() {
        /*
         * A manager should be able to:
         * list content
         * add content
         * remove content
         * view any customer's history
         */
        mainPanel = new JPanel();
        mainPanel.setLayout( new GridLayout( 5, 0, 10, 10 ) );


        mainPanel.setBorder( new EmptyBorder( new Insets( PADDING, PADDING, PADDING, PADDING ) ) );

        managerOptionsLabel = new JLabel( "Manager options:" );
        managerOptionsLabel.setHorizontalAlignment( JLabel.CENTER );
        mainPanel.add( managerOptionsLabel );

        listContentButton = new JButton( "List all items" );
        addContentButton = new JButton( "Add an item" );
        removeContentButton = new JButton( "Remove an item" );
        viewCustomerButton = new JButton( "View Customer history" );

        listContentButton.addActionListener( this );
        addContentButton.addActionListener( this );
        removeContentButton.addActionListener( this );
        viewCustomerButton.addActionListener( this );

        mainPanel.add( listContentButton );
        mainPanel.add( addContentButton );
        mainPanel.add( removeContentButton );
        mainPanel.add( viewCustomerButton );

        add( mainPanel );

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
