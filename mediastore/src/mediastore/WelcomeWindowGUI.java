package mediastore;

import mediastore.helpers.GBC;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * A class that implements the user interface of
 * the Mediastore welcome screen.
 *
 * @author Ryan Smith, Milton John
 * @version 1.0 Mar 19, 2013
 *
 */
public class WelcomeWindowGUI extends JFrame implements ActionListener {

    private JButton enterButton;                        //button to enter the store
    private JButton managerLoginButton;                 //button for Manager login
    private JLabel welcomeLabel;                       //String that displays "Welcome"
    
    public boolean active;

    public WelcomeWindowGUI() {
        super( "Mediastore" );

        addWindowListener( new WelcomeWindowGUIExitHandler() );

        active = true;

        setLayout( new GridLayout( 3, 0 ) );

        enterButton = new JButton( "Enter the store" );
        enterButton.addActionListener( this );

        managerLoginButton = new JButton( "Manager login" );
        managerLoginButton.addActionListener( this );

        welcomeLabel = new JLabel( "Welcome." );
        welcomeLabel.setHorizontalAlignment( JLabel.CENTER );
        welcomeLabel.setFont( new Font( "Sans", Font.PLAIN, 48 ) );

        JPanel enterPanel = new JPanel();
        enterPanel.setLayout( new GridBagLayout() );
        enterPanel.add( welcomeLabel,
                new GBC( 0, 0 )
                .setWeight( 1, 0 )
                .setAnchor( GBC.PAGE_START ) );

        enterPanel.add( enterButton,
                new GBC( 0, 0 )
                .setWeight( 1, 0 )
                .setAnchor( GBC.CENTER )
                .setInsets( 75, 0, 0, 0 )
                .setIpad( 10, 10 )
                .setFill( GBC.HORIZONTAL ) );

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout( new GridBagLayout() );
        loginPanel.add( managerLoginButton,
                new GBC( 0, 0 )
                .setWeight( 1, 1 )
                .setAnchor( GBC.LAST_LINE_END )
                .setInsets( 5, 5, 5, 5 )
                .setIpad( 10, 10 ) );


        add( new JPanel() );
        add( enterPanel );
        add( loginPanel );
    }

    @Override
    public void actionPerformed( ActionEvent e ) {
        if ( e.getSource() == managerLoginButton ) {
            MediaStoreGUI.loginScreen();
        }
        if ( e.getSource() == enterButton ) {
            MediaStoreGUI.customerScreen();
        }
    }

    private class WelcomeWindowGUIExitHandler extends WindowAdapter {

        public void windowClosing( WindowEvent e ) {
            // do nothing
        }
    }
}