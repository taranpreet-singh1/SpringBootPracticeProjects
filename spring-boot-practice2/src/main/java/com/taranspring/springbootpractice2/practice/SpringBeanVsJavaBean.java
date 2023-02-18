package com.taranspring.springbootpractice2.practice;


import java.io.Serializable;

class Pojo{
    private String text;
    private int number;
    public String toString(){
        return text + ":" + number;
    }
}


class JavaBean implements Serializable { //EJB

    //Should have no argument constructor
    public JavaBean(){

    }
    private String text;
    private int number;

    //should have getters and setters

}

public class SpringBeanVsJavaBean {

    public static void main(String[] args){
        Pojo pojo = new Pojo();

    }

}
