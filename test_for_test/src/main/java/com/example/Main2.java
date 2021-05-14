package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("12312");
        list.add("sos");
        list.add("-312");
        list.add("1");
        list.add("dsad");
        Integer integer = list.stream()
//                .filter(Main2::isParsable)
                .filter(x->isParsable(x))
                .map(Integer::valueOf)
//                .filter(x->x%2==0)

                .reduce(1,(x,y)->{
                    if (x%2==0){
                        return x;
                    }else {
                        return y;
                    }
                },(x,y)->x*y);

        System.out.println(integer);

    }
    public static boolean isParsable(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (final NumberFormatException e) {
            return false;
        }
    }
}
