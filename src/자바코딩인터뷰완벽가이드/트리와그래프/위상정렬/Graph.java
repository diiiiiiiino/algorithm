package 자바코딩인터뷰완벽가이드.트리와그래프.위상정렬;

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

    public Stack<T> topologicalSort(T startElement){
        Set<T> visited = new HashSet<>();
        Stack<T> stack = new Stack<>();
        topologicalSort(startElement, visited, stack);

        return stack;
    }

    private void topologicalSort(T currentElement, Set<T> visited, Stack<T> stack) {
        visited.add(currentElement);

        List<T> adjacents = adjacencyList.get(currentElement);
        if(adjacents != null){
            for(T t : adjacents){
                if(t != null && !visited.contains(t)){
                    topologicalSort(t, visited, stack);
                    visited.add(t);
                }
            }
        }

        stack.push(currentElement);
    }

    public static void main(String[] args) {
        Graph<String> graph = new Graph();

        graph.addEdge("D", "B");
        graph.addEdge("D", "A");
        graph.addEdge("B", "A");
        graph.addEdge("B", "C");
        graph.addEdge("B", "F");
        graph.addEdge("B", "E");
        graph.addEdge("E", "G");
        graph.addEdge("G", "H");
        graph.addEdge("A", "C");
        graph.addEdge("C", "F");
        graph.addEdge("F", "G");

        Stack<String> ts = graph.topologicalSort("D");

        while (ts.empty() == false) {
            System.out.print(ts.pop() + " ");
        }
    }
}
