public class BinarySearch{

    private static int[] array = {0,1,2,3,4,5,6,7,8,9};

    public static void main(String[] args){

        if(Search(array, 7)){
            System.out.println("Found 7");
        }
        if(!Search(array, 123)){
            System.out.println("Did not find 123");
        }

    }

    private static boolean Search(int[] array, int search){

        int first = 0;
        int last = array.length - 1;
        int middle = (first + last) / 2;

        while(first <= last){

            if(array[middle] < search){
                first = middle + 1;
            }else if(array[middle] == search){
                return true;
            }else{
                last = middle - 1;
            }
            middle = (first + last) / 2;
        }
        return false;
    }
}

