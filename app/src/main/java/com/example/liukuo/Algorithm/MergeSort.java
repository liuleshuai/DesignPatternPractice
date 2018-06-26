package com.example.liukuo.Algorithm;

/**
 * 归并排序（递归拆分+合并。。。）
 * 基本思路：
 * 归并排序算法是典型的分治算法，对于规模较大的问题，可以分解成若干容易求解的简单的问题，最后把解合并构成初始问题的解。
 * 1.先将需要排序的数，按中点进行分组
 * 2.重复分组，直到分到的组不能再分（最后是单个数为一组）
 * 3.反向比较排序，合并上述分开的组
 * 时间复杂度 O(nlogn)
 * 稳定排序
 */
public class MergeSort {

    private static void sort(int[] data, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            sort(data, start, mid);
            sort(data, mid + 1, end);
            merge(data, start, mid, end);
        }
    }

    /**
     * start-mid数组和mid-end数组合并
     */
    private static void merge(int[] data, int start, int mid, int end) {
        int i = start, j = mid + 1;
        int[] temp = new int[data.length];
        int k = 0;
        while (i <= mid && j <= end) {
            if (data[i] >= data[j]) {
                temp[k] = data[j];
                k++;
                j++;
            } else {
                temp[k] = data[i];
                k++;
                i++;
            }
        }
        while (i <= mid) {
            temp[k] = data[i];
            k++;
            i++;
        }
        while (j <= mid) {
            temp[k] = data[j];
            k++;
            j++;
        }
        for (int m = 0; m < k; m++) {
            data[start + m] = temp[m];
        }
    }

    public static void main(String[] args) {
        int[] data = {3, 4, 5, 1, 1, 2, 7, 2, 1, 0, 10, 8};
        if (data.length > 0) {
            sort(data, 0, data.length - 1);
        }
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + ",");
        }
    }
}
