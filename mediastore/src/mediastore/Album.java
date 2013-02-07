package mediastore;

/**
 * A class that encapsulates a music CD.
 *
 * @author Milton John and Ryan Smith
 */
public class Album extends Media {
    
    public Album(){
        super();
    }
    
    public Album(String author, String title, int duration, String genre, double price){
        
        super(author, title, duration, genre, price);
    }
}

