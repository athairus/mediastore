package mediastore;

import mediastore.helpers.GBC;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * @author Milton John, Cole Arnold, Ryan Smith
 * @version 1.0 Mar 16, 2013
 *
 */
public class ManagerPasswordGUI extends JFrame implements ActionListener {

    private JPasswordField passwordField;
    private JLabel enterPasswordLabel;
    private JButton backButton;

    public ManagerPasswordGUI() {
        super( "Mediastore" );

        setLayout( new GridLayout( 3, 0 ) );

        passwordField = new JPasswordField();
        passwordField.addActionListener( this );

        backButton = new JButton( "Back");
        backButton.addActionListener( this );

        enterPasswordLabel = new JLabel( "Please enter the Manager password: " );
        enterPasswordLabel.setHorizontalAlignment( JLabel.CENTER );

        JPanel promptPanel = new JPanel();
        promptPanel.setLayout( new GridBagLayout() );
        promptPanel.add( enterPasswordLabel,
                new GBC( 0, 0 )
                .setWeight( 1, 1 )
                .setAnchor( GBC.PAGE_START ) );

        promptPanel.add( passwordField,
                new GBC( 0, 0 )
                .setWeight( 1, 1 )
                .setAnchor( GBC.CENTER )
                .setIpad( 120, 0 ) );

        JPanel backPanel = new JPanel();
        backPanel.setLayout( new GridBagLayout() );
        backPanel.add( backButton,
                new GBC( 0, 0 )
                .setWeight( 1, 1 )
                .setAnchor( GBC.LAST_LINE_END )
                .setInsets( 5, 5, 5, 5 )
                .setIpad( 10, 10 ) );

        add( new JPanel() );
        add( promptPanel );
        add( backPanel );



    }

    @Override
    public void actionPerformed( ActionEvent e ) {
        if ( e.getSource() == passwordField ) {
            // check password
            // if ok, move on to manager interface
        }
        if ( e.getSource() == backButton ) {
            MediaStoreGUI.welcomeScreen();
        }
    }
}
