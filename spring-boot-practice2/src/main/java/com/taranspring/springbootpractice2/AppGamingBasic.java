package com.taranspring.springbootpractice2;

import com.taranspring.springbootpractice2.game.GameRunner;
import com.taranspring.springbootpractice2.game.MarioGame;

public class AppGamingBasic {

    public static void main(String[] args){

        var marioGame = new MarioGame();
        var gameRunner = new GameRunner(marioGame);
        gameRunner.run();
    }



}
