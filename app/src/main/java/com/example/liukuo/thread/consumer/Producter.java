package com.example.liukuo.thread.consumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by LiuKuo at 2018/6/26
 */

public class Producter implements Runnable {
    private int size;
    private BlockingQueue<Integer> queue;

    public Producter(int size) {
        this.size = size;
        queue = new LinkedBlockingDeque<>(size);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                if (queue.size() >= size) {
                    queue.wait();
                }
                queue.put(produce());
                queue.notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public int produce() {
        int temp = new Random().nextInt();
        System.out.println("Thread:" + Thread.currentThread().getId() + "produce" + temp);
        return temp;
    }
}
