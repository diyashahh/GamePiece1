/*
Diya Shah, Ella Wilkins, Gavin Caulfield
Lab 5
4/13/22
CISC181
 */
public class PieceBlueHen extends Piece implements Attacker, Recruiter{
    /*
    extended class- has 4 fields, includes everything from Piece
     */
    private int numAttacks;
    private int numRecruits;
    private boolean flies;

    final public int MAX_NUM_ATTACKS = 3;

    public PieceBlueHen (char symbol,
                         String teamColor,
                         int numAttacks, int numRecruits,
                         boolean hidden, boolean original){
        /*
        6 param constructor
        calls super- uses abstract class for some features
        no return
         */
        super(symbol,teamColor,hidden,original);
        this.numAttacks = numAttacks;
        this.numRecruits = numRecruits;
        updateFly();
    }

    public PieceBlueHen ()  {
        /*
        no param
        creates new instance w unique features
         */
        this('H',"NON",
                0,0,
                false,true);
    }

    public char getSymbol() {
        return symbol;
    }
    public String getTeamColor() {
        return teamColor;
    }
    public int getNumAttacks()    {
        return this.numAttacks;
    }
    public int getNumRecruits(){
        return this.numRecruits;
    }
    public boolean isHidden() {
        return hidden;
    }
    public boolean isOriginal() {
        return original;
    }
    public boolean canFly()    {
        return this.flies;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
    public void setTeamColor(String teamColor) {
        this.teamColor = teamColor;
    }

    public void setNumAttacks(int numAttacks)    {
        this.numAttacks = numAttacks;
        updateFly();
    }




    public void setNumRecruits(int numRecruits)    {
        this.numRecruits = numRecruits;
    }



    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
    public void setOriginal(boolean original) {
        this.original = original;
    }

    private void updateFly()    {
        /*
        determines if piece is able to  fly or not based on
        amount of numAttacks
         */

        if (this.numAttacks < MAX_NUM_ATTACKS){
            this.flies = true;
        }
        else {
            this.flies = false;
        }
    }
    public void speak(){

        /*
        prints go UD!
        no return/param
         */
        System.out.println("Go UD!");
    }

    public boolean validMovePath(int fromSquareRow, int fromSquareCol,
                                 int toSquareRow, int toSquareCol) {
        // You will implement this method in a later step
        // each Piece will have a different valid path
        return true;
    }

    public PieceBlueHen spawn()    {
        /*
        spawns piece! creates new
        returns PieceBlueHen, no param
         */

        PieceBlueHen copyHen =
                new PieceBlueHen(Character.toLowerCase(this.symbol),
                        this.teamColor,this.numAttacks,this.numRecruits,
                        false,false);
        return copyHen;
    }

    public boolean canSpawn(){

        /*
        returns bool, no param
         */
        return true;
    }
    @Override
    public boolean validRecruitPath(int RRrow, int RRcol, int RDrow, int RDcol) {
        return true;
    }
    @Override
    public boolean validAttackPath(int ARrow, int ARcol, int ADrow, int ADcol) {
        return true;
    }


}
