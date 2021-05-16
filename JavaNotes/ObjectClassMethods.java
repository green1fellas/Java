import java.util.ArrayList;

public class ObjectClassMethods {

    public static void main(String[] args) throws InterruptedException {

        ArrayList<String> list = new ArrayList<>();
        list.add("hi");
        list.add("bye");
        list.add("other thing");

        System.out.println(list.equals(list));
        System.out.println(list.getClass());
        System.out.println(list.hashCode());

        ArrayList<String> list2 = (ArrayList)list.clone();
        System.out.println(list2.toString());

        // THREADS

        //list.notify();
        //list.notifyAll();
        //list.wait();
        //list.wait(100);
        System.out.println("extra thing");

    }
}

/*
    .equals()
    .getClass()
    .hashCode()
    .toString

    .notify()
    .notifyAll()
    .wait()
    .wait(100)
 */