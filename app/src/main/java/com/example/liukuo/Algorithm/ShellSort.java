package com.example.liukuo.Algorithm;

/**
 * 希尔排序（缩小增量排序）
 * <p>
 * 基本思想：
 * 算法先将要排序的一组数按某个增量 d（n/2,n为要排序数的个数）分成若干组，
 * 每组中记录的下标相差 d.对每组中全部元素进行直接插入排序，
 * 然后再用一个较小的增量（d/2）对它进行分组，在每组中再进行直接插入排序。
 * 当增量减到 1时，进行直接插入排序后，排序完成。
 *
 * 平均的时间复杂度是O(nlogn)
 * 最好情况O(nlogn)
 * 最坏情况O(n^2)
 * 空间复杂度O(1)
 * 占用常数内存，不占用额外内存
 * 不稳定排序
 * Created by LiuKuo at 2018/6/20
 */

public class ShellSort {

    public static void sort(int[] data) {
        int len = data.length / 2;
        while (len != 0) {
            for (int i = len; i < data.length; i++) {
                for (int j = i; j >= len; j -= len) {
                    if (data[j] < data[j - len]) {
                        int temp = data[j];
                        data[j] = data[j - len];
                        data[j - len] = temp;
                    } else {
                        break;
                    }
                }
            }
            len /= 2;
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
