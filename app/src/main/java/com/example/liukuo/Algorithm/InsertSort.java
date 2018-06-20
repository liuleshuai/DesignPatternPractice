package com.example.liukuo.Algorithm;

/**
 * 插入排序
 * <p>
 * 基本思想：在一个有序数组中插入新的数据并排序。
 * 其实就是你玩扑克牌的时候，排序你自己的牌的思路从后面抽出牌，插入到前面的牌中
 * 时间复杂度O(n^2)
 * Created by LiuKuo at 2018/6/20
 */

public class InsertSort {
    public static void sort(int[] data) {
        // i每次加1，相当于插入一张牌
        for (int i = 1; i < data.length; i++) {
            for (int j = i; j > 0; j--) {
                if (data[j] < data[j - 1]) {
                    int temp = data[j];
                    data[j] = data[j - 1];
                    data[j - 1] = temp;
                } else {
                    break;
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
