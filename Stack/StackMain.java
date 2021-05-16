package Stack;

public class StackMain {

    public static void main(String[] args){

        Stack stack = new Stack();
        stack.push(1,2);
        stack.push(5,4);
        stack.push(6,7);
        System.out.println(stack.pop());
        System.out.println("Empty: " + stack.isEmpty());
        System.out.println("Peek: " + stack.peek().getData1());
        stack.printStack();

    }

}
