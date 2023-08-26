package 자바코딩인터뷰완벽가이드.트리와그래프.두노드사이의경로;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyGraph<T> {

    private Map<T, List<T>> adj;

    public MyGraph() {
        this.adj = new HashMap<>();
    }

    private void addEdge(T from, T to) {
        if (from == null || to == null) {
            return;
        }

        List<T> list = adj.getOrDefault(from, new ArrayList<>());

        if(list.isEmpty()){
            adj.put(from, list);
        }

        list.add(to);
    }

    private boolean isPath(T from, T to) {
        if (from == null || to == null) {
            return false;
        }

        if(from == to){
            return true;
        }

        Map<T, Boolean> visited = new HashMap<>();

        dfs(from, visited);

        return visited.getOrDefault(to, false);
    }

    private void dfs(T from, Map<T, Boolean> visited){
        visited.put(from, true);

        for(T y : adj.getOrDefault(from, new ArrayList<>())){
            if(visited.getOrDefault(y, false)) continue;
            dfs(y, visited);
        }
    }

    public static void main(String[] args) {
        MyGraph<String> myGraph = new MyGraph();

        // 유향 그래프
        myGraph.addEdge("A", "C");
        myGraph.addEdge("C", "B");
        myGraph.addEdge("C", "E");
        myGraph.addEdge("B", "E");
        myGraph.addEdge("D", "A");
        myGraph.addEdge("D", "B");

        boolean isPathAE = myGraph.isPath("A", "E");
        System.out.println("Is path from A to E: " + isPathAE);

        boolean isPathEA = myGraph.isPath("E", "A");
        System.out.println("Is path from E to A: " + isPathEA);

        boolean isPathCD = myGraph.isPath("C", "D");
        System.out.println("Is path from C to D: " + isPathCD);

        boolean isPathDC = myGraph.isPath("D", "C");
        System.out.println("Is path from D to C: " + isPathDC);

        boolean isPathDE = myGraph.isPath("D", "E");
        System.out.println("Is path from D to E: " + isPathDE);

        boolean isPathED = myGraph.isPath("E", "D");
        System.out.println("Is path from E to D: " + isPathED);
    }




}
