/*
Diya Shah, Ella Wilkins, Gavin Caulfield
Lab 5
4/13/22
CISC181
 */
public class GameBoard {
    /**
     * Creates the gameboard from BoardSquares
     *
     * Three qualities are an integer for the number of rows and
     * squares made from a Two-Dimensional array for BoardSquares[][]
     *
     */
    private int rows;
    private int columns;
    private BoardSquare[][] squares;

    public GameBoard(int rows, int columns){
        /**
         * Two parameter constructor being and int for the rows and columns
         */
        this.rows = rows;
        this.columns = columns;
        this.squares = new BoardSquare[rows][columns];
        setUpEmptyBoard();
    }

    public int getNumRows() {
        return rows;
    }

    public int getNumColumns() {
        return columns;
    }

    public BoardSquare[][] getSquares() {
        return squares;
    }
    public boolean inBounds(int rows, int columns){
        /**
         * When altering a BoardSquare, we must first make sure it is inbounds
         * inBounds checks if a BoardSquare fits within the parameters given to the GameBoard
         * @param rows is the int for the amount of rows
         * @param columns is the int for the amount of columns
         */
        boolean in = false;
        if(rows >= 0 || columns >= 0) {
            if (rows <= (this.rows - 1)) {
                if (columns <= (this.columns - 1)) {
                    in = true;
                }
            }
        }
        return in;
    }
    private void setUpEmptyBoard(){
        /**
         * Sets up a board without any pieces attached
         */
        boolean brk = true;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(brk){
                    squares[i][j] = new BoardSquare("White");
                }
                else{
                    squares[i][j] = new BoardSquare("Black");
                }
                brk = !brk;
            }
            brk = !brk;
        }
    }
    public BoardSquare findRandomEmptySpace() {
        /**
         * Looks for a space on the gameboard without a piece attached
         */
        boolean brk = false;
        BoardSquare boardsquare = null;
        while (!brk) {
            int row = (int)(Math.random() * rows);
            int col = (int)(Math.random() * rows);
            boardsquare = squares[row][col];
            brk = boardsquare.isEmpty();
        }
        return boardsquare;
    }
    @Override
    public String toString(){
        StringBuilder boardString = new StringBuilder();
        boardString.append("Col :       ");

        for(int col = 0; col < squares[0].length; col++){
            boardString.append(col + "        ");
        }
        boardString.append("\n");
        for(int row = 0; row < squares.length; row++){
            boardString.append("Row : " + row + "   ");
            for(int col = 0; col < squares[row].length; col++){
                boardString.append(squares[row][col].toString() + "  ");
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }


}


