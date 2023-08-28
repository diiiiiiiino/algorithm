package 자바코딩인터뷰완벽가이드.트리와그래프.이진트리좌우반전;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

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

    public enum TraversalOrder {
        PRE,
        IN,
        POST,
        LEVEL
    }

    // 너비 우선 탐색(BFS)을 이용해 트리에 노드 삽입
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

    // 너비 우선 탐색(BFS) 알고리즘을 이용해 삽입
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

    // 좌우 반전 트리 생성하기
    public BinaryTree mirrorTreeInTree() {
        Node mirroredRoot = mirrorTreeInTree(root);
        BinaryTree<T> mirroredBt = new BinaryTree();

        mirroredBt.root = mirroredRoot;

        return mirroredBt;
    }

    // 좌우 반전 트리 생성하기
    private Node mirrorTreeInTree(Node root) {
        if (root == null) {
            return null;
        }

        Node node = new Node(root.element);
        node.left = mirrorTreeInTree(root.right);
        node.right = mirrorTreeInTree(root.left);

        return node;
    }

    // 주어진 트리 반전하기
    public void mirrorTreeInPlace() {
        mirrorTreeInPlace(root);
    }

    // 주어진 트리 반전하기
    private void mirrorTreeInPlace(Node node) {
        if (node == null) {
            return;
        }

        Node auxNode;

        mirrorTreeInPlace(node.left);
        mirrorTreeInPlace(node.right);

        auxNode = node.left;
        node.left = node.right;
        node.right = auxNode;
    }

    // 깊이 우선 탐색(DFS) 및 너비 우선 탐색(BFS)을 이용한 트리 출력
    public void print(TraversalOrder to) {
        if (root == null) {
            System.out.println("empty");
            return;
        }

        switch (to) {
            // 깊이 우선 탐색(DFS)
            case IN:
                printInOrder(root);
                break;
            case PRE:
                printPreOrder(root);
                break;
            case POST:
                printPostOrder(root);
                break;
            // 너비 우선 탐색(BFS)
            case LEVEL:
                printLevelOrder(root);
                break;
            default:
                throw new IllegalArgumentException("Unrecognized traversal order");
        }
    }

    private void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(" " + node.element);
            printInOrder(node.right);
        }
    }

    private void printPreOrder(Node node) {
        if (node != null) {
            System.out.print(" " + node.element);
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }

    private void printPostOrder(Node node) {
        if (node != null) {
            printPostOrder(node.left);
            printPostOrder(node.right);
            System.out.print(" " + node.element);
        }
    }

    private void printLevelOrder(Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(" " + current.element);

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public static void main(String[] args) {
        /*
                  40                40
                /    \            /    \
              47      45         45    47
             /  \    /            \   /  \
            11   3  44            44 3    11
        */
        BinaryTree<Integer> bt = new BinaryTree<>();

        bt.insert(40);
        bt.insert(47);
        bt.insert(45);
        bt.insert(11);
        bt.insert(3);
        bt.insert(44);

        System.out.println("Given tree");
        System.out.println("----------");

        System.out.println("\nTraversal LEVEL: ");
        bt.print(BinaryTree.TraversalOrder.LEVEL);

        System.out.println("\n\nTraversal IN-ORDER: ");
        bt.print(BinaryTree.TraversalOrder.IN);

        System.out.println("\n\nTraversal PRE-ORDER: ");
        bt.print(BinaryTree.TraversalOrder.PRE);

        System.out.println("\n\nMirorred tree in a new tree");
        System.out.println("---------------------------");

        BinaryTree<Integer> mirroredBt = bt.mirrorTreeInTree();

        System.out.println("\nTraversal LEVEL (mirror in new tree): ");
        mirroredBt.print(BinaryTree.TraversalOrder.LEVEL);

        System.out.println("\n\nTraversal IN-ORDER (mirror in new tree): ");
        mirroredBt.print(BinaryTree.TraversalOrder.IN);

        System.out.println("\n\nTraversal PRE-ORDER (mirror in new tree): ");
        mirroredBt.print(BinaryTree.TraversalOrder.PRE);

        System.out.println("\n\nMirorred tree in place");
        System.out.println("----------------------");

        bt.mirrorTreeInPlace();

        System.out.println("\nTraversal LEVEL (mirror in place): ");
        bt.print(BinaryTree.TraversalOrder.LEVEL);

        System.out.println("\n\nTraversal IN-ORDER (mirror in place): ");
        bt.print(BinaryTree.TraversalOrder.IN);

        System.out.println("\n\nTraversal PRE-ORDER (mirror in place): ");
        bt.print(BinaryTree.TraversalOrder.PRE);
    }
}
