package com.meizhi.zDemo.hutoolUtilDemo;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

public class DateUtilDemo {

    public static void main(String[] args) {
        String now = DateUtil.now();
        System.out.println(now);
        DateTime dateTime = DateUtil.parseDateTime(now);
        System.out.println(dateTime);
    }
}
