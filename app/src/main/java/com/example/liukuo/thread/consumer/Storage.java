package com.example.liukuo.thread.consumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 缓冲区
 * Created by LiuKuo at 2018/6/26
 */

public class Storage<T> {
    private int max;
    private int count;
    private BlockingQueue<T> queue;

    public Storage(int max) {
        this.max = max;
        queue = new LinkedBlockingDeque<>(max);
    }

    public synchronized void produce(T item) throws InterruptedException {
        while (count >= max) {
            System.out.println("仓库满了，等待中...");
            this.wait();
        }
        System.out.println("生产>>" + item.toString());
        count++;
        queue.put(item);
        this.notify();
    }

    public synchronized T consume() throws InterruptedException {
        while (count < 0) {
            System.out.println("仓库缺货，等待中...");
            this.wait();
        }
        count--;
        T item = queue.take();
        System.out.println("消费>>" + item.toString());
        this.notify();
        return item;
    }
}
