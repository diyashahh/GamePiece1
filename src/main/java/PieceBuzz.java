/*
Diya Shah, Ella Wilkins, Gavin Caulfield
Lab 5
4/13/22
CISC181
 */
public class PieceBuzz extends Piece implements Attacker{
    //extended class - has 3 member fields, includes everything from Piece

    private int numAttacks;
    private int numTimesBeenAttacked;
    private boolean workingLaser;


    public PieceBuzz(char symbol,
                     String teamColor,
                     int numAttacks,
                     int numTimesBeenAttacked,
                     boolean workingLaser,
                     boolean hidden,
                     boolean original) {
        /*
        7 param constructor
        calls super- uses abstract class for some features
        no return

         */
        super(symbol,teamColor,hidden,original);
        this.numAttacks = numAttacks;
        this.numTimesBeenAttacked = numTimesBeenAttacked;
        this.workingLaser = workingLaser;
    }

    public PieceBuzz(){
        /*
        no param, sets new qualities, no return
         */
        this('B',"- -",
                0,0,
                true, false, true);
    }

    public char getSymbol() {
        return symbol;
    }
    public String getTeamColor() {
        return teamColor;
    }
    public int getNumAttacks() {
        return numAttacks;
    }
    public int getNumTimesBeenAttacked() {
        return numTimesBeenAttacked;
    }
    public boolean canAttack(){
        return workingLaser;
    }
    public boolean isHidden() {
        return hidden;
    }
    public boolean isOriginal(){ return original;}

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
    public void setTeamColor(String teamColor) {
        this.teamColor = teamColor;
    }
    public void setWorkingLaser(boolean workingLaser) {
        this.workingLaser = workingLaser;
    }
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
    public void setOriginal(boolean original) {
        this.original = original;
    }

    public void setNumAttacks(int numAttacks)  {
        this.numAttacks = numAttacks;
    }

    public void updateNumTimesBeenAttacked(){
        /*
        updates num times attacked and set laser to false
        no return and no param
         */
        this.numTimesBeenAttacked += 1;
        this.workingLaser = false;
    }

    public void speak(){

        /*
        prints to infinity and beyond
        no return and param
         */System.out.println("To Infinity and Beyond!");
    }

    public boolean validMovePath(int fromSquareRow, int fromSquareCol,
                                 int toSquareRow, int toSquareCol) {
        // You will implement this method in a later step
        // each Piece will have a different valid path
        //returns bool
        return true;
    }
    public Piece spawn(){

        //no param and returns null Piece
        return null;
    }
    public boolean canSpawn(){

        //returns bool and no param
        return false;
    }
    @Override
    public boolean validAttackPath(int ARrow, int ARcol, int ADrow, int ADcol) {
        return true;
    }

}
