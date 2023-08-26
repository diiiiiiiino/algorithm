package 자바코딩인터뷰완벽가이드.트리와그래프.균형이진트리;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T> {
    private final class Node{
        private T data;
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

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node node = queue.poll();

            if(node.left == null){
                node.left = new Node(data);
                return;
            } else {
                queue.add(node.left);
            }

            if(node.right == null){
                node.right = new Node(data);
                return;
            } else {
                queue.add(node.right);
            }
        }
    }

    private boolean isBalanced1() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node root) {
        if(root == null){
            return true;
        }

        if(Math.abs(height(root.left) - height(root.right)) > 1){
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    private int height(Node root){
        if(root == null){
            return 0;
        }

        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public boolean isBalanced2() {
        return checkHeight(root) != Integer.MIN_VALUE;
    }

    private int checkHeight(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = checkHeight(root.left);
        if (leftHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE; // 에러
        }

        int rightHeight = checkHeight(root.right);
        if (rightHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE; // 에러
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return Integer.MIN_VALUE; // 에러 반환
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public static void main(String[] args) {
        /* 루트에서 균형이 맞지 않음
                  40
                /    \
               30     49
              /  \   /  \
             20  35 45   52
                /  \
               34  37
                  /
                 36
        */
        BinaryTree<Integer> bt = new BinaryTree<>();

        bt.insert(40);
        bt.insert(30);
        bt.insert(49);
        bt.insert(20);
        bt.insert(35);
        bt.insert(45);
        bt.insert(52);
        bt.insert(34);
        bt.insert(37);
        bt.insert(36); // 이 줄을 주석 처리하면 트리가 균형을 이룹니다.

        System.out.println("Balanced (approach 1)? " + bt.isBalanced1());
        System.out.println("Balanced (approach 2)? " + bt.isBalanced2());
    }
}
