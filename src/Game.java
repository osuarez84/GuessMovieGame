import java.util.Random;

public class Game {

    /* INSTANCE VARIABLES */
    private Movie[] movieList;
    private int length;
    private String guessTitle;
    private String rndTitle;



    // Constructor: it receives the list with the films for the game
    public Game (Movie[] list, int l) {
        this.movieList = list;
        this.length = l;
        this.guessTitle = "";
        this.rndTitle = "";
    }


    /* METHODS */
    private String getRandomTitle (){
        int rnd = new Random().nextInt(this.length);
        return this.movieList[rnd].getTitle();

    }


    private String convertToUnderscores (String title){
        /* Split the title into words */
        String[] temp = title.split(" ");

        /* Obtain the number of words to count for the white spaces */
        int count = temp.length;

        /* Variable to store the underscore version of the title */
        String tempT = new String();

        /* Concatenate the string already converted to underscores */
        for (int i = 0; i < count; i++) {
            tempT = tempT + temp[i].replaceAll(".", "_");
            tempT = tempT + " ";
        }

        return tempT;

    }


    private String replaceCharAt (String title, int index, char newLetter) {
        char[] chars = title.toCharArray();
        chars[index] = newLetter;
        return String.valueOf(chars);
    }



    /* Method to launch the game */
    public void startGame () {

        /* pick random title from list */
        this.rndTitle = this.getRandomTitle();

        /* convert the title to underscores */
        this.guessTitle = this.convertToUnderscores(rndTitle);


    }


    public boolean checkLetter(char letter) {
        boolean isPresent = false;

        /* check first if the letter is present in the title */
        if (this.rndTitle.indexOf(letter) != -1) {

            /* loop through the entire string to compare all the characters */
            for (int i = 0; i < this.rndTitle.length(); i++) {
                if (this.rndTitle.charAt(i) == letter) {
                    this.guessTitle = replaceCharAt(this.guessTitle, i, letter);
                }
            }

            /* set the flag to indicate that the letter occurred in the title */
            isPresent = true;
        }

        return isPresent;


    }

    public boolean checkWholeTitle () {

        /* check whether are there more '_' char
         * in the guessTitle. If not then
          * the user has win!*/
        boolean v = false;

        /* are there still missing letter? */
        /* if not set the flag to complete! */
        if (this.guessTitle.indexOf('_') == -1) {
                v = true;
        }

        return v;

    }




    /* GETTERs AND SETTERs */
    public String getUnderscoreTitle (){
        return this.guessTitle;
    }

    public String getSolutionTitle () {
        return this.rndTitle;
    }




}
