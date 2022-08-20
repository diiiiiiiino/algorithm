package 알고리즘.그래프.Kruskal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Kruskal {
    HashMap<String, String> parent = new HashMap<>();
    HashMap<String, Integer> rank = new HashMap<>();

    public String find(String node){
        if(parent.get(node) != node){
          parent.put(node, find(parent.get(node)));
        }

        return parent.get(node);
    }

    public void union(String root1, String root2){
        if(rank.get(root1) > rank.get(root2)){
            parent.put(root2, root1);
        } else {
            parent.put(root1, root2);
            if(rank.get(root1) == rank.get(root2)){
                rank.put(root2, rank.get(root2) + 1);
            }
        }
    }

    public ArrayList<Edge> func(ArrayList<Edge> edges, ArrayList<String> vertexes) {
        ArrayList<Edge> mst = new ArrayList<>();

        vertexes.forEach(key -> {
            parent.put(key, key);
            rank.put(key, 0);
        });

        Collections.sort(edges);

        for(Edge edge : edges){
            String root1 = find(edge.nodeV);
            String root2 = find(edge.nodeU);

            if(root1 != root2) {
                union(root1, root2);
                mst.add(edge);
            }
        }

        return mst;
    }


    public static void main(String[] args){
        ArrayList<String> vertexes = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F", "G"));

        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge(7, "A", "B"));
        edges.add(new Edge(5, "A", "D"));
        edges.add(new Edge(7, "B", "A"));
        edges.add(new Edge(8, "B", "C"));
        edges.add(new Edge(9, "B", "D"));
        edges.add(new Edge(7, "B", "E"));
        edges.add(new Edge(8, "C", "B"));
        edges.add(new Edge(5, "C", "E"));
        edges.add(new Edge(5, "D", "A"));
        edges.add(new Edge(9, "D", "B"));
        edges.add(new Edge(7, "D", "E"));
        edges.add(new Edge(6, "D", "F"));
        edges.add(new Edge(7, "E", "B"));
        edges.add(new Edge(5, "E", "C"));
        edges.add(new Edge(7, "E", "D"));
        edges.add(new Edge(8, "E", "F"));
        edges.add(new Edge(9, "E", "G"));
        edges.add(new Edge(6, "F", "D"));
        edges.add(new Edge(8, "F", "E"));
        edges.add(new Edge(11, "F", "G"));
        edges.add(new Edge(9, "G", "E"));
        edges.add(new Edge(11, "G", "F"));


        Kruskal kruskal = new Kruskal();
        System.out.println(kruskal.func(edges, vertexes));
    }
}
