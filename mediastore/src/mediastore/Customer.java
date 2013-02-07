package mediastore;

/**
 *
 * @author Cole Arnold and Ryan Smith
 */
public class Customer {
    String ID;
    String name;
    String address;
    // Purchase History
    int credit;
    int startingSize = 50; // starting size of Media arrays
    Album[] albumsOwned;
    AudioBooks[] audioBooksOwned;
    Movie[] moviesOwned;
    int albumIndex; // keeps track of current index in album array
    int audioIndex;
    int movieIndex;

    public Customer(String ID, String name, String address, int credit) {
        this.ID = ID;
        this.name = name;
        this.address = address;
        this.credit = credit;
        albumsOwned = new Album[ startingSize ];
        audioBooksOwned = new AudioBooks[ startingSize ];
        moviesOwned = new Movie[ startingSize ];
        albumIndex = 0;
        audioIndex = 0;
        movieIndex = 0;
    }

    public Album[] reallocateAudioBooksSize( AudioBooks[] AubioBooksOwned ) {
        int oldSize = startingSize;
        this.startingSize = startingSize * 2;
        albumsOwned = new Album[ startingSize ];
        System.arraycopy( this.albumsOwned, 0, albumsOwned, 0, oldSize );

        return albumsOwned;
    }

    public Movie[] reallocateMovieSize( Movie[] moviesOwned ) {
        int oldSize = startingSize;
        this.startingSize = startingSize * 2;
        moviesOwned = new Movie[ startingSize ];
        System.arraycopy( this.moviesOwned, 0, moviesOwned, 0, oldSize );

        return moviesOwned;
    }

    public AudioBooks[] reallocateAlbumSize( AudioBooks[] audioBooksOwned ) {
        int oldSize = startingSize;
        this.startingSize = startingSize * 2;
        audioBooksOwned = new AudioBooks[ startingSize ];
        System.arraycopy( this.audioBooksOwned, 0, audioBooksOwned, 0, oldSize );

        return audioBooksOwned;
    }

    public void buyAlbum( Album newAlbum ) {
        albumsOwned[albumIndex] = newAlbum;
        albumIndex++;
    }

    public void buyMovie( Movie newMovie ) {
        moviesOwned[movieIndex] = newMovie;
        movieIndex++;
    }

    public void buyAudioBook( AudioBooks newAudioBooks ) {
        audioBooksOwned[audioIndex] = newAudioBooks;
        audioIndex++;
    }
    
    public void search()
    {
        
    }
}
