package 알고리즘.그래프;

public class KruskalEdge implements Comparable<KruskalEdge> {
    public int weight;
    public String nodeV;
    public String nodeU;

    public KruskalEdge(int weight, String nodeV, String nodeU){
        this.weight = weight;
        this.nodeV = nodeV;
        this.nodeU = nodeU;
    }

    public String toString() {
        return "(" + this.weight + ", " + this.nodeV + ", " + this.nodeU + ")";
    }

    @Override
    public int compareTo(KruskalEdge o) {
        return this.weight - o.weight;
    }
}
