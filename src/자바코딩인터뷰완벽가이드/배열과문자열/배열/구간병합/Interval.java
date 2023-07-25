package 자바코딩인터뷰완벽가이드.배열과문자열.배열.구간병합;

public class Interval {
    int start, end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "[" + start + ", " + end + "]";
    }
}