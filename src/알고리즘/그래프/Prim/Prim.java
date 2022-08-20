package 알고리즘.그래프.Prim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Prim {
    public ArrayList<Edge> func(ArrayList<Edge> edges, String startNode){
        ArrayList<Edge> mst  = new ArrayList<>();
        HashMap<String, ArrayList<Edge>> adjacentMap = new HashMap<>();
        ArrayList<String> connectedNodes = new ArrayList<>();

        for(Edge edge : edges){
            if(!adjacentMap.containsKey(edge.node1)){
                adjacentMap.put(edge.node1, new ArrayList<>());
            }

            if(!adjacentMap.containsKey(edge.node2)){
                adjacentMap.put(edge.node2, new ArrayList<>());
            }
        }

        for(Edge edge : edges){
            ArrayList<Edge> adjacents = adjacentMap.get(edge.node1);
            adjacents.add(new Edge(edge.weight, edge.node1, edge.node2));

            adjacents = adjacentMap.get(edge.node2);
            adjacents.add(new Edge(edge.weight, edge.node2, edge.node1));
        }

        connectedNodes.add(startNode);
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        for(Edge edge : adjacentMap.get(startNode)){
            priorityQueue.add(edge);
        }

        while(priorityQueue.size() > 0){
            Edge edge = priorityQueue.poll();

            if(!connectedNodes.contains(edge.node2)) {
                mst.add(edge);
                connectedNodes.add(edge.node2);

                ArrayList<Edge> adjacentEdges = adjacentMap.get(edge.node2);
                for(Edge adjacentEdge : adjacentEdges){
                    if(!connectedNodes.contains(adjacentEdge.node2)){
                        priorityQueue.add(adjacentEdge);
                    }
                }
            }

        }

        return mst;
    }

    public static void main(String[] args){
        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge(7, "A", "B"));
        edges.add(new Edge(5, "A", "D"));
        edges.add(new Edge(9, "B", "D"));
        edges.add(new Edge(8, "B", "C"));
        edges.add(new Edge(7, "B", "E"));
        edges.add(new Edge(5, "C", "E"));
        edges.add(new Edge(7, "D", "E"));
        edges.add(new Edge(6, "D", "F"));
        edges.add(new Edge(8, "E", "F"));
        edges.add(new Edge(9, "E", "G"));
        edges.add(new Edge(11, "F", "G"));

        Prim prim = new Prim();
        System.out.println(prim.func(edges, "A"));
    }
}
