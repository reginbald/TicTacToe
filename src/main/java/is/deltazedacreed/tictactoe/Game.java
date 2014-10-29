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

    public void changePlayer(){
        if (board.players == 1){
            board.players = 2;
        } else {
            board.players = 1;
        }
    }


    public static void main(String[] args){

    }
}
