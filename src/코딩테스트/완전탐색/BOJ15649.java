package 코딩테스트.완전탐색;

/**
 * https://www.acmicpc.net/problem/15649
 */
public class BOJ15649 {
    static int N = 4, M = 2;
    static int[] selected = new int[M + 1];
    static int[] used = new int[N + 1];

    public static void func(int k){
        if(k == M + 1){
            for(int i = 1; i < M + 1; i++){
                System.out.print(selected[i] + " ");
            }
            System.out.println();
        } else {
            for(int i = 1; i <= N; i++){
                if(used[i] == 1) continue;

                selected[k] = i; used[i] = 1;
                func(k + 1);
                selected[k] = 0; used[i] = 0;
            }
        }
    }

    public static void main(String[] args){
        func(1);
    }
}
