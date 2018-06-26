package com.example.liukuo.thread.lock;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock
 * Created by LiuKuo at 2018/6/26
 */

public class MessageQueue2 {
    private Queue<String> queue;
    private int max;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public MessageQueue2(int size) {
        queue = new LinkedList<>();
        max = size;
    }

    public String take() throws InterruptedException {
        lock.lock();
        while (queue.size() == 0) {
            System.out.println("我没有了,等等");
            condition.await();
        }
        String message = queue.poll();
        System.out.println("我-1");
        try {
            condition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return message;
    }

    public synchronized void put(String message) throws InterruptedException {
        try {
            lock.lock();
            while (queue.size() == max) {
                System.out.println("我满了,等等");
                condition.await();
            }
            queue.offer(message);
            System.out.println("我+1");
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] a) throws InterruptedException {
        final MessageQueue1 queue1 = new MessageQueue1(2);
        final String msg = "handsome";

        Executor executor = Executors.newFixedThreadPool(4, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r);
            }
        });
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                try {
                    queue1.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                try {
                    queue1.put(msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        executor.execute(runnable1);
        executor.execute(runnable2);
        executor.execute(runnable2);
        executor.execute(runnable2);
        executor.execute(runnable1);

    }
}
