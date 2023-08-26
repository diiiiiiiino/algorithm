package 자바코딩인터뷰완벽가이드.트리와그래프.하위트리;

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

        insert(root, data);
    }

    private void insert(Node node, T data){
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()){
            node = queue.peek();
            queue.poll();

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

    public Node root(){
        return root;
    }

    private boolean isSubtree(BinaryTree<T> q) {
        return isSubtree(root, q.root);
    }

    private boolean isSubtree(Node p, Node q) {
        if(p == null){
            return false;
        }

        if(!match(p, q)){
            return (isSubtree(p.left, q) || isSubtree(p.right, q));
        }

        return true;
    }

    private boolean match(Node p, Node q) {
        if(p == null && q == null){
            return true;
        }

        if(p == null || q == null){
            return false;
        }

        return (p.data == q.data && match(p.left, q.left) && match(p.right, q.right));
    }

    public static void main(String[] args) {
        /*    P:                     Q:
              40                     30
            /    \                  /  \
          30      10               20   90
         /  \    /  \             /
        20   90  70 80           6
       /
      6
        */
        BinaryTree<Integer> p = new BinaryTree<>();

        p.insert(40);
        p.insert(30);
        p.insert(10);
        p.insert(20);
        p.insert(90);
        p.insert(70);
        p.insert(80);
        p.insert(6);

        BinaryTree<Integer> q = new BinaryTree<>();

        q.insert(30);
        q.insert(20);
        q.insert(90);
        q.insert(6);

        System.out.println("'p' subtree of 'q' ? " + p.isSubtree(q));
        System.out.println("'q' subtree of 'p' ? " + q.isSubtree(p));
    }
}
