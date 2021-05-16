package Queue;

import java.util.NoSuchElementException;

class Queue {

    private Node firstNode;
    private Node lastNode;
    private int n;


    Queue(){

        firstNode = null;
        lastNode = null;
        n = 0;

    }

    private int peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return firstNode.getData1();
    }

    void enqueue(int data1, int data2){

        Node temp = lastNode;
        lastNode = new Node(data1, data2);
        lastNode.nextNode = null;
        if(isEmpty()) firstNode = lastNode;
        else temp.nextNode = lastNode;
        n++;

    }

    Node dequeue(){

        if(isEmpty()) throw new NoSuchElementException("Queue underflow");

        Node temp = firstNode;
        firstNode = firstNode.nextNode;
        n--;
        if(isEmpty()) lastNode = null;
        return temp;

    }

    private boolean isEmpty(){
        return firstNode == null;
    }

    private int size(){
        return n;
    }

    void printQueue(){

        Node temp = firstNode;

        while(temp != null){

            temp.printNode();

            temp = temp.nextNode;

        }
    }
}
