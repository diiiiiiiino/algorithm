package 자바코딩인터뷰완벽가이드.트리와그래프.체스기사;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ChessKnight {

    private class Node{
        private final int r;
        private final int c;
        private int distance;

        private Node(int r, int c) {
            this.r = r;
            this.c = c;
        }

        private Node(int r, int c, int distance){
            this.r = r;
            this.c = c;
            this.distance = distance;
        }
    }

    private static final int[] ROW = {2, 1, -1, -2, -2, -1, 1, 2};
    private static final int[] COL = {1, 2, 2, 1, -1, -2, -2, -1};

    private int countKnightMoves(int rs, int cs, int rt, int ct, int n) {
        Node startCell = new Node(rs, cs);

        Node targetCell = new Node(rt, ct);

        return countKnightMoves(startCell, targetCell, n);
    }

    private int countKnightMoves(Node startCell, Node targetCell, int n) {
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(startCell);

        while(!queue.isEmpty()){
            Node q = queue.poll();

            int c = q.c;
            int r = q.r;
            int distance = q.distance;

            if(c == targetCell.c && r == targetCell.r){
                return distance;
            }

            if(visited.contains(q)) continue;
            visited.add(q);

            for(int i = 0; i < ROW.length; i++){
                int nc = COL[i] + c;
                int nr = ROW[i] + r;
                if(nc < 0 || nr < 0 || nc >= n || nr >= n) continue;

                queue.add(new Node(nc, nr, distance + 1));
            }
        }

        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        ChessKnight ck = new ChessKnight();

        int movesNr = ck.countKnightMoves(0, 7, 7, 0, 8);

        System.out.println("Minimum number of needed moves: " + movesNr);
    }
}
