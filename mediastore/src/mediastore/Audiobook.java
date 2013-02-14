package mediastore;

/**
 * A class that encapsulates an audio book.
 *
 * @author Milton John, Ryan Smith and Cole Arnold
 */
public class Audiobook extends Media {
    
    public String toTextDBRepresentation(){
        return author + "\n " + title + "\n " + duration + "\n " + genre + "\n " + ranking + "\n " + price + "\n ";
    }
}
