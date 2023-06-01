package 자바코딩인터뷰완벽가이드.배열과문자열.회전하는문자열;

import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.println(isRotation("helloworld", "orldhellow"));
    }

    public static boolean isRotation(String str1, String str2){
        return (str1 + str1).matches("(?i).*" + Pattern.quote(str2) + ".*");
    }
}
