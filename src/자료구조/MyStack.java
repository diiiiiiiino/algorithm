package 자료구조;

import java.util.ArrayList;
import java.util.List;

public class MyStack<T> {
    private List<T> stack = new ArrayList<>();

    public boolean push(T item) {
        return stack.add(item);
    }

    public T pop() {
        return stack.isEmpty() ? null : stack.remove(stack.size() - 1);
    }
}
