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
    private boolean isValidInput(int x, int y){
        if(x >= 0 && x <= 2 && y >= 0 && y <= 2){
            return true;
        }
        return false;
    }

    public static void main(String[] args){

    }
}
