package com.example.liukuo.Algorithm;

/**
 * 希尔排序（缩小增量排序）
 * <p>
 * 时间复杂度O(n^2)
 * Created by LiuKuo at 2018/6/20
 */

public class ShellSort {

    public static void sort(int[] data) {
        int len = data.length / 2;
        while (len != 0) {
            for (int i = 0; i < len; i++) {

            }
            len /= 2;
        }
    }

    public static void main(String[] args) {
        int[] data = {3, 4, 5, 1, 1, 2, 7, 2, 10, 8};
        sort(data);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + ",");
        }
    }
}
