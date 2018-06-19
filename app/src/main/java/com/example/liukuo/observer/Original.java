package com.example.liukuo.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 观察者模式
 * <p>
 * 定义对象之间的一种一对多依赖关系，使得每当一个对象状态发生改变时，其相关依赖对象皆得到通知并被自动更新
 * Created by LiuKuo at 2018/6/19
 */

public class Original {
    public static class Taobao {
        List<Package> list;
        /**
         * AtomicInteger一个提供原子操作的Integer的类,可以实现线程安全的加减操作。
         */
        private AtomicInteger integer = new AtomicInteger();

        public Taobao() {
            list = new ArrayList<>();
            generatePackage();
        }

        public void register(Package p) {
            if (list != null) {
                if (!list.contains(p)) {
                    list.add(p);
                }
            }
        }

        public void remove(Package p) {
            list.remove(p);
        }

        private void generatePackage() {
            ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(4, new ThreadFactory() {
                @Override
                public Thread newThread(Runnable r) {
                    return new Thread(r, "线程" + integer.getAndIncrement());
                }
            });
            executor.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    sendPackage();
                }
            }, 0, 2, TimeUnit.SECONDS);
        }

        private void sendPackage() {
            for (Package item : list) {
                item.receive();
            }
        }
    }

    public static class Package {
        public void receive() {
            System.out.println(Thread.currentThread().getName() + "--------- 收到快递了！");
        }
    }

    public static void main(String[] args) {
        Package s1 = new Package();
        Package s2 = new Package();
        Taobao taobao = new Taobao();
        taobao.register(s1);
        taobao.register(s2);
    }
}
