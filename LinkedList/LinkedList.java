package LinkedList;

class LinkedList {

    private Link first;

    LinkedList() {
        first = null;
    }

    boolean isEmpty() {

        return first == null;
    }

    void insert(int d1, int d2) {

        Link newLink = new Link(d1, d2);
        newLink.setNextLink(first);
        first = newLink;
    }

    void delete() {

        if(first == null){
            return;
        }
        first = first.getNextLink();
    }

    void printList(){

        Link temp = first;

        System.out.println("List: ");
        while(temp != null){

            temp.printLink();
            temp = temp.getNextLink();
        }
        System.out.println();
    }
}