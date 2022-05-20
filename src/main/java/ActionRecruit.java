/**
 * Lab 7 - Diya Shah, Gavin C, Ella W
 * CISC181
 * May 4, 2022
 */
public class ActionRecruit extends Action {
//extended class
    public ActionRecruit(GameS22 game, int fromRow, int fromColumn, int toRow, int toColumn) {
        /*
        5 param constructor, uses super-
        same as Action classes constructor
         */

        super(game, fromRow, fromColumn, toRow, toColumn);
    }

    @Override
    public void performAction() {
        /*
        override-
        calls speak method, removes recruited piece, adds it,
        changes turn
         */
        BoardSquare[][] boardSquares = game.getBoardSquare();
        Piece piece1 = boardSquares[fromRow][fromColumn].getPiece();
        Piece piece2 = boardSquares[toRow][toColumn].getPiece();
        piece1.speak();
        game.getOpponentTeam().removePieceFromTeam(piece2);
        game.getCurrentTeam().addPieceToTeam(piece2);
        game.changeTurn();
    }

}
