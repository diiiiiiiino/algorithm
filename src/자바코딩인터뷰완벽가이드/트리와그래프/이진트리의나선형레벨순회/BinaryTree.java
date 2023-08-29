package 자바코딩인터뷰완벽가이드.트리와그래프.이진트리의나선형레벨순회;

import java.util.*;

public class BinaryTree<T> {
    private Node root = null;

    private class Node {
        private Node left;
        private Node right;

        private final T element;

        private Node(T element) {
            this.element = element;
            this.left = null;
            this.right = null;
        }

        private Node(Node left, Node right, T element) {
            this.element = element;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "element=" + element;
        }
    }

    public boolean insert(T element) {
        if (element == null) {
            return false;
        }

        if (root == null) {
            root = new Node(element);

            return true;
        }

        insert(root, element);

        return true;
    }

    private void insert(Node node, T element) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            node = queue.peek();
            queue.poll();

            if (node.left == null) {
                node.left = new Node(element);
                break;
            } else {
                queue.add(node.left);
            }

            if (node.right == null) {
                node.right = new Node(element);
                break;
            } else {
                queue.add(node.right);
            }
        }
    }

    public void spiralOrderTraversalTwoStacks() {
        if (root == null) {
            return;
        }

        printSpiralTwoStacks(root);
    }

    private void printSpiralTwoStacks(Node node) {
        if(node == null){
            return;
        }

        Stack<Node> lr = new Stack<>();
        Stack<Node> rl = new Stack<>();

        lr.push(node);

        while(!lr.isEmpty() || !rl.isEmpty()){

            while(!lr.isEmpty()){
                Node node1 = lr.pop();
                System.out.print(node1.element + " ");

                if(node1.left != null){
                    rl.push(node1.left);
                }

                if(node1.right != null){
                    rl.push(node1.right);
                }
            }

            while(!rl.isEmpty()){
                Node node1 = rl.pop();
                System.out.print(node1.element + " ");

                if(node1.right != null){
                    lr.push(node1.right);
                }

                if(node1.left != null){
                    lr.push(node1.left);
                }
            }
        }
    }

    public void spiralOrderTraversalDeque() {
        if (root == null) {
            return;
        }

        printSpiralDeque(root);
    }

    private void printSpiralDeque(Node root) {
        if(root == null){
            return;
        }

        Deque<Node> deque = new ArrayDeque<>();
        deque.addFirst(root);
        boolean isOdd = false;

        while(!deque.isEmpty()){
            int size = deque.size();
            int i = 0;

            if(isOdd){
                while(i < size) {
                    i++;

                    Node node = deque.pollFirst();
                    System.out.print(node.element + " ");

                    if(node.left != null){
                        deque.addLast(node.left);
                    }

                    if(node.right != null){
                        deque.addLast(node.right);
                    }
                }
            } else {
                while(i < size) {
                    i++;
                    Node node = deque.pollLast();
                    System.out.print(node.element + " ");

                    if(node.right != null){
                        deque.addFirst(node.right);
                    }

                    if(node.left != null){
                        deque.addFirst(node.left);
                    }
                }
            }

            isOdd = !isOdd;
        }
    }

    public static void main(String[] args) {
        /* 출력: 40 45 47 11 3 44 5 87 77 6 2 1 4 23 21 1 5 8
                40 47 45 5 44 3 11 21 23 4 1 2 6 77 87 8 5 1
                  ----40----
                 /          \
                47          45
              /    \      /    \
             11     3    44     5
           /   \   / \  /  \   / \
          21   23 4   1 2  6  77  87
          /\   /
         1  5 8
        */
        BinaryTree<Integer> bt = new BinaryTree<>();

        bt.insert(40);

        bt.insert(47);
        bt.insert(45);

        bt.insert(11);
        bt.insert(3);
        bt.insert(44);
        bt.insert(5);

        bt.insert(21);
        bt.insert(23);
        bt.insert(4);
        bt.insert(1);
        bt.insert(2);
        bt.insert(6);
        bt.insert(77);
        bt.insert(87);

        bt.insert(1);
        bt.insert(5);
        bt.insert(8);

        bt.spiralOrderTraversalTwoStacks();
        System.out.println();
        bt.spiralOrderTraversalDeque();
    }
}
