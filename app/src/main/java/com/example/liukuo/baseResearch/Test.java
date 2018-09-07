package com.example.liukuo.baseResearch;

/**
 * String不能被修改，它的引用被修改了
 * final修饰的是常量，表示引用不可以修改。
 * Created by LiuKuo at 2018/7/9
 */

public class Test {
    public static void main(String[] args) {
        String a = "hello2";
        final String b = "hello";
        String d = "hello";
        String c = b + 2;  //相当于"hello"+"2"
        String e = d + 2;
        System.out.println(b == d);
        System.out.println(a == c);
        System.out.println(a == e);
        System.out.println(a.equals(e));
    }
}
