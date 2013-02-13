package mediastore;

/**
 * A class that encapsulates an audio book.
 *
 * @author Milton John, Ryan Smith and Cole Arnold
 */
public class AudioBook extends Media {

    public AudioBook() {
        super();
    }

    public AudioBook( String author, String title, int duration, String genre, double price, int releaseYear ) {

        super( author, title, duration, genre, price, releaseYear );
    }
}
