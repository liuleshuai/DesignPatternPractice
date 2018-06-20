package com.example.liukuo.designPattern.builder;

/**
 * android中建造者模式的一般写法
 *
 * @author 67017
 */
public class MyBuilder {
    private String text;
    private String color;
    private int width;

    public void setText(String text) {
        this.text = text;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void show() {
        System.out.println("文字：" + text + "，颜色：" + color + ",宽度：" + width);
    }

    public static class Builder {

        private MyBuilder instance = new MyBuilder();
        private static Builder builder = new Builder();

        public static Builder getBuilder() {
            return builder;
        }

        public Builder setText(String text) {
            instance.setText(text);
            return this;
        }

        public Builder setColor(String color) {
            instance.setColor(color);
            return this;
        }

        public Builder setWidth(int width) {
            instance.setWidth(width);
            return this;
        }

        public MyBuilder build() {
            return instance;
        }

    }

    public static void main(String[] args) {
        MyBuilder builder = MyBuilder.Builder.getBuilder().setText("您好").setColor("red").setWidth(100).build();
        builder.show();
    }
}
