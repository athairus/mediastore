package mediastore;

/**
 * @author Milton John
 * @version 1.0 Mar 16, 2013
 */
import java.awt.*;
import javax.swing.*;
import mediastore.helpers.GBC;

public class CustomerGUI extends JFrame {

    private JLabel musicLabel;              //label for music listing
    private JLabel movieLabel;              //label for movie listing
    private JLabel audiobookLabel;          //label for audiobook listing
    private JLabel searchLabel;             //label for search bar
    private JTextField searchField;         //search bar text field
    private Font headerFont;                //font for headers
    private JList musicList;                //list of music items for sale
    private JList movieList;                //list of movie items for sale
    private JList audiobookList;            //list of audiobooks
    private JTabbedPane tabs;               //tabs object
    private JPanel musicTabPanel;           //panel for music tab
    private JPanel movieTabPanel;           //panel for movie tab
    private JPanel audiobookTabPanel;      //panel for audiobook tab

    public CustomerGUI() {

        super( "Mediastore" );

        setLayout( new BorderLayout() );                //set up layout

        headerFont = new Font( "Sans", Font.PLAIN, 36 );

        musicLabel = new JLabel( "Music" );
        musicLabel.setHorizontalAlignment( JLabel.CENTER );
        musicLabel.setFont( headerFont );


        movieLabel = new JLabel( "Movies" );
        movieLabel.setHorizontalAlignment( JLabel.CENTER );
        movieLabel.setFont( headerFont );


        audiobookLabel = new JLabel( "Audiobooks" );
        audiobookLabel.setHorizontalAlignment( JLabel.CENTER );
        audiobookLabel.setFont( headerFont );

        searchLabel = new JLabel( "Search: " );
        searchLabel.setHorizontalAlignment( JLabel.LEADING );
        searchLabel.setFont( new Font( "Sans", Font.ITALIC, 12 ) );

        searchField = new JTextField( 10 );

        tabs = new JTabbedPane();

        musicTabPanel = new JPanel();
        musicTabPanel.setLayout( new BorderLayout() );

        movieTabPanel = new JPanel();
        movieTabPanel.setLayout( new BorderLayout() );

        audiobookTabPanel = new JPanel();
        audiobookTabPanel.setLayout( new BorderLayout() );

        tabs.addTab( "<html><body><table width='150'>Music</table></body></html>", musicTabPanel );
        tabs.addTab( "<html><body><table width='150'>Movies</table></body></html>", movieTabPanel );
        tabs.addTab( "<html><body><table width='150'>Audiobooks</table></body></html>", audiobookTabPanel );




        JPanel searchPanel = new JPanel();              //set up search panel
        searchPanel.add( searchLabel );
        searchPanel.add( searchField );
        searchPanel.setBorder( BorderFactory.createLineBorder( Color.BLACK ) );



        JPanel topPanel = new JPanel();                 //set up top panel
        topPanel.setLayout( new GridBagLayout() );

        topPanel.add( tabs, new GBC( 0, 1 )
                .setWeight( 1, 1 )
                .setFill( GBC.BOTH ) );

        topPanel.add( searchPanel,
                new GBC( 0, 0 )
                .setWeight( 0, 0 )
                .setAnchor( GBC.NORTHEAST ) );



        add( topPanel, BorderLayout.NORTH );                //add panels to GUI

    }
}
