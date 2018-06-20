package com.example.liukuo.designPattern.strategy;

/**
 * 策略模式
 * 策略模式属于对象的行为模式。其用意是针对一组算法，将每一个算法封装到具有共同接口的独立的类中，从而使得它们可以相互替换。
 * Created by LiuKuo at 2018/6/19
 */

public class FootballPlayer {
    public interface Strategy {
        String method();
    }

    public static class Player {
        private Strategy strategy;
        private String name;

        public Player(String name) {
            this.name = name;
        }

        public void setStrategy(Strategy strategy) {
            this.strategy = strategy;
        }

        public void shoot() {
            System.out.println(name + strategy.method());
        }
    }

    public static class RemoteShoot implements Strategy {

        @Override
        public String method() {
            return "远射得分！";
        }
    }

    public static class Freekicks implements Strategy {

        @Override
        public String method() {
            return "任意球得分！";
        }
    }

    public static class Penalty implements Strategy {

        @Override
        public String method() {
            return "点球得分！";
        }
    }

    public static void main(String[] args) {
        Player player = new Player("Messi");
        RemoteShoot remoteShoot = new RemoteShoot();
        player.setStrategy(remoteShoot);
        player.shoot();
    }
}
