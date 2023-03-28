package 모던자바인액션.람다표현식.람다조합;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static 모던자바인액션.람다표현식.람다조합.Color.GREEN;

public class Main {
    public static void main(String[] args){
        System.out.println("-------------------------1. Comparator 조합-----------------------------");
        List<Apple> apples = Arrays.stream(new Apple[]{ new Apple(5, Color.RED), new Apple(7, Color.BLUE), new Apple(5, GREEN), new Apple(1, Color.BLUE)})
                .collect(Collectors.toList());

        Comparator<Apple> c = Comparator.comparing(Fruit::getWeight);

        //apples.sort(c);
        //apples.sort(c.reversed());
        apples.sort(c.reversed().thenComparing(Apple::getColor));

        for(Apple apple : apples){
            System.out.println(apple.getWeight() + ", color : " + apple.getColor());
        }
        System.out.println("------------------------------------------------------");
        System.out.println("-------------------------2. Predicate 조합-----------------------------");

        Predicate<Apple> redApple = apple -> Color.RED.equals(apple.getColor());
        Predicate<Apple> notRedApple = redApple.negate();

        System.out.println("빨간 사과 아닐때 " + notRedApple.test(new Apple(5, Color.BLUE)));

        Predicate<Apple> redAndHeavyApple = redApple.and(apple -> apple.getWeight() > 150);
        System.out.println("빨간 사과면서 무게가 150보다 큰지 확인 " + redAndHeavyApple.test(new Apple(555, Color.RED)));

        Predicate<Apple> redAndHeavyAppleOrGreen = redAndHeavyApple.or(apple -> GREEN.equals(apple.getColor()));
        System.out.println("빨간 사과면서 무게가 150보다 크거나 그냥 녹색 사과인지 확인 " + redAndHeavyAppleOrGreen.test(new Apple(10, Color.RED)));

        System.out.println("------------------------------------------------------");
        System.out.println("-------------------------3. Function 조합-----------------------------");
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h = f.andThen(g);
        Function<Integer, Integer> compose = f.compose(g);

        int result = h.apply(1);
        System.out.println("andThen : " + result);

        int result2 = compose.apply(1);
        System.out.println("compose : " + result2);

        System.out.println("------------------------------------------------------");
    }
}
