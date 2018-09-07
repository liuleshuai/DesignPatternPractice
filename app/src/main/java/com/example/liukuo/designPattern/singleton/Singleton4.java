package com.example.liukuo.designPattern.singleton;

/**
 * 延迟初始化单例(静态内部类)
 * 推荐！！！
 * Created by LiuKuo at 2018/6/13
 */

public class Singleton4 {
    private Singleton4() {
    }

    private static class Singleton {
        private static Singleton4 instance = new Singleton4();
    }

    public static Singleton4 getInstance() {
        return Singleton.instance;
    }

    public void print() {
        System.out.println("静态内部类单例");
    }

    public static void main(String[] args) {
        Singleton4.getInstance().print();
    }
}
