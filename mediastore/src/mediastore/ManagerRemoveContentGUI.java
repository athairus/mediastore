package mediastore;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ManagerRemoveContentGUI extends JFrame implements ItemListener, ActionListener {

    final int PADDING = 16;
    JPanel mainPanel;
    //
    JButton okButton;
    JButton cancelButton;
    JPanel buttonPanel;
    //
    Database db;
    //
    JTable table;

    public ManagerRemoveContentGUI() {
        addWindowListener( new ManagerRemoveContentGUIExitHandler() );
        mainPanel = new JPanel();
        mainPanel.setLayout( new BorderLayout() );
        mainPanel.setBorder( new EmptyBorder( new Insets( PADDING, PADDING, PADDING, PADDING ) ) );

        mainPanel.add( new JLabel( "Choose an item to remove: " ), BorderLayout.NORTH );
        Vector<Vector> items = new Vector<Vector>();
        Vector<String> columns = new Vector<String>();
        columns.addElement( "" );
        db = MediaStoreGUI.db;
        for ( Media m : db.media ) {
            Vector<Media> tmp = new Vector<Media>();
            tmp.addElement( m );
            items.addElement( tmp );
        }
        table = new JTable( items, columns );
        mainPanel.add( table, BorderLayout.CENTER );

        buttonPanel = new JPanel();

        okButton = new JButton( "OK" );
        cancelButton = new JButton( "Cancel" );

        okButton.addActionListener( this );
        cancelButton.addActionListener( this );

        buttonPanel.add( okButton );
        buttonPanel.add( cancelButton );

        mainPanel.add( buttonPanel, BorderLayout.SOUTH );

        add( mainPanel );
    }

    @Override
    public void itemStateChanged( ItemEvent e ) {
    }

    @Override
    public void actionPerformed( ActionEvent e ) {
        if ( e.getSource() == okButton ) {
            // determine selected item
            int index = table.getSelectedRow();
            if ( index == -1 ) {
                JOptionPane.showMessageDialog( null, "Please choose an item to remove first.", "", JOptionPane.ERROR_MESSAGE );
                return;
            }
            Media deadManWalking = null;
            int i = 0;
            for ( Media m : db.media ) {
                deadManWalking = m;
                if ( i == index ) {
                    break;
                }
                i++;
            }

            try {
                // remove item
                db.manager.remove( deadManWalking.getID() );
            } catch ( IOException ex ) {
                Logger.getLogger( ManagerRemoveContentGUI.class.getName() ).log( Level.SEVERE, null, ex );
            }
            MediaStoreGUI.managerScreen();
            JOptionPane.showMessageDialog( null, "Item removed successfully." );
        }

        if ( e.getSource() == cancelButton ) {
            MediaStoreGUI.managerScreen();
        }
    }

    private class ManagerRemoveContentGUIExitHandler extends WindowAdapter {

        @Override
        public void windowClosing( WindowEvent e ) {
            MediaStoreGUI.managerScreen();
        }
    }
}
