package 자바코딩인터뷰완벽가이드.연결리스트와맵.LRU캐시;

import java.util.HashMap;
import java.util.Map;

public final class LRUCache {
    private final class Node {
        private int key;
        private int value;
        private Node next;
        private Node prev;

        @Override
        public String toString() {
            return "(" + key + ", " + value + ") ";
        }
    }

    private final Map<Integer, Node> hashmap;

    private Node head;
    private Node tail;

    private static final int LRU_SIZE = 5;

    public LRUCache() {
        hashmap = new HashMap<>();
    }

    public int getEntry(int key) {
        Node node = hashmap.get(key);

        if (node != null) {
            removeNode(node);
            addNode(node);

            return node.value;
        }

        return -1;
    }

    public void putEntry(int key, int value) {
        Node node = hashmap.get(key);

        if (node != null) {
            node.value = value;

            removeNode(node);
            addNode(node);
        } else {
            Node newNode = new Node();
            newNode.prev = null;
            newNode.next = null;
            newNode.value = value;
            newNode.key = key;

            if (hashmap.size() >= LRU_SIZE) {
                hashmap.remove(tail.key);
                removeNode(tail);

            }
            addNode(newNode);

            hashmap.put(key, newNode);
        }
    }

    private void addNode(Node node) {
        node.next = head;
        node.prev = null;

        if (head != null) {
            head.prev = node;
        }

        head = node;

        if (tail == null) {
            tail = head;
        }
    }

    private void removeNode(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }

    public void print() {
        System.out.println("\nCache content: ");

        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode);
            currentNode = currentNode.next;
        }

        System.out.println();
    }
}