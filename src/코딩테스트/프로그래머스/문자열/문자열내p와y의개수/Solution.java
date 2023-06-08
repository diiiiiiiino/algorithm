package 코딩테스트.프로그래머스.문자열.문자열내p와y의개수;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution2("pPoooyY");
    }

    boolean solution(String s) {
        boolean answer = true;
        s = s.toLowerCase();
        
        int pCount = 0;
        int yCount = 0;
        
        for(char ch : s.toCharArray()){
            if(ch == 'p') pCount++;
            if(ch == 'y') yCount++;
        }
        
        return pCount == yCount;
    }

    boolean solution2(String s){
        s = s.toLowerCase();

        int ps = s.length() - s.replace("p", "").length();
        int ys = s.length() - s.replace("y", "").length();

        return ps == ys;
    }


    boolean solution3(String s){
        int ps = 0;
        int ys = 0;

        for(char c : s.toCharArray()){
            switch(c){
                case 'p', 'P' -> ps++;
                case 'y', 'Y' -> ys++;
            }
        }

        return ps == ys;
    }
}