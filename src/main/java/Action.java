/**
 * Lab 7 - Diya Shah, Gavin C, Ella W
 * CISC181
 * May 4, 2022
 */


public abstract class Action {
    /*
    abstract class
    five protected fields - game type, int fromRow, fromColumn,
    toRow, toColumn
     */
    protected GameS22 game;
    protected int fromRow , fromColumn , toRow, toColumn;

    public Action (GameS22 game, int fromRow, int fromColumn, int toRow, int toColumn){
        /*
        5 param constructor- initializes/sets the 5 properties
         */
        this.game  = game;
        this.fromRow = fromRow;
        this.fromColumn = fromColumn;
        this.toRow = toRow;
        this.toColumn = toColumn;
    }
    public abstract void performAction(); //abstract method , no param and return
}