package mediastore;

/**
 * A class that encapsulates a generic media object.
 *
 * @author Milton John, Ryan Smith and Cole Arnold
 */
public abstract class Media {

    protected int id;               // unique ID 
    protected String author;        // the author (or artist) of the work
    protected String title;         // the title of the work
    protected int duration;         // in seconds
    protected String genre;         // genre the object belongs to
    protected double rating;        // the item's rating (out of 5 stars)
    // a rating of 0 indicates it was not
    // reviewed yet
    protected int totalReviews;     // the total number of customers who have
    // reviewed this item
    protected double price;         // price in USD
    protected int numSold;          // number of media objects sold
    protected int ranking;          // ranking in terms of sales, 0 means not 
    // ranked, otherwise ranked from 
    // most popular to least in descending order
    // generated on demand

    //Default constructor
    public Media() {
        // initialzies all data members to "" or 0
        author = "";
        title = "";
        duration = 0;
        genre = "";
        rating = 0.0;
        totalReviews = 0;
        price = 0.0;

        ranking = 0;
    }

    /**
     *
     * @param author
     * @param title
     * @param duration
     * @param genre
     * @param price
     * @param numSold
     */
    public Media( int id, String author, String title, int duration, String genre, double rating, int totalReviews, double price, int numSold ) {
        // initializes all data member to their respective parameters
        this();
        this.id = id;
        this.author = author;
        this.title = title;
        this.duration = duration;
        this.genre = genre;
        this.rating = rating;
        this.totalReviews = totalReviews;
        this.price = price;
        this.numSold = numSold;
    }

    //****************************************************************************
    //*                            Set and Get Methods                           *
    //****************************************************************************
    /**
     * Sets the author of the media item
     *
     * @param author name of the author
     */
    public void setAuthor( String author ) {
        // POST: sets author to parameter
        this.author = author;
    }

    /**
     * Returns author
     *
     * @return author
     */
    public String getAuthor() {
        //POST: returns author
        return author;
    }

    /**
     * Sets the genre of the media item
     *
     * @param genre
     */
    public void setGenre( String genre ) {
        // POST: sets genre to parameter
        this.genre = genre;
    }

    /**
     * Returns the genre
     *
     * @return genre
     */
    public String getGenre() {
        //POST: returns genre
        return genre;
    }

    /**
     * Sets the title of the media item
     *
     * @param title
     */
    public void setTitle( String title ) {
        // POST: sets title to parameter
        this.title = title;
    }

    /**
     * Returns the title
     *
     * @return title
     */
    public String getTitle() {
        //POST: returns title
        return title;
    }

    /**
     * Sets duration of the media item
     *
     * @param duration length of media object in seconds
     */
    public void setDuration( int duration ) {
        // POST: sets duration to parameter
        this.duration = duration;
    }

    /**
     * Returns duration of media item
     *
     * @return duration
     */
    public int getDuration() {
        //POST: returns duration
        return duration;
    }

    /**
     * Sets the rank of media object
     *
     * @param ranking ranking of object based on sales
     */
    public void setRanking( int ranking ) {
        // POST: sets ranking to parameter
        this.ranking = ranking;
    }

    /**
     * Returns the ranking of media object
     *
     * @return ranking
     */
    public int getRanking() {
        //POST: returns ranking
        return ranking;
    }

    /**
     * Sets price of media object
     *
     * @param price cost of media
     */
    public void setPrice( double price ) {
        // POST: sets price to parameter
        this.price = price;
    }

    /**
     * Returns the price of media object
     *
     * @return price
     */
    public double getPrice() {
        //POST: returns price
        return price;
    }

    /**
     * Returns the ID of a media object
     *
     * @return id
     */
    public int getID() {
        return id;
    }

    /**
     * Returns the number of items sold.
     *
     * @return The number of items sold
     */
    public int getNumSold() {
        return numSold;
    }

    public double getRating() {
        if ( rating < 0 ) {
            return 0;
        }
        if ( rating > 5 ) {
            return 5;
        }
        return rating;
    }

    public int getTotalReviews() {
        return totalReviews;
    }

    @Override
    public String toString() {
        return title + " (" + author + ")";
    }

    public abstract int getReleaseYear();
    //*****************************************************************************  
}
