package 알고리즘.그래프.Prim.advanced;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Prim {
    public ArrayList<Path> improvedPrimFunc(HashMap<String, HashMap<String, Integer>> graph, String startNode) {
        ArrayList<Path> mst = new ArrayList<>();

        HashMap<String, String> mstPath = new HashMap<>();
        HashMap<String, Edge> edgeMap = new HashMap<>();
        PriorityQueue<Edge> needVisit = new PriorityQueue<>();

        for(String key : graph.keySet()){
            Edge edge;
            if(key == startNode){
                edge = new Edge(key, 0);
                mstPath.put(key, key);
            } else {
                edge = new Edge(key, Integer.MAX_VALUE);
                mstPath.put(key, null);
            }

            edgeMap.put(key, edge);
            needVisit.add(edge);
        }

        while(needVisit.size() > 0){
            Edge currentEdge = needVisit.poll();
            edgeMap.remove(currentEdge.node);

            mst.add(new Path(mstPath.get(currentEdge.node), currentEdge.node, currentEdge.weight));

            HashMap<String, Integer> adjacentMap = graph.get(currentEdge.node);
            for(String key : adjacentMap.keySet()){
                if(edgeMap.containsKey(key)){
                    Edge adjacentEdge = edgeMap.get(key);

                    if(adjacentEdge.weight > adjacentMap.get(key)){
                        adjacentEdge.weight = adjacentMap.get(key);
                        mstPath.put(key, currentEdge.node);

                        needVisit.remove(adjacentEdge);
                        needVisit.add(adjacentEdge);
                    }
                }
            }

        }

        return mst;
    }

    public static void main(String[] args){
        HashMap<String, HashMap<String, Integer>> mygraph = new HashMap<>();

        HashMap<String, Integer> edges;
        edges = new HashMap<>();
        edges.put("B", 7);
        edges.put("D", 5);
        mygraph.put("A", edges);

        edges = new HashMap<>();
        edges.put("A", 7);
        edges.put("D", 9);
        edges.put("C", 8);
        edges.put("E", 7);
        mygraph.put("B", edges);

        edges = new HashMap<>();
        edges.put("B", 8);
        edges.put("E", 5);
        mygraph.put("C", edges);

        edges = new HashMap<>();
        edges.put("A", 5);
        edges.put("B", 9);
        edges.put("E", 7);
        edges.put("F", 6);
        mygraph.put("D", edges);

        edges = new HashMap<>();
        edges.put("B", 7);
        edges.put("C", 5);
        edges.put("D", 7);
        edges.put("F", 8);
        edges.put("G", 9);
        mygraph.put("E", edges);

        edges = new HashMap<>();
        edges.put("D", 6);
        edges.put("E", 8);
        edges.put("G", 11);
        mygraph.put("F", edges);

        edges = new HashMap<>();
        edges.put("E", 9);
        edges.put("F", 11);
        mygraph.put("G", edges);

        Prim prim = new Prim();
        System.out.println(prim.improvedPrimFunc(mygraph, "A"));

    }
}
