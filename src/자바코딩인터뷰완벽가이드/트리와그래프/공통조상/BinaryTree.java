package 자바코딩인터뷰완벽가이드.트리와그래프.공통조상;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T> {
    private Node root = null;

    private class Node{
        private Node left;
        private Node right;

        private final T element;

        public Node(T element){
            this.element = element;
        }

        @Override
        public String toString() {
            return "element=" + element;
        }
    }

    public boolean insert(T element){
        if(element == null){
            return false;
        }

        if(root == null){
            root = new Node(element);

            return true;
        }

        insert(root, element);

        return true;
    }

    private void insert(Node node, T element){
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()){
            node = queue.poll();

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

    public T commonAncestor(T e1, T e2){
        Node n1 = findNode(e1, root);
        Node n2 = findNode(e2, root);

        if(n1 == null || n2 == null){
            throw new IllegalArgumentException();
        }

        return commonAncestor(root, n1, n2).element;
    }

    private Node commonAncestor(Node root, Node n1, Node n2) {
        if(root == null){
            return null;
        }

        if(root == n1 && root == n2){
            return root;
        }

        Node left = commonAncestor(root.left, n1, n2);
        if(left != null && left != n1 && left != n2){
            return left;
        }

        Node right = commonAncestor(root.right, n1, n2);
        if(right != null && right != n1 && right != n2){
            return right;
        }

        if(left != null && right != null){
            return root;
        } else if(root == n1 || root == n2){
            return root;
        } else {
            return left == null ? right : left;
        }
    }

    private Node findNode(T element, Node node){
        if(node != null){
            if(node.element.equals(element)){
                return node;
            } else {
                Node foundNode = findNode(element, node.left);
                if(foundNode == null){
                    foundNode = findNode(element, node.right);
                }

                return foundNode;
            }
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        /*
                  40
                /    \
              47      45
             /  \    /  \
            11   3  44   4
           /  \
          12  55
        */
        BinaryTree<Integer> bt = new BinaryTree<>();

        bt.insert(40);
        bt.insert(47);
        bt.insert(45);
        bt.insert(11);
        bt.insert(3);
        bt.insert(44);
        bt.insert(4);
        bt.insert(12);
        bt.insert(55);

        int ancestor = bt.commonAncestor(12, 3);

        System.out.println("Common ancestor: " + ancestor);
    }
}
