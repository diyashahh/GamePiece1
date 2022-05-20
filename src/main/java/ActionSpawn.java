/**
 * Lab 7 - Diya Shah, Gavin C, Ella W
 * CISC181
 * May 4, 2022
 */
public class ActionSpawn extends Action {
    /*
    extended class
     */

    public ActionSpawn(GameS22 game, int fromRow, int fromColumn, int toRow, int toColumn){
        /*
        5 param constructor, uses super-
        same as Action classes constructor
         */
        super(game,fromRow,fromColumn,toRow,toColumn);
    }

    @Override
    public void performAction() {
        /*
        override-
        calls speak method, calls piece from squares spawn method,
        add new piece, puts that on to square, changes turn
         */
        BoardSquare[][] boardSquares = game.getBoardSquare();
        Piece piece1 = boardSquares[fromRow][fromColumn].getPiece();
        piece1.speak();
        Piece spawn = piece1.spawn();
        game.getCurrentTeam().addPieceToTeam(spawn);
        boardSquares[toRow][toColumn].setPiece(spawn);
        game.changeTurn();
    }
}
//ADD max amount of attacks conditional