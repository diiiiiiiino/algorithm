package 코딩테스트.프로그래머스.문자열.숫자문자열과영단어;

class Solution {
    private static final String[] words = {
            "zero", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine"
    };

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution2("one4seveneight");
        System.out.println(result);
    }

    public int solution2(String s){
        for(int i = 0; i < words.length; i++){
            s = s.replace(words[i], Integer.toString(i));
        }

        return Integer.parseInt(s);
    }

    public int solution(String s) {
        int answer = 0;
        
        char[] chars = s.toCharArray();
        
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for(char ch : chars){
            if(Character.isAlphabetic(ch)){
                sb.append(ch);
                int num = translateNum(sb.toString());
                if(num != -1){
                    result.append(num);
                    sb.delete(0, sb.length());
                }
            } else {
                result.append(ch);
            }
        }
        
        return Integer.parseInt(result.toString());
    }
    
    int translateNum(String s){
        int result = -1;
        switch(s){
            case "zero": 
                result = 0;
                break;
            case "one": 
                result = 1;
                break;
            case "two": 
                result = 2;
                break;
            case "three": 
                result = 3;
                break;
            case "four" : 
                result = 4;
                break;
            case "five" : 
                result = 5;
                break;
            case "six" : 
                result = 6;
                break;
            case "seven" : 
                result = 7;
                break;
            case "eight" : 
                result = 8;
                break;
            case "nine" : 
                result = 9;
                break;
        }
        return result;
    }
}