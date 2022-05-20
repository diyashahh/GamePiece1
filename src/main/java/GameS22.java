public class GameS22 extends Game{
    /**
     * Creates a Game extended from the Game Class
     * @param rows is an int for the number of rows in the board
     * @param columns is an int for the number of columns in the board
     * @param team1 is a Team for the first team
     * @param team2 is a Team for the second Team
     */
    public GameS22(int rows, int columns, Team team1, Team team2) {
        super(rows, columns, team1, team2);
    }
    /**
     * Abstract function from the Game class that determines
     * whether a team is a winner
     * @return ck is a boolean determining if a team is a winner
     */
    @Override
    public boolean isAWinner() {
        boolean ck = getOpponentTeam().getTeamPieces() == null ? true : false;
        return ck;
    }

    /**
     * Abstract function from the Game class that
     * gets the winner for the game
     * @return a Team that either is a winner--if there is no winner
     * it will return null
     */
    @Override
    public Team getWinner() {
        Team winner = null;
        if(getCurrentTeam().getTeamPieces() == null){
            winner = getOpponentTeam();
        }
        else if(getOpponentTeam().getTeamPieces() == null){
            winner = getCurrentTeam();
        }
        return winner;
    }

    /**
     * Abstract function from the Game class that checks
     * whether a game is finished (One or more teams does not have
     * any more game pieces)
     * @return ck is a boolean checking whether the game is finished.
     */
    @Override
    public boolean isGameEnded() {
        boolean ck = getOpponentTeam().getTeamPieces() == null || getCurrentTeam().getTeamPieces() == null ? true : false;
        return ck;
    }
}
