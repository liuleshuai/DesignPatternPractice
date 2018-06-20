package com.example.liukuo.designPattern.decoration;

/**
 * Created by LiuKuo at 2018/6/15
 */

public abstract class Sweet {
    private String remark;

    public String getRemark() {
        return remark;
    }

    public abstract int cost();
}
