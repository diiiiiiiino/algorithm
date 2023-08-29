package 자바코딩인터뷰완벽가이드.트리와그래프.단말노드에서k만큼떨어진노드;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BinaryTree {
    private Node root;

    private class Node{
        private int element;
        private Node left;
        private Node right;

        public Node(int element) {
            this.element = element;
        }

        @Override
        public String toString() {
            return "element=" + element;
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

    private void leafDistance(int dist) {
        buildTree();

        List<Node> pathToLeaf = new ArrayList<>();
        Set<Node> nodesAtDist = new HashSet<>();

        leafDistance(root, pathToLeaf, nodesAtDist, dist);

        for(Node nd : nodesAtDist){
            System.out.println(nd.element + " ");
        }
    }

    private void leafDistance(Node node, List<Node> pathToLeaf, Set<Node> nodesAtDist, int dist) {
        if(node == null){
            return;
        }

        if(isLeaf(node) && pathToLeaf.size() >= dist){
            nodesAtDist.add(pathToLeaf.get(pathToLeaf.size() - dist));

            return;
        }

        pathToLeaf.add(node);

        leafDistance(node.left, pathToLeaf, nodesAtDist, dist);
        leafDistance(node.right, pathToLeaf, nodesAtDist, dist);

        pathToLeaf.remove(node);
    }

    private boolean isLeaf(Node node) {
        return (node.left == null && node.right == null);
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();

        bt.leafDistance(2);
    }
}
