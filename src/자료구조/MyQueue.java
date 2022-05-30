package 자료구조;

import java.util.ArrayList;
import java.util.List;

public class MyQueue<T> {
    private List<T> queue = new ArrayList<>();

    public boolean add(T item){
        return queue.add(item);
    }

    public T poll() {
        return queue.isEmpty() ? null : queue.remove(0);
    }
}
