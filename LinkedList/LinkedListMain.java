package LinkedList;

class LinkedListMain {


    public static void main(String[] args){

        LinkedList list = new LinkedList();

        list.insert(1,2);
        list.insert(2,3);
        list.insert(3,4);

        list.printList();
        list.delete();
        list.printList();
        System.out.println("Is empty: " + list.isEmpty());

    }
}