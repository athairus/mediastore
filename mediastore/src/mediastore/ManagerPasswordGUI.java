package mediastore;

import mediastore.helpers.GBC;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

/*
 * @author Milton John, Cole Arnold, Ryan Smith
 * @version 1.0 Mar 16, 2013
 *
 */
public class ManagerPasswordGUI extends JFrame implements ActionListener {

    private JPasswordField passwordField;
    private JLabel enterPasswordLabel;
    private JButton backButton;
    private JPanel mainPanel;
    final int PADDING = 16;

    public ManagerPasswordGUI() {
        super( "Mediastore" );

        mainPanel = new JPanel();


        mainPanel.setBorder( new EmptyBorder( new Insets( PADDING, PADDING, PADDING, PADDING ) ) );
        mainPanel.setLayout( new GridLayout( 3, 0 ) );

        addWindowListener( new ManagerPasswordGUIExitHandler() );

        passwordField = new JPasswordField( 5 );
        passwordField.addActionListener( this );

        backButton = new JButton( "Back" );
        backButton.addActionListener( this );

        enterPasswordLabel = new JLabel( "Please enter the Manager password: " );
        enterPasswordLabel.setHorizontalAlignment( JLabel.CENTER );

        JPanel promptPanel = new JPanel();
        promptPanel.setLayout( new GridLayout( 2, 0 ) );
        promptPanel.add( enterPasswordLabel );

        promptPanel.add( passwordField );

        JPanel backPanel = new JPanel();
        backPanel.setLayout( new GridBagLayout() );
        backPanel.add( backButton,
                new GBC( 0, 0 )
                .setWeight( 1, 1 )
                .setAnchor( GBC.LAST_LINE_END )
                .setInsets( 5, 5, 5, 5 )
                .setIpad( 10, 10 ) );

        mainPanel.add( new JPanel() );
        mainPanel.add( promptPanel );
        mainPanel.add( backPanel );

        add( mainPanel );



    }

    @Override
    public void actionPerformed( ActionEvent e ) {
        if( e.getSource() == passwordField ) {
            // check password
            boolean result = MediaStoreGUI.db.manager.checkPassword( passwordField.getText() );
            // if ok, move on to manager interface
            if( result ) {
                MediaStoreGUI.managerScreen();
            } else {
                JOptionPane.showMessageDialog( null, "Incorrect password", "", JOptionPane.ERROR_MESSAGE );
            }
        }
        if( e.getSource() == backButton ) {
            MediaStoreGUI.welcomeScreen();
        }
    }

    private class ManagerPasswordGUIExitHandler extends WindowAdapter {

        public void windowClosing( WindowEvent e ) {
            MediaStoreGUI.welcomeScreen();
        }
    }
}