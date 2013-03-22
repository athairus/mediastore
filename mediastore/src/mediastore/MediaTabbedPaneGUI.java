package mediastore;

/**
 * A class that implements the tab interface of the mediastore
 *
 * @author Ryan Smith, Milton John
 * @version 1.0 Mar 21, 2013
 *
 */
import javax.swing.*;
import java.awt.*;
import java.util.Vector;
import javax.swing.table.TableRowSorter;

public class MediaTabbedPaneGUI extends JTabbedPane {

    private JPanel musicTabPanel;              //panel for music tab
    private JPanel movieTabPanel;              //panel for movie tab
    private JPanel audiobookTabPanel;          //panel for audiobook tab
    private JLabel musicLabel;                 //label for music tab panel
    private JLabel movieLabel;                 //label for movie tab panel
    private JLabel audiobookLabel;             //label for audiobook tab panel
    private Font headerFont;                   //font for header labels
    private JScrollPane musicScrollPane;       //scroll pane for music table
    private JScrollPane movieScrollPane;       //scroll pane for movie table
    private JScrollPane audiobookScrollPane;   //scroll pane for audiobook table
    private JTable musicTable;                 //table of music items for sale
    private JTable movieTable;                 //table of movie items for sale
    private JTable audiobookTable;             //table of audiobooks
    private Vector<Vector> musicVector;        //vector of music
    private Vector<Vector> movieVector;        //vector of movies
    private Vector<Vector> audiobookVector;    //vector of audiobooks
    private int tabSize = getHeight();

    public MediaTabbedPaneGUI() {

        setPreferredSize( new Dimension( 350, 350) );


        headerFont = new Font( "Sans", Font.PLAIN, 36 );

        musicTabPanel = new JPanel();
        musicTabPanel.setLayout( new BorderLayout() );

        movieTabPanel = new JPanel();
        movieTabPanel.setLayout( new BorderLayout() );

        audiobookTabPanel = new JPanel();
        audiobookTabPanel.setLayout( new BorderLayout() );

        addTab( "<html><body><table width='150'>Music</table></body></html>", musicTabPanel );
        addTab( "<html><body><table width='150'>Movies</table></body></html>", movieTabPanel );
        addTab( "<html><body><table width='150'>Audiobooks</table></body></html>", audiobookTabPanel );


        musicLabel = new JLabel( "Music" );                               //set up music label
        musicLabel.setHorizontalAlignment( JLabel.CENTER );
        musicLabel.setFont( headerFont );

        movieLabel = new JLabel( "Movies" );                              //set up movie label
        movieLabel.setHorizontalAlignment( JLabel.CENTER );
        movieLabel.setFont( headerFont );

        audiobookLabel = new JLabel( "Audiobooks" );                      //set up audiobook label
        audiobookLabel.setHorizontalAlignment( JLabel.CENTER );
        audiobookLabel.setFont( headerFont );


        musicTabPanel.add( musicLabel, BorderLayout.NORTH );              //add labels to tab panels
        movieTabPanel.add( movieLabel, BorderLayout.NORTH );
        audiobookTabPanel.add( audiobookLabel, BorderLayout.NORTH );

        Vector<String> musicColumns = new Vector<String>();
        musicColumns.addElement( "Artist" );
        musicColumns.addElement( "Title" );
        musicColumns.addElement( "Duration (Min)" );
        musicColumns.addElement( "Genre" );
        musicColumns.addElement( "Rating" );
        musicColumns.addElement( "No. Reviews" );
        musicColumns.addElement( "Price" );
        musicColumns.addElement( "No. Sold" );

        Vector<String> movieColumns = new Vector<String>();
        movieColumns.addElement( "Title" );
        movieColumns.addElement( "Director" );
        movieColumns.addElement( "Duration (Min)" );
        movieColumns.addElement( "Genre" );
        movieColumns.addElement( "Rating" );
        movieColumns.addElement( "Reviews" );
        movieColumns.addElement( "Price" );
        movieColumns.addElement( "No. Sold" );
        movieColumns.addElement( "Release Year" );


        Vector<String> audiobookColumns = new Vector<String>();
        audiobookColumns = new Vector<String>();
        audiobookColumns.addElement( "Title" );
        audiobookColumns.addElement( "Author" );
        audiobookColumns.addElement( "Duration (Min)" );
        audiobookColumns.addElement( "Genre" );
        audiobookColumns.addElement( "Rating" );
        audiobookColumns.addElement( "Reviews" );
        audiobookColumns.addElement( "Price" );
        audiobookColumns.addElement( "No. Sold" );


        musicVector = new Vector<Vector>();
        movieVector = new Vector<Vector>();
        audiobookVector = new Vector<Vector>();
        for ( Media m : MediaStoreGUI.db.media ) {

            if ( m instanceof Album ) {

                Vector<String> tempVector = new Vector<String>();

                tempVector.addElement( m.author );
                tempVector.addElement( m.title );
                tempVector.addElement( Integer.toString( m.duration ) );
                tempVector.addElement( m.genre );
                tempVector.addElement( Double.toString( m.rating ) );
                tempVector.addElement( Integer.toString( m.totalReviews ) );
                tempVector.addElement( Double.toString( m.price ) );
                tempVector.addElement( Integer.toString( m.numSold ) );

                musicVector.addElement( tempVector );

            }
            if ( m instanceof Movie ) {

                Vector<String> tempVector = new Vector<String>();


                tempVector.addElement( m.title );
                tempVector.addElement( m.author );
                tempVector.addElement( Integer.toString( m.duration ) );
                tempVector.addElement( m.genre );
                tempVector.addElement( Double.toString( m.rating ) );
                tempVector.addElement( Integer.toString( m.totalReviews ) );
                tempVector.addElement( Double.toString( m.price ) );
                tempVector.addElement( Integer.toString( m.numSold ) );
                tempVector.addElement( Integer.toString( m.getReleaseYear() ) );

                movieVector.addElement( tempVector );
            }
            if ( m instanceof Audiobook ) {

                Vector<String> tempVector = new Vector<String>();


                tempVector.addElement( m.title );
                tempVector.addElement( m.author );
                tempVector.addElement( Integer.toString( m.duration ) );
                tempVector.addElement( m.genre );
                tempVector.addElement( Double.toString( m.rating ) );
                tempVector.addElement( Integer.toString( m.totalReviews ) );
                tempVector.addElement( Double.toString( m.price ) );
                tempVector.addElement( Integer.toString( m.numSold ) );

                audiobookVector.addElement( tempVector );
            }
        }


        musicTable = new JTable( musicVector, musicColumns ) {
            public boolean isCellEditable( int data, int columns ) {
                return false;
            }
        };
        musicTable.setPreferredScrollableViewportSize( new Dimension( 350, 100 ) );
        musicTable.setFillsViewportHeight( true );
        musicTable.setAutoCreateRowSorter( true );
        musicTable.getTableHeader().setReorderingAllowed( false );
        musicTable.setShowGrid( false );
        musicTable.setIntercellSpacing( new Dimension( 0, 0 ) );

        musicScrollPane = new JScrollPane( musicTable );

        musicTabPanel.add( musicScrollPane, BorderLayout.CENTER );

        movieTable = new JTable( movieVector, movieColumns ) {
            public boolean isCellEditable( int data, int columns ) {
                return false;
            }
        };
        movieTable.setPreferredScrollableViewportSize( new Dimension( 350, 100 ) );
        movieTable.setFillsViewportHeight( true );
        movieTable.setAutoCreateRowSorter( true );
        movieTable.getTableHeader().setReorderingAllowed( false );
        movieTable.setShowGrid( false );
        movieTable.setIntercellSpacing( new Dimension( 0, 0 ) );

        movieScrollPane = new JScrollPane( movieTable );

        movieTabPanel.add( movieScrollPane, BorderLayout.CENTER );

        audiobookTable = new JTable( audiobookVector, audiobookColumns ) {
            public boolean isCellEditable( int data, int columns ) {
                return false;
            }
        };
        audiobookTable.setPreferredScrollableViewportSize( new Dimension( 350, 100 ) );
        audiobookTable.setFillsViewportHeight( true );
        audiobookTable.setAutoCreateRowSorter( true );
        audiobookTable.getTableHeader().setReorderingAllowed( false );
        audiobookTable.setShowGrid( false );
        audiobookTable.setIntercellSpacing( new Dimension( 0, 0 ) );


        audiobookScrollPane = new JScrollPane( audiobookTable );

        audiobookTabPanel.add( audiobookScrollPane, BorderLayout.CENTER );

    }
}
