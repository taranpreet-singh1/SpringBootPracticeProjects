package com.taranspring.springbootpractice2;

import com.taranspring.springbootpractice2.game.GameRunner;
import com.taranspring.springbootpractice2.game.MarioGame;
import com.taranspring.springbootpractice2.game.SuperContraGame;

public class App01GamingBasic {

    public static void main(String[] args){

        var marioGame = new MarioGame();
        var game = new SuperContraGame();
        var gameRunner = new GameRunner(game); //Object creation + wiring of dependencies
        //Game is a dependency of Game Runner
        gameRunner.run();
    }



}
