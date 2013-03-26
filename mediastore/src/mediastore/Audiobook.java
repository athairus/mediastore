package mediastore;

/**
 * A class that encapsulates an audio book.
 *
 * @author Milton John, Ryan Smith and Cole Arnold
 */
public class Audiobook extends Media {

    /**
     * Initializer constructor
     *
     * @param id id of the audio book
     * @param author director of the audio book
     * @param title title of the audio book
     * @param duration length of the audio book (in seconds)
     * @param genre genre of the audio book
     * @param rating rating of the audio book
     * @param totalReviews total number of reviews of the audio book
     * @param price price (in dollars) of the audio book
     * @param numSold numbers sold (initialized to 0)
     */
    public Audiobook( int id, String author, String title, int duration, String genre, double rating, int totalReviews, double price, int numSold ) {

        super( id, author, title, duration, genre, rating, totalReviews, price, numSold );

    }

    /**
     *
     * @return a string that contains all the information on the audio book
     */
    public String toTextDB() {
        return author + "\n" + title + "\n" + duration + "\n" + genre + "\n" + rating + "\n" + totalReviews + "\n" + price + "\n" + numSold;
    }

    @Override                       //had to add this so I could override it in movie.java
    public int getReleaseYear() {
        return 0;
    }
}
