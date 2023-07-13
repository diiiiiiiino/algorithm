package 자바코딩인터뷰완벽가이드.배열과문자열.배열.배열하나로스택3개구현하기;

public class StackNode {
    public int value;
    public int backLink;

    public StackNode(int value, int backLink) {
        this.value = value;
        this.backLink = backLink;
    }

    @Override
    public String toString() {
        return "StackNode{" +
                "value=" + value +
                ", backLink=" + backLink +
                '}';
    }
}
