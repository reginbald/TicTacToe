// Copyright (c) 2014 Delta Zeda Creed.

package is.deltazedacreed.tictactoe;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Class that tests the class Game.
 */
public class GameTest{

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
        game.insert(0, 2);
        game.changePlayer();
        game.insert(2, 2);

        StringBuilder test = game.board.writeGameField();

        for (int j = 0; j < 30; j = j + 3){
            if (j == 9 || j == 19 || j == 29){
                assertEquals('\n', test.charAt(j));
                j++;
                row++;
                column = 0;
            } else {
                assertEquals('[', test.charAt(j));
                assertEquals(game.board.grid[row][column], test.charAt(j + 1));
                assertEquals(']', test.charAt(j + 2));
            }
            column++;
        }
    }
}
