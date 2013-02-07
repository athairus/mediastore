package mediastore;

/**
 * A class that encapsulates a movie.
 * @author Ryan Smith
 */

public class Movie extends Media {

    private String director; //director of the movie
    private int releaseYear; //year of movie's release
    
    public Movie()
    {   //POST: Initializes data members to "" or 0
        director = "";
        releaseYear = 0;
    }

 //****************************************************************************
 //*                            Set and Get Methods                           *
 //****************************************************************************
    
    public void setDirector(String director)
    { //POST: Takes string and sets director to indicated string
        this.director = director;
    }
    
    public void setReleaseYear(int releaseYear)
    {
        this.releaseYear = releaseYear;
    }
    
    
    
    
    
    
}
