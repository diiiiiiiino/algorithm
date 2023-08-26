package 자바코딩인터뷰완벽가이드.트리와그래프.레벨별리스트;

import java.util.*;

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

    private boolean insert(T data) {
        if(data == null){
            return false;
        }

        if(root == null){
            root = new Node(data);

            return true;
        }

        insert(root, data);

        return true;
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

    public static void main(String[] args) {
        // [[40], [47, 45], [11, 13, 44, 88], [3, 1]]
        /*
                  --40--
                /        \
              -47-       -45-
             /    \     /    \
            11     13  44    88
           /  \
          3    1
        */

        BinaryTree<Integer> bt = new BinaryTree<>();

        bt.insert(40);
        bt.insert(47);
        bt.insert(45);
        bt.insert(11);
        bt.insert(13);
        bt.insert(44);
        bt.insert(88);
        bt.insert(3);
        bt.insert(1);

        System.out.println(bt.fetchAllLevels());
    }

    public List<List<T>> fetchAllLevels() {
        if (root == null) {
            return Collections.emptyList();
        }

        // 각 리스트는 하나의 레벨을 나타냅니다.
        List<List<T>> allLevels = new ArrayList<>();

        // 첫 번째 레벨은 루트만 포함합니다.
        Queue<Node> currentLevelOfNodes = new ArrayDeque<>();
        List<T> currentLevelOfElements = new ArrayList<>();

        currentLevelOfNodes.add(root);
        currentLevelOfElements.add(root.data);

        while (!currentLevelOfNodes.isEmpty()) {
            // 현재 레벨을 이전 레벨로 저장합니다.
            Queue<Node> previousLevelOfNodes = currentLevelOfNodes;

            // 최종 리스트에 레벨을 추가합니다.
            allLevels.add(currentLevelOfElements);

            // 다음 레벨을 현재 레벨로 설정합니다.
            currentLevelOfNodes = new ArrayDeque<>();
            currentLevelOfElements = new ArrayList<>();

            // 현재 레벨의 모든 노드를 순회합니다.
            for (Node parent : previousLevelOfNodes) {
                if (parent.left != null) {
                    currentLevelOfNodes.add(parent.left);
                    currentLevelOfElements.add(parent.left.data);
                }

                if (parent.right != null) {
                    currentLevelOfNodes.add(parent.right);
                    currentLevelOfElements.add(parent.right.data);
                }
            }
        }

        return allLevels;
    }


}
