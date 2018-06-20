package com.example.liukuo.designPattern.template;

/**
 * Created by LiuKuo at 2018/6/19
 */

public abstract class BasePlay {
    public abstract void start();

    public abstract void look();

    public abstract void stop();

    public abstract void done();

    public void go() {
        stop();
        start();
        look();
        done();
    }
}
