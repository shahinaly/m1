import java.util.ArrayList;
import java.util.HashMap;

public class RatingManager {

    private HashMap<Integer, Rating> userRatings = new HashMap<Integer,Rating>();
    private FileParser fileParser = new FileParser();
    
    public void addRating(int movieID, String ratingInput) throws NumberFormatException {
        Rating newRating = new Rating(movieID, Integer.parseInt(ratingInput));
        userRatings.put(movieID, newRating);

        // TODO: Handle parsing exceptions

    }

    public void updateRating(int movieID, String ratingInput) throws NumberFormatException{
        Rating newRating = new Rating(movieID, Integer.parseInt(ratingInput));
        userRatings.put(movieID, newRating);

        // TODO: Handle parsing exceptions
    }

    public Rating findRating(int movieID){
        return userRatings.get(movieID);
    }

    public ArrayList<Rating> getUserRatings() {
        return new ArrayList<Rating>(userRatings.values());
    }

    private void saveRatings(){
        FileParser.saveRatings(this.getUserRatings(), "UserRatings.txt");
    }
}


