package mediastore;

/**
 * A class that encapsulates a music album.
 *
 * @author Milton John, Ryan Smith and Cole Arnold
 */
public class Album extends Media {
    
    public String toTextDBRepresentation() {
        return author + '\n' + title + '\n' + duration + '\n' + genre + '\n' + ranking + '\n' + price;
    }
}
