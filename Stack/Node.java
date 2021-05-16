package Stack;

class Node{

    private int data1;
    private int data2;
    private Node nextNode;

    Node(int d1, int d2){

        data1 = d1;
        data2 = d2;

    }

    void printLink(){

        System.out.println("{" + data1 + ", " + data2 + "}");

    }

    int getData1(){
        return this.data1;
    }
    int getData2(){
        return this.data2;
    }
    Node getNextNode(){
        return this.nextNode;
    }
    void setData1(int newData1){
        this.data1 = newData1;
    }
    void setData2(int newData2){
        this.data2 = newData2;
    }
    void setNextLink(Node newNextLink){
        this.nextNode = newNextLink;
    }

}