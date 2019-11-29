package com.meizhi.zDemo.demo5;

import java.util.function.Function;

public class TestFunction {

    public static Integer testMethod(Function<String, Integer> function, String param) {
        Integer apply = function.apply(param);
        return apply;
    }

    public static void main(String[] args) {
        Integer length = testMethod(String::length, "哈哈哈");
        System.out.println(length);
    }


}
