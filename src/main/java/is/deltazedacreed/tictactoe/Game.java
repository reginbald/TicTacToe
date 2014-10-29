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
<<<<<<< HEAD

    // Determines which player's turn it is.
=======
    // Changes player, if player 1 is currently playing, the function switches to player 2
>>>>>>> ff575249a2ee9e8865eeb2b6734f9567cb45ca8d
    public void changePlayer(){
        if (board.players == 1){
            board.players = 2;
        } else {
            board.players = 1;
        }
    }

    // Insert a player's character at the correct place.
    public void insert(int x, int y){
        if (board.players == 1){
            board.grid[x][y] = 'o';
        } else {
            board.grid[x][y] = 'x';
        }
    }

    public static void main(String[] args){

    }
}
