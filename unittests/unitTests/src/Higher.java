import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Higher {
    public static void main(String[] args) {
        int a = 25;
        int b = -25;
        int c = higher(a,b);
        System.out.println("\nThe higher of 25 and -25 is " + c);
    }

    public static int higher(int x, int y) {
        if(x > y) {
            return x;
        } else {
            return y;
        }
    }

    @Test 
    public void testHigher(String arg) {
        assertEquals(25, higher(25,25));
        assertEquals(5, higher(3, 5));
        assertEquals(6, higher(3, 5));
    }
}
