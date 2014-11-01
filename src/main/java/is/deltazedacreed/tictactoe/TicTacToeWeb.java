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
                String coordinates = request.queryParams("gridSquare");
                String[] xy = coordinates.split("\\s+");
                int x = Integer.parseInt(xy[0]);
                int y = Integer.parseInt(xy[1]);

                game.insert(x, y);
                int player = Board.getPlayers();
                game.changePlayers(); 

                if (Game.winner()){
                    // Initialize the game for a new game
                    game = new Game();
                    return "Player " + player + " wins!";
                }
                if (Game.tie()) {
                    // Initialize the game for a new game
                    game = new Game();
                    return "It's a tie!";
                }
                return player;
            }
        });
    }
}
