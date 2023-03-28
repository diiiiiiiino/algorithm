package 모던자바인액션.람다표현식.생성자참조;

@FunctionalInterface
public interface TripleFunction<T, U, K, R> {
    R apply(T weight, U color, K price);
}
