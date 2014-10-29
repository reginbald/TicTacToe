/*
 * Copyright (c) 2014 Delta Zeda Creed.
 */
package is.deltazedacreed.tictactoe;

import static spark.Spark.*;
import spark.*;

/**
 * Class turns the TicTacToe game in to a web application using the Spark framework. 
 */
public class TicTacToeWeb{
    public static void main(String[] args) {
        setPort(4575);
        get(new Route("/hello") {
            @Override
            public Object handle(Request request, Response response) {
                return "Hello World!";
            }
        });
    }
}
