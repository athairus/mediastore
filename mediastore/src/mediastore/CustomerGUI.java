package mediastore;


/**
 * @author Milton John
 * @version 1.0 Mar 16, 2013    
 */

import java.awt.*;
import javax.swing.*;



public class CustomerGUI extends JFrame {

    private JLabel musicLabel;              //label for music listing
    private JLabel movieLabel;              //label for movie listing
    private JLabel audiobookLabel;          //label for audiobook listing
    private JLabel searchLabel;             //label for search bar
    private JTextField searchField;         //search bar text field
    private Font headerFont;                //font for headers
    
    
    public CustomerGUI() {
        
        super( "Mediastore" );
        
        setLayout( new GridLayout( 4, 4 ) );                //set up layout
        
        headerFont = new Font( "Sans", Font.PLAIN, 36);
        
        musicLabel = new JLabel("Music");
        musicLabel.setHorizontalAlignment( JLabel.CENTER );
        musicLabel.setFont( headerFont );
        
    
        movieLabel = new JLabel("Movies");
        movieLabel.setHorizontalAlignment( JLabel.CENTER );
        movieLabel.setFont( headerFont );
        
        
        audiobookLabel = new JLabel("Audiobooks");
        audiobookLabel.setHorizontalAlignment( JLabel.CENTER );
        audiobookLabel.setFont( headerFont );
        
        searchLabel = new JLabel("Search: ");
        searchLabel.setHorizontalAlignment( JLabel.LEADING );
        searchLabel.setFont( new Font("Sans", Font.ITALIC, 12));
        
        searchField = new JTextField(10);
        
        
        
        
        JPanel searchPanel = new JPanel();            //set up search panel
        searchPanel.add(searchLabel);
        searchPanel.add(searchField);
        
        add(new JPanel());                            //add panels to GUI
        add(new JPanel());
        add(searchPanel);;
        
        add(new JPanel());
        add(new JPanel());
        add(new JPanel());
        
        add(new JPanel());
        add(new JPanel());
        add(new JPanel());
    }

}
