package 자바코딩인터뷰완벽가이드.트리와그래프.이진트리의수직합;

import java.util.Map;
import java.util.TreeMap;

public class BinaryTree<T> {
    private Node root = null;

    private class Node{
        private Node left;
        private Node right;

        private final int element;

        private Node(int element){
            this.element = element;
        }
    }

    /*
             21
           /    \
          14     45
         /  \     \
        7    3    44
       /  \      /  \
      5    2    9    6
               /
             11
    */
    private void buildTree() {
        root = new Node(21);
        root.left = new Node(14);
        root.right = new Node(45);
        root.left.left = new Node(7);
        root.left.right = new Node(3);
        root.left.left.left = new Node(5);
        root.left.left.right = new Node(2);
        root.right.right = new Node(44);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(6);
        root.right.right.left.left = new Node(11);
    }

    public void verticalSum(){
        buildTree();
        Map<Integer, Integer> map = new TreeMap<>();
        verticalSum(root, map, 0);

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            System.out.println(entry.getValue() + " ");
        }
    }

    private void verticalSum(Node root, Map<Integer, Integer> map, int dist) {
        if(root == null){
            return;
        }

        if(!map.containsKey(dist)){
            map.put(dist, 0);
        }

        map.put(dist, map.get(dist) + root.element);

        verticalSum(root.left, map, dist - 1);
        verticalSum(root.right, map, dist + 1);
    }
}
