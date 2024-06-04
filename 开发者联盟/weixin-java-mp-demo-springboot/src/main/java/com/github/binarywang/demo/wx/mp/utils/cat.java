package com.github.binarywang.demo.wx.mp.utils;

/**
 * @Author: CY
 * @email: 5844104706@qq.com
 * @Date: 2021/1/6 11:06
 * @Description:
 **/
public class cat {

        //定义name、age两个实例变量
        String name;
        int age;
        //使用构造器初始化name、age两个实例变量
        public cat(String name,int age)
        {
            System.out.println("执行构造器");
            this.name = name;
            this.age = age;
        }
        {
            System.out.println("执行非静态初始化块");
            weight = 2.0;
        }
        //定义时指定初始值
        double weight = 2.3;
        public String toString()
        {
            return "Cat[name=" + name
                + ",age=" + age + ",weigth=" + weight + "]";
        }
}
