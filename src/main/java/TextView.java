import java.util.Scanner;
public class TextView {
    private int fromRowIndex;
    private int fromColIndex;
    private int toRowIndex;
    private int toColIndex;
    private char action;
    /**
     * This method takes continuous user input, checking that its valid, meaning
     * that its a proper int value, and is within the interval bound by minVal
     * and maxVal.
     *
     * @param minVal lowest value the user could enter
     * @param maxVal highest value the user could enter
     * @param scr scanner object
     * @return int value, which is a valid integer and falls between the
     * min and max.
     */
    public static int getValidInt(int minVal, int maxVal, Scanner scr) {
        boolean valid = false;
        int userInput = 0;

        while(!(valid)){
            System.out.println("\nEnter an int from " + minVal + " to " + maxVal +".");
            if(scr.hasNextInt()) {
                userInput = scr.nextInt();
                if (userInput >= minVal && userInput <= maxVal) {
                    System.out.println(userInput + " is a valid int.");
                    valid = true;
                }
                else {
                    System.out.println("This int does not fall within the interval.");
                }
            }
            else{
                scr.next();
                System.out.println("Please enter an INT value.");
            }
        }

        return userInput;
    }
    /**
     * This method takes continuous input from the user, and it checks if the
     * starting char of the input is 'A', 'M', 'R', or 'S'. If it is either of
     * these letters, it will return that letter.
     *
     * @param scr scanner object
     * @return returns the letter that matches either of the action types as
     * inputted by the user.
     */
    public static char getUsersNextActionType(Scanner scr){
        boolean flag = true;
        char letter = 'z';
        String userInput;
        while(flag){
            System.out.println("\nPlease enter 'A', 'M', 'R', or 'S'.");
            userInput = scr.next();
            if((userInput.charAt(0) == 'A') || (userInput.charAt(0) == 'a')){
                letter = userInput.charAt(0);
                flag = false;
            }
            else if((userInput.charAt(0) == 'M') || (userInput.charAt(0) == 'm')){
                letter = userInput.charAt(0);
                flag = false;
            }
            else if((userInput.charAt(0) == 'R') || (userInput.charAt(0) == 'r')){
                letter = userInput.charAt(0);
                flag = false;
            }
            else if((userInput.charAt(0) == 'S') || (userInput.charAt(0) == 's')){
                letter = userInput.charAt(0);
                flag = false;
            }
            else{
                System.out.println("Invalid input.");
            }
        }
        System.out.println(letter + " is valid.");
        return letter;
    }

    /**
     * This method gets the type of action the player wants to perform and assigns it
     * to actionType
     * @param game object of GameS22
     */
    public void getNextPlayersAction(GameS22 game) {
        Scanner scnr = new Scanner(System.in);

        System.out.println("Enter the action you want to perform");
        action = getUsersNextActionType(scnr);
        System.out.println("Enter the row and column for the piece you want to move.");
        System.out.println("Row:");
        fromRowIndex = getValidInt(0 ,game.getGameBoard().getNumRows(), scnr);
        System.out.println("Columns:");
        fromColIndex = getValidInt(0, game.getGameBoard().getNumColumns(), scnr);
        System.out.println("Enter the row and column for the piece you want to approach.");
        System.out.println("Row:");
        toRowIndex = getValidInt(0,game.getGameBoard().getNumRows(), scnr);
        System.out.println("Column:");
        toColIndex = getValidInt(0, game.getGameBoard().getNumColumns(), scnr);

    }

    public int getFromRowIndex(){
        return fromRowIndex;
    }
    public int getFromColIndex(){
        return fromColIndex;
    }

    public int getToRowIndex() {
        return toRowIndex;
    }

    public int getToColIndex() {
        return toColIndex;
    }
    public char getAction(){
        return action;
    }

    /**
     * Prints the game object
     * @param game object of GameS22
     */
    public void updateView(Game game){
        System.out.println(game);
    }

    /**
     * Prints that the game is over and which team has won.
     * @param game object of GameS22
     */
    public void printEndOfGameMessage(Game game){
        if(game.isGameEnded()){
            Team team = game.getWinner();
            System.out.println("The game has ended.\n" + team + " has won.");
        }
    }
}
