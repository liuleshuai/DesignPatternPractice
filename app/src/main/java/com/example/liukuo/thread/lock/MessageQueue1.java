package com.example.liukuo.thread.lock;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * 多并发
 * wait && notify
 * 1.synchronized修饰的非静态方法或者synchronized (this)都是对于这个类的对象的
 * 2.synchronized(xxx.class)修饰的这个类的，注意区别啊
 * Created by LiuKuo at 2018/6/26
 */

public class MessageQueue1 {
    private Queue<String> queue;
    private int max;

    public MessageQueue1(int size) {
        queue = new LinkedList<>();
        max = size;
    }

    public String take() throws InterruptedException {
        // 锁对象
        // 注意：synchronized同步的内容必须和wait/notifyAll的对象是一致的，否则报错。
        synchronized (queue) {
            while (queue.size() == 0) {
                System.out.println("我没有了,等等");
                queue.wait();
            }
            String message = queue.poll();
            System.out.println("我-1");
            queue.notifyAll();
            return message;
        }
    }

    public synchronized void put(String message) throws InterruptedException {
        // 锁对象
        synchronized (queue) {
            while (queue.size() == max) {
                System.out.println("我满了,等等");
                queue.wait();
            }
            queue.offer(message);
            System.out.println("我+1");
            queue.notifyAll();
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
        executor.execute(runnable2);
        executor.execute(runnable2);
        executor.execute(runnable2);
        executor.execute(runnable2);
        executor.execute(runnable1);
    }
}
