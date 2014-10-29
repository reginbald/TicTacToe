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
        SparkApplication tictactoeweb = new TicTacToeWeb();
        String port = System.getenv("PORT");
        if (port != null) {
            setPort(Integer.valueOf(port));
        }
        tictactoeweb.init();
    }

    public void init(){
        get(new Route("/"){
            @Override
            public Object handle(Request request, Response response){
                return "Hello world!";
            }
        });
    }
}
