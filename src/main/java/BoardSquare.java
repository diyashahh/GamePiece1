/*
Diya Shah, Ella Wilkins, Gavin Caulfield
Lab 5
4/13/22
CISC181
 */
public class BoardSquare {
    /**
     * Class that represents each individual BoardSquare for
     * the game board
     *
     * has three qualities whether it is empty, the piece on the
     * square, and the color of the board square.
     */

    private boolean empty;
    private Piece piece;
    private String color;

    public BoardSquare(String color){
        /**
         * Constructor for BoardSquare. Sets empty to true
         * @param color is a String that represents the color
         */
        this.color = color;
        this.empty = true;
    }

    public Piece getPiece() {
        return piece;
    }

    public boolean isEmpty() {
        return empty;
    }

    public String getSquareColor() {
        return color;
    }

    public void setPiece(Piece piece) {
        /**
         * Sets a piece to the boardsquare
         *
         * @param piece is the Piece going on the boardsquare
         */
        this.piece = piece;
        this.empty = false;
    }
    public Piece removePiece(){
        /**
         * Removes a piece from a square ; sets empty to true
         */
        Piece temp = this.piece;
        this.piece = null;
        this.empty = true;
        return temp;
    }

    @Override
    public String toString() {
        /**Prints out the boardsquare
         * if the boardsquare is empty, returns "-------"
         * if boardsquare is not empty, returns "-piece-"
         */
        if(piece == null) {
            return "-------";
        }
        else{
            return "-" + piece.toString() + "-";
        }
    }
}
