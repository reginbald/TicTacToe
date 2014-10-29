// Copyright (c) 2014 Delta Zeda Creed.

package is.deltazedacreed.tictactoe;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
//import package.Board.java;

/**
 * Class constructor that tests the class Game.
 */
public class GameTest{
    //
    @Test
    public void testChangePlayer() {
    	Game test = new Game();
    	test.players = 1;
    	test.changePlayer();
    	assertEquals(2, test.players);
    	test.changePlayer();
    	assertEquals(1, test.players); 
   	}



}
