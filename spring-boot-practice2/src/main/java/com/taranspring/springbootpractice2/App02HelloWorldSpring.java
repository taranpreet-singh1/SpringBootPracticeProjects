package com.taranspring.springbootpractice2;

import com.taranspring.springbootpractice2.game.GameRunner;
import com.taranspring.springbootpractice2.game.MarioGame;
import com.taranspring.springbootpractice2.game.SuperContraGame;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

    public static void main(String[] args){

        //Launch a Spring Context
        var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);

        //Configure the things that we want Spring to manage - @Configuration Class
        System.out.println(context.getBean("name"));
        System.out.println(context.getBean("age"));
        System.out.println(context.getBean("person"));
        System.out.println(context.getBean("customAddress"));
    }



}
