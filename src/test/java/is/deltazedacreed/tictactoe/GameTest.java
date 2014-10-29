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
    public void testChangePlayer(){
        Game test = new Game();
        Board board = new Board();
        test.changePlayer(board);
        assertEquals(2, board.players);
        test.changePlayer(board);
        assertEquals(1, board.players); 
       }

}
