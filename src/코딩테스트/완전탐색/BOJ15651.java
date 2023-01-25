package 코딩테스트.완전탐색;

/**
 * https://www.acmicpc.net/problem/15651
 */
public class BOJ15651 {
    static int N = 4, M = 2;
    static int[] selected = new int[M + 1];

    public static void func(int k){
        if(k == M + 1){
            for(int i = 1; i < M + 1; i++){
                System.out.print(selected[i] + " ");
            }
            System.out.println();

            return;
        }

        for(int i = 1; i <= N; i++){
            selected[k] = i;
            func(k+1);
            selected[k] = 0;
        }
    }

    public static void main(String[] args){
        func(1);
    }
}
