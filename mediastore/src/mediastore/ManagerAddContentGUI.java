package mediastore;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ManagerAddContentGUI extends JFrame implements ActionListener {

    final String[] mediaTypeChoices = { "Movie", "Music Album", "Audiobook" };
    JPanel mainPanel;
    JLabel mediaTypeLabel;
    JComboBox mediaTypeComboBox;
    JLabel mediaAuthorLabel;
    JTextField mediaAuthorTextField;
    JLabel mediaTitleLabel;
    JTextField mediaTitleTextField;
    JLabel mediaDurationLabel;
    JTextField mediaDurationTextField;
    JLabel mediaRatingLabel;
    JTextField mediaRatingTextField;
    JLabel mediaTotalReviewsLabel;
    JTextField mediaTotalReviewsTextField;
    JLabel mediaPriceLabel;
    JTextField mediaPriceTextField;
    JLabel mediaReleaseYearLabel;
    JTextField mediaReleaseYearTextField;
    JButton okButton;
    JButton cancelButton;

    public ManagerAddContentGUI() {
        addWindowListener( new ManagerAddContentGUIExitHandler() );
        mainPanel = new JPanel();
        movieMode();
    }

    private void movieMode() {
        baseSetup();
        titlePrompt( "Director:" );
        add( mainPanel );
    }

    private void albumMode() {

        baseSetup();
        titlePrompt( "Album Artist:" );
        add( mainPanel );
    }

    private void audiobookMode() {

        baseSetup();
        titlePrompt( "Author:" );
        add( mainPanel );
    }

    // set up the layout and row 1
    private void baseSetup() {
        remove( mainPanel );
        mainPanel = new JPanel();
        mainPanel.setLayout( new GridLayout( 9, 0 ) );
        mediaTypeLabel = new JLabel( "Media type: " );
        int saved = 0;
        if ( mediaTypeComboBox != null ) {
            saved = mediaTypeComboBox.getSelectedIndex();
        }
        mediaTypeComboBox = new JComboBox( mediaTypeChoices );
        mediaTypeComboBox.removeActionListener( this );
        mediaTypeComboBox.setSelectedIndex( saved );
        mediaTypeComboBox.addActionListener( this );
        JPanel row1 = new JPanel();
        row1.add( mediaTypeLabel );
        row1.add( mediaTypeComboBox );
        mainPanel.add( row1 );
    }

    private void titlePrompt( String query ) {
        mediaAuthorLabel = new JLabel( query );
        mediaAuthorTextField = new JTextField( 15 );
        JPanel row2 = new JPanel();
        row2.add( mediaAuthorLabel );
        row2.add( mediaAuthorTextField );
        mainPanel.add( row2 );
    }

    @Override
    public void actionPerformed( ActionEvent e ) {
        if ( e.getSource() == mediaTypeComboBox ) {
            switch ( mediaTypeComboBox.getSelectedIndex() ) {
                case 0: // movie
                    movieMode();
                    break;
                case 1:
                    albumMode();
                    break;
                case 2:
                    audiobookMode();
                    break;
                default:
                    break;
            }
        }
    }

    private class ManagerAddContentGUIExitHandler extends WindowAdapter {

        @Override
        public void windowClosing( WindowEvent e ) {
            MediaStoreGUI.managerScreen();
        }
    }
}
