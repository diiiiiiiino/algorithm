package 코딩테스트.프로그래머스.유니온파인드.기본;

public class UnionFind {

    private static class Node {
        private int depth = 1;
        private int value;
        private Node parent = null;

        public Node(int value) {
            this.value = value;
        }

        public boolean isConnected(Node o){
            return root() == o.root();
        }

        public void merge(Node o){
            if(isConnected(o)) return;

            Node root1 = root();
            Node root2 = o.root();

            if(root1.depth > root2.depth){
                root2.parent = root1;
            } else if(root1.depth < root2.depth){
                root1.parent = root2;
            } else {
                root2.parent = root1;
                root1.depth += 1;
            }
        }

        private Node root() {
            if(parent == null) return this;
            return parent.root();
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node.merge(node2);
        node3.merge(node4);

        node.merge(node3);
    }
}
