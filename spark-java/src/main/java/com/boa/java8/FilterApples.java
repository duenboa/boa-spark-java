package com.boa.java8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DuenBoa
 * @date 2018/1/23
 */
public class FilterApples {

    static List<Apple> filterApples(List<Apple> list, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : list) {
            if (p.filter(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Apple> list = new ArrayList<Apple>() {{
            add(new Apple("blue", 1));
            add(new Apple("green", 2));
            add(new Apple("red", 3));
        }};
        List<Apple> apples = filterApples(list, Apple::isGreenApple);
        System.out.println(apples);
    }

    public interface Predicate<T> {
        boolean filter(T t);
    }

    public static class Apple {
        private String color;
        private Integer weight;
        public Apple(String color, Integer weight) {
            this.color = color;
            this.weight = weight;
        }

        public static boolean isGreenApple(Apple apple) {
            return "green".equals(apple.getColor());
        }

        public static boolean isHeavyApple(Apple apple) {
            return apple.getWeight() > 150;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Apple{" +
                    "color='" + color + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }

}
