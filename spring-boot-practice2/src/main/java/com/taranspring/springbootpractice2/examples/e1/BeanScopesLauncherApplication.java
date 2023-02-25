package com.taranspring.springbootpractice2.examples.e1;


import com.taranspring.springbootpractice2.GamingAppLauncherApplication;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class NormalClass{

}


@Scope(value= ConfigurableBeanFactory.SCOPE_PROTOTYPE)  //value = "prototype" should work too
@Component
class PrototypeClass{

}

@Configuration
@ComponentScan
public class BeanScopesLauncherApplication {

    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(BeanScopesLauncherApplication.class)) {


            System.out.println(context.getBean(NormalClass.class)); //Singleton
            System.out.println(context.getBean(NormalClass.class)); //Singleton

            System.out.println(context.getBean(PrototypeClass.class)); //Prototype - many object Instances per Spring IoC container
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));

        }

    }

    }
