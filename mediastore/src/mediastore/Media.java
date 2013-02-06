package mediastore;

/**
 * A class that encapsulates a generic media object.
 * @author Milton John
 */
public abstract class Media {

    String author;      // the author (or artist) of the work
    String title;       // the title of the work
    int duration;       // in seconds
    String genre;       // genre the object belongs to
    int ranking;        // 0 means not ranked, otherwise ranked from 
                        // most popular to least in descending order
    double price;       // price in USD
}
