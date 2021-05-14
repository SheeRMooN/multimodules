package com.example.event;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;

@Configuration
public class HelloEventHandler  {

   @Order(2)
   @EventListener
   public void handleContextRefreshEvent(ContextStartedEvent ctxStartEvt) {
      System.out.println("Context Start Event received.");
   }

   @Order(1)
   @EventListener(classes = { ContextStartedEvent.class, ContextStoppedEvent.class })
   public void handleMultipleEvents() {
      System.out.println("Multi-event listener invoked");
   }

   @EventListener(classes = {CustomEvent.class})
   public void handleMM(CustomEvent customEvent){
      System.out.println(customEvent.toString());
   }
}