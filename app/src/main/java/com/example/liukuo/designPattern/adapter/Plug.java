package com.example.liukuo.designPattern.adapter;

/**
 * 适配器模式：(通过接口进行包装一下，已达到适配的目的)MVP模式
 * 适配器就是一种适配中间件，它存在于不匹配的二者之间，用于连接二者，
 * 将不匹配变得匹配，简单点理解就是平常所见的转接头，转换器之类的存在。
 * Created by LiuKuo at 2018/6/14
 * 主要用于如下场景：
 * <p>
 * （1）想要使用一个已经存在的类，但是它却不符合现有的接口规范，导致无法直接去访问，这时创建一个适配器就能间接去访问这个类中的方法。
 * <p>
 * （2）我们有一个类，想将其设计为可重用的类（可被多处访问），我们可以创建适配器来将这个类来适配其他没有提供合适接口的类。
 * <p>
 * 三相插头----适配器-----二相插头(实现通电)
 */

public class Plug {
    interface ThreePlug {
        void work();
    }

    interface TwoPlug {
        void work();
    }

    public static class KingTwoPlug implements TwoPlug {

        @Override
        public void work() {
            System.out.println("正常工作");
        }
    }

    public static class Adapter implements ThreePlug {
        private TwoPlug twoPlug;

        public Adapter(TwoPlug twoPlug) {
            this.twoPlug = twoPlug;
        }

        @Override
        public void work() {
            twoPlug.work();
        }
    }

    public static void main(String[] args) {
        TwoPlug twoPlug = new KingTwoPlug();
        Adapter adapter = new Adapter(twoPlug);
        adapter.work();
    }
}
