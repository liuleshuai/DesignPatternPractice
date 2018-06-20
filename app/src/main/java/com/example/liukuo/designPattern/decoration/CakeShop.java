package com.example.liukuo.designPattern.decoration;

/**
 * 装饰者模式
 * 动态的给对象添加一些额外的属性或行为。相比于使用继承，装饰者模式更加灵活。
 * Created by LiuKuo at 2018/6/15
 */

public class CakeShop {

    public static class Cake extends Sweet {
        @Override
        public String getRemark() {
            return "订一个蛋糕";
        }

        @Override
        public int cost() {
            return 25;
        }
    }

    public static class FruitDecorator extends Decorator {
        private Sweet sweet;

        public FruitDecorator(Sweet sweet) {
            this.sweet = sweet;
        }

        @Override
        public String getRemark() {
            return sweet.getRemark() + "，记得添加水果";
        }

        @Override
        public int cost() {
            return sweet.cost() + 5;
        }
    }

    public static class IceCreamDecorator extends Decorator {
        private Sweet sweet;

        public IceCreamDecorator(Sweet sweet) {
            this.sweet = sweet;
        }

        @Override
        public String getRemark() {
            return sweet.getRemark() + "，记得添加冰淇淋";
        }

        @Override
        public int cost() {
            return sweet.cost() + 5;
        }
    }

    public static class CandleDecorator extends Decorator {
        private Sweet sweet;

        public CandleDecorator(Sweet sweet) {
            this.sweet = sweet;
        }

        @Override
        public String getRemark() {
            return sweet.getRemark() + "，记得添加蜡烛";
        }

        @Override
        public int cost() {
            return sweet.cost() + 5;
        }
    }

    public static void main(String[] args) {
        Cake cake = new Cake();
        System.out.println(cake.getRemark());
        FruitDecorator fruitCake = new FruitDecorator(cake);
        System.out.println(fruitCake.getRemark());
        IceCreamDecorator iceCreamCake = new IceCreamDecorator(fruitCake);
        System.out.println(iceCreamCake.getRemark());
        CandleDecorator candleDecorator = new CandleDecorator(new FruitDecorator(new Cake()));
        System.out.println(candleDecorator.getRemark());
    }
}
