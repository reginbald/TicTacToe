// Copyright (c) 2014 Delta Zeda Creed.

package is.deltazedacreed.tictactoe;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Class that tests the class Board.
 */
public class BoardTest{

    @Test
    // Test number of columns of grid
    public void testGridColumns(){
        Board board = new Board();
        assertEquals(3, board.getGrid()[0].length);
    }

    @Test
    // Test number of rows of grid
    public void testGridRows(){
        Board board = new Board();
        assertEquals(3, board.getGrid().length);
    }

    @Test
    // Test which player begins the game
    public void testWhoBegins(){
        Board board = new Board();
        assertEquals(1, board.getPlayers());
    }

    @Test
    // Test if grid is empty, that is, each grid square is a whitespace.
    public void testGridIsEmpty(){
        Board board = new Board();
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                assertEquals(' ', board.getGrid()[i][j]);
            }
        }
    }
}
