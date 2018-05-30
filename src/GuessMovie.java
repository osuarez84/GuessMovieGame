import java.util.Scanner;
import java.io.File;


public class GuessMovie {

    public static void main (String[] args) {

        try {

            /* Prepare objects to read the file */
            File file = new File("movies.txt");
            Scanner scanner = new Scanner(file);

            /* Prepare objects to save the list of films */
            Movie[] movies = new Movie[100];



            int i = 0;

            /* Read the whole list of films from the file */
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                movies[i] = new Movie(line);
                i++;
            }

            /* Create the new game with the list of films */
            int lengthList = i;
            Game newGame = new Game(movies, lengthList);

            // launch the game
            newGame.startGame();
            Scanner scannerGuess = new Scanner(System.in);
            int counterGuess = 0;

            System.out.println("Welcome to the guess film game!");
            System.out.println("I would choose a film title and you would have to guess it!");
            System.out.println("Let's try!");

            /* Get the picked film and the underscore version */
            String tS = newGame.getSolutionTitle();
            String tU = newGame.getUnderscoreTitle();
            char letterGuess;

            while(true) {
                System.out.println("You are guessing: " + tU);
                System.out.println("You have guessed (" + counterGuess + ") wrong letters.");
                System.out.println("Guess a letter:");
                letterGuess = scannerGuess.nextLine().charAt(0);

                /* if the character is in the title reveal it */
                if (newGame.checkLetter(letterGuess)) {
                    /* refresh the underscored title with the new letters */
                    tU = newGame.getUnderscoreTitle();
                } else {

                    /* if not, add 1 to the counterGuess */
                    counterGuess++;
                }

                /* is the entire title resolved? */
                if(newGame.checkWholeTitle()) {
                    System.out.println("Congrats!! You have WIN!");
                    System.out.println("You have guessed "+ tS + " correctly!");
                    break;
                }
                /* are we out of chances? Limit to 10 */
                else if (counterGuess == 10) {
                    System.out.println("You have guessed (10) wrong letters.");
                    System.out.println("You have LOST!!");
                    break;
                }
            }




        }
        catch (Exception exception){
            System.out.println("The file doesn't exist!");
        }








    }

}
