// Copyright (c) 2014 Delta Zeda Creed.

package is.deltazedacreed.tictactoe;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Class constructor that tests the class Game.
 */
public class GameTest{

    // Test the changePlayer function.
    @Test
    public void testChangePlayer(){
        Game game = new Game();
        Board board = new Board();
        game.changePlayer(board);
        assertEquals(2, board.players);
        game.changePlayer(board);
        assertEquals(1, board.players); 
    }

    // Test if the insert function inserts the correct letter.
    @Test
    public void testInsert(){
        Game game = new Game();
        Board board = new Board();
        game.insert(0, 1);

        if(board.players == 1){
            assertEquals('o', board.grid[0][1]);
        } else {
            assertEquals('x', board.grid[0][1]);
        }
    }
}
