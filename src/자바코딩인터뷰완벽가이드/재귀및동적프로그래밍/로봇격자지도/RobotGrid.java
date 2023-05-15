package 자바코딩인터뷰완벽가이드.재귀및동적프로그래밍.로봇격자지도;

import java.awt.*;
import java.util.Set;

public class RobotGrid {
    private RobotGrid(){
        throw new AssertionError("Cannot be instantiated");
    }

    public static boolean computePath(int m, int n, boolean[][] maze, Set<Point> path){
        if(path == null || maze == null){
            throw new IllegalArgumentException("Path and maze cannot be null");
        }

        if(m < 0 || n < 0){
            return false;
        }

        if(maze[m][n]){
            return false;
        }

        if((m == 0 && n == 0) ||
                computePath(m, n - 1, maze, path) ||
                computePath(m - 1, n, maze, path)){
            path.add(new Point(m, n));
            return true;
        }

        return false;
    }
}
