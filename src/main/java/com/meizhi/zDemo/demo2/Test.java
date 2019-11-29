package com.meizhi.zDemo.demo2;

import java.util.function.Supplier;

public class Test {
    public static Integer getMax(Supplier<Integer> function) {
        return function.get();
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 4, 52, 333, 23};
        int max = getMax(() -> {
            int maxTemp = arr[0];
            for (int i : arr) {
                if (i > maxTemp) {
                    maxTemp = i;
                }
            }
            return maxTemp;
        });
        System.out.println(max);

    }
}
