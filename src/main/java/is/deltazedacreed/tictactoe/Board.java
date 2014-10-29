// Copyright (c) 2014 Delta Zeda Creed.

package is.deltazedacreed.tictactoe;

/**
 * Class constructor specifying the board of the game, TicTacToe.
 */
public class Board{

    public static char grid[][];
    public static int players;

    // Constructor
    public Board(){
        grid = new char[3][3];
        players = 1;
        initializeGrid();
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
    public StringBuilder writeGameField(){
        StringBuilder gameField = new StringBuilder();

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                gameField.append("[" + grid[i][j] + "]");
            }
            gameField.append("\n");
        }
        return gameField;
    }

    // Changes player, if player 1 is currently playing, the function switches to player 2
    public void changePlayer(){
        if (board.players == 1){
            board.players = 2;
        } else {
            board.players = 1;
        }
    }
}
