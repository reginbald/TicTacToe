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
        setPlayers(1);
        initializeGrid();
    }

    // Initialize grid. Insert whitespaces in every grid square.
    public static void initializeGrid(){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                getGrid()[i][j] = ' ';
            }
        }
    }

    // Initialize who's turn it is when the game is played again.
    public void initializePlayer(){
        if (getPlayers() == 2){
            setPlayers(1);
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
