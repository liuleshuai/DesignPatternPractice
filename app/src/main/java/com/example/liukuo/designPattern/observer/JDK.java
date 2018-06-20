package com.example.liukuo.designPattern.observer;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * JDK的util包内Java提供了一套观察者模式
 * Created by LiuKuo at 2018/6/19
 */

public class JDK {
    public static class Package {
        public String number;
        public String weight;
        public String name;

        public Package(String number, String weight, String name) {
            this.number = number;
            this.weight = weight;
            this.name = name;
        }
    }

    public static class TaoBao extends Observable {
        private AtomicInteger integer = new AtomicInteger();

        public TaoBao() {
            ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(4, new ThreadFactory() {
                @Override
                public Thread newThread(Runnable r) {
                    return new Thread(r, Thread.currentThread().getName() + integer.getAndIncrement());
                }
            });
            scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    setChanged();//打开通知功能开关
                    notifyObservers(new Package("0001", "0.5kg", "免费肥皂"));
                }
            }, 0, 2, TimeUnit.SECONDS);
        }
    }

    public static class User implements Observer {

        @Override
        public void update(Observable o, Object arg) {
            Package p = (Package) arg;
            System.out.println("订单号：" + p.number + "，重量：" + p.weight + "，名称：" + p.name);
        }
    }

    public static void main(String[] args) {
        User user1 = new User();
        User user2 = new User();
        TaoBao taoBao = new TaoBao();
        taoBao.addObserver(user1);
        taoBao.addObserver(user2);
    }

}
