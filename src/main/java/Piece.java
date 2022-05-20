/*
Diya Shah, Ella Wilkins, Gavin Caulfield
Lab 5
4/13/22
CISC181
 */
public abstract class Piece {
    /*abstract class that other classes extend to
    4 protected fields that all extended classes use
     */

    protected char symbol;
    protected String teamColor;
    protected boolean hidden ;
    protected boolean original;
    public Piece (char symbol, String teamColor, boolean hidden, boolean original){
        /*
        4 param constructor- sets these attributes
         */
        this.symbol=symbol;
        this.teamColor=teamColor;
        this.hidden=hidden;
        this.original=original;
    }
    public char getSymbol(){return symbol;}
    public String getTeamColor(){ return teamColor;}
    public boolean isHidden(){return hidden;}
    public boolean isOriginal(){return original;}
    public void setTeamColor(String teamColor){this.teamColor = teamColor;}
    public void setSymbol(char symbol){this.symbol = symbol;}
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
    public void setOriginal(boolean original) {
        this.original = original;
    }

    public abstract void speak();
    //abstract class, 0 param

    public abstract boolean validMovePath(int fromSquareRow, int fromSquareCol,
                                          int toSquareRow, int toSquareCol);
    //abstract bool class, 4 param

    public abstract boolean canSpawn();
    public abstract Piece spawn();
    @Override
    public String toString() {
        return this.teamColor + " " + this.symbol;
    }
}