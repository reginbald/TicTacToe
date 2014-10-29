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
        game.changePlayer();
        assertEquals(2, game.board.players);
        game.changePlayer();
        assertEquals(1, game.board.players); 
    }

    // Test if the insert function inserts the correct letter.
    @Test
    public void testInsert(){
        Game game = new Game();
        game.insert(0, 1);

        if (game.board.players == 1){
            assertEquals('o', game.board.grid[0][1]);
        } else {
            assertEquals('x', game.board.grid[0][1]);
        }
    }
}
