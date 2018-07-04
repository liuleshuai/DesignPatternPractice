package com.example.liukuo.dp;

import java.util.Scanner;

/**
 * 动态规划
 * 硬币问题
 * 如果我们有面值为1元、3元和5元的硬币若干枚，如何用最少的硬币凑够11元？
 * Created by LiuKuo at 2018/7/4
 */

public class Coin {
    public int minNum(int money, int[] coinValue) {
        int[] temp = new int[money + 1];
        for (int i = 1; i <= money; i++) {
            int min = money;
            for (int m = 0; m < coinValue.length; m++) {
                if (i >= coinValue[m]) {
                    temp[i] = temp[i - coinValue[m]] + 1;
                    if (min > temp[i]) {
                        min = temp[i];
                    }
                }
            }
            temp[i] = min;
        }
        return temp[money];
    }

    public static void main(String[] args) {
        int[] coinValue = {1, 3, 5};
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int money = scanner.nextInt();
            Coin coin = new Coin();
            int num = coin.minNum(money, coinValue);
            System.out.println(num);
        }
    }
}
