import java.util.Collections;
/*
Diya Shah, Ella Wilkins, Gavin Caulfield
Lab 5
4/13/22
CISC181
 */
public abstract class Game {
    /**
     * Creates the game
     *
     * Four qualities are the gameBoard made from a GameBoard, teams 1 and 2 made from
     * the Team object, and a String representing turn
     */
    private GameBoard gameBoard;
    private Team team1;
    private Team team2;
    private String turn;

    private void initializeGameBoard(int rows, int columns) {
        /**
         * Sets up the GameBoard
         * @param rows is the int for the number of rows
         * @param columns is the int for the number of columns
         */
        this.gameBoard = new GameBoard(rows, columns);
        for (Piece piece : team1.getTeamPieces()) {
            gameBoard.findRandomEmptySpace().setPiece(piece);
        }
        for (Piece piece : team2.getTeamPieces()) {
            gameBoard.findRandomEmptySpace().setPiece(piece);
        }
    }

    public Game(int rows, int columns, Team team1, Team team2) {
        /**
         * 4 piece constructor for the Game
         *
         * @param rows is the int for the number of rows
         * @param columns is the int for the number of columns
         * @param team1 is the first team
         * @param team2 is the second team
         */
        this.turn = team1.getTeamColor();
        this.team1 = team1;
        this.team2 = team2;
        initializeGameBoard(rows, columns);

    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public Team getCurrentTeam() {
        /**
         * Gets the current team up to play
         */
        Team teamturn = team1;
        if (team2.getTeamColor() == turn) {
            teamturn = team2;
        }
        return teamturn;
    }
    public Team getOpponentTeam(){
        Team notturn = team1;
        if(team1.getTeamColor() == turn){
            notturn = team2;
        }
        return notturn;
    }
    public boolean isTurn(Team team){
        return team.getTeamColor() == turn;
    }
    public BoardSquare[][] getBoardSquare(){
        return gameBoard.getSquares();
    }

    public void changeTurn() {
        /**
         * Changes the turn between teams
         */
        if (turn == team1.getTeamColor()) {
            this.turn = team2.getTeamColor();
        }
        else {
            this.turn = team1.getTeamColor();
        }
    }
    @Override
    public String toString(){
        StringBuilder retString = new StringBuilder();
        retString.append("Game Board:\n")
                .append(String.join("", Collections.nCopies(10 + gameBoard.getNumColumns()*8, "*")))
                .append("\n" + getGameBoard().toString())
                .append(String.join("", Collections.nCopies(10 + gameBoard.getNumColumns()*8, "*")))
                .append("\n" + getCurrentTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + gameBoard.getNumColumns()*8, "*")))
                .append("\n" + getOpponentTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + gameBoard.getNumColumns()*8, "*")))
                .append("\nIt is Team " + getCurrentTeam().getTeamColor() + "'s turn\n");
        return retString.toString();
    }
    public abstract boolean isAWinner();
    public abstract Team getWinner();
    public abstract boolean isGameEnded();
}
