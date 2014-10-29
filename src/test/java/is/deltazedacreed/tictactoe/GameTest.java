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

    // Test if the characters are inserted at the correct places
    @Test
    public void testInsertedGameField(){
        Game game = new Game();
        int column = 0;
        int row = 0;

        game.insert(0, 1);
        game.changePlayer();
        game.insert(0, 3);
        game.changePlayer();
        game.insert(3, 3);

        for (int j = 0; j < 30; j++){
            if (j == 9 || j == 19 || j == 29){
                row++;
                column = 0;
                assertEquals('\n', game.board.gameField.charAt(j));
            } else {
                assertEquals('[', game.board.gameField.charAt(j));
                assertEquals(game.board.grid[row][column], game.board.gameField.charAt(++j));
                assertEquals(']', game.board.gameField.charAt(++j));
                column++;
            }
        }
    }
}
