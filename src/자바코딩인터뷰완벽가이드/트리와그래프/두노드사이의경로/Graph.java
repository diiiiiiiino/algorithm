package 자바코딩인터뷰완벽가이드.트리와그래프.두노드사이의경로;

import java.util.*;

public class Graph<T> {
    private final Map<T, List<T>> adjacencyList;

    public Graph(){
        this.adjacencyList = new HashMap<>();
    }

    public boolean addEdge(T from, T to){
        if(from == null || to == null){
            return false;
        }

        List<T> adjacents = adjacencyList.get(from);

        if(adjacents == null){
            List<T> list = new ArrayList<>();
            list.add(to);

            adjacencyList.put(from, list);
        } else {
            adjacents.add(to);
        }

        return true;
    }

    public boolean isPath(T from, T to){
        if(from == null || to == null){
            return false;
        }

        if(from == to){
            return true;
        }

        Queue<T> queue = new ArrayDeque<>();
        Set<T> visited = new HashSet<>();

        visited.add(from);
        queue.add(from);

        while(!queue.isEmpty()){
            T element = queue.poll();

            List<T> adjacents = adjacencyList.get(element);
            if(adjacents != null){
                for(T t : adjacents){
                    if(t != null && !visited.contains(t)){
                        visited.add(t);
                        queue.add(t);

                        if(t.equals(to)){
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }
}
