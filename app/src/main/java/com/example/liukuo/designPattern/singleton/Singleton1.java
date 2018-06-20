package com.example.liukuo.designPattern.singleton;

/**
 * 饿汉式单例
 * Created by LiuKuo at 2018/6/13
 */

public class Singleton1 {
    private static Singleton1 instance = new Singleton1();

    public static Singleton1 getInstance() {
        return instance;
    }

    public void print() {
        System.out.println("饿汉式单例");
    }

    public static void main(String[] args) {
        Singleton1.getInstance().print();
    }
}
