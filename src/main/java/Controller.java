import java.util.ArrayList;

public class Controller {
    private GameS22 game;
    private TextView txt;
    public GameS22 setUpGameModel(){
        // Create 4 pieces for team A

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

        // Create an instance of the game
        return new GameS22(8, 8,teamA, teamB);
    }

    public Controller(){
        game = setUpGameModel();
        txt = new TextView();
        txt.updateView(game);
    }

    /**
     * Creates an instance of any of the Action types and calls performAction
     * @param fromRowIndex starting row index of the piece
     * @param fromColIndex starting column index of the piece
     * @param toRowIndex ending row index of the piece
     * @param toColIndex ending column index of the piece
     * @param action the action the piece will perform
     */

    public void carryOutAction(int fromRowIndex, int fromColIndex, int toRowIndex, int toColIndex, char action){
        if(action == 'M'){
            ActionMove mv = new ActionMove(game, fromRowIndex, fromColIndex, toRowIndex, toColIndex);
            mv.performAction();
        }
        if(action == 'A'){
            ActionAttack at = new ActionAttack(game, fromRowIndex, fromColIndex, toRowIndex, toColIndex);
            at.performAction();
        }
        if(action == 'R'){
            ActionRecruit rc = new ActionRecruit(game, fromRowIndex, fromColIndex, toRowIndex, toColIndex);
            rc.performAction();
        }
        if(action == 'S'){
            ActionSpawn sp = new ActionSpawn(game, fromRowIndex, fromColIndex, toRowIndex, toColIndex);
            sp.performAction();
        }
    }

    public void playGame() {
        boolean gmOver = false;
        boolean validAction = false;
        while (!gmOver) {
            do {
                txt.getNextPlayersAction(game);
                if (Rules.checkValidAction(game, txt.getFromRowIndex(), txt.getFromColIndex(), txt.getToRowIndex(), txt.getToColIndex(), txt.getAction())) {
                    validAction = true;
                }
            }while(!validAction);




            carryOutAction(txt.getFromRowIndex(), txt.getFromColIndex(), txt.getToRowIndex(), txt.getToColIndex(), txt.getAction());
            txt.updateView(game);
            if (game.isGameEnded()) {
                gmOver = true;
            }
        }
    }
    public static void main(String[] args){
        Controller newgame = new Controller();
        newgame.playGame();
    }

}
