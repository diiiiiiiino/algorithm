package 자바코딩인터뷰완벽가이드.트리와그래프.K번째로큰요소;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node root;

    private class Node{
        private T element;
        private Node left;
        private Node right;

        public Node(T element, Node left, Node right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "element=" + element;
        }
    }

    public boolean insert(T element){
        if(element == null){
            return false;
        }

        if(contains(element)){
            return false;
        }

        root = insert(root, element);

        return true;
    }

    private Node insert(Node current, T element) {
        if(current == null){
           return new Node(element, null, null);
        }

        if(element.compareTo(current.element) < 0){
            current.left = insert(current.left, element);
        } else {
            current.right = insert(current.right, element);
        }

        return current;
    }

    public boolean contains(T element){
        return contains(root, element);
    }

    private boolean contains(Node current, T element) {
        if(current == null || element == null){
            return false;
        }

        if(element.compareTo(current.element) == 0){
            return true;
        }

        return element.compareTo(current.element) > 0 ? contains(current.right, element) : contains(current.left, element);
    }

    public void kthLargest2(int k){
        List<T> elements = new ArrayList<>();
        kthLargest2(root, elements);

        System.out.println(elements.get(elements.size() - k));
    }

    public void kthLargest2(Node current, List<T> elements){
        if(current == null || elements == null){
            return;
        }

        kthLargest2(current.left, elements);
        elements.add(current.element);
        kthLargest2(current.right, elements);
    }

    public void kthLargest(int k){
        kthLargest(root, k);
    }

    private int c;
    private void kthLargest(Node root, int k) {
        if(root == null || c >= k){
            return;
        }

        kthLargest(root.right, k);
        c++;

        if(c == k){
            System.out.println(root.element);
        }

        kthLargest(root.left, k);
    }

    public static void main(String[] args) {
        /*
                  50
                /    \
              45      54
                \    /  \
                47  52  56
                    /
                   55

                  40
                /    \
              30      45
             /  \    /  \
            15  33  42  56
           / \      /     \
          5  17    41      67
        */
        BinarySearchTree<Integer> bt = new BinarySearchTree<>();

        /*bt.insert(56);
        bt.insert(55);
        bt.insert(54);
        bt.insert(52);
        bt.insert(50);
        bt.insert(47);
        bt.insert(45);*/

        bt.insert(40);
        bt.insert(30);
        bt.insert(45);
        bt.insert(15);
        bt.insert(33);
        bt.insert(42);
        bt.insert(56);
        bt.insert(5);
        bt.insert(17);
        bt.insert(41);
        bt.insert(67);

        bt.kthLargest(3);
        bt.kthLargest2(3);
    }
}
