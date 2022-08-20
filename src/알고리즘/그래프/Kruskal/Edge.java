package 알고리즘.그래프.Kruskal;

public class Edge implements Comparable<Edge>{
    int weight;
    String nodeU;
    String nodeV;

    public Edge(int weight, String nodeV, String nodeU){
        this.weight = weight;
        this.nodeV = nodeV;
        this.nodeU = nodeU;
    }

    public String toString(){
        return "(" + weight + ", " + nodeU + ", " + nodeV + ")";
    }

    @Override
    public int compareTo(Edge edge){
        return this.weight - edge.weight;
    }
}
