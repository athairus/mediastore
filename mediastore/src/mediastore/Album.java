package mediastore;

/**
 * A class that encapsulates a music album.
 *
 * @author Milton John, Ryan Smith and Cole Arnold
 */
public class Album extends Media {

    public Album() {
        super();
    }

    public Album( String author, String title, int duration, String genre, double price, double numSold ) {

        super( author, title, duration, genre, price, numSold );
        
    }
    
    public String toTextDBRepresentation() {
        return author + '\n' + title + '\n' + duration + '\n' + genre + '\n' + ranking + '\n' + price;
    }
}
