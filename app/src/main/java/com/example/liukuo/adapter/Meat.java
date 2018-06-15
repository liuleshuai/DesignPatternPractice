package com.example.liukuo.adapter;

/**
 * 使用猪肉，按鸡肉的做法做菜。
 * Created by LiuKuo at 2018/6/14
 */

public class Meat {

    interface Pork {
        void cook();
    }

    public static class Chicken {
        public void cook() {
            System.out.println("小鸡炖蘑菇");
        }
    }

    public static class Adapter implements Pork {

        private Chicken chicken;

        public Adapter(Chicken chicken) {
            this.chicken = chicken;
        }

        @Override
        public void cook() {
            chicken.cook();
        }
    }

    public static void main(String[] args) {
        Chicken chicken = new Chicken();
        Pork pig = new Adapter(chicken);
        pig.cook();
    }
}
