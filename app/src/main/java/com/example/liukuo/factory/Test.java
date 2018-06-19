package com.example.liukuo.factory;

/**
 * 工厂模式
 */
public class Test {

    public interface Graph {
        void description();
    }

    public static class Square implements Graph {

        @Override
        public void description() {
            System.out.println("这是一个正方形");
        }
    }

    public static class Circle implements Graph {

        @Override
        public void description() {
            System.out.println("这是一个圆形");
        }
    }

    public static class Factory {
        private Graph graph;

        public Graph create(Class<? extends Graph> clazz) {
            if (clazz.getName().equals(Square.class.getName())) {
                graph = new Square();
            } else if (clazz.getName().equals(Circle.class.getName())) {
                graph = new Circle();
            }
            return graph;
        }
    }

    public static void main(String[] args) {
        Factory factory = new Factory();
        Graph graph = factory.create(Circle.class);
        if (graph != null) {
            graph.description();
        }
    }
}
