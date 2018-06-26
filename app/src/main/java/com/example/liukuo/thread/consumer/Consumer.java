package com.example.liukuo.thread.consumer;

import java.util.concurrent.BlockingQueue;

/**
 * Created by LiuKuo at 2018/6/26
 */

public class Consumer implements Runnable {
    private final BlockingQueue<Integer> deque;

    public Consumer(BlockingQueue<Integer> deque) {
        this.deque = deque;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2500);
                synchronized (deque) {
                    if (deque.size() <= 0) {
                        System.out.println("仓库没货，等待中...");
                        deque.wait();
                    }
                    Integer num = deque.take();
                    System.out.println("取货号码：" + num + ",存货：" + deque.size());
                    deque.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
