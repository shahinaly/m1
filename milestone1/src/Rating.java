import java.time.LocalDate;

public class Rating {
   int movieID;
   int rating;
   LocalDate date;

   public Rating(int movieID, int rating){
    this.rating = rating;
    this.movieID = movieID;
    this.date = LocalDate.now();
   }

   public int getMovieID() {
       return movieID;
   }
   public int getRating() {
       return rating;
   }
   public LocalDate getDate() {
       return date;
   }
   public void setRating(int rating) {
       this.rating = rating;
   }
}
