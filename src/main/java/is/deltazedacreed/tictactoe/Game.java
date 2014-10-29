// Copyright (c) 2014 Delta Zeda Creed.

package is.deltazedacreed.tictactoe;
//import package.Board.java;

/**
 * Class that runs the game, TicTacToe.
 */
public class Game{

     public void changePlayer(Board board){
        if (board.players == 1){
            board.players = 2;
        } else {
            board.players = 1;
        }
    }

    public static void main(String[] args){
        Board board = new Board();

    }
}
