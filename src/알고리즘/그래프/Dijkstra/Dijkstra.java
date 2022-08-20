package 알고리즘.그래프.Dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {
    public HashMap<String, Integer> func(HashMap<String, List<Edge>> graph, String startVertex) {
        HashMap<String, Integer> distances = new HashMap<>();
        graph.keySet().forEach(key -> distances.put(key, Integer.MAX_VALUE));

        distances.put(startVertex, 0);
        PriorityQueue<Edge> needVisit = new PriorityQueue<>();
        needVisit.add(new Edge(distances.get(startVertex), startVertex));

        while(needVisit.size() > 0) {
            Edge currentEdge = needVisit.poll();
            int currentDistance = currentEdge.distance;
            String currentVertex = currentEdge.vertex;

            if(distances.get(currentVertex) < currentDistance) {
                continue;
            }

            for(Edge edge : graph.get(currentVertex)){
                String adjacentVertex = edge.vertex;
                int adjacentDistance = edge.distance;
                int totalDistance = currentDistance + adjacentDistance;

                if(distances.get(adjacentVertex) > totalDistance) {
                    distances.put(adjacentVertex, totalDistance);
                    needVisit.add(new Edge(totalDistance, adjacentVertex));
                }
            }

        }

        return distances;
    }

    public static void main(String[] args){
        HashMap<String, List<Edge>> hashMap = new HashMap<>();
        hashMap.put("A", List.of(new Edge(8, "B"), new Edge(1, "C"), new Edge(2, "D")));
        hashMap.put("B", List.of());
        hashMap.put("C", List.of(new Edge(5, "B"), new Edge(2, "D")));
        hashMap.put("D", List.of(new Edge(3, "E"), new Edge(5, "F")));
        hashMap.put("E", List.of(new Edge(1, "F")));
        hashMap.put("F", List.of(new Edge(5, "A")));

        Dijkstra dijkstra = new Dijkstra();
        System.out.println(dijkstra.func(hashMap, "A"));
    }
}
