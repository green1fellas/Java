import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args){

        int[] array = new int[]{4,6,3,2,9,0};
        System.out.println(Arrays.toString(bubbleSort(array)));
    }

    private static int[] bubbleSort(int[] list){

        for(int i = 0; i < list.length-1; i++){
            for(int j = 0; j < list.length-1-i;j++){

                if(list[j] > list[j+1]){
                    int temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                }
            }
        }
        return list;
    }
}