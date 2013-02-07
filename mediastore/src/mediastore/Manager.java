package mediastore;

import java.util.Scanner;

/**
 *
 * @author Cole Arnold and Ryan Smith
 */
public class Manager {

    String password;
    
    
    public void add(){
        System.out.println("What media type do you want to add?");
        System.out.println("1. Album");
        System.out.println("2. Movie");
        System.out.println("3. Audiobook");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        
        if( choice == 1 )
        {
           System.out.println("Enter the artist, album title, album duration, genre, and price respectively.");
           
        }
        else if( choice == 2 )
        {
            
        }
        else if( choice == 3 )
        {
            
        }    
        else
           System.out.println("Input was invalid.");
    
    
    }   
}
