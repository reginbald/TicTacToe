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
}
