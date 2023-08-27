package 자바코딩인터뷰완벽가이드.트리와그래프.이진트리가이진탐색트리일때;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T extends Comparable<T>> {
    private final class Node{
        private final T data;
        private Node left;
        private Node right;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node root;

    public void insert(T data){
        if(root == null){
            root = new Node(data);
            return;
        }

        insert(root, data);
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

    private boolean isBinarySearchTree() {
        return isBinarySearchTree(root, null, null);
    }

    private boolean isBinarySearchTree(Node node, T minElement, T maxElement) {
        if(node == null){
            return true;
        }

        if((minElement != null && node.data.compareTo(minElement) <= 0) || (maxElement != null && node.data.compareTo(maxElement) > 0)){
            return false;
        }

        if(!isBinarySearchTree(node.left, minElement, node.data) || !isBinarySearchTree(node.right, node.data, maxElement)){
            return false;
        }

        return true;
    }

    private void printLevelOrder() {
        if(root == null){
            return;
        }
        printLevelOrder(root);
    }

    private void printLevelOrder(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()){
            Node node1 = queue.poll();
            System.out.print(node1.data + " ");

            if(node1.left != null){
                queue.add(node1.left);
            }

            if(node1.right != null){
                queue.add(node1.right);
            }
        }
    }


    public static void main(String[] args) {
        /* 이진 탐색 트리(BST)의 모양
                  40
                /    \
              35      45
             /  \    /  \
            30   37 44   48
           /
          20
        */
        BinaryTree<Integer> bt = new BinaryTree<>();

        bt.insert(40);
        bt.insert(35);
        bt.insert(45);
        bt.insert(30);
        bt.insert(37);
        bt.insert(44);
        bt.insert(48);
        bt.insert(20);

        System.out.println("\n\nTraversal LEVEL: ");
        bt.printLevelOrder();

        System.out.println("\n\nIs this binary tree BST: " + bt.isBinarySearchTree());
    }
}
