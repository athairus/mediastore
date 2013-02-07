package mediastore;

/**
 * A class that encapsulates a generic media object.
 *
 * @author Milton John and Cole Arnold
 */
public abstract class Media {

    String author;      // the author (or artist) of the work
    String title;       // the title of the work
    int duration;       // in seconds
    String genre;       // genre the object belongs to
    int ranking;        // 0 means not ranked, otherwise ranked from 
    // most popular to least in descending order
    double price;       // price in USD

    public Media() {
        // initialzies all data members to "" or 0
        author = "";
        title = "";
        genre = "";
        duration = 0;
        ranking = 0;
        price = 0.0;

    }

    public Media( String author, String title, int duration, String genre, int ranking, double price ) {
        // initializes all data member to their respective parameters
        this.author = author;
        this.title = title;
        this.duration = duration;
        this.genre = genre;
        this.ranking = ranking;
        this.price = price;

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
    //*****************************************************************************   
}
