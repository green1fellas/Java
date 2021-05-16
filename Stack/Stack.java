package Stack;

class Stack {

    private Node first;

    Stack() {
        first = null;
    }

    boolean isEmpty() {

        return first == null;
    }

    Node peek(){

        return first;

    }

    void push(int d1, int d2) {

        Node newLink = new Node(d1, d2);
        newLink.setNextLink(first);
        first = newLink;
    }

    Node pop() {

        if(first == null){
            return null;
        }
        Node temp = first;
        first = first.getNextNode();
        return temp;
    }

    void printStack(){

        Node temp = first;

        System.out.println("List: ");
        while(temp != null){

            temp.printLink();
            temp = temp.getNextNode();
        }
        System.out.println();
    }
}
