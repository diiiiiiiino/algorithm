package 자료구조;

public class SingleLinkedList<T> {
    public Node<T> head = null;

    public class Node<T> {
        T data;
        Node<T> next = null;

        public Node(T data) {
            this.data = data;
        }
    }

    public void addNode(T data) {
        if(head == null) {
            this.head = new Node<>(data);
        } else {
            Node<T> node = this.head;
            while(node.next != null) {
                node = node.next;
            }
            node.next = new Node<T>(data);
        }
    }

    public Node searchNode(T data) {
        if (this.head != null) {
            Node<T> node = this.head;
            while (node != null) {
                if (node.data == data) {
                    return node;
                } else {
                    node = node.next;
                }
            }
        }
        return null;
    }

    public void addNodeInside(T addData, T searchData) {
        Node<T> node = searchNode(searchData);

        if(node == null) {
            this.addNode(addData);
        } else {
            Node<T> next = node.next;
            node.next = new Node<>(addData);
            node.next.next = next;
        }
    }

    public boolean deleteNode(T data) {
        if(this.head == null) {
            return false;
        } else {
            Node<T> node = this.head;

            if(node.data == data) {
                this.head = this.head.next;
                return true;
            } else {
                while(node.next != null) {
                    if(node.next.data == data) {
                        node.next = node.next.next;
                        return true;
                    }
                    node = node.next;
                }
                return false;
            }
        }
    }

    public void printAll() {
        if(this.head != null) {
            Node<T> node = this.head;
            System.out.println(node.data);

            while(node.next != null){
                node = node.next;
                System.out.println(node.data);
            }
        }
    }
}

