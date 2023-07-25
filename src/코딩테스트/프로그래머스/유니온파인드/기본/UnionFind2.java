package 코딩테스트.프로그래머스.유니온파인드.기본;

public class UnionFind2 {
    private static class Node {
        private Node parent = null;
        private int value;

        public Node(int value) {
            this.value = value;
        }

        public boolean isConnected(Node o){
            return root() == o.root();
        }

        public void merge(Node o){
            if(isConnected(o)) return;
            o.parent = this;
        }

        private Node root(){
            if(parent == null) return this;
            return parent = parent.root();
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node.merge(node2);
        node3.merge(node4);

        node2.merge(node4);
    }
}
