package mediastore;

import java.util.Scanner;

/**
 *
 * @author Milton John, Ryan Smith and Cole Arnold
 */
public class Manager {

    private String password; //managers password
    private Database db; //the database this instance is a member of

    Manager( String password ) {

        this.password = password;

    }

    public void addContent() {

        //Command Line prompt for manager to add desired item to Media store
        System.out.println( "What media type do you want to add?" );
        System.out.println( "1. Album" );
        System.out.println( "2. Movie" );
        System.out.println( "3. Audiobook" );
        Scanner input = new Scanner( System.in ); //Scanner oject

        int choice = input.nextInt();
        switch ( choice ) {
            case 1:
                System.out.print( "Enter the album artist: " );
                String artist = input.next();
                System.out.print( "Enter the album title: " );
                String albumTitle = input.next();
                System.out.print( "Enter the album duration: " );
                int albumDuration = input.nextInt();
                System.out.print( "Enter the album's genre: " );
                String albumGenre = input.next();
                System.out.print( "Enter the album's price: " );
                double albumPrice = input.nextDouble();
                Media newAlbum = new Album( artist, albumTitle, albumDuration, albumGenre, albumPrice );
                //store this new album in appropriate place (ask milton)

                break;
            case 2:
                System.out.println( "Enter the movie director: " );
                String director = input.next();
                System.out.print( "Enter the movie title: " );
                String movieTitle = input.next();
                System.out.print( "Enter the movie duration: " );
                int movieDuration = input.nextInt();
                System.out.print( "Enter the movie genre: " );
                String movieGenre = input.next();
                System.out.print( "Enter the movie price: " );
                double moviePrice = input.nextDouble();
                System.out.print( "Enter the movie release year: " );
                int movieYear = input.nextInt();
                Media newMovie = new Movie( director, movieTitle, movieDuration, movieGenre, moviePrice, movieYear );
                //store this new movie in appropriate place (ask milton)

                break;
            case 3:
                System.out.print( "Enter the audiobook author: , book title, book duration, genre, and price respectively." );
                String author = input.next();
                System.out.print( "Enter the audiobook title: " );
                String bookTitle = input.next();
                System.out.print( "Enter the audiobook duration: " );
                int bookDuration = input.nextInt();
                System.out.print( "Enter the audiobook genre: " );
                String bookGenre = input.next();
                System.out.print( "Enter the audiobook price: " );
                double bookPrice = input.nextDouble();
                Media newAudiobook = new Audiobook( author, bookTitle, bookDuration, bookGenre, bookPrice );
                //store this new album in appropriate place (ask milton)

                break;
        }

    }

    public void removeContent( int id ) {
        Media object = db.getFromID( id ); //stores desired media item in temporary object
        db.media.remove( object );         //deletes temporary media object
        db.deleteMediaItem( object );      //deletes media object from store

    }

    public int checkItemSales( int id ) {

        Media object = db.getFromID( id );
        return object.numSold;
    }

    public void checkTotalSales() {
        
    }
    
}