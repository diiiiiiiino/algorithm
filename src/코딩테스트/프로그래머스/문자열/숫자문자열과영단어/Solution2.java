package 코딩테스트.프로그래머스.문자열.숫자문자열과영단어;

class Solution2 {
    private static final String[] words = {
            "zero", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine"
    };

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int result = solution.solution("one4seveneight");
        System.out.println(result);
    }

    public int solution(String s){
        for(int i = 0; i < words.length; i++){
            s = s.replace(words[i], Integer.toString(i));
        }

        return Integer.parseInt(s);
    }
}