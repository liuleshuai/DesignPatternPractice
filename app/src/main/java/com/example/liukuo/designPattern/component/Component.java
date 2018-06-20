package com.example.liukuo.designPattern.component;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式
 * 将对象组合成树形结构以表示‘部分-整体’的层次结构。组合模式使得用户对单个对象和组合对象的使用具有一致性。
 * <p>
 * 当发现需求中是体现部分与整体层次结构时，以及你希望用户可以忽略组合对象与单个对象的不同，
 * 统一地使用组合结构中的所有对象时，就应该考虑组合模式了。
 * Created by LiuKuo at 2018/6/19
 */

public class Component {

    // 相当于节点
    public static class FIFA extends Football {
        List<Football> childrenIphone = new ArrayList<>();

        public FIFA(String name) {
            this.name = name;
        }

        @Override
        public void add(Football fb) {
            childrenIphone.add(fb);
        }

        @Override
        public void remove(Football fb) {
            childrenIphone.remove(fb);
        }

        @Override
        public void bestPlayer() {
            System.out.println(this.name + "选出的2017-18赛季最佳球员是：C罗");
            for (Football m : childrenIphone) {
                m.bestPlayer();
            }
        }
    }

    // 相当于叶子
    public static class OtherFC extends Football {
        private String player;

        public OtherFC(String name, String player) {
            this.name = name;
            this.player = player;
        }

        @Override
        public void add(Football fb) {

        }

        @Override
        public void remove(Football fb) {

        }

        @Override
        public void bestPlayer() {
            System.out.println(this.name + "选出的2017-18赛季最佳球员是：" + player);
        }
    }

    public static void main(String[] args) {
        Football fifa = new FIFA("国际足联");
        Football afc = new OtherFC("亚洲足联", "武磊");
        Football uefc = new OtherFC("欧洲足联", "萨拉赫");
        fifa.add(afc);
        fifa.add(uefc);
        fifa.bestPlayer();
    }
}
