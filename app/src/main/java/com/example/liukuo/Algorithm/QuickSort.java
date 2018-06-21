package com.example.liukuo.Algorithm;

/**
 * 快速排序
 * 基本思路：
 * 在无序数组中，取第一个数n0作为基准，新建一个i,j下标分别从数组的前后两侧查找大于n0的数，
 * 并将这两个数交换，直到i==j，此时i的位置即为n0在此数组中的排序后位置（比它小的都在前面，大的在后面）
 * 故将n0与ni进行交换，接下来可将数组分为两组数据分别采用递归的形式设置其n0的位置。
 * <p>
 * 平均时间复杂度：O(nlogn)
 * 最好情况：O(nlogn)
 * 最坏情况：O(n²)
 * 空间复杂度O(logn)
 * 占用常数内存，不占用额外的内存
 * 是不稳定排序
 * Created by LiuKuo at 2018/6/21
 */

public class QuickSort {
    private static void quickSort(int[] data, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = start, j = end;
        int key = data[start];
        while (i < j) {
            //此处注意顺序,如果是先左后右的话，需要i-1
            while (i < j && data[j] >= key) {
                j--;
            }
            while (i < j && data[i] <= key) {
                i++;
            }
            if (i < j) {
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }
        data[start] = data[i];
        data[i] = key;

        quickSort(data, start, i - 1);
        quickSort(data, i + 1, end);
    }

    public static void main(String[] args) {
        int[] data = {3, 4, 5, 1, 1, 2, 7, 2, 1, 0, 10, 8};
        if (data.length > 0) {
            quickSort(data, 0, data.length - 1);
        }
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + ",");
        }
    }
}
