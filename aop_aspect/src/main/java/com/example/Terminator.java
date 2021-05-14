package com.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Terminator {
    private String name;
    private String model;
    private int kills;

    public void messageBefore(){
        System.out.println(toString());
    }
    public void messageAfter(){
        System.out.println(toString());
    }
    public void messageAround(){
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "I Terminator " +
                "\nmy name = '" + name + '\'' +
                "\nmy model = '" + model + '\'' +
                "\ni kills = " + kills ;
    }
}
