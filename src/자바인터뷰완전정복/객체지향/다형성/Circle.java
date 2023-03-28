package 자바인터뷰완전정복.객체지향.다형성;

public class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("Draw a circle...");
    }
}
