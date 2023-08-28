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
        if (node == null) {
            return;
        }

        Stack<Node> rl = new Stack<>();
        Stack<Node> lr = new Stack<>();

        rl.push(node);

        while (!rl.empty() || !lr.empty()) {
            while (!rl.empty()) {
                Node temp = rl.peek();
                rl.pop();

                System.out.print(temp.element + " ");

                if (temp.right != null) {
                    lr.push(temp.right);
                }

                if (temp.left != null) {
                    lr.push(temp.left);
                }
            }

            while (!lr.empty()) {
                Node temp = lr.peek();
                lr.pop();

                System.out.print(temp.element + " ");

                if (temp.left != null) {
                    rl.push(temp.left);
                }
                if (temp.right != null) {
                    rl.push(temp.right);
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
        if (root == null) {
            return;
        }

        Deque<Node> deque = new ArrayDeque<>();
        deque.addFirst(root);

        // 홀수 또는 짝수 레벨인지 확인
        boolean oddEvenFlag = false;

        while (!deque.isEmpty()) {
            int nodesNo = deque.size();

            if (oddEvenFlag) {
                while (nodesNo > 0) {
                    Node currentNode = deque.pollFirst();
                    System.out.print(currentNode.element + " ");

                    if (currentNode.left != null) {
                        deque.addLast(currentNode.left);
                    }

                    if (currentNode.right != null) {
                        deque.addLast(currentNode.right);
                    }

                    nodesNo--;
                }
            } else {
                while (nodesNo > 0) {
                    Node currentNode = deque.pollLast();

                    System.out.print(currentNode.element + " ");

                    if (currentNode.right != null) {
                        deque.addFirst(currentNode.right);
                    }

                    if (currentNode.left != null) {
                        deque.addFirst(currentNode.left);
                    }

                    nodesNo--;
                }
            }

            oddEvenFlag = !oddEvenFlag;
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
