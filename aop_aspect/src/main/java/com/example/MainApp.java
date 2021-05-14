package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(value = "com.example")
public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainApp.class);
//==========================================================================================
//        context.getBean(Terminator.class).messageAfter();
//        context.getBean(Terminator.class).messageBefore();
        context.getBean(Terminator.class).messageAround();
    }
}
