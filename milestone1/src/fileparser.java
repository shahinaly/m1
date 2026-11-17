import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.*;


public class fileparser {
    public static void main(String[] args) {
        //movies
        File movies = new File("movies.txt");
        ArrayList<movieclassplaceholder> movielist = new ArrayList<>();

        try {
            Scanner scan = new Scanner(movies);


            while(scan.hasNextLine()){
                String line = scan.nextLine();

                if (line.startsWith("movie_id")) {
                    continue; 
                }       //skipping the first line

                movieclassplaceholder movie = new movieclassplaceholder();
                int i = 0;
                int j = 0;
                int whichvar = 0;
                for (j = 0; j < line.length(); j++){
                    if ((line.charAt(j) == ',')) {
                        String current = line.substring(i, j);
                        i = j + 1;

                        switch(whichvar) {
                            case 0:
                                movie.movie_id = Integer.parseInt(current);
                                break;
                            case 1:
                                movie.title = current;
                                break;
                            case 2:
                                movie.director = current;
                                break;
                            case 3:
                                movie.year = Integer.parseInt(current);
                                break;
                            case 4:
                                movie.genres = current;
                                break;
                            case 5:
                                movie.avg_rating = Float.parseFloat(current);
                                break;
                            default:
                                break;
                        }
                        whichvar++;
                    }
                }   //end for 
                String current = line.substring(i, j);
                i = 0;
                whichvar = 0;
                movie.num_ratings = Integer.parseInt(current);
                movielist.add(movie);
            }   //end while

            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //ratings
        File ratings = new File("my_ratings.txt");
        ArrayList<ratingsclassplaceholder> ratinglist = new ArrayList<>();

        try {
            Scanner scan = new Scanner(ratings);


            while(scan.hasNextLine()){
                String line = scan.nextLine();

                if (line.startsWith("movie_id")) {
                    continue; 
                }       //skipping the first line

                ratingsclassplaceholder currentrating = new ratingsclassplaceholder();
                int i = 0;
                int j = 0;
                int whichvar = 0;
                for (j = 0; j < line.length(); j++){
                    if ((line.charAt(j) == ',')) {
                        String current = line.substring(i, j);
                        i = j + 1;

                        switch(whichvar) {
                            case 0:
                                currentrating.movie_id = Integer.parseInt(current);
                                break;
                            case 1:
                                currentrating.rating = Float.parseFloat(current);
                                break;
                            default:
                                break;
                        }
                        whichvar++;
                    }
                }   //end for 
                String current = line.substring(i, j);
                i = 0;
                whichvar = 0;
                currentrating.timestamp = LocalDate.parse(current);
                ratinglist.add(currentrating);
            }   //end while

            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
