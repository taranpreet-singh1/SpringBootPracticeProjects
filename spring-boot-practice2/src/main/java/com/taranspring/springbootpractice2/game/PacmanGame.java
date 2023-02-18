package com.taranspring.springbootpractice2.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("Pacman")
public class PacmanGame implements GamingConsole{

    public void up(){
        System.out.println("up");
    }

    public void down(){
        System.out.println("Down");
    }

    public void left(){
        System.out.println("left");
    }

    public void right(){
        System.out.println("Right");
    }

}
