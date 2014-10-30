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
    // Test number of players
    public void testNumberOfPlayers(){
        Board board = new Board();
        assertEquals(1, board.getPlayers());
    }

    @Test
    // Test if changePlayer function swiches to correct player.
    public void testChangePlayers(){
        Board board = new Board();
        board.changePlayers();
        assertEquals(2, board.getPlayers());
        board.changePlayers();
        assertEquals(1, board.getPlayers()); 
    }

    @Test
    // Test if player is initialized.
    public void testInitializePlayer(){
        Board board = new Board();
        board.changePlayers();
        board.initializePlayer();
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

    @Test
    // Test if the game field prints out the whitespaces of the grid on the correct form
    public void testGameField(){
        Board board = new Board();
        int column = 0;
        int row = 0;

        StringBuilder test = board.writeGameField();

        for (int j = 0; j < 30; j = j + 3){
            if (j == 9 || j == 19 || j == 29){
                assertEquals('\n', test.charAt(j));
                j++;
                row++;
                column = 0;
            } else {
                assertEquals('[', test.charAt(j));
                assertEquals(board.getGrid()[row][column], test.charAt(j + 1));
                assertEquals(']', test.charAt(j + 2));
            }
            column++;
        }
    }
}
