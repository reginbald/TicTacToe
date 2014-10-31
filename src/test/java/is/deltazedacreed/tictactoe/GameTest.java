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

        if (game.getBoard().getPlayers() == 1){
            assertEquals('o', game.getBoard().getGrid()[0][1]);
        } else {
            assertEquals('x', game.getBoard().getGrid()[0][1]);
        }
    }

    // Test if the characters are inserted at the correct places
    @Test
    public void testInsertedGameField(){
        Game game = new Game();
        int column = 0;
        int row = 0;

        game.insert(0, 1);
        game.getBoard().changePlayers();
        game.insert(0, 2);
        game.getBoard().changePlayers();
        game.insert(2, 2);

        StringBuilder test = game.getBoard().writeGameField();

        for (int j = 0; j < 30; j = j + 3){
            if (j == 9 || j == 19 || j == 29){
                assertEquals('\n', test.charAt(j));
                j++;
                row++;
                column = 0;
            } else {
                assertEquals('[', test.charAt(j));
                assertEquals(game.getBoard().getGrid()[row][column], test.charAt(j + 1));
                assertEquals(']', test.charAt(j + 2));
            }
            column++;
        }
    }

    @Test
    // Make sure the input is valid
    public void testInput(){
        Game game = new Game();
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                assertEquals(true, game.isValidInput(i, j));
            }
       }
    }

    @Test
    // Test if input is out of range
    public void testOutOfRangeInput(){
        Game game = new Game();
        assertEquals(false, game.isValidInput(0, 3));
    }

    @Test
    // Make sure that one can't insert into a non-empty grid square
    public void testInputWithNonEmptySquare(){
        Game game = new Game();
        game.insert(0, 1);
        assertEquals(false, game.isValidInput(0, 1));
    }

    @Test
    // Check the winRow function
    public void testWinRow(){
        Game game = new Game();
        game.insert(0, 0);
        game.insert(1, 0);
        game.insert(2, 0);
        assertEquals(true, game.winRow());
    }

    @Test
    // Check the winColumn function
    public void testWinColumn(){
        Game game = new Game();
        game.insert(0, 0);
        game.insert(0, 1);
        game.insert(0, 2);
        assertEquals(true, game.winColumn());
    }

    @Test
    // Check the WinCross function
    public void testWinCross(){
        Game game = new Game();

        game.insert(0, 0);
        game.insert(1, 1);
        game.insert(2, 2);
        assertEquals(true, game.winCross());
    }
    @Test
    public void testWinCross2(){
        Game game = new Game();
        game.insert(0, 2);
        game.insert(1, 1);
        game.insert(2, 0);
        assertEquals(true, game.winCross());
    }
    @Test
    public void testWinCross3(){
        Game game = new Game();
        game.insert(1, 1);
        assertEquals(false, game.winCross());
    }

    @Test
    // check if wincross gives true when it shouldn't
    public void testNoWinCross(){
        Game game = new Game();
        game.insert(0, 0);
        game.insert(0, 1);
        game.insert(0, 2);
        assertEquals(false, game.winCross());
    }

    @Test
    // check if wincross returns false if the board is empty
    public void testEmptyWinCross(){
        Game game = new Game();
        assertEquals(false, game.winCross());
    }

    @Test
    // Check if winner function returns false when no one has won
    public void testNoWinner(){
        Game game = new Game();
        game.insert(0, 1);
        assertEquals(false, game.winner());
    }

    @Test
    // Check if the winner function gets that someone has won a row
    public void testRowWinner(){
        Game game = new Game();
        game.insert(0, 0);
        game.insert(0, 1);
        game.insert(0, 2);
        assertEquals(true, game.winner());
    }

    @Test
    // Check if the winner function gets that someone has won a column
    public void testColWinner(){
        Game game = new Game();
        game.insert(0, 0);
        game.insert(1, 0);
        game.insert(2, 0);
        assertEquals(true, game.winner());
    }

    @Test
    // Check if the winner function gets that someone has won a cross
    public void testCrossWinner(){
        Game game = new Game();
        game.insert(0, 0);
        game.insert(1, 1);
        game.insert(2, 2);
        assertEquals(true, game.winner());
    }

    @Test
    // Check if there's tie
    // o o x
    // x x o
    // o o x
    public void testTie(){ 
        Game game = new Game();
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 2; j++){
                game.insert(i, j);
            }
            game.getBoard().changePlayers();
            game.insert(i, 2);
        }
        assertEquals(true, game.tie());
    }
}
