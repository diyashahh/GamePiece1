public class ActionAttack extends Action{
    //extended class

    public ActionAttack(GameS22 game, int fromRow, int fromColumn, int toRow, int toColumn){
        /*
        5 param constructor, uses super-
        same as Action classes constructor
         */
        super(game, fromRow, fromColumn, toRow, toColumn);
    }

    @Override
    /*
    override method
    calls speak, removes attack piece from boards,
    removes attack piece from opponent board,
    move piece from sq to sq, change turn
     */
    public void performAction() {
        BoardSquare[][] boardSquares = game.getBoardSquare();
        Piece piece1 = boardSquares[fromRow][fromColumn].getPiece();
        Piece piece2 = boardSquares[toRow][toColumn].getPiece();
        piece1.speak();
        boardSquares[toRow][toColumn].removePiece();
        if(piece2.getTeamColor() == game.getOpponentTeam().getTeamColor()){
            game.getOpponentTeam().removePieceFromTeam(piece2);
            boardSquares[fromRow][fromColumn].removePiece();
            boardSquares[toRow][toColumn].setPiece(piece1);
            game.changeTurn();
        }
        /*
        calls speak method, removes attack piece, removes attack piece
        from current, creates new Evil piece, add a new piece to current,
        places new piece, change turn
         */
        if(piece1 instanceof PieceEvilMinion && piece2 instanceof  PieceMinion){
            game.getCurrentTeam().removePieceFromTeam(piece2);
            PieceEvilMinion newEvilmin = new PieceEvilMinion();
            game.getCurrentTeam().addPieceToTeam(newEvilmin);
            boardSquares[toRow][toColumn].setPiece(newEvilmin);
            game.changeTurn();
        }
    }
}