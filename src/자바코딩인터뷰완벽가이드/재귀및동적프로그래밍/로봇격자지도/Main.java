package 자바코딩인터뷰완벽가이드.재귀및동적프로그래밍.로봇격자지도;

import java.awt.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        /* R - 로봇, # - 미로, T - 도달 위치
        (m, n) +           +
               |R| | | | | |
               |R|R| | | | |
               |#|R|R|R|R| |
               |#|#|#|#|R| |
               | | | | |R| |
               | | | | |R|T|
               +           + (0, 0)
        */

        // LinkedHashSet에 경로를 저장합니다.
        Set<Point> path = new LinkedHashSet<>();

        // 미로를 정의합니다.
        boolean[][] maze  = new boolean[2][2];
        maze[1][0]=true;

        // 경로를 계산하고 표시합니다.
        RobotGrid.computePath(1, 1, maze, path);

        System.out.println("Computed path (plain recursion):");
        path.forEach(System.out::println);

        System.out.println(-75 >> 1);
        System.out.println(75 >> 1);
        System.out.println(-75 >>> 1);
        System.out.println(Integer.toBinaryString(-75) + " " + Integer.toBinaryString(-75 >>> 1) + " " + (-75 >>> 1));
    }
}