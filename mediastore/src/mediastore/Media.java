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
    protected int releaseYear;      // year this media item was released

    public Media() {
        // initialzies all data members to "" or 0
        author = "";
        title = "";
        genre = "";
        duration = 0;
        ranking = 0;
        price = 0.0;
        releaseYear = 0;
    }

    public Media( String author, String title, int duration, String genre, double price, int releaseYear ) {
        // initializes all data member to their respective parameters
        this();
        this.author = author;
        this.title = title;
        this.duration = duration;
        this.genre = genre;
        this.price = price;
        this.releaseYear = releaseYear;

    }

    //****************************************************************************
    //*                            Set and Get Methods                           *
    //****************************************************************************
    public void setAuthor( String author ) {
        // POST: sets author to parameter
        this.author = author;
    }

    public String getAuthor() {
        //POST: returns author
        return author;
    }

    public void setGenre( String genre ) {
        // POST: sets genre to parameter
        this.genre = genre;
    }

    public String getGenre() {
        //POST: returns genre
        return genre;
    }

    public void setTitle( String title ) {
        // POST: sets title to parameter
        this.title = title;
    }

    public String getTitle() {
        //POST: returns title
        return title;
    }

    public void setDuration( int duration ) {
        // POST: sets duration to parameter
        this.duration = duration;
    }

    public int getDuration() {
        //POST: returns duration
        return duration;
    }

    public void setRanking( int ranking ) {
        // POST: sets ranking to parameter
        this.ranking = ranking;
    }

    public int getRanking() {
        //POST: returns ranking
        return ranking;
    }

    public void setPrice( double price ) {
        // POST: sets price to parameter
        this.price = price;
    }

    public double getPrice() {
        //POST: returns price
        return price;
    }

    public int getID() {
        return id;
    }
    //*****************************************************************************  
}
