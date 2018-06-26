package com.example.liukuo.thread.consumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by LiuKuo at 2018/6/26
 */

public class Producter implements Runnable {
    private int size;
    private final BlockingQueue<Integer> queue;

    public Producter(int size) {
        this.size = size;
        queue = new LinkedBlockingDeque<>(size);
    }

    public BlockingQueue<Integer> getQueue() {
        return queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                synchronized (queue) {
                    if (queue.size() >= size) {
                        System.out.println("仓库满了，等待中...");
                        queue.wait();
                    }
                    queue.put(produce());
                    queue.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public int produce() {
        int temp = new Random().nextInt(10000);
        System.out.println("生产编号：" + temp + "，库存：" + (queue.size() + 1));
        return temp;
    }
}
