package mediastore;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ManagerAddContentGUI extends JFrame implements ItemListener {

    JPanel mainPanel;
    JPanel topPanel;
    JPanel moviePanel;
    JPanel albumPanel;
    JPanel audiobookPanel;
    String MOVIE = "Movie";
    String ALBUM = "Music Album";
    String AUDIOBOOK = "Audiobook";
    String[] mediaTypeChoices = { MOVIE, ALBUM, AUDIOBOOK };
    //
    JLabel mediaTypeLabel;
    JComboBox mediaTypeComboBox;
    //
    JLabel movieDirectorLabel;
    JTextField movieDirectorTextField;
    JLabel movieTitleLabel;
    JTextField movieTitleTextField;
    JLabel movieDurationLabel;
    JTextField movieDurationTextField;
    JLabel movieRatingLabel;
    JTextField movieRatingTextField;
    JLabel movieTotalReviewsLabel;
    JTextField movieTotalReviewsTextField;
    JLabel moviePriceLabel;
    JTextField moviePriceTextField;
    JLabel movieReleaseYearLabel;
    JTextField movieReleaseYearTextField;
    //
    JLabel albumAuthorLabel;
    JTextField albumAuthorTextField;
    JLabel albumTitleLabel;
    JTextField albumTitleTextField;
    JLabel albumDurationLabel;
    JTextField albumDurationTextField;
    JLabel albumRatingLabel;
    JTextField albumRatingTextField;
    JLabel albumTotalReviewsLabel;
    JTextField albumTotalReviewsTextField;
    JLabel albumPriceLabel;
    JTextField albumPriceTextField;
    //
    JLabel audiobookAuthorLabel;
    JTextField audiobookAuthorTextField;
    JLabel audiobookTitleLabel;
    JTextField audiobookTitleTextField;
    JLabel audiobookDurationLabel;
    JTextField audiobookDurationTextField;
    JLabel audiobookRatingLabel;
    JTextField audiobookRatingTextField;
    JLabel audiobookTotalReviewsLabel;
    JTextField audiobookTotalReviewsTextField;
    JLabel audiobookPriceLabel;
    JTextField audiobookPriceTextField;
    //
    JButton okButton;
    JButton cancelButton;

    public ManagerAddContentGUI() {
        addWindowListener( new ManagerAddContentGUIExitHandler() );
        //mainPanel = new JPanel();
        //movieMode();

        setLayout( new BorderLayout() );
        mainPanel = new JPanel();
        mainPanel.setLayout( new CardLayout() );

        topPanel = new JPanel();
        mediaTypeLabel = new JLabel( "Media type: " );
        topPanel.add( mediaTypeLabel );

        mediaTypeComboBox = new JComboBox( mediaTypeChoices );
        mediaTypeComboBox.setSelectedIndex( 0 );
        mediaTypeComboBox.addItemListener( this );
        topPanel.add( mediaTypeComboBox );

        add( topPanel, BorderLayout.NORTH );

        //<editor-fold defaultstate="collapsed" desc="set up the movie GUI">
        moviePanel = new JPanel();
        moviePanel.setLayout( new GridLayout( 9, 1, 10, 10 ) );

        movieDirectorLabel = new JLabel( "Director: " );
        movieDirectorTextField = new JTextField( 15 );
        movieTitleLabel = new JLabel( "Title: " );
        movieTitleTextField = new JTextField( 15 );

        //</editor-fold>

        mainPanel.add( moviePanel, MOVIE );
        mainPanel.add( new JPanel(), ALBUM );
        mainPanel.add( new JPanel(), AUDIOBOOK );

        add( mainPanel, BorderLayout.SOUTH );


    }

    @Override
    public void itemStateChanged( ItemEvent e ) {
        if ( e.getSource() == mediaTypeComboBox ) {
            CardLayout cl = (CardLayout) ( mainPanel.getLayout() );
            cl.show( mainPanel, (String) e.getItem() );
        }
    }

    private class ManagerAddContentGUIExitHandler extends WindowAdapter {

        @Override
        public void windowClosing( WindowEvent e ) {
            MediaStoreGUI.managerScreen();
        }
    }
}
