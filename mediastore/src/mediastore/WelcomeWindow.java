package mediastore;

import java.awt.*;
import javax.swing.*;

/**
 * A class that implements the user interface of
 * the Mediastore welcome screen.
 *
 * @author Ryan Smith, Milton John
 * @version 1.0 Mar 19, 2013
 *
 */
public class WelcomeWindow extends JFrame {

    private JButton enterButton;                        //button to enter the store
    private JButton managerLoginButton;                 //button for Manager login
    private JLabel welcomeLabel;                       //String that displays "Welcome"

    public WelcomeWindow() {
        super( "Mediastore" );

        setLayout( new GridLayout( 3, 3 ) );

        enterButton = new JButton( "Enter the store" );

        managerLoginButton = new JButton( "Manager login" );

        welcomeLabel = new JLabel( "Welcome." );
        welcomeLabel.setHorizontalAlignment( JLabel.CENTER );
        welcomeLabel.setFont( new Font( "Sans", Font.PLAIN, 48 ) );

        JPanel enterPanel = new JPanel();
        enterPanel.setLayout( new GridBagLayout() );
        enterPanel.add( welcomeLabel,
                new GBC( 0, 0 )
                .setWeight( 1, 1 )
                .setAnchor( GBC.PAGE_START ) );
        enterPanel.add( enterButton,
                new GBC( 0, 0 )
                .setWeight( 1, 1 )
                .setAnchor( GBC.CENTER )
                .setInsets( 20, 0, 0, 0 )
                .setIpad( 10, 10 ) 
                .setFill( GBC.HORIZONTAL ));

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout( new GridBagLayout() );
        loginPanel.add( managerLoginButton,
                new GBC( 0, 2 )
                .setWeight( 1, 1 )
                .setAnchor( GBC.LAST_LINE_END )
                .setIpad( 10, 10 ) );

        add( new JPanel() );
        add( new JPanel() );
        add( new JPanel() );

        add( new JPanel() );
        add( enterPanel );
        add( new JPanel() );

        add( new JPanel() );
        add( new JPanel() );
        add( loginPanel );
    }
}