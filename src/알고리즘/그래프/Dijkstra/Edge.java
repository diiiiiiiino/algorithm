package 알고리즘.그래프.Dijkstra;

public class Edge implements Comparable<Edge> {
    int distance;
    String vertex;

    public Edge(int distance, String vertex){
        this.distance = distance;
        this.vertex = vertex;
    }

    public String toString() {
        return "(" + distance + ", " + vertex + ")";
    }

    @Override
    public int compareTo(Edge edge){
        return this.distance - edge.distance;
    }
}
