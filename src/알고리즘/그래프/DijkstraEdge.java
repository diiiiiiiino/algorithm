package 알고리즘.그래프;

public class DijkstraEdge implements Comparable<DijkstraEdge>{
    public int distance;
    public String vertex;

    public DijkstraEdge(int distance, String vertex){
        this.distance = distance;
        this.vertex = vertex;
    }

    public String toString(){
        return "vertex : " + this.vertex + " , distance " + this.distance;
    }

    @Override
    public int compareTo(DijkstraEdge o) {
        return this.distance - o.distance;
    }
}
