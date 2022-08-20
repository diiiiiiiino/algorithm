package 알고리즘.그래프;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

// BFS :
public class BFS {

    public List<String> func(HashMap<String, List<String>> graph, String startNode) {
        ArrayList<String> visited = new ArrayList<>();
        LinkedList<String> needVisit = new LinkedList<>();

        needVisit.add(startNode);

        while(needVisit.size() > 0) {
            String node = needVisit.pollFirst();

            if(!visited.contains(node)) {
                visited.add(node);
                needVisit.addAll(graph.get(node));
            }
        }

        return visited;
    }

    public static void main(String[] args) {
        HashMap<String, List<String>> graph = new HashMap<>();
        graph.put("A", List.of("B", "C"));
        graph.put("B", List.of("A", "D"));
        graph.put("C", List.of("A", "G", "H", "I"));
        graph.put("D", List.of("B", "E", "F"));
        graph.put("E", List.of("D"));
        graph.put("F", List.of("D"));
        graph.put("G", List.of("C"));
        graph.put("H", List.of("C"));
        graph.put("I", List.of("C", "J"));
        graph.put("J", List.of("I"));

        BFS bfs = new BFS();
        System.out.println(bfs.func(graph, "A"));
    }
}
