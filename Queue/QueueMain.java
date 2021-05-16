package Queue;

public class QueueMain {

    public static void main(String[] args){

        Queue queue = new Queue();
        queue.enqueue(1,2);
        queue.enqueue(7,6);
        queue.enqueue(10,11);
        queue.printQueue(); System.out.println();
        System.out.println(queue.dequeue().getData1());
        queue.printQueue();
    }
}
