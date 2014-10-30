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
                StringBuilder gameField = game.getBoard().writeGameField();
                return gameField;
            }
        });
        post(new Route("/id"){
            @Override
            public Object handle(Request request, Response response){
                StringBuilder gameField = new StringBuilder();
                String[] coordinates = request.queryParams("id").split(" ");
                Integer xCoord = Integer.valueOf(coordinates[0]);
                Integer yCoord = Integer.valueOf(coordinates[1]);
                game.insert(xCoord, yCoord);
                gameField = game.getBoard().writeGameField();
                return gameField.toString();
            }
        });
    }
}
