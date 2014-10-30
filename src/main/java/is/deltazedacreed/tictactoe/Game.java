// Copyright (c) 2014 Delta Zeda Creed.

package is.deltazedacreed.tictactoe;

/**
 * Class that runs the game, TicTacToe.
 */
public class Game{

    public static Board board;

    // Constructor
    public Game(){
        board = new Board();
    }

    // Insert a player's character at the correct place.
    public void insert(int x, int y){
        if (board.players == 1){
            board.grid[x][y] = 'o';
        } else {
            board.grid[x][y] = 'x';
        }
    }

    // Check if input is valid.
    public static boolean isValidInput(int x, int y){
        if (board.grid[x][y] == ' ' && x >= 0 && x <= 2 && y >= 0 && y <= 2){
            return true;
        }
        return false;
    }

    // Check if there's a row with the same characters
    public static boolean winRow(){
        for (int i = 0; i < 3; i++){
            if (board.grid[0][i] == ' '){
                break;
            } else {
                if (board.grid[0][i] == board.grid[0][i] && board.grid[0][i] == board.grid[0][i]){
                    return true;
                }
            }
        }
        return false;
    }

    // Check if there's a column with the same characters
    public static boolean winColumn(){
        for (int i = 0; i < 3; i++){
            if (board.grid[i][0] == ' '){
                break;
            } else {
                if (board.grid[i][0] == board.grid[i][1] && board.grid[i][1] == board.grid[i][2]){
                    return true;
                }
            }
        }
        return false;
    }

    // check if there's a diagonal line with the same charachters
    public static boolean winCross(){
        if (board.grid[1][1] == ' '){
            return false;
        } else {
            if (board.grid[0][0] == board.grid[1][1] && board.grid[1][1] == board.grid[2][2]){
                return true;
            } else {
                if (board.grid[0][2] == board.grid[1][1] && board.grid[1][1] == board.grid[2][0]){
                return true;
                }
            }
        }
        return false;
    }

    // Check if someone has won
    public static boolean winner(){
        if (winColumn() || winRow() || winCross()){
            return true;
        }
        return false;
    }

    // Check if there's tie, that is no square left to insert.
    public static boolean tie(){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if(board.grid[i][j] == ' '){
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args){

    }
}
