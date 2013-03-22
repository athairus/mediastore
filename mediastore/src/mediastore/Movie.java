package mediastore;

/**
 * A class that encapsulates a movie.
 *
 * @author Milton John, Ryan Smith and Cole Arnold
 */
public class Movie extends Media {

    protected int releaseYear;

    //Default constructor
    public Movie() {
        super();
    }

    /**
     * Initializer constructor
     *
     * @param id id of the movie
     * @param author director of the movie
     * @param title title of the movie
     * @param duration length of the movie (in seconds)
     * @param genre genre of the movie
     * @param rating rating of the movie
     * @param totalReviews total number of reviews of the movie
     * @param price price (in dollars) of the movie
     * @param releaseYear year movie was released
     * @param numSold numbers sold (initialized to 0)
     */
    public Movie( int id, String author, String title, int duration, String genre, double rating, int totalReviews, double price, int numSold, int releaseYear ) {
        super( id, author, title, duration, genre, rating, totalReviews, price, numSold );
        this.releaseYear = releaseYear;
    }

    //****************************************************************************
    //*                            Set and Get Methods                           *
    //****************************************************************************
    /**
     * Sets the release year of a movie
     *
     * @param releaseYear year of release
     */
    public void setReleaseYear( int releaseYear ) {
        this.releaseYear = releaseYear;
    }

    /**
     * Returns the release year of the movie
     *
     * @return releaseYear
     */
    @Override
    public int getReleaseYear() {
        return releaseYear;
    }

    /**
     * Returns movie object when called from Media class
     *
     * @return null
     */
    protected Movie getFromID() { // only media should call this method
        return null;
    }

    /**
     * Returns a string with all information of the movie
     *
     * @return toTextDB
     */
    public String toTextDB() {
        return author + "\n" + title + "\n" + duration + "\n" + genre + "\n" + rating + "\n" + totalReviews + "\n" + price + "\n" + numSold + "\n" + releaseYear;
    }
}
