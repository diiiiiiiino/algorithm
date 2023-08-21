package 자바코딩인터뷰완벽가이드.연결리스트와맵.LRU캐시;

import java.util.HashMap;

public class MyLRUCache {
    private final class Node{
        private int key;
        private int data;
        private Node next;
        private Node prev;
    }

    private Node head;
    private Node tail;
    private HashMap<Integer, Node> map;
    private final int LRU_SIZE = 5;

    public MyLRUCache() {
        this.map = new HashMap<>();
    }

    public void putEntry(int key, int data){
        Node node = map.get(key);

        if(node != null){
            node.data = data;

            removeNode(node);
            addNode(node);
        } else {
            Node newNode = new Node();
            newNode.key = key;
            newNode.data = data;

            if(map.size() >= LRU_SIZE){
                map.remove(tail.key);
                removeNode(tail);
                addNode(newNode);
            } else {
                addNode(newNode);
            }

            map.put(key, newNode);
        }
    }

    public int getEntry(int key){
        Node node = map.get(key);

        if(node != null){
            removeNode(node);
            addNode(node);
            return node.data;
        }

        return -1;
    }

    public void print(){
        System.out.println("Cache content:");
        Node currentNode = head;

        while(currentNode != null){
            System.out.print("(" + currentNode.key + ", " + currentNode.data + ") ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    private void addNode(Node node){
        node.next = head;
        node.prev = null;

        if(head != null){
            head.prev = node;
        }

        head = node;

        if(tail == null){
            tail = node;
        }
    }

    private void removeNode(Node node){
        if(node.prev != null){
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if(node.next != null){
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }

    public static void main(String[] args) {
        MyLRUCache cache = new MyLRUCache();

        cache.putEntry(1, 10);
        cache.putEntry(2, 20);
        cache.putEntry(3, 30);
        cache.putEntry(4, 40);
        cache.putEntry(5, 50);
        cache.putEntry(6, 60);
        cache.putEntry(7, 70);

        cache.print();

        System.out.println("\nGet key 4: " + cache.getEntry(4));

        cache.print();

        cache.putEntry(8, 80);
        cache.putEntry(9, 90);

        cache.print();

        System.out.println("\nGet key 6: " + cache.getEntry(6));
        cache.print();

        System.out.println("\nGet key 2 (-1 means data not found): " + cache.getEntry(2));
        cache.print();

        System.out.println("\nGet key 6: " + cache.getEntry(6));
        cache.print();

        System.out.println("\nGet key 8: " + cache.getEntry(8));
        cache.print();

        cache.putEntry(10, 100);
        cache.print();
    }
}
