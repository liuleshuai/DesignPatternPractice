package com.example.liukuo.Algorithm;

/**
 * 堆排序
 * 基本原理：说白了就是利用大/小顶堆的根节点是最值，进行循环交换完成排序。
 * 堆一般采用的是完全二叉树结构。
 * 完全二叉树：即若设二叉树的深度为h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，第 h 层所有的结点都连续集中在最左边。
 * 1.将无序数组构建成最大堆/最小堆（这样根节点就是最值了）
 * 2.将根节点与最后一个数据进行交换，然后对前n-1个数据进行最大堆/最小堆构建。
 * 3.将根节点与倒数第二个数据进行交换，然后对前n-2个数据进行最大堆/最小堆构建。
 * 4.依次交换构建，直到只剩一个数据。
 * 平均时间复杂度：O(nlogn)
 * 最好情况：O(nlogn)
 * 最坏情况：O(nlogn)
 * 空间复杂度：O(1)
 * 占用常数内存，不占用额外内存
 * 是不稳定排序方式
 * Created by LiuKuo at 2018/6/21
 */

public class HeapSort {

    /**
     * 将数据构建成最小堆
     */
    private static void makeMinHeap(int[] data) {
        int count = data.length;
        // 倒数第二层开始排序
        for (int i = (count - 1) / 2; i >= 0; i--) {
            fixDown(data, i, count);
        }
    }

    private static void fixDown(int[] data, int i, int count) {
        // 左子树
        int j = i * 2 + 1;
        while (j < count) {
            //取左右子树中的最小值下标
            if (j + 1 < count && data[j] > data[j + 1]) {
                j++;
            }
            //最小值小于结点则交换，否则跳出此次循环
            if (data[j] < data[i]) {
                int temp = data[j];
                data[j] = data[i];
                data[i] = temp;
                // 处理下层
                i = j;
                j = i * 2 + 1;
            } else {
                break;
            }

        }
    }

    private static void sort(int[] data) {
        makeMinHeap(data);
        // 对最小堆进行排序
        for (int i = data.length - 1; i >= 0; i--) {
            //从后面取数与根节点交换，根节点是最小值，所以循环后是从大到小排序的
            //如果想从小到大排序，需要先构建最大堆，这样根节点的值是最大值每次与最后面互换。
            int temp = data[0];
            data[0] = data[i];
            data[i] = temp;
            fixDown(data, 0, i);
//            for (int ii = 0; ii < data.length; ii++) {
//                System.out.print(data[ii] + ",");
//            }
//            System.out.println();
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
