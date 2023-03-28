package 모던자바인액션.람다표현식.생성자참조;

import 모던자바인액션.람다표현식.람다조합.Apple;
import 모던자바인액션.람다표현식.람다조합.Color;
import 모던자바인액션.람다표현식.람다조합.Fruit;
import 모던자바인액션.람다표현식.람다조합.Orange;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    static Map<String, Function<Integer, Fruit>> map = new HashMap<>();


    public static void main(String[] args){
        Supplier<Apple> c1 = () -> new Apple();
        c1 = Apple::new;
        Apple a1 = c1.get();

        Function<Integer, Apple> c2 = (weight) -> new Apple(weight);
        c2 = Apple::new;
        Apple a2 = c2.apply(55);

        Function<Color, Apple> c3 = (color) -> new Apple(color);
        c3 = Apple::new;
        Apple a3 = c3.apply(Color.RED);

        BiFunction<Integer, Color, Apple> c4 = (weight, color) -> new Apple(weight, color);
        c4 = Apple::new;
        Apple a4 = c4.apply(170, Color.RED);

        TripleFunction<Integer, Color, Integer, Apple> c5 = (weight, color, price) -> new Apple(weight, color, price);
        c5 = Apple::new;
        Apple a5 = c5.apply(170, Color.BLUE, 100);

        map.put("apple", Apple::new);
        map.put("orange", Orange::new);

        Fruit apple = giveMeFruit("apple", 170);
        Fruit orange = giveMeFruit("orange", 99);
    }

    public static Fruit giveMeFruit(String fruit, Integer weight){
        return map.get(fruit.toLowerCase())
                .apply(weight);
    }
}
