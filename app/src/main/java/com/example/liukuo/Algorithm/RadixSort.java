package com.example.liukuo.Algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 基数排序(桶子法)
 * 基本原理：
 * 按照个位，十位……的大小分别按桶排序重组数组。拿个位来说，230, 210，120为0的重组后排在最前面，
 * 此时按十位继续重组，210,120,230，最后百位重组时，120,210,230。
 * 1.取得数组中的最大数，并取得位数
 * 2.arr为原始的数组，从最低位开始取每个位组成radix数组；
 * 3.对radix进行计数排序
 * <p>
 * 平均时间复杂度是：O(d(r+n))
 * 空间复杂度：O(rd+n)
 * r代表关键字基数，d代表长度，n代表关键字个数
 * 稳定排序
 * Created by LiuKuo at 2018/6/22
 */

public class RadixSort {
    private static void radixSort(int[] data, int count) {
        int max = data[0];
        for (int temp : data) {
            max = Math.max(temp, max);
        }
        int maxDigit = 0;
        while (max != 0) {
            max /= 10;
            maxDigit++;
        }
        // 初始化
        List<ArrayList<Integer>> temp = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            temp.add(new ArrayList<Integer>());
        }
        for (int i = 0, mod = 10, div = 1; i < maxDigit; i++, mod *= 10, div *= 10) {
            // 按位桶排序
            for (int j = 0; j < count; j++) {
                temp.get(data[j] % mod / div).add(data[j]);
            }
            int ii = 0;
            for (int m = 0; m < temp.size(); m++) {
                for (int n = 0; n < temp.get(m).size(); n++) {
                    data[ii++] = temp.get(m).get(n);
                }
                temp.get(m).clear();
            }
        }
    }

    public static void main(String[] args) {
        int[] data = {3, 4, 5, 1, 1, 2, 7, 2, 1, 0, 10, 8};
        if (data.length > 0) {
            radixSort(data, data.length);
        }
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + ",");
        }
    }
}
