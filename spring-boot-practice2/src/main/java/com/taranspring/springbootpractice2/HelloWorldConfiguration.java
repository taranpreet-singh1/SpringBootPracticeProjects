package com.taranspring.springbootpractice2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//record released in JDK16 - no getter, setter, constructor required
record Person(String name, int age, Address address){};

record Address(String firstLine, String city){};

@Configuration
public class HelloWorldConfiguration {

        @Bean
        public String name(){
            return "Taran";
        }

        @Bean
        public int age(){
            return 22;
        }

        @Bean
        public Person person(){
             return new Person("John", 20, new Address("Something", "Something"));
        }

        @Bean
        public Person person2MethodCall(){
            return new Person(name(),age(), address());
        }

        @Bean
        public Person person3Parameters(String name, int age, Address address2){
            return new Person(name,age,address2);
        }

        @Bean(name = "customAddress")
        public Address address(){
            return new Address("Gurcharan Park", " Ludhiana ");
        }

}
