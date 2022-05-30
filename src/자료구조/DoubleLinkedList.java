package 자료구조;

public class DoubleLinkedList<T> {
    public Node<T> head = null;
    public Node<T> tail = null;

    public class Node<T> {
        Node<T> prev;
        Node<T> next;
        T data;

        public Node(T data){
            this.data = data;
        }
    }

    public void addNode(T data) {
        if(this.head == null) {
            this.head = new Node<>(data);
            this.tail = this.head;
        } else {
            Node<T> node = this.head;
            while(node.next != null) {
                node = node.next;
            }
            node.next = new Node<>(data);
            node.next.prev = node;
            this.tail = node.next;
        }
    }

    public void printAll() {
        if(this.head != null) {
            Node<T> node = this.head;
            System.out.println(node.data);

            while(node.next != null) {
                node = node.next;
                System.out.println(node.data);
            }
        }
    }

    public T searchFromHead(T searchData) {
        if (this.head != null) {
            Node<T> node = this.head;
            while (node != null) {
                if (node.data == searchData) {
                    return node.data;
                } else {
                    node = node.next;
                }
            }
        }
        return null;
    }

    public T searchFromTail(T searchData) {
        if(this.tail != null) {
            Node<T> node = this.tail;
            while(node != null) {
                if(node.data == searchData) {
                    return node.data;
                } else {
                    node = node.prev;
                }
            }
        }

        return null;
    }

    public boolean insertToFront(T existedData, T addData) {
        if(this.head == null) {
            this.head = new Node<>(addData);
            this.tail = this.head;
            return true;
        } else if(this.head.data == existedData) {
            Node<T> node = new Node<>(addData);
            node.next = this.head;
            this.head.prev = node; //구현 필요 한듯 보임
            this.head = node;
            return true;
        }
        if (this.head != null) {
            Node<T> node = this.head;
            while (node != null) {
                if (node.data == existedData) {
                    Node<T> prevNode = node.prev;
                    prevNode.next = new Node<>(addData);
                    prevNode.next.next = node;

                    prevNode.next.prev = prevNode;
                    node.prev = prevNode.next;

                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }
}
