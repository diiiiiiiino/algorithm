package 코딩테스트.프로그래머스.문자열.신규아이디추천;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution("...!@BaT#*..y.abcdefghijklm");
    }

    public String solution(String new_id) {
        String answer = "";

        answer = new_id.toLowerCase();
        answer = answer.replaceAll("[^a-z0-9\\-_.]", "");
        answer = answer.replaceAll("\\.{2,}", ".");
        answer = answer.replaceAll("^\\.", "");
        answer = answer.replaceAll("\\.$", "");

        if(answer.isEmpty()) {
            answer = "a";
        }

        if(answer.length() >= 16){
            answer = answer.substring(0, 15).replaceAll("\\.$", "");
        }

        while(answer.length() < 3){
            answer += answer.charAt(answer.length() - 1);
        }

        return answer;
    }
}