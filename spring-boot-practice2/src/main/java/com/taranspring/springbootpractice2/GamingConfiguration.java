package com.taranspring.springbootpractice2;

import com.taranspring.springbootpractice2.game.GameRunner;
import com.taranspring.springbootpractice2.game.GamingConsole;
import com.taranspring.springbootpractice2.game.PacmanGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GamingConfiguration {

    @Bean
    public GamingConsole game(){
        var game = new PacmanGame();
        return game;
    }

    @Bean
    public GameRunner gameRunner(GamingConsole game){
        var gameRunner = new GameRunner(game);
        return gameRunner;
    }

}
