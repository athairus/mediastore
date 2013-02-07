package mediastore;

/**
 * A class that encapsulates a movie.
 *
 * @author Ryan Smith
 */

public class Movie extends Media {

    private String director; //director of the movie
    private int releaseYear; //year of movie's release
    
    public Movie(){   
      //POST: Initializes data members to "" or 0
        super();
        director = "";
        releaseYear = 0;
    }
    
    public Movie(String author, String title, int duration, String genre, int ranking, double price, String director, int releaseYear){
      //PRE: Takes an author, title, duration, genre, ranking, price ( > 0 ), director of movie, and release year ( > 0 )
      //POST: Sets data members to respective values
      super(author, title, duration, genre, ranking, price);
      this.director = director;
      this.releaseYear = releaseYear;
    }

 //****************************************************************************
 //*                            Set and Get Methods                           *
 //****************************************************************************
    
    public void setDirector(String director){   
        //PRE: Parameter takes a director name
        //POST: Sets director to indicated string
        this.director = director;
    }
    
    public void setReleaseYear(int releaseYear){
      //PRE: Parameter takes in year of movie release
      //POST: Release year is set to given value
        this.releaseYear = releaseYear;
    }
    
    public String getDirector(){
      //POST: returns movie's director
        return director;
    }
    
    public int getReleaseYear(){
      //POST: returns movie's release year
        return releaseYear;
    }
    
    protected Movie getFromID(){ // only media should call this method
        return null;
    }
    
    
}
