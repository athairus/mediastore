package mediastore;

/**
 * A class that encapsulates an audio book.
 *
 * @author Milton John, Ryan Smith and Cole Arnold
 */
public class Audiobook extends Media {

    public Audiobook() {
        super();
    }

    public Audiobook( String author, String title, int duration, String genre, double price, int releaseYear ) {

        super( author, title, duration, genre, price, releaseYear );
    }
    
    public String toTextDBRepresentation(){
        return author + "\n " + title + "\n " + duration + "\n " + genre + "\n " + ranking + "\n " + price + "\n " + releaseYear;
    }
}
