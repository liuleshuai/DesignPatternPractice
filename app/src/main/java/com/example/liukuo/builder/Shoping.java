package com.example.liukuo.builder;

/**
 * 建造者模式
 * Created by LiuKuo at 2018/6/13
 * 作用：将一个复杂对象的构建与它的表示分离。
 * 在用户不知道对象的建造过程和细节的情况下就可以直接创建复杂的对象。
 * 1.用户只需要给出指定复杂对象的类型和内容；
 * 2.建造者模式负责按顺序创建复杂对象（把内部的建造过程和细节隐藏起来)
 * 解决的问题：
 * 1.方便用户创建复杂的对象（不需要知道实现过程）
 * 2.代码复用性 & 封装性（将对象构建过程和细节进行封装 & 复用）
 */

public class Shoping {

    /**
     * 其实可以不写接口
     */
    public interface IBuy {
        /**
         * 买电视
         */
        ShopBuy buyTv();

        /**
         * 买手机
         */
        ShopBuy buyPhone();

        /**
         * 买电脑
         */
        ShopBuy buyPc();

        Buy getBuy();
    }

    public static class ShopBuy implements IBuy {
        private Buy buy = new Buy();

        @Override
        public ShopBuy buyTv() {
            buy.setTv("海信");
            return this;
        }

        @Override
        public ShopBuy buyPhone() {
            buy.setPhone("iphone");
            return this;
        }

        @Override
        public ShopBuy buyPc() {
            buy.setPc("联想");
            return this;
        }

        @Override
        public Buy getBuy() {
            return buy;
        }
    }

    /**
     * 这块也可以不这样写，直接在用的时候根据需要进行配置
     */
    public static class ToBuy {
        void buy(IBuy build) {
            build.buyPc()
                    .buyPhone()
                    .buyTv()
                    .getBuy()
                    .show();
        }
    }

    public static class Buy {
        private String tv;
        private String phone;
        private String pc;

        public void setTv(String tv) {
            this.tv = tv;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public void setPc(String pc) {
            this.pc = pc;
        }

        public void show() {
            System.out.println("买了" + tv + "电视、" + phone + "手机、" + pc + "电脑！");
        }
    }

    public static void main(String[] args) {
        ShopBuy shopBuy = new ShopBuy();
        ToBuy toBuy = new ToBuy();
        toBuy.buy(shopBuy);
    }
}
