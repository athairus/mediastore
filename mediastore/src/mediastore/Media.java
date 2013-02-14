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
    protected int ranking;          // ranking in terms of sales,0 means not 
                                    // ranked, otherwise ranked from 
                                    // most popular to least in descending order
    protected double price;         // price in USD
    protected int numSold;          // number of media objects sold


    //Default constructor
    public Media() {
        // initialzies all data members to "" or 0
        author = "";
        title = "";
        genre = "";
        duration = 0;
        ranking = 0;
        price = 0.0;
        numSold = 0;
    }
    /** Initializer constructor for Media object
     * 
     * @param author the author's name
     * @param title the media contents title
     * @param duration length of media object
     * @param genre genre of the work
     * @param price price of the media object
     * @param numSold the amount sold 
     */
    public Media( String author, String title, int duration, String genre, double price, double numSold ) {
        // initializes all data member to their respective parameters
        this();
        this.author = author;
        this.title = title;
        this.duration = duration;
        this.genre = genre;
        ranking = 0;
        this.price = price;

    }

    //****************************************************************************
    //*                            Set and Get Methods                           *
    //****************************************************************************
    
    /** Sets the author of the media item
     * 
     * @param author name of the author 
     */
    public void setAuthor( String author ) {
        // POST: sets author to parameter
        this.author = author;
    }

    /** Returns author
     * 
     * @return author
     */
    public String getAuthor() {
        //POST: returns author
        return author;
    }
    
    /** Sets the genre of the media item
     * 
     * @param genre 
     */
    public void setGenre( String genre ) {
        // POST: sets genre to parameter
        this.genre = genre;
    }

    /** Returns the genre
     * 
     * @return genre
     */
    public String getGenre() {
        //POST: returns genre
        return genre;
    }
    
    /** Sets the title of the media item
     * 
     * @param title 
     */
    public void setTitle( String title ) {
        // POST: sets title to parameter
        this.title = title;
    }

    /** Returns the title
     * 
     * @return title
     */
    public String getTitle() {
        //POST: returns title
        return title;
    }

    /** Sets duration of the media item
     * 
     * @param duration length of media object in seconds
     */
    public void setDuration( int duration ) {
        // POST: sets duration to parameter
        this.duration = duration;
    }

    /** Returns duration of media item
     * 
     * @return duration
     */
    public int getDuration() {
        //POST: returns duration
        return duration;
    }

    /** Sets the rank of media object
     * 
     * @param ranking ranking of object based on sales
     */
    public void setRanking( int ranking ) {
        // POST: sets ranking to parameter
        this.ranking = ranking;
    }
    
    /** Returns the ranking of media object
     * 
     * @return ranking
     */
    public int getRanking() {
        //POST: returns ranking
        return ranking;
    }

    /** Sets price of media object
     * 
     * @param price cost of media
     */
    public void setPrice( double price ) {
        // POST: sets price to parameter
        this.price = price;
    }

    /** Returns the price of media object
     * 
     * @return price
     */
    public double getPrice() {
        //POST: returns price
        return price;
    }

    /** Returns the ID of a media object
     * 
     * @return id
     */
    public int getID() {
        return id;
    }
    //*****************************************************************************  
}
