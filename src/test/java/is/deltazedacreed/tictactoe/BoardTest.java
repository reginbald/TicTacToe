// Copyright (c) 2014 Delta Zeda Creed.

package is.deltazedacreed.tictactoe;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Class constructor that tests the class Board.
 */
public class BoardTest{

    @Test
    // Test number of columns of grid
    public void testGridColumns(){
        Board board = new Board();
        assertEquals(3, board.grid[0].length);
    }

    @Test
    // Test number of rows of grid
    public void testGridRows(){
        Board board = new Board();
        assertEquals(3, board.grid.length);
    }

    @Test
    // Test number of players
    public void testNumberOfPlayers(){
        Board board = new Board();
        assertEquals(1, board.players);
    }

    @Test
    // Test if grid is empty, that is, each grid square is a whitespace.
    public void testGridIsEmpty(){
        Board board = new Board();
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                assertEquals(' ', board.grid[i][j]);
            }
        }
    }

    @Test
    // Test if the game field prints out the whitespaces of the grid on the correct form
    public void testGameField(){
        Board board = new Board();
        for (int j = 0; j < 30; j++){
            if (j == 9 || j == 19 || j == 29){
                assertEquals('\n', board.gameField.charAt(j));
            } else {
                assertEquals('[', board.gameField.charAt(j));
                assertEquals(' ', board.gameField.charAt(++j));
                assertEquals(']', board.gameField.charAt(++j));
            }
        }
    }
}
