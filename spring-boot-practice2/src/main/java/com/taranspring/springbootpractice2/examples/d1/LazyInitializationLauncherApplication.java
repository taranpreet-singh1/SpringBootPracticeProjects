package com.taranspring.springbootpractice2.examples.d1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//Dependency Injection: Identify beans, their dependencies, and wire them together (Provides IOC - Inversion of Control)

@Component
class ClassA{

}

@Component
@Lazy
class ClassB{

    private ClassA classA;
    public ClassB(ClassA classA){
        System.out.println("Some Intialization logic");
        this.classA = classA;
    }

    public void doSomething(){
        System.out.println("Do Something");
    }

}
@Configuration
@ComponentScan("com.taranspring.springbootpractice2.examples.d1")
public class LazyInitializationLauncherApplication {

    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(LazyInitializationLauncherApplication.class)) {

        System.out.println("Initialization of context is completed");
        context.getBean(ClassB.class).doSomething();
        }

    }

    }
