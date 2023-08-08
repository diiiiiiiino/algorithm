package 자바코딩인터뷰완벽가이드.배열과문자열.게임점수계산;

public class Scores {
    public static int count(int n){
        if(n <= 0){
            return - 1;
        }

        int[] table = new int[n + 1];
        table[0] = 1;

        for(int i = 3; i <= n; i++){
            table[i] += table[i - 3];
        }

        for(int i = 5; i <= n; i++){
            table[i] += table[i - 5];
        }

        for(int i = 10; i <= n; i++){
            table[i] += table[i - 10];
        }

        return table[n];
    }

    public static void main(String[] args) {
        System.out.println("33: " + Scores.count(15));
        System.out.println("18: " + Scores.count(30));
    }
}
