package 모던자바인액션.생성자참조;

@FunctionalInterface
public interface TripleFunction<T, U, K, R> {
    R apply(T weight, U color, K price);
}
