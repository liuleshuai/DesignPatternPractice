package com.example.liukuo.designPattern.component;

/**
 * Created by LiuKuo at 2018/6/19
 */

public abstract class Football {
    String name;

    public abstract void add(Football ball);

    public abstract void remove(Football ball);

    public abstract void bestPlayer();
}
