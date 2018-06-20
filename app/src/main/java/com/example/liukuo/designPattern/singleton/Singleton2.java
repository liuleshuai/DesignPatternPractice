package com.example.liukuo.designPattern.singleton;

/**
 * 懒汉式(线程不安全)
 * Created by LiuKuo at 2018/6/13
 */

public class Singleton2 {
    private static Singleton2 instance;

    public static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }

    public void print() {
        System.out.println("懒汉式(线程不安全)");
    }

    public static void main(String[] args) {
        Singleton2.getInstance().print();
    }
}
