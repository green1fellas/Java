import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args){

        int[] array = new int[]{5,3,8,1,0,2};
        System.out.println(Arrays.toString(Sort(array)));

    }

    private static int[] Sort(int[] list){

        int key;

        for(int i = 1; i < list.length; i++){

            key = list[i];
            int j = i-1;

            while(j >= 0 && key < list[j]){
                list[j+1] = list[j];
                j--;
            }
            list[j+1] = key;
        }
        return list;
    }
}