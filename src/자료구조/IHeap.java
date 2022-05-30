package 자료구조;

public interface IHeap {
    boolean insert(Integer data);
    Integer pop();
    boolean moveUp(Integer insertedIdx);
    boolean moveDown(Integer poppedIdx);
}
