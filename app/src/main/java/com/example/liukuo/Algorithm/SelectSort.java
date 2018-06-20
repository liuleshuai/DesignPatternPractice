package com.example.liukuo.Algorithm;

/**
 * 选择排序
 * <p>
 * 基本思路：
 * 让第一个数与后面的所有数一个个比较，找出最小的数，将最小的数跟第一个数交换
 * 接着从第二个数开始，继续上面的操作
 * 时间复杂度O(n^2)
 * Created by LiuKuo at 2018/6/20
 */

public class SelectSort {

    public static void sort(int[] data) {
        int minPos;
        for (int i = 0; i < data.length - 1; i++) {
            minPos = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[minPos] > data[j]) {
                    minPos = j;
                }
            }
            if (minPos != i) {
                int temp = data[i];
                data[i] = data[minPos];
                data[minPos] = temp;
            }
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
