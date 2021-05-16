public class Generics {

    private static <T> void genericPrint(T t){
        System.out.println(t);
    }

    public static void main(String[] args) {

        int a = 97;
        double b = 4.333;
        String c = "Hello World";
        char d = 'h';

        genericPrint(a);
        genericPrint(b);
        genericPrint(c);
        genericPrint(d);


    }
}
