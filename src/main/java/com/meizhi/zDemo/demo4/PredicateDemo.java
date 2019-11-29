package com.meizhi.zDemo.demo4;

import java.util.function.Predicate;

public class PredicateDemo {

    public static boolean testMethod(Predicate<String> param ,Predicate<String> param2) {
        return param.and(param2).test("hello");
    }

    public static void main(String[] args) {
        boolean h = testMethod((param) -> param.contains("h") , (param) -> param.contains("e"));
        System.out.println(h);
    }


}
