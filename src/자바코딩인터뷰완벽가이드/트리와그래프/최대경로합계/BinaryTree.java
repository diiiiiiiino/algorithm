package 자바코딩인터뷰완벽가이드.트리와그래프.최대경로합계;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinaryTree {
    private class Node{
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "data=" + data;
        }
    }

    private Node root;
    private int max;

    public void insert(int data){
        if(root == null){
            root = new Node(data);
            return;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node node = queue.poll();

            if(node.left == null){
                node.left = new Node(data);
                break;
            } else {
                queue.add(node.left);
            }

            if(node.right == null){
                node.right = new Node(data);
                break;
            } else {
                queue.add(node.right);
            }
        }
    }

    private int maxPathSum() {
        maxPathSum(root);

        return max;
    }

    private int maxPathSum(Node root) {
        if(root == null){
            return 0;
        }

        int left = Math.max(0, maxPathSum(root.left));
        int right = Math.max(0, maxPathSum(root.right));

        max = Math.max(max, left + right + root.data);

        return Math.max(left, right) + root.data;
    }

    public static void main(String[] args) {
        /*  최대 경로의 합계는 158입니다.
                    50
                /       \
               -2       -1
              / \       / \
            41    3    -7  70
                 /
                -5
        */
        BinaryTree bt = new BinaryTree();

        bt.insert(50);
        bt.insert(-2);
        bt.insert(-1);
        bt.insert(41);
        bt.insert(3);
        bt.insert(-7);
        bt.insert(70);
        bt.insert(0);
        bt.insert(0);
        bt.insert(-5);

        int max = bt.maxPathSum();

        System.out.println("Max: " + max);
    }
}
