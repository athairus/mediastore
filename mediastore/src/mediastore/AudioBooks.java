package mediastore;

/**
 * A class that encapsulates an audio book.
 *
 * @author Cole Arnold and Ryan Smith
 */
public class AudioBooks extends Media {
    
    public AudioBooks(){
        super();
    }
    
    public AudioBooks(String author, String title, int duration, String genre, double price){
        
        super(author, title, duration, genre, price);
    }
    
    
}
