/**
 * Lab 7 - Diya Shah, Gavin C, Ella W
 * CISC181
 * May 4, 2022
 */

public class ActionMove extends Action {
    /*
    extended class
     */
    public ActionMove(GameS22 game, int fromRow, int fromColumn, int toRow, int toColumn){
        /*
        5 param constructor, uses super-
        same as Action classes constructor
         */
        super(game, fromRow, fromColumn, toRow, toColumn);
    }

    @Override
    /*
    override performAction,
    no return and no param-
    calls speak method, removes piece from From square,
    sets piece to square, changes turn
     */
    public void performAction() {
        BoardSquare[][] boardSquares = game.getBoardSquare();
        Piece piece1 = boardSquares[fromRow][fromColumn].getPiece();
        piece1.speak();
        boardSquares[fromRow][fromColumn].removePiece();
        boardSquares[toRow][toColumn].setPiece(piece1);
        game.changeTurn();
    }
}