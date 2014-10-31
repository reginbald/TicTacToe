/*
 * Copyright (c) 2014 Delta Zeda Creed.
 */
package is.deltazedacreed.tictactoe;

import static spark.Spark.*;
import spark.*;
import spark.servlet.SparkApplication;

/**
 * Class turns the TicTacToe game in to a web application using the Spark framework. 
 */
public class TicTacToeWeb implements SparkApplication{
    public static void main(String[] args){
        staticFileLocation("/public");
        SparkApplication tictactoeweb = new TicTacToeWeb();
        String port = System.getenv("PORT");
        if (port != null) {
            setPort(Integer.valueOf(port));
        }
        tictactoeweb.init();
    }

    public void init(){
        final Game game = new Game();
        post(new Route("/"){
            @Override
            public Object handle(Request request, Response response){
                StringBuilder gameField = new StringBuilder();
                Integer x = Integer.valueOf(request.queryParams("x-coord"));
                Integer y = Integer.valueOf(request.queryParams("y-coord"));

                // Insert if input is valid
                if (!Game.isValidInput(x, y)){
                    return "Input error";
                } else {
                    game.insert(x, y);
                    gameField = game.writeGameField();
                    game.changePlayers(); 
                    if (Game.winner()){
                        // Initialize the game for a new game
                        game.setBoard(new Board());
                        gameField = game.writeGameField();

                        return "Player" + Board.getPlayers() + " wins!";
                    }
                    if (Game.tie()) {
                        // Initialize the game for a new game
                        game.setBoard(new Board());
                        gameField = game.writeGameField();
                        return "It's a tie!";
                    } else {
                        return gameField.toString();
                    }
                }
            }
        });
    }
}
