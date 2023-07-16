package 코딩테스트.프로그래머스.그래프.다시풀기.방의개수;

import javax.sound.midi.Soundbank;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    private static class Vertex{
        public final int x;
        public final int y;
        public final String id;
        public final Set<String> connectedVertices;

        public Vertex(int x, int y){
            this.x = x;
            this.y = y;
            this.id = id(x, y);
            this.connectedVertices = new HashSet<>();
        }

        public static String id(int x, int y){
            return String.format("(%d, %d)", x, y);
        }
    }

    private static final int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    private static final int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    public int solution(int[] arrows){
        int count = 0;
        Map<String, Vertex> vertices = new HashMap<>();

        Vertex v = new Vertex(0, 0);
        vertices.put(v.id, v);
        for(int d : arrows){
            for(int i = 0; i < 2; i++){
                int x = v.x + dx[d];
                int y = v.y + dy[d];
                String id = Vertex.id(x, y);

                if(!vertices.containsKey(id)){
                    vertices.put(id, new Vertex(x, y));
                } else if(!v.connectedVertices.contains(id)){
                    count++;
                }

                Vertex u = vertices.get(id);
                v.connectedVertices.add(u.id);
                v.connectedVertices.add(v.id);
                v = vertices.get(id);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[]{6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0});
    }
}
