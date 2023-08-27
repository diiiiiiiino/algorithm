package 자바코딩인터뷰완벽가이드.트리와그래프.이진트리의양끝노드출력;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T> {

    private class Node{
        private T element;
        private Node left;
        private Node right;

        public Node(T element) {
            this.element = element;
        }
    }

    private Node root;

    private void insert(T element) {
        if(root == null){
            root = new Node(element);
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node node = queue.poll();

            if(node.left == null){
                node.left = new Node(element);
                return;
            } else {
                queue.add(node.left);
            }

            if(node.right == null){
                node.right = new Node(element);
                return;
            } else {
                queue.add(node.right);
            }
        }
    }

    private void printCorners() {
        if(root == null){
            return;
        }

        int level = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            int position = size;
            System.out.print("level : " + level + " -> ");
            level++;

            while(position > 0){
                Node node = queue.poll();
                position--;

                if(position == (size - 1) || position == 0){
                    System.out.print(node.element + " ");
                }

                if(node.left != null){
                    queue.add(node.left);
                }

                if(node.right != null){
                    queue.add(node.right);
                }
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        /*
                 --40--
                /      \
               47       45
             /    \    /  \
            11     3  44   23
           /  \   /
          2    4 1
        */
        BinaryTree<Integer> bt = new BinaryTree<>();

        bt.insert(40);
        bt.insert(47);
        bt.insert(45);
        bt.insert(11);
        bt.insert(3);
        bt.insert(44);
        bt.insert(23);
        bt.insert(2);
        bt.insert(4);
        bt.insert(1);

        bt.printCorners();
    }
}
