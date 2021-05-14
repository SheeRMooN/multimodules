package com.example;

import com.example.event.CustomEventPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(value = "com.example")
public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainApp.class);
//==========================================================================================
        context.start();
        context.getBean(CustomEventPublisher.class).publish();
        context.stop();
    }
}
