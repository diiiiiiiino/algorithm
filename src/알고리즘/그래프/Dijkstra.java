package 알고리즘.그래프;

import java.util.*;

public class Dijkstra {


    public HashMap<String, Integer> dijkstraFunc(HashMap<String, List<DijkstraEdge>> graph, String start){
        HashMap<String, Integer> distances = new HashMap<>();
        for (String key : graph.keySet()) {
            distances.put(key, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        PriorityQueue<DijkstraEdge> needVisit = new PriorityQueue<>();
        needVisit.add(new DijkstraEdge(distances.get(start), start));

        // 알고리즘 작성
        while (needVisit.size() > 0) {
            DijkstraEdge edgeNode = needVisit.poll();
            int currentDistance = edgeNode.distance;
            String currentNode = edgeNode.vertex;

            if (distances.get(currentNode) < currentDistance) {
                continue;
            }

            List<DijkstraEdge> nodeList = graph.get(currentNode);
            for (int index = 0; index < nodeList.size(); index++) {
                DijkstraEdge adjacentNode = nodeList.get(index);
                String adjacent = adjacentNode.vertex;
                int weight = adjacentNode.distance;
                int distance = currentDistance + weight;

                if (distance < distances.get(adjacent)) {
                    distances.put(adjacent, distance);
                    needVisit.add(new DijkstraEdge(distance, adjacent));
                }
            }
        }
        return distances;
    }

    public HashMap<String, Integer> dijkstraFunc2(HashMap<String, List<DijkstraEdge>> graph, String start){
        HashMap<String, Integer> distance = new HashMap<>();
        graph.keySet()
                .forEach(key -> distance.put(key, Integer.MAX_VALUE));

        distance.put(start, 0);

        PriorityQueue<DijkstraEdge> needVisit = new PriorityQueue();
        needVisit.add(new DijkstraEdge(distance.get(start), start));

        while(needVisit.size() > 0) {
            DijkstraEdge edge = needVisit.poll();
            String currentVertex = edge.vertex;
            int currentDistance = edge.distance;

            if(currentDistance > distance.get(currentVertex)) {
                continue;
            }

            List<DijkstraEdge> edges = graph.get(currentVertex);
            for(DijkstraEdge e : edges) {
                DijkstraEdge adjacentEdge = e;
                String adjacentVertex = adjacentEdge.vertex;
                int adjacentDistance = adjacentEdge.distance;
                int totalDistance = currentDistance + adjacentDistance;

                if(totalDistance < distance.get(adjacentVertex)) {
                    distance.put(adjacentVertex, totalDistance);
                    needVisit.add(new DijkstraEdge(totalDistance, adjacentVertex));
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        HashMap<String, List<DijkstraEdge>> graph = new HashMap<>();
        graph.put("A", List.of(new DijkstraEdge(8, "B"), new DijkstraEdge(1, "C"), new DijkstraEdge(2, "D")));
        graph.put("B", List.of());
        graph.put("C", List.of(new DijkstraEdge(5, "B"), new DijkstraEdge(2, "D")));
        graph.put("D", List.of(new DijkstraEdge(3, "E"), new DijkstraEdge(5, "F")));
        graph.put("E", List.of(new DijkstraEdge(1, "F")));
        graph.put("F", List.of(new DijkstraEdge(5, "A")));

        Dijkstra dObject = new Dijkstra();
        System.out.println(dObject.dijkstraFunc2(graph, "A"));
    }
}
