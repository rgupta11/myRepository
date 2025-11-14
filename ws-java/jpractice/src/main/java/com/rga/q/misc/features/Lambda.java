package com.rga.q.misc.features;

import java.util.function.Predicate;

public class Lambda {


    public static void main(String args[]){
        Predicate<String> largerThan5 = s -> s.length() > 5;
        largerThan5.test("Hello");
        System.out.println(largerThan5.test("HelloWorld"));
    }
    
}
