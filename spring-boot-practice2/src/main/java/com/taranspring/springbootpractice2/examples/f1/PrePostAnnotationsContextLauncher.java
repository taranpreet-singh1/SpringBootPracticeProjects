package com.taranspring.springbootpractice2.examples.f1;


import com.taranspring.springbootpractice2.GamingAppLauncherApplication;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class SomeClass{
    private SomeDependency someDependency;

    public SomeClass(SomeDependency someDependency){
        super();
        this.someDependency = someDependency;
        System.out.println("ALl dependencies are ready");
    }

    @PostConstruct
    public void intialize(){
        someDependency.getReady();
    }

    @PreDestroy
    public void cleanup(){
        System.out.println("Cleanup");
    }
}

@Component
class SomeDependency{
    public void getReady(){
        System.out.println("Some logic");
    }
}


@Configuration
@ComponentScan
public class PrePostAnnotationsContextLauncher {

    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(PrePostAnnotationsContextLauncher.class)) {

            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        }

    }

    }
