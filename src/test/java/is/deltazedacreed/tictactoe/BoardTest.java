// Copyright (c) 2014 Delta Zeda Creed.

package is.deltazedacreed.tictactoe;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Class constructor that tests the class Board.
 */
public class BoardTest{

    @Test
    // Test size of grid
    public void testGridSize(){
        Board board = new Board();
        assertEquals(9, board.grid.length);
    }

    @Test
    // Test number of players
    public void testNumberOfPlayers(){
        Board board = new Board();
        assertEquals(1, board.players);
    }
}
