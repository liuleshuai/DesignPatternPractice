package com.example.liukuo.template;

/**
 * 模板方法
 * <p>
 * 模板方法是通过定义一个算法骨架，而将算法中的步骤延迟到子类，这样子类就可以复写这些步骤的实现来实现特定的算法.
 * Created by LiuKuo at 2018/6/19
 */

public class FootballPlayer {


    public static class Pass extends BasePlay {

        @Override
        public void start() {
            System.out.print("启动->");
        }

        @Override
        public void look() {
            System.out.print("观察队友跑位->");
        }

        @Override
        public void stop() {
            System.out.print("卸下皮球->");
        }

        @Override
        public void done() {
            System.out.println("传球");
        }
    }

    public static class Shoot extends BasePlay {

        @Override
        public void start() {
            System.out.print("启动->");
        }

        @Override
        public void look() {
            System.out.print("瞄准球门->");
        }

        @Override
        public void stop() {
            System.out.print("卸下皮球->");
        }

        @Override
        public void done() {
            System.out.println("射门");
        }
    }

    public static void main(String[] args) {
        Pass pass = new Pass();
        pass.go();
        Shoot shoot = new Shoot();
        shoot.go();
    }
}
