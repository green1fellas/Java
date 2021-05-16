package BinarySearchTree;

class Tree {

    private Node head;

    Tree() {
        head = null;
    }

    void insert(int data) {

        head = addRec(head, data);
    }

    private Node addRec(Node temp, int data) {

        if (temp == null) {
            return new Node(data);
        }
        if (data < temp.data) {
            temp.leftChild = addRec(temp.leftChild, data);
        } else if (data > temp.data) {
            temp.rightChild = addRec(temp.rightChild, data);
        }
        return temp;
    }

    void delete(int data) {

        deleteRec(head, data);
    }

    private Node deleteRec(Node temp, int data) {

        if (temp == null) {
            return null;
        }

        if (temp.data == data) {

            if (temp.leftChild == null && temp.rightChild == null) {
                return null;
            }
            if (temp.leftChild == null) {
                return temp.rightChild;
            }
            if (temp.rightChild == null) {
                return temp.leftChild;

            }

            int smallestVal = smallestValue(temp.rightChild);
            temp.data = smallestVal;
            temp.rightChild = deleteRec(temp.rightChild, smallestVal);
            return temp;

        } else {
            if(data < temp.data){
                temp.leftChild = deleteRec(temp.leftChild, data);
                return temp;
            } else {
                temp.rightChild = deleteRec(temp.rightChild, data);
                return temp;
            }
        }
    }

    private int smallestValue(Node temp) {

        return temp.leftChild == null ? temp.data : smallestValue(temp.leftChild);

    }

    boolean containsNode(int data) {

            return containsNodeRec(head, data);
    }

    private boolean containsNodeRec(Node temp, int data) {

        if (temp == null) {
            return false;
        }

        if (temp.data == data) {
            return true;
        } else {
            return temp.data > data ? containsNodeRec(temp.leftChild, data) :
                    containsNodeRec(temp.rightChild, data);
        }
    }

    void printTree() {

        traverseInOrder(head);

    }

    private void traverseInOrder(Node temp) {

        if (temp != null) {

            traverseInOrder(temp.leftChild);
            System.out.println(temp.data);
            traverseInOrder(temp.rightChild);

        }

    }

    void printTreeVisual(){
        printTreeVisualRec(head, 0);
    }

    private void printTreeVisualRec(Node temp, int depth) {

        if (temp != null) {
            printTreeVisualRec(temp.rightChild, depth + 1);
            for(int i = 0; i < depth; i++) {
                System.out.print("   ");
            }
            System.out.println(temp.data);
            printTreeVisualRec(temp.leftChild, depth + 1);
        }
    }
}

// Helpful link for tree traversals
// https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/


