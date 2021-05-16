import java.util.ArrayList;
import java.util.Arrays;

public class HashFunction {

    private String[] theArray;
    private int arraySize;
    private int itemsInArray = 0;

    public static void main(String[] args) {

        HashFunction hash = new HashFunction(30);
        HashFunction hash2 = new HashFunction(30);

        String[] arr = {"1", "5", "17", "21", "26"};

        String[] arr2 = {"100", "510", "170", "214", "268", "398",
                "235", "802", "900", "723", "699", "1", "16", "999", "890",
                "725", "998", "978", "988", "990", "989", "984", "320", "321",
                "400", "415", "450", "50", "660", "624"};

        hash.hashFunction1(arr, hash.theArray);
        System.out.println(Arrays.toString(hash.theArray));

        //hash2.hashFunction2(arr2, hash2.theArray);
        //System.out.println(Arrays.toString(hash2.theArray));

        //hash2.findKey("660");

        hash2.increaseArraySize(60);

        //System.out.println(Arrays.toString(hash2.theArray));

        hash2.doubleHash(arr2, hash2.theArray);
        System.out.println(Arrays.toString(hash2.theArray));
        hash2.findKeyDbleHashed("989");



    }

    private boolean isPrime(int num){

        if(num % 2 == 0)
            return false;

        for(int i = 3; i * i <= num; i+=2){

            if(num % i == 0)
                return false;
        }
        return true;
    }

    private int getNextPrime(int minNumToCheck){

        for(int i = minNumToCheck; true; i++){
            if(isPrime(i))
                return i;
        }
    }

    private void increaseArraySize(int minArraySize){

        int newArraySize = getNextPrime(minArraySize);
        moveOldArray(newArraySize);

    }

    private void moveOldArray(int newArraySize){

        String[] cleanArray = removeEmptySpacesInArray(theArray);
        theArray = new String[newArraySize];
        arraySize = newArraySize;

        Arrays.fill(theArray, "-1");

        hashFunction2(cleanArray, theArray);

    }

    private String[] removeEmptySpacesInArray(String[] arrayToClean){

        ArrayList<String> stringList = new ArrayList<String>();

        for(String theString : arrayToClean)
            if(!theString.equals("-1") && !theString.equals(""))
                stringList.add(theString);

        return stringList.toArray(new String[stringList.size()]);

    }

    private void hashFunction1(String[] items, String[] array) {

        // The item is both the position and key.
        // For instance, "100" is in spot 100, represented
        // as 100 in this example.

        for (int n = 0; n < items.length; n++) {
            String newVal = items[n];
            array[Integer.parseInt(newVal)] = newVal;
        }
    }

    private void hashFunction2(String[] items, String[] array) {

        for (int n = 0; n < items.length; n++) {

            String newVal = items[n];

            // 29 is used because array is size 30; makes sure value
            // will fit

            int arrayIndex = Integer.parseInt(newVal) % 29;
            System.out.println("Modulus Index=" + arrayIndex + " for value " + newVal);

            while (!array[arrayIndex].equals("-1")) {
                ++arrayIndex;
                System.out.println("Collision Try " + arrayIndex + " Instead");
                arrayIndex %= arraySize;
            }

            array[arrayIndex] = newVal;

        }

    }

    private void doubleHash(String[] items, String[] array) {

        for (int n = 0; n < items.length; n++) {

            String newVal = items[n];

            // 29 is used because array is size 30; makes sure value
            // will fit

            int arrayIndex = Integer.parseInt(newVal) % arraySize;

            int stepDistance = 7 - (Integer.parseInt(newVal) % 7);

            System.out.println("Modulus Index=" + arrayIndex + " for value " + newVal);

            while (!array[arrayIndex].equals("-1")) {
                arrayIndex += stepDistance;
                System.out.println("Collision Try " + arrayIndex + " Instead");
                arrayIndex %= arraySize;
            }

            array[arrayIndex] = newVal;

        }

    }

    private String findKey(String key) {

        int arrayIndex = Integer.parseInt(key) % 29;

        while (!theArray[arrayIndex].equals("-1")) {
            if (theArray[arrayIndex].equals(key)) {
                System.out.println(key + " was found in index " + arrayIndex);

                return theArray[arrayIndex];
            }

            ++arrayIndex;
            arrayIndex %= arraySize;
        }

        return null;
    }

    private String findKeyDbleHashed(String key) {

        int arrayIndex = Integer.parseInt(key) % arraySize;

        int stepDistance = 7 - (Integer.parseInt(key) % 7);

        while (!theArray[arrayIndex].equals("-1")) {
            if (theArray[arrayIndex].equals(key)) {
                System.out.println(key + " was found in index " + arrayIndex);

                return theArray[arrayIndex];
            }

            arrayIndex += stepDistance;
            arrayIndex %= arraySize;
        }

        return null;
    }

    private HashFunction(int size) {

        arraySize = size;
        theArray = new String[size];
        Arrays.fill(theArray, "-1");

    }

}
