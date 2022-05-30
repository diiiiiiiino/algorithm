package 자료구조;

public class MyTree {
    Node head;

    class Node{
        Node left;
        Node right;
        int value;

        Node(int value) {
            this.value = value;
        }
    }

    public boolean insert(int value){
        if(this.head == null) {
            this.head = new Node(value);
        } else {
            Node node = this.head;
            while(true) {
                if(value < node.value) {
                    if(node.left != null) {
                        node = node.left;
                    } else {
                        node.left = new Node(value);
                        break;
                    }
                } else {
                    if(node.right != null) {
                        node = node.right;
                    } else {
                        node.right = new Node(value);
                        break;
                    }
                }
            }
        }
        return true;
    }

    public Node search(int value) {
        Node node = this.head;
        while(node != null) {
            if(node.value == value) {
                return node;
            } else if(value < node.value) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        return null;
    }

    public boolean delete(int value) {
         boolean searched = false;

         Node currParentNode = this.head;
         Node currNode = this.head;

         if(this.head == null) {
             return false;
         } else {
             if(this.head.value == value && this.head.left == null && this.head.right == null) {
                 this.head = null;
                 return true;
             }

             while(currNode != null) {
                 if(currNode.value == value) {
                     searched = true;
                     break;
                 } else if(value < currNode.value) {
                     currParentNode = currNode;
                     currNode = currNode.left;
                 } else {
                     currParentNode = currNode;
                     currNode = currNode.right;
                 }
             }

             if(!searched) {
                 return false;
             }

             if(currNode.left == null && currNode.right == null) {
                 if(value < currParentNode.value) {
                     currParentNode.left = null;
                 } else {
                     currParentNode.right = null;
                 }
                 currNode = null;
             } else if(currNode.left != null && currNode.right == null) {
                 if(value < currParentNode.value) {
                     currParentNode.left = currNode.left;
                 } else {
                     currParentNode.right = currNode.left;
                 }
                 currNode = null;
             } else if(currNode.left == null && currNode.right != null) {
                 if(value < currParentNode.value) {
                     currParentNode.left = currNode.right;
                 } else {
                     currParentNode.right = currNode.right;
                 }
                 currNode = null;
             } else {
                 if(value < currParentNode.value) {
                     Node changeParentNode = currNode.right;
                     Node changeNode = currNode.right;

                     while(changeNode.left != null) {
                         changeParentNode = changeNode;
                         changeNode = changeNode.left;
                     }

                     if(changeNode.right != null) {
                         changeParentNode.left = changeNode.right;
                     } else {
                         changeParentNode.left = null;
                     }

                     currParentNode.left = changeNode;
                     changeNode.right = currNode.right;
                     changeNode.left = currNode.left;

                     currNode = null;
                 } else {
                     Node changeParentNode = currNode.right;
                     Node changeNode = currNode.right;

                     while(changeNode.left != null) {
                         changeParentNode = changeNode;
                         changeNode = changeNode.left;
                     }

                     if(changeNode.right != null) {
                         changeParentNode.left = changeNode.right;
                     } else {
                         changeParentNode.left = null;
                     }

                     currParentNode.right = changeNode;
                     changeNode.right = currNode.right;
                     changeNode.left = currNode.left;

                     currNode = null;
                 }
             }
         }

        return true;
    }
}
