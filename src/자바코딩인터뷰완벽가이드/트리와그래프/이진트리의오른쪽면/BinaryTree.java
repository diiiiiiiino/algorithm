package 자바코딩인터뷰완벽가이드.트리와그래프.이진트리의오른쪽면;

import org.junit.jupiter.params.ParameterizedTest;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class BinaryTree {
    private Node root;

    private class Node{
        private int element;
        private Node left;
        private Node right;

        public Node(int element) {
            this.element = element;
        }
    }

    public void insert(int element){
        if(root == null){
            root = new Node(element);
            return;
        }

        Queue<Node> queue = new ArrayDeque<>();
        while(!queue.isEmpty()){
            Node node = queue.poll();

            if(node.left == null){
                node.left = new Node(element);
                break;
            } else {
                queue.add(node.left);
            }

            if(node.right == null){
                node.right = new Node(element);
                break;
            } else {
                queue.add(node.right);
            }
        }
    }

    /*
              40
            /    \
          47      45
         /  \    /
        11   3  44
       /  \   \
      7    5   9
     /
    2
    */
    private void buildTree() {
        root = new Node(40);
        root.left = new Node(47);
        root.right = new Node(45);
        root.left.left = new Node(11);
        root.left.right = new Node(3);
        root.right.left = new Node(44);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(5);
        root.left.right.right = new Node(9);
        root.left.left.left.left = new Node(2);
    }

    private void printRightViewRecursive() {
        buildTree();

        Map<Integer, Integer> map = new HashMap<>();
        printRightViewRecursive(root, 1, map);

        for(int i = 1; i <= map.size(); i++){
            System.out.println(map.get(i) + " ");
        }
    }

    private void printRightViewRecursive(Node root, int level, Map<Integer, Integer> map){
        if(root == null){
            return;
        }

        map.put(level, root.element);

        printRightViewRecursive(root.left, level + 1, map);
        printRightViewRecursive(root.right, level + 1, map);
    }

    private void printRightViewIterative() {
        buildTree();

        if(root == null){
            return;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            int i = 0;

            while(i < size){
                i++;
                Node node = queue.poll();

                if(i == size){
                    System.out.print(node.element + " ");
                }

                if(node.left != null){
                    queue.add(node.left);
                }

                if(node.right != null){
                    queue.add(node.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();

        System.out.println("Iterative approach:");
        bt.printRightViewIterative();

        System.out.println("\n\nRecursive approach:");
        bt.printRightViewRecursive();
    }
}
