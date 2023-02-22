package com.taranspring.springbootpractice2.examples.a1;


import com.taranspring.springbootpractice2.GamingAppLauncherApplication;
import com.taranspring.springbootpractice2.game.GameRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//Dependency Injection: Identify beans, their dependencies, and wire them together (Provides IOC - Inversion of Control)

@Component
class YourBusinessClass{

//    @Autowired //Field Injection
    Dependency1 dependency1;
 //   @Autowired  //Field injection
    Dependency2 dependency2;

//    @Autowired
//    public void setDependency1(Dependency1 dependency1) {
//        System.out.println("Setter Injection - setDependency1 ");
//        this.dependency1 = dependency1;
//    }
//
//    @Autowired
//    public void setDependency2(Dependency2 dependency2) {
//        System.out.println("Setter Injection - setDependency2");
//        this.dependency2 = dependency2;
//    }


    //Constructor Injection - Recommended by Spring Team
    //@Autowired - Auto wired is not mandatory in Constructor Injection
    public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
        System.out.println("Constructor Injection - Your Business Class");
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

    @Autowired
    public String toString(){
        return "Using "+ dependency1 + " and "+ dependency2;
    }
}

//Dependency1
@Component
class Dependency1{

}


//Dependency2
@Component
class Dependency2{

}

@Configuration
@ComponentScan("com.taranspring.springbootpractice2.examples.a1")
public class DepInjectionLauncher {

    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(DepInjectionLauncher.class)) {

            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println(context.getBean(YourBusinessClass.class));

        }

    }

    }
