package mediastore;


import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;


public class MediaViewerGUI extends JFrame implements ActionListener {

    private Database db;
    private JLabel author;
    private JLabel title;
    private JLabel duration;
    private JLabel genre;
    private JLabel rating;
    private JLabel totalReviews;
    private JLabel price;
    private JLabel ranking;
    private JLabel coverLabel;
    private ImageIcon cover;
    private JPanel infoPanel;
    private JPanel buttonPanel;
    private JPanel imagePanel;
    private JButton preview;
    private JButton buy;
    private Media media;
    private Customer customer;

    public MediaViewerGUI( Media m, Customer c ) throws java.io.IOException {

        super( "Mediastore" );

        JPanel contentPane = new JPanel();
        
        setContentPane( contentPane );
        contentPane.setLayout( null );
        db = MediaStoreGUI.db;
        media = m;
        customer = c;
        setLayout( new BorderLayout(10,10));

        cover = db.viewCoverImage( m );
        coverLabel = new JLabel( cover );
        author = new JLabel( "Author: " + m.getAuthor() );
        title = new JLabel( "Title: " + m.getTitle() );
        duration = new JLabel( "Duration: " + m.getDuration() );
        genre = new JLabel( "Genre: " + m.getGenre() );
        rating = new JLabel( "Rating: " + m.getRating() );
        totalReviews = new JLabel( "Total Reviews: " + m.getTotalReviews() );
        price = new JLabel( "Price: " + m.getPrice() );
        ranking = new JLabel( "Ranking: " + m.getRanking() );
        preview = new JButton( "Preview" );
        buy = new JButton( "Buy" );

        buttonPanel = new JPanel();
        buttonPanel.add( buy );
        buttonPanel.add( preview );

        infoPanel = new JPanel();    
        infoPanel.add( author);
        infoPanel.add( title );
        infoPanel.add( duration );
        infoPanel.add( genre );
        infoPanel.add( rating );
        infoPanel.add( totalReviews );
        infoPanel.add( price );
        infoPanel.add( ranking );       
        
        imagePanel = new JPanel();
        imagePanel.add( coverLabel );

        add( buttonPanel, BorderLayout.NORTH );
        add( infoPanel, BorderLayout.WEST);
        add( imagePanel, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed( ActionEvent e ) {
        try {
            if ( e.getSource() == preview ) {
                db.preview( media );
            }
            if ( e.getSource() == buy ) {
                customer.buy( media.id );
            }
        } catch ( IOException ex ) {
        }
    }
}
