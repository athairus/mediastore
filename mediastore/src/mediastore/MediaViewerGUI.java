package mediastore;

import mediastore.helpers.GBC;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private JLabel imageLabel;
    private ImageIcon image;
    private JPanel viewPanel;
    private JButton preview;
    private JButton buy;
    private Media media;
    private Customer customer;

    public MediaViewerGUI(Media m, Customer c) throws java.io.IOException {
        super("Mediastore");
        media = m;
        customer = c;
        setLayout(new GridLayout(3, 0));

        image = db.viewCoverImage(m);
        imageLabel = new JLabel(image);
        author = new JLabel("Author: " + m.getAuthor());
        title = new JLabel("Title: " + m.getTitle());
        duration = new JLabel("Duration: " + m.getDuration());
        genre = new JLabel("Genre: " + m.getGenre());
        rating = new JLabel("Rating: " + m.getRating());
        totalReviews = new JLabel("Total Reviews: " + m.getTotalReviews());
        price = new JLabel("Price: " + m.getPrice());
        ranking = new JLabel("Ranking: " + m.getRanking());
        preview = new JButton("Preview");
        buy = new JButton("Buy");

        viewPanel = new JPanel();
        viewPanel.setLayout(new GridBagLayout());
        viewPanel.add(imageLabel,
                new GBC(0, 0)
                .setWeight(1, 1)
                .setAnchor(GBC.CENTER));
        viewPanel.add(buy,
                new GBC(0, 0)
                .setWeight(1, 1)
                .setAnchor(GBC.NORTHWEST));
        viewPanel.add(preview,
                new GBC(0, 0)
                .setWeight(1, 1)
                .setAnchor(GBC.EAST));
        viewPanel.add(author,
                new GBC(0, 0)
                .setWeight(1, 1)
                .setAnchor(GBC.EAST));
        viewPanel.add(title,
                new GBC(0, 0)
                .setWeight(1, 1)
                .setAnchor(GBC.EAST));
        viewPanel.add(duration,
                new GBC(0, 0)
                .setWeight(1, 1)
                .setAnchor(GBC.EAST));
        viewPanel.add(genre,
                new GBC(0, 0)
                .setWeight(1, 1)
                .setAnchor(GBC.EAST));
        viewPanel.add(rating,
                new GBC(0, 0)
                .setWeight(1, 1)
                .setAnchor(GBC.EAST));
        viewPanel.add(totalReviews,
                new GBC(0, 0)
                .setWeight(1, 1)
                .setAnchor(GBC.EAST));
        viewPanel.add(price,
                new GBC(0, 0)
                .setWeight(1, 1)
                .setAnchor(GBC.EAST));
        viewPanel.add(ranking,
                new GBC(0, 0)
                .setWeight(1, 1)
                .setAnchor(GBC.EAST));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == preview) {
                db.preview(media);
            }
            if (e.getSource() == buy) {
                customer.buy(media.id);

            }
        } catch (IOException ex) {
        }
    }
}
