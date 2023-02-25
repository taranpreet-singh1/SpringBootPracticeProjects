package com.taranspring.springbootpractice2.examples.g1;


import com.taranspring.springbootpractice2.GamingAppLauncherApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
class BusinessService{
    private DataService dataService;


    public DataService getDataService() {
        System.out.println("Setter Injection");
        return dataService;
    }

    @Autowired
    public void setDataService(DataService dataService) {
        this.dataService = dataService;
    }
}

@Component
class DataService{

}

@Configuration
@ComponentScan
public class CdiContextLauncher {

    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(CdiContextLauncher.class)) {

            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println(context.getBean(BusinessService.class).getDataService());

        }

    }

    }
