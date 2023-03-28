package 모던자바인액션.메서드참조;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Consumer<Integer> consumer = integer -> Test.staticMethod(integer);
        consumer = Test::staticMethod;

        consumer.accept(1);

        Test test = new Test();

        BiConsumer<Test, Integer> biConsumer = (test1, integer) -> test1.instanceMethod(integer);
        biConsumer = Test::instanceMethod;
        biConsumer.accept(test, 5);

        Consumer<Integer> consumer2 = integer -> test.instanceMethod(integer);
        consumer2 = test::instanceMethod;
        consumer2.accept(5);

    }
}
