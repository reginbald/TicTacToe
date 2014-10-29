// Copyright (c) 2014 Delta Zeda Creed.

package is.deltazedacreed.tictactoe;

/**
 * Class constructor specifying the board of the game, TicTacToe.
 */
public class Board{

    public static char grid[][];
    public static int players;
    public static StringBuilder gameField;

    // Constructor
    public Board(){
        grid = new char[3][3];
        players = 1;
        initializeGrid();
        gameField = new StringBuilder();
        gameField = writeGameField();
    }

    // Initialize grid. Insert whitespaces in every grid square.
    private void initializeGrid(){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                grid[i][j] = ' ';
            }
        }
    }

    // Initialize game field.
    private StringBuilder writeGameField(){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                gameField.append("[" + grid[i][j] + "]");
            }
            gameField.append("\n");
        }
        return gameField;
    }
}
