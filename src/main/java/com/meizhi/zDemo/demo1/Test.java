package com.meizhi.zDemo.demo1;

public class Test {

    public static void doSomething(MyFunctionInterface myFunctionInterface){
        myFunctionInterface.testMethod("ss");
   }

    public static void main(String[] args) {
        doSomething(name-> System.out.println(name));
    }
}
