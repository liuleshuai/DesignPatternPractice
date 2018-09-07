package com.example.liukuo.designPattern.singleton;

/**
 * 懒汉式（线程安全）
 * 双Check模式
 * Created by LiuKuo at 2018/6/13
 */

public class Singleton3 {
    private static volatile Singleton3 instance;

    private Singleton3() {
    }

    public static Singleton3 getInstance() {
        if (instance == null) {
            // 注意此处和this的区别，一个是对于对象的（this,需要去除static），一个是对类的。
            synchronized (Singleton3.class) {
                if (instance == null) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }

    public void print() {
        System.out.println("懒汉式（线程安全）");
    }

    public static void main(String[] args) {
        Singleton3.getInstance().print();
    }
}
