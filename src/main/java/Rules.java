import java.util.ArrayList;

public class Rules {
    /**
     * checkValidAction ensures that any move-sets performed by the user (Move,
     * Spawn, Recruit, or Attack) is a valid move by the set of rules for the game.
     *
     * @param game is the Game in which these rules are being enforced
     * @param fromSqrRow is the row of the BoardSquare the piece is performing their
     *                   move set
     * @param fromSqrCol is the column of the BoardSquare the piece is performing their
     *                   move set
     * @param toSqrRow is the row of the BoardSquare the piece is performing their
     *                 move set towards
     * @param toSqrCol is the column of the BoardSquare the piece is performing their
     *                 move set towards
     * @param action is the char representing the move set actually being performed
     *               ('M' = Move, 'R' = Recruit 'S' = Spawn, and 'A' = Attack)
     * @return valid is a boolean determining if the move-set is valid
     */


    public static boolean checkValidAction(GameS22 game, int fromSqrRow, int fromSqrCol, int toSqrRow, int toSqrCol, char action) {
        //Move
        boolean valid = false;
        //Creates a toPiece (the piece on the toSquare) and a fromPiece(the piece on the fromSquare) to clean up code
        Piece toPiece = game.getGameBoard().getSquares()[toSqrRow][toSqrCol].getPiece();
        Piece fromPiece = game.getGameBoard().getSquares()[fromSqrRow][fromSqrCol].getPiece();
        if (action == 'M') {
            //Checks to see if the from and to squares are inbounds
            if (game.getGameBoard().inBounds(fromSqrRow, fromSqrCol)
                    && game.getGameBoard().inBounds(toSqrRow, toSqrCol)) {
                //System.out.println("Square inbounds");
                //Checks to see if the fromPiece is null
                if(fromPiece != null) {
                    //System.out.println("FromPiece not null");
                    //Checks to see if the fromPiece is on the CurrentTeam up to play
                    if (fromPiece.getTeamColor() == game.getCurrentTeam().getTeamColor()) {
                        //System.out.println("FromPiece is on curr team");
                        //Checks to see if the toSquare does not have a piece on it (is Empty()
                        if (game.getGameBoard().getSquares()[toSqrRow][toSqrCol].isEmpty()) {
                            //System.out.println("ToSquare is empty");
                            System.out.println("move successful");

                            valid = true;

                        }
                    }
                }
            }
        }
        //Spawn
        else if (action == 'S') {
            if (game.getGameBoard().inBounds(fromSqrRow, fromSqrCol)
                    && game.getGameBoard().inBounds(toSqrRow, toSqrCol)) {
                if(fromPiece != null) {
                    if (fromPiece.getTeamColor() == game.getCurrentTeam().getTeamColor()) {
                        if (game.getGameBoard().getSquares()[toSqrRow][toSqrCol].isEmpty()) {
                            //Checks if the piece is a PieceBuzz because Buzz can't spawn
                            if (!(fromPiece instanceof PieceBuzz)) {
                                valid = true;
                            }

                        }
                    }
                }
            }
        }
        else if (action == 'R') {
            if (game.getGameBoard().inBounds(fromSqrRow, fromSqrCol)
                    && game.getGameBoard().inBounds(toSqrRow, toSqrCol)) {
                if(fromPiece != null) {
                    if (fromPiece.getTeamColor() == game.getCurrentTeam().getTeamColor()) {
                        if (toPiece.getTeamColor() == game.getOpponentTeam().getTeamColor()) {
                            //Checks to see if fromPiece is buzz because buzz can't recruit
                            if (!(fromPiece instanceof PieceBuzz)) {
                                valid = true;
                            }
                        }
                    }
                }
            }
        }
        else if(action == 'A'){
            if (game.getGameBoard().inBounds(fromSqrRow, fromSqrCol)
                    && game.getGameBoard().inBounds(toSqrRow, toSqrCol)) {
                System.out.println("InBounds");
                if (fromPiece != null) {
                    System.out.println("fromPiece not null");
                    if (fromPiece.getTeamColor() == game.getCurrentTeam().getTeamColor()) {
                        System.out.println("From piece on current team");
                        //Checks to see if the piece on the to square is either an opponent piece or a minion piece
                        //(evil minions can attack minions on any team)
                        if (toPiece.getTeamColor() == game.getOpponentTeam().getTeamColor()
                                || toPiece instanceof PieceMinion) {
                            System.out.println("Checks that topiece is other team or minion");
                            //Checks to see if the square is empty
                            if (!(game.getGameBoard().getSquares()[toSqrRow][toSqrCol].isEmpty())) {
                                System.out.println("ToSquare has a piece");
                                if(fromPiece.validMovePath(fromSqrRow, fromSqrCol, toSqrRow, toSqrCol));
                                    System.out.println("Piece can move to the square");
                                    /*
                                    *Checks to see if fromPiece is a PieceBuzz as he can only attack with
                                    * a working laser
                                    */

                                    if (fromPiece instanceof PieceBuzz) {
                                        if (((PieceBuzz) fromPiece).canAttack()) {
                                            System.out.println("FromPiece is PieceBuzz who can attack");
                                            valid = true;
                                        }
                                    }
                                    /*
                                    * Checks to see if fromPiece is a PieceEvilMinion as they can only
                                    * attack if they are hungry
                                     */
                                    else if (fromPiece instanceof PieceEvilMinion) {
                                        if (((PieceEvilMinion) fromPiece).canAttack()) {
                                            System.out.println("FromPiece is evil minion that can attack");
                                            valid = true;
                                        }
                                    }
                                    //Checks to see if fromPiece is a PieceBlueHen
                                    else if (fromPiece instanceof PieceBlueHen) {
                                        System.out.println("FromPiece is PieceBlueHen");
                                        valid = true;
                                    }
                                    //PieceMinions cannot attack
                                }
                            }
                        }
                    }
                }
            }
        return valid;
    }
    public static void main(String[] arg){
        // Load the pieces in an ArrayList
        ArrayList<Piece> piecesTeamA = new ArrayList<>();
        piecesTeamA.add(new PieceMinion('M',"Blu",
                0,0,false,true));
        piecesTeamA.add(new PieceBuzz('B',"Blu",2,1,
                true,false,true));
        piecesTeamA.add(new PieceBlueHen('H',"Blu",3,
                9,false,true));
        piecesTeamA.add(new PieceEvilMinion('E',"Blu",1,
                1,4,false, true));
        // Create a team object
        Team teamA = new Team("Blu",piecesTeamA);

        // Create 4 pieces for team B
        // Load the pieces in an ArrayList
        ArrayList<Piece> piecesTeamB = new ArrayList<>();
        piecesTeamB.add(new PieceMinion('M',"Red",
                0,0,false,true));
        piecesTeamB.add(new PieceBlueHen('H',"Red",3,
                9,false,true));
        piecesTeamB.add(new PieceBuzz('B',"Red",2,1,
                true,false,true));
        piecesTeamB.add(new PieceEvilMinion('E',"Red",1,
                1,4,false, true));
        // Create a team object
        Team teamB = new Team("Red",piecesTeamB);

        // create a game
        GameS22 game = new GameS22(6,6,teamA,teamB);

        // clear Piece off the board
        for(int row = 0; row < game.getGameBoard().getNumRows();row++){
            for (int col = 0; col < game.getGameBoard().getNumColumns(); col++){
                game.getGameBoard().getSquares()[row][col].removePiece();
            }
        }
        System.out.println(game);

        // load your pieces in specific locations of your choice
        game.getGameBoard().getSquares()[3][0].setPiece(piecesTeamA.get(0));
        game.getGameBoard().getSquares()[3][1].setPiece(piecesTeamA.get(1));
        game.getGameBoard().getSquares()[0][2].setPiece(piecesTeamA.get(2));
        game.getGameBoard().getSquares()[3][3].setPiece(piecesTeamA.get(3));
        game.getGameBoard().getSquares()[5][0].setPiece(piecesTeamB.get(0));
        game.getGameBoard().getSquares()[5][1].setPiece(piecesTeamB.get(1));
        game.getGameBoard().getSquares()[2][2].setPiece(piecesTeamB.get(2));
        game.getGameBoard().getSquares()[5][3].setPiece(piecesTeamB.get(3));

        System.out.println(game);

        // Test some moves that should be valid
        // Test some moves that are invalid

        System.out.println("This should be a valid move");
        System.out.println(Rules.checkValidAction(game,
                0,0,
                1,4,'M'));

        System.out.println("To Square isn't empty - should not be a valid move");
        System.out.println(Rules.checkValidAction(game,
                0,0,
                0,1,'M'));
        System.out.println("This isn't current team's piece - should not be valid");
        System.out.println(Rules.checkValidAction(game,
                2,0,
                0,5,'M'));


        // You can change the turn to test the other team pieces
        game.changeTurn();

        System.out.println(Rules.checkValidAction(game,
                2,0,
                0,5,'M'));
        System.out.println("True");
        System.out.println("Testing buzz again");
        System.out.println(Rules.checkValidAction(game,
                2,2,
                0,2, 'A'));


    }
}
