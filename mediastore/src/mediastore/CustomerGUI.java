package mediastore;

/**
 * @author Milton John
 * @version 1.0 Mar 16, 2013
 */
import java.awt.*;
import javax.swing.*;
import mediastore.helpers.GBC;
import java.util.LinkedList;

public class CustomerGUI extends JFrame {

    private JLabel musicLabel;              //label for music listing
    private JLabel movieLabel;              //label for movie listing
    private JLabel audiobookLabel;          //label for audiobook listing
    private JLabel searchLabel;             //label for search bar
    private JTextField searchField;         //search bar text field
    private Font headerFont;                //font for headers
    private JTable musicTable;              //table of music items for sale
    private JTable movieList;               //table of movie items for sale
    private JTable audiobookList;           //table of audiobooks
    private JTabbedPane tabs;               //tabs object
    private JPanel musicTabPanel;           //panel for music tab
    private JPanel movieTabPanel;           //panel for movie tab
    private JPanel audiobookTabPanel;       //panel for audiobook tab
    private LinkedList<Media> music;        //list for music
    private LinkedList<Media> movies;       //list for movies
    private LinkedList<Media> audiobooks;   //list for audiobooks

    public CustomerGUI() {
        this( false, 1 );
    }

    public CustomerGUI( boolean managerMode, int id ) {

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

        searchField = new JTextField( 10 );




        tabs = new JTabbedPane();

        musicTabPanel = new JPanel();                       //set up music tab panel
        musicTabPanel.setLayout( new BorderLayout() );




        movieTabPanel = new JPanel();                       //set up movie tab panel
        movieTabPanel.setLayout( new BorderLayout() );




        audiobookTabPanel = new JPanel();                   //set up audiobook tab panel
        audiobookTabPanel.setLayout( new BorderLayout() );

        tabs.addTab( "<html><body><table width='150'>Music</table></body></html>", musicTabPanel );
        tabs.addTab( "<html><body><table width='150'>Movies</table></body></html>", movieTabPanel );
        tabs.addTab( "<html><body><table width='150'>Audiobooks</table></body></html>", audiobookTabPanel );


        Object[] musicColumns = { "Title", "Artist", "Duration", "Genre", "Ranking" };
        for ( Media m : MediaStoreGUI.db.media ) {
            if ( m instanceof Album ) {
                //music.add( m );
            }
        }


        //musicTable = new JTable( music., musicColumns );





                                                           //set up search panel
        JPanel searchPanel = new JPanel();
        searchPanel.add( new JLabel( String.format( "$%.2f  |  ", MediaStoreGUI.db.getCustomerFromID( id ).getBalance() ) ) );
        searchPanel.add( searchLabel );
        searchPanel.add( searchField );


        JPanel topPanel = new JPanel();                     //set up top panel
        topPanel.setLayout( new GridBagLayout() );

        topPanel.add( tabs, new GBC( 0, 1 )
                .setWeight( 1, 1 )
                .setFill( GBC.BOTH ) );

        topPanel.add( searchPanel,
                new GBC( 0, 0 )
                .setWeight( 0, 0 )
                .setAnchor( GBC.NORTHEAST ) );


        add( topPanel, BorderLayout.NORTH );                //add top panel to GUI

        if ( managerMode ) {
            //TODO: add panel to south with total sales and sales
        }


    }
}
