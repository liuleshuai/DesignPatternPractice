package com.example.liukuo.Algorithm;

/**
 * 冒泡排序
 * <p>
 * 基本思路：
 * 两个数比较大小，较大的数下沉，较小的数冒起来
 * 时间复杂度 O(n^2)
 * Created by LiuKuo at 2018/6/20
 */

public class BubbleSort {

    public static void sort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = i + 1; j < data.length; j++) {
                if (data[i] > data[j]) {
                    int temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
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
