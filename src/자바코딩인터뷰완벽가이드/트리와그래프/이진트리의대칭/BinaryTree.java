package 자바코딩인터뷰완벽가이드.트리와그래프.이진트리의대칭;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T> {
    private Node root = null;
    private class Node{
        private T element;
        private Node left;
        private Node right;

        public Node(T element) {
            this.element = element;
        }

        @Override
        public String toString() {
            return "element=" + element;
        }
    }

    public void insert(T element){
        if(element == null){
            return;
        }

        if(root == null){
            root = new Node(element);
            return;
        }

        insert(root, element);
    }

    private void insert(Node root, T element) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

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

    public boolean isSymmetricRecursive() {
        if(root == null){
            return true;
        }

        return isSymmetricRecursive(root.left, root.right);
    }

    private boolean isSymmetricRecursive(Node leftNode, Node rightNode) {
        boolean result = false;

        if(leftNode == null && rightNode == null){
            result = true;
        }

        if(leftNode != null && rightNode != null){
            result = (leftNode.element.equals(rightNode.element))
                    && isSymmetricRecursive(leftNode.left, rightNode.right)
                    && isSymmetricRecursive(leftNode.right, rightNode.left);
        }

        return result;
    }

    public boolean isSymmetricIterative(){
        if(root == null){
            return true;
        }

        boolean result = false;
        Queue<Node> queue = new LinkedList<>();

        queue.offer(root.left);
        queue.offer(root.right);

        while(!queue.isEmpty()){
            Node left = queue.poll();
            Node right = queue.poll();

            if(left == null && right == null){
                result = true;
            } else if(left == null || right == null || left.element != right.element){
                result = false;
                break;
            } else {
                queue.offer(left.left);
                queue.offer(right.right);

                queue.offer(left.right);
                queue.offer(right.left);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        /*
              50
            /    \
          45      45
         /  \    /  \
        41   3  3   41
        */
        BinaryTree<Integer> bt = new BinaryTree<>();

        bt.insert(50);
        bt.insert(45);
        bt.insert(45);
        bt.insert(41);
        bt.insert(3);
        bt.insert(3);
        bt.insert(41);

        System.out.println("Symmetry check recursive: " + bt.isSymmetricRecursive());
        System.out.println("Symmetry check iterative: " + bt.isSymmetricIterative());
    }
}
