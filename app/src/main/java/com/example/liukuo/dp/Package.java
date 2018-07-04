package com.example.liukuo.dp;

import java.util.Scanner;

/**
 * 动态规划
 * 在N件物品取出若干件放在容量为W的背包里，每件物品的体积为W1，W2……Wn（Wi为整数），
 * 与之相对应的价值为P1,P2……Pn（Pi为整数）。求背包能够容纳的最大价值。
 * Created by LiuKuo at 2018/7/4
 */

public class Package {
    public int money(int content, int[] weight, int[] value) {
        int[] dp = new int[content + 1];
        int max = 0;
        for (int i = 0; i <= content; i++) {
            int temp = 0;
            for (int v = 0; v < value.length; v++) {
                if (i >= weight[v]) {
                    dp[i] = dp[i - weight[v]] + value[v];
                    if (temp < dp[i]) {
                        temp = dp[i];
                    }
                }
            }
            if (max < temp) {
                max = temp;
            }
            dp[i] = temp;
        }
        for (int i = 0; i <= content; i++) {
            System.out.print(dp[i] + " ");
        }
        return max;
    }

    public static void main(String[] args) {
        int[] weight = {2, 3, 5, 7, 20};
        int[] value = {1, 2, 3, 4, 10000};
        Package pk = new Package();

        while (true) {
            Scanner scanner = new Scanner(System.in);
            int bag = scanner.nextInt();
            int maxMoney = pk.money(bag, weight, value);
            System.out.println(maxMoney);
        }
    }
}
