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
        if (x >= 0 && x <= 2 && y >= 0 && y <= 2){
            return true;
        }
        return false;
    }

    // Check if there's a row with the same characters
    public static boolean winRow(){
        for (int i = 0; i < 3; i++){
            if (grid[i][0] != ' ' && grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2]){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){

    }
}
