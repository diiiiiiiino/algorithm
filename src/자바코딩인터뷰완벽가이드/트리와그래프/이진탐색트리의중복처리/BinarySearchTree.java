package 자바코딩인터뷰완벽가이드.트리와그래프.이진탐색트리의중복처리;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node root = null;

    private class Node{
        private T element;
        private int count;
        private Node left;
        private Node right;

        public Node(Node left, Node right, T element) {
            this.element = element;
            this.left = left;
            this.right = right;
            this.count = 1;
        }
    }

    public boolean insert(T element){
        if(element == null){
            return false;
        }

        root = insert(root, element);

        return true;
    }

    public boolean delete(T element){
        if(element == null){
            return false;
        }

        root = delete(root, element);

        return true;
    }

    private Node delete(Node node, T element){
        if(node == null){
            return null;
        }

        if(element.compareTo(node.element) < 0){
            node.left = delete(node.left, element);
        } else if(element.compareTo(node.element) > 0){
            node.right = delete(node.right, element);
        }

        if(element.compareTo(node.element) == 0){
            if(node.count > 1){
                node.count--;
                return node;
            }

            if(node.right == null){
                Node left = node.left;
                node = null;

                return left;
            } else if(node.left == null){
                Node right = node.right;
                node = null;

                return right;
            } else {
                Node leftmost = findLeftmostNode(node.right);

                node.element = leftmost.element;
                node.right = delete(node.right, node.element);
            }
        }

        return node;
    }

    private Node findLeftmostNode(Node node) {
        while(node.left != null){
            node = node.left;
        }

        return node;
    }

    private Node insert(Node current, T element){
        if(current == null){
            return new Node(null, null, element);
        }

        if(element.compareTo(current.element) == 0){
            current.count++;

            return current;
        }

        if(element.compareTo(current.element) < 0){
            current.left = insert(current.left, element);
        } else {
            current.right = insert(current.right, element);
        }

        return current;
    }

    public void print(TraversalOrder to) {
        if (root == null) {
            System.out.println("empty");
            return;
        }

        switch (to) {
            case IN:
                printInOrder(root);
                break;
            case PRE:
                printPreOrder(root);
                break;
            case POST:
                printPostOrder(root);
                break;
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
            System.out.print(" " + node.element + "(" + node.count + ")");
            printInOrder(node.right);
        }
    }

    private void printPreOrder(Node node) {
        if (node != null) {
            System.out.print(" " + node.element + "(" + node.count + ")");
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }

    private void printPostOrder(Node node) {
        if (node != null) {
            printPostOrder(node.left);
            printPostOrder(node.right);
            System.out.print(" " + node.element + "(" + node.count + ")");
        }
    }

    private void printLevelOrder(Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(" " + current.element + "(" + current.count + ")");

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public enum TraversalOrder {
        PRE,
        IN,
        POST,
        LEVEL
    }

    public static void main(String[] args) {
        /*
                  40(2)           D          40(1)
                /      \          E         /     \
              30(2)    45(4)      L       30(2)   45(2)
             /    \      \        E       /
           17(2) 33(1)   56(1)    T     17(1)
                                  E
        */
        BinarySearchTree<Integer> bt = new BinarySearchTree<>();

        bt.insert(40);
        bt.insert(30);
        bt.insert(45);
        bt.insert(30);
        bt.insert(33);
        bt.insert(45);
        bt.insert(56);
        bt.insert(45);
        bt.insert(17);
        bt.insert(45);
        bt.insert(17);
        bt.insert(40);

        System.out.println("\n\nTraversal LEVEL: ");
        bt.print(BinarySearchTree.TraversalOrder.LEVEL);

        System.out.println("\n\nTraversal IN-ORDER: ");
        bt.print(BinarySearchTree.TraversalOrder.IN);

        System.out.println("\n\nTraversal PRE-ORDER: ");
        bt.print(BinarySearchTree.TraversalOrder.PRE);

        System.out.println("\n\nTraversal POST-ORDER: ");
        bt.print(BinarySearchTree.TraversalOrder.POST);

        System.out.println("\n\n\n\nDeleting... \n\n");
        bt.delete(33);
        bt.delete(45);
        bt.delete(45);
        bt.delete(40);
        bt.delete(17);
        bt.delete(56);

        System.out.println("\n\nTraversal LEVEL: ");
        bt.print(BinarySearchTree.TraversalOrder.LEVEL);

        System.out.println("\n\nTraversal IN-ORDER: ");
        bt.print(BinarySearchTree.TraversalOrder.IN);

        System.out.println("\n\nTraversal PRE-ORDER: ");
        bt.print(BinarySearchTree.TraversalOrder.PRE);

        System.out.println("\n\nTraversal POST-ORDER: ");
        bt.print(BinarySearchTree.TraversalOrder.POST);

    }
}
