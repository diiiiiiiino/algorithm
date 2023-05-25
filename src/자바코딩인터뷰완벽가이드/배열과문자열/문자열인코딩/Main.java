package 자바코딩인터뷰완벽가이드.배열과문자열.문자열인코딩;

public class Main {
    public static void main(String[] args) {
        char[] str = " String with spaces ".toCharArray();
        System.out.println(encodeWhitespaces(str));
    }

    public static char[] encodeWhitespaces(char[] str){
        if(str == null){
            throw new IllegalArgumentException("The given string cannot be null");
        }

        int countWhitespaces = 0;
        for(int i = 0; i < str.length; i++){
            if(Character.isWhitespace(str[i])){
                countWhitespaces++;
            }
        }

        if(countWhitespaces > 0){
            char[] encodeStr = new char[str.length + countWhitespaces * 2];

            int index = 0;
            for(int i = 0; i < str.length; i++){
                if(Character.isWhitespace(str[i])){
                    encodeStr[index++] = '%';
                    encodeStr[index++] = '2';
                    encodeStr[index++] = '0';
                } else {
                    encodeStr[index++] = str[i];
                }
            }

            return encodeStr;
        }

        return str;
    }
}
