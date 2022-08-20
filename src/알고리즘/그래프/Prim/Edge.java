package 알고리즘.그래프.Prim;

public class Edge implements Comparable<Edge> {
    int weight;
    String node1;
    String node2;

    public Edge(int weight, String node1, String node2){
        this.weight = weight;
        this.node1 = node1;
        this.node2 = node2;
    }

    public String toString(){
        return "(" + weight + ", " + node1 + ", " + node2 + ")";
    }

    @Override
    public int compareTo(Edge edge){
        return this.weight - edge.weight;
    }
}
