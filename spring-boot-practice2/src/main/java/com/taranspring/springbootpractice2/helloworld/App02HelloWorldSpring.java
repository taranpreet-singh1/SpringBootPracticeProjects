package com.taranspring.springbootpractice2.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class App02HelloWorldSpring {

    public static void main(String[] args){

        //Launch a Spring Context

        try(var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)){

            //Configure the things that we want Spring to manage - @Configuration Class
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));
            System.out.println(context.getBean("person"));
            System.out.println(context.getBean("customAddress"));

            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        };





    }



}
