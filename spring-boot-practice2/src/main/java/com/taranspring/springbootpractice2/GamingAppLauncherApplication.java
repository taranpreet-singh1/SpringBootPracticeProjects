package com.taranspring.springbootpractice2;

import com.taranspring.springbootpractice2.game.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.taranspring.springbootpractice2.game")//Spring will scan for component and create a bean so we don't have to
public class GamingAppLauncherApplication {

//    @Bean
//    public GamingConsole game(){
//        var game = new PacmanGame();
//        return game;
//    }

//    @Bean
//    public GameRunner gameRunner(GamingConsole game){
//        var gameRunner = new GameRunner(game);
//        return gameRunner;
//    }


    public static void main(String[] args){

        try(var context = new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class)){
            //context.getBean(GamingConsole.class).up();

            context.getBean(GameRunner.class).run();

            context.getBean(GamingConsole.class).up();

        }


    }



}
