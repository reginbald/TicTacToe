// Copyright (c) 2014 Delta Zeda Creed.

package is.deltazedacreed.tictactoe;

import java.util.Scanner;

/**
 * Class that runs the game, TicTacToe.
 */
public class Game{

    private static Board board;
    public static boolean playAgain;
    public static StringBuilder gameField;
    private static Scanner scanInt;
    private static Scanner scanString;

    // Constructor
    public Game(){
        setBoard(new Board());
        playAgain = true;
        gameField = new StringBuilder();
        scanInt = new Scanner(System.in);
        scanString = new Scanner(System.in);
    }

    // Changes player, if player 1 is currently playing, the function switches to player 2
    public void changePlayers(){
        if (Board.getPlayers() == 1){
            Board.setPlayers(2);
        } else {
            Board.setPlayers(1);
        }
    }

    // Insert a player's character at the correct place.
    public void insert(int x, int y){
        if (Board.getPlayers() == 1){
            Board.getGrid()[x][y] = 'o';
        } else {
            Board.getGrid()[x][y] = 'x';
        }
    }

    // Check if input is valid.
    public static boolean isValidInput(int x, int y){
        if (x >= 0 && x <= 2 && y >= 0 && y <= 2){
            if (Board.getGrid()[x][y] == ' ') {
                return true;
            }
        }
        return false;
    }

    // Check if there's a row with the same characters
    public static boolean winRow(){
        for (int i = 0; i < 3; i++){
            if (Board.getGrid()[0][i] == ' '){
                break;
            } else if (Board.getGrid()[0][i] == Board.getGrid()[1][i]){ 
                if (Board.getGrid()[1][i] == Board.getGrid()[2][i]){
                    return true;
                }
            }
        }
        return false;
    }

    // Check if there's a column with the same characters
    public static boolean winColumn(){
        for (int i = 0; i < 3; i++){
            if (Board.getGrid()[i][0] == ' '){
                break;
            } else if (Board.getGrid()[i][0] == Board.getGrid()[i][1]){
                if (Board.getGrid()[i][1] == Board.getGrid()[i][2]){
                    return true;
                }
            }
        }
        return false;
    }

    // check if there's a diagonal line with the same charachters
    public static boolean winCross(){
        if (Board.getGrid()[1][1] == ' '){
            return false;
        } else if (Board.getGrid()[0][0] == Board.getGrid()[1][1]){
            if (Board.getGrid()[1][1] == Board.getGrid()[2][2]){
                return true;
            }
        } else if (Board.getGrid()[0][2] == Board.getGrid()[1][1]){
            if (Board.getGrid()[1][1] == Board.getGrid()[2][0]){
                return true;
            }
        }
        return false;
    }

    // Check if someone has won
    public static boolean winner(){
        if (winColumn() || winRow() || winCross()){
            return true;
        }
        return false;
    }

    // Check if there's tie, that is no square left to insert.
    public static boolean tie(){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (Board.getGrid()[i][j] == ' '){
                    return false;
                }
            }
        }
        return true;
    }

    // Main function that runs the game
    public static void main(String[] args){
        Game game = new Game();
        int x;
        int y;

        // Start the game
        System.out.println("Welcome to the game TicTacToe!");
        
        while (playAgain){
            // While the game hasn't ended yet
            while (!Game.winner() && !Game.tie()){
                System.out.println(gameField.toString());
                System.out.print("Player " + Board.getPlayers());
                System.out.println(": Where do you want to insert? (row column)");
                x = scanInt.nextInt();
                y = scanInt.nextInt();
                
                // Insert if input is valid
                if (Game.isValidInput(x, y)){
                    game.insert(x, y);
                    gameField = Game.getBoard().writeGameField();
                    game.changePlayers();
                } else {
                    System.out.println("Location is not valid. Please try again.");
                }
            }
            
            System.out.println(gameField.toString());

            // Check whether someone has won or if there's a tie
            if (Game.winner()){
                System.out.println("Player" + Board.getPlayers() + " wins!");
            } else {
                System.out.println("It's a tie!");
            }
            
            scanString = new Scanner(System.in);
            System.out.println("Do you want to play again? yes/no");
            String answer = scanString.nextLine();
            if (answer.equals("no")){
                playAgain = false;
                return;
            }
            
            // Initialize the game for a new game
            Game.getBoard().initializePlayer();
            Board.initializeGrid();
            gameField = Game.getBoard().writeGameField();
        }
    }

    public static Board getBoard() {
        return board;
    }

    public static void setBoard(Board board) {
        Game.board = board;
    }
}
