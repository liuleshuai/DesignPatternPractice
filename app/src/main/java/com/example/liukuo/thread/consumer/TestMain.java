package com.example.liukuo.thread.consumer;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 生产者消费者模式（阻塞队列实现）
 * Created by LiuKuo at 2018/6/26
 */

public class TestMain {
    public static void main(String[] args) {
        Producter producter = new Producter(10);
        Consumer consumer1 = new Consumer(producter.getQueue());
        Consumer consumer2 = new Consumer(producter.getQueue());
        Executor executor = Executors.newFixedThreadPool(5);
        executor.execute(producter);
        executor.execute(consumer1);
        executor.execute(consumer2);
    }
}
