/*
Diya Shah, Ella Wilkins, Gavin Caulfield
Lab 5
4/13/22
CISC181
 */
public class PieceEvilMinion extends PieceMinion implements Attacker, Recruiter{
    /*
    extended class- includes all features from PieceMinion
    3 protected fields
     */
    protected int numAttacks;
    protected boolean hungry;
    protected int max_num_attacks=4;


    public PieceEvilMinion(char symbol, String teamColor,
                           int numRecruits, int numAttacks, int numTimesSpawned,
                           boolean hidden, boolean original){
        /*
        7 param constructor
        uses super to get features from PieceMinion class
         */

        super(symbol,teamColor,numRecruits,numTimesSpawned,hidden,original);
        this.numAttacks=numAttacks;
        updateHungry();
    }
    public PieceEvilMinion(){/*
        no param constructor
        creates a new default piece
         */

        this('E',"NON",0,0,0,false,true);
    }
    public boolean canAttack() {
        return hungry;
    }
    public int getNumAttacks(){return numAttacks;}
    public void setTeamColor(String teamColor) {
        this.teamColor = teamColor;
    }
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
    public void setNumAttacks(int numAttacks) {
        this.numAttacks = numAttacks;
    }
    public void setNumTimesSpawned(int numTimesSpawned) {
        this.numTimesSpawned = numTimesSpawned;
    }
    public void updateHungry() {
        if (max_num_attacks<4){
            this.hungry=true;
        }
    }
    public void speak(){
        /*
        prints Roar!
        no return/no param
         */

        System.out.println("Roar!");
    }
    public boolean validMovePath(){
        return true;
    }
    public PieceEvilMinion spawn(){
        //returns new object, no param
        return new PieceEvilMinion(Character.toLowerCase(this.symbol),this.teamColor,1,0,0,false,false);
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
