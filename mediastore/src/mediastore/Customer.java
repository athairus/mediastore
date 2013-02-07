/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mediastore;

/**
 *
 * @author max7b_000
 */
public class Customer {
    String name;
    String emailAddress;
    int age;
    int birthdate;
    int moneySpent;
    int startingSize = 50; // starting size of Media arrays
    Album[] albumsOwned;
    AudioBooks[] audioBooksOwned;
    Movie[] moviesOwned;
    
    public Customer(String name, String emailAddress, int age, int birthdate, int moneySpent){
        this.name = name;
        this.emailAddress = emailAddress;
        this.age = age;
        this.birthdate = birthdate;
        this.moneySpent = moneySpent;
        albumsOwned = new Album[startingSize];
        audioBooksOwned = new AudioBooks[startingSize];
        moviesOwned = new Movie[startingSize];
    }
    
    public Album[] reallocateAlbumnSize(Album[] albumsOwned){
        int oldSize = startingSize;
        this.startingSize = startingSize*2;
        albumsOwned = new Album[startingSize];
        System.arraycopy(this.albumsOwned,0,albumsOwned,0,oldSize);
        
        return albumsOwned;
    }
    
}
