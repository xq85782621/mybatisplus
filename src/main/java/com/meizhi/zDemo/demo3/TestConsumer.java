package com.meizhi.zDemo.demo3;

import java.util.function.Consumer;

public class TestConsumer {

    public static void consumerString(Consumer<String> function){
        function.accept("hello");
    }

    public static void main(String[] args) {
      consumerString((params)->{
          System.out.println(params);
      });
    }

}
