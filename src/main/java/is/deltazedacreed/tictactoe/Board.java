// Copyright (c) 2014 Delta Zeda Creed.

package is.deltazedacreed.tictactoe;

/**
 * Class constructor specifying the board of the game, TicTacToe.
 */
public class Board{

    private static char grid[][];
    private static int players;

    // Constructor
    public Board(){
        setGrid(new char[3][3]);
        initializeGrid();
        setPlayers(1);
    }

    // Initialize grid. Insert whitespaces in every grid square.
    private static void initializeGrid(){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                getGrid()[i][j] = ' ';
            }
        }
    }

    public static int getPlayers() {
        return players;
    }

    public static void setPlayers(int players) {
        Board.players = players;
    }

    public static char[][] getGrid() {
        return grid;
    }

    public static void setGrid(char grid[][]) {
        Board.grid = grid;
    }
}
