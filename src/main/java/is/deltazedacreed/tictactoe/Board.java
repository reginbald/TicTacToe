// Copyright (c) 2014 Delta Zeda Creed.

package is.deltazedacreed.tictactoe;

/**
 * Class constructor specifying the board of the game, TicTacToe.
 */
public class Board{

    public static char grid[];
    public static int players;

    // Constructor
    public Board(){
        grid = new char[9];
        players = 1;
    }
}
