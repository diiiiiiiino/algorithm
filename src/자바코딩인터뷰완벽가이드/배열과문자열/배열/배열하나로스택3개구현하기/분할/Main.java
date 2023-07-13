package 자바코딩인터뷰완벽가이드.배열과문자열.배열.배열하나로스택3개구현하기.분할;

import 자바코딩인터뷰완벽가이드.배열과문자열.배열.배열하나로스택3개구현하기.OverflowException;
import 자바코딩인터뷰완벽가이드.배열과문자열.배열.배열하나로스택3개구현하기.UnderflowException;

public class Main {
    public static void main(String[] args) throws OverflowException, UnderflowException {
        ThreeStack ts = new ThreeStack(10);

        // 0 - 첫 번째 스택
        // 1 - 두 번째 스택
        // 2 - 세 번째 스택

        // 두 번째 스택에서 2, 12, 1을 푸시합니다.
        ts.push(1, 2);
        ts.push(1, 12);
        ts.push(1, 1);
        ts.printStacks();

        System.out.println("----------------------------------------");

        // 세 번째 스택에서 91, 21을 푸시하고 두 번째 스택에서 팝합니다.
        ts.push(2, 91);
        ts.push(2, 21);
        int value = ts.pop(1);
        System.out.println("\nPop from second stack: " + value);
        ts.printStacks();

        System.out.println("----------------------------------------");

        // 첫 번째 스택에서 23, 11, 3을 푸시합니다.
        ts.push(0, 23);
        ts.push(0, 11);
        ts.push(0, 3);
        ts.printStacks();

        System.out.println("----------------------------------------");

        // 각 스택에서 노드 하나를 팝합니다.
        int value1 = ts.pop(0);
        int value2 = ts.pop(1);
        int value3 = ts.pop(2);
        ts.printStacks();

        System.out.println();
        System.out.println("Pop: " + value1);
        System.out.println("Pop: " + value2);
        System.out.println("Pop: " + value3);
    }
}