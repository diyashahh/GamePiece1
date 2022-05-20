import java.util.ArrayList;
/*
Diya Shah, Ella Wilkins, Gavin Caulfield
Lab 5
4/13/22
CISC181
 */
public class Team {
    /** Creates an object for one of the teams in the game
     * Two qualities are a String for the teamColor, and
     * an ArrayList<Piece> for the list of piece on the team
     */
    private String teamColor;
    private ArrayList<Piece> teamPieces;

    public Team(String teamColor, ArrayList<Piece> teamPieces) {
        /**
         * A constructor for the team
         * @param teamColor is a String representing the team's color
         * @param teamPieces is an ArrayList<Piece> that represents the team's pieces
         */
        this.teamColor = teamColor;
        this.teamPieces = teamPieces;
    }

    public String getTeamColor() {
        return teamColor;
    }

    public ArrayList<Piece> getTeamPieces() {
        return teamPieces;
    }

    public void removePieceFromTeam(Piece piece) {
        /**
         * Removes a piece from the team
         * @param piece is the Piece being removed.
         */
        teamPieces.remove(piece);
    }

    public void addPieceToTeam(Piece piece) {
        /**
         * Adds a piece to the team
         * @param piece is the Piece being added
         */
        piece.setTeamColor(teamColor);
        teamPieces.add(piece);
    }

    @Override
    public String toString() {
        String str = "";
        for (Piece piece : teamPieces) {
            str += piece.toString() + "  ";
        }
        return "Team " + teamColor + " pieces:\n" + str;
    }
}
