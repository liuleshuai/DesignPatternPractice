package com.example.liukuo.facade;

/**
 * 外观模式
 * 外观模式的主要目的在于让外部减少与子系统内部多个模块的交互，从而让外部能够更简单得使用子系统，
 * 它负责把客户端的请求转发给子系统内部的各个的模块进行处理。
 * Created by LiuKuo at 2018/6/19
 */

public class BigTongue {
    public static class ModuleA {
        public void say() {
            System.out.println("说说说说说你爱我！");
        }
    }

    public static class ModuleB {
        public void say() {
            System.out.println("我我我我说不出口！");
        }
    }

    public static class ModuleC {
        public void say() {
            System.out.println("对不起我有大舌头！");
        }
    }

    public static class Facade {
        public void say() {
            ModuleA moduleA = new ModuleA();
            ModuleB moduleB = new ModuleB();
            ModuleC moduleC = new ModuleC();
            moduleA.say();
            moduleB.say();
            moduleC.say();
        }
    }

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.say();
    }
}
