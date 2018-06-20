package com.example.liukuo.designPattern.singleton;

/**
 * 懒汉式（线程安全）
 * 双Check模式
 * Created by LiuKuo at 2018/6/13
 */

public class Singleton3 {
    private static volatile Singleton3 instance;

    public static Singleton3 getInstance() {
        if (instance == null) {
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
