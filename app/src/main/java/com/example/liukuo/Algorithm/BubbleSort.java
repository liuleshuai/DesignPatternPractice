package com.example.liukuo.Algorithm;

/**
 * 冒泡排序
 * <p>
 * 基本思路：
 * 两个数比较大小，较大的数下沉，较小的数冒起来
 *
 * 平均时间复杂度：O(n^2),
 * 最好情况O(n),
 * 最坏情况O(n^2),
 * 空间复杂度O(1),
 * 占用常数内存，不占用额外内存，
 * 稳定排序
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
        int[] data = {3, 4, 5, 1, 1, 2, 7, 2, 1, 0, 10, 8};
        sort(data);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + ",");
        }
    }
}
