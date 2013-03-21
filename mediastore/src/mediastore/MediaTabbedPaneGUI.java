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

public class MediaTabbedPaneGUI extends JTabbedPane{

    private JPanel musicTabPanel;               //panel for music tab
    private JPanel movieTabPanel;               //panel for movie tab
    private JPanel audiobookTabPanel;           //panel for audiobook tab
    private JLabel musicLabel;                  //label for music tab panel
    private JLabel movieLabel;                  //label for movie tab panel
    private JLabel audiobookLabel;              //label for audiobook tab panel
    private Font headerFont;                    //font for header labels
    private JScrollPane musicScrollPane;        //scroll pane for music table
    private JScrollPane movieScrollPane;        //scroll pane for movie table
    private JScrollPane audiobookScrollPane;    //scroll pane for audiobook table
    private JTable musicTable;                  //table of music items for sale
    private JTable movieTable;                  //table of movie items for sale
    private JTable audiobookTable;              //table of audiobooks
    
    
    
    
   public MediaTabbedPaneGUI() {
       
       setPreferredSize( new Dimension( 500, 500 ));
    
       
       headerFont = new Font( "Sans", Font.PLAIN, 36 );
       
       musicTabPanel = new JPanel();
       musicTabPanel.setLayout(new BorderLayout() );
       
       movieTabPanel = new JPanel();
       movieTabPanel.setLayout( new BorderLayout() );
       
       audiobookTabPanel = new JPanel();
       audiobookTabPanel.setLayout( new BorderLayout() );
       
        addTab( "<html><body><table width='150'>Music</table></body></html>", musicTabPanel );
        addTab( "<html><body><table width='150'>Movies</table></body></html>", movieTabPanel );
        addTab( "<html><body><table width='150'>Audiobooks</table></body></html>", audiobookTabPanel );
        
        
        musicLabel = new JLabel("Music");                               //set up music label
        musicLabel.setHorizontalAlignment( JLabel.CENTER );
        musicLabel.setFont( headerFont );
        
        movieLabel = new JLabel("Movies");                              //set up movie label
        movieLabel.setHorizontalAlignment( JLabel.CENTER );
        movieLabel.setFont( headerFont );
        
        audiobookLabel = new JLabel("Audiobooks");                      //set up audiobook label
        audiobookLabel.setHorizontalAlignment( JLabel.CENTER );
        audiobookLabel.setFont( headerFont );
        
        
        musicTabPanel.add(musicLabel, BorderLayout.NORTH);              //add labels to tab panels
        movieTabPanel.add(movieLabel, BorderLayout.NORTH);
        audiobookTabPanel.add(audiobookLabel, BorderLayout.NORTH);
        
        String[] musicColumns = { "Artist", "Title"};// "Duration", "Genre", "Rating", "Reviews", "Price", "No. Sold" };
        String[][] musicArray = {{"Lady Gaga", "Shit"}};
        
        
        String[] movieColumns = { "Title", "Director", "Duration", "Genre", "Rating", "Reviews", "Price", "No. Sold", "Release Year" };
        Media[][] movieArray;
        
        
        String[] audiobookColumns = { "Title", "Author", "Duration", "Genre", "Rating", "Reviews", "Price", "No. Sold" };
        Media[][] audiobookArray;
        
        for ( Media m : MediaStoreGUI.db.media ) {
            
            if ( m instanceof Album ) {
                //musicArray[][] = m;
            }
            if( m instanceof Movie ) {
                //movies.add( m );
            }
            if(m instanceof Audiobook ) {
                //audiobooks.add( m );
            }
        }


        musicTable = new JTable( musicArray, musicColumns );        //set up music table
        musicTable.setPreferredScrollableViewportSize( new Dimension(350, 100));
        musicTable.setFillsViewportHeight( true );

        musicScrollPane = new JScrollPane(musicTable);
        
        musicTabPanel.add(musicScrollPane, BorderLayout.CENTER);
        
        
        
        
        
   }
    
    

}
