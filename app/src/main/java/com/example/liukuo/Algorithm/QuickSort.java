package com.example.liukuo.Algorithm;

/**
 * 快速排序
 * 平均时间复杂度：O(nlogn)
 * 最好情况：O(nlogn)
 * 最坏情况：O(n²)
 * 空间复杂度O(logn)
 * 占用常数内存，不占用额外的内存
 * 是不稳定排序
 * Created by LiuKuo at 2018/6/21
 */

public class QuickSort {
    private static void quicksort(int[] data, int start, int end) {
        if (start > end) {
            return;
        }
        int i = start, j = end;
        int key = data[start];
        while (i < j) {
            while (i < j && data[i] <= key) {
                i++;
            }
            while (i < j && data[j] >= key) {
                j--;
            }
            if (i < j) {
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
            data[start] = data[i];
            data[i] = key;

            quicksort(data, start, i - 1);
            quicksort(data, i + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] data = {3, 4, 5, 1, 1, 2, 7, 2, 1, 0, 10, 8};
        if (data.length > 0) {
            quicksort(data, 0, data.length - 1);
        }
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + ",");
        }
    }
}
