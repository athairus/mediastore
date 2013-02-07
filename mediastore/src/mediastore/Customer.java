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
    
    Database db;
    

    public Customer() {
        
    }
    
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


    public void buy( String id ) {
        Media object = db.getFromID( id );
        // check to see if enough credits are present
        credit -= object.getPrice();
        Purchase purchase = new Purchase( id, object.getPrice(), System.currentTimeMillis());
        db.writeCustomerPurchase( ID, purchase );
    }
    
    public void search()
    {
        
    }
}
