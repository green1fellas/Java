import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] arr = {3,2,5,6,8,1,9};

        System.out.println(Arrays.toString(arr));
        sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int left, int right){

        if(left < right){

            int pivot = partition(arr, left, right);
            sort(arr, left, pivot-1);
            sort(arr, pivot + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right){

        int pivot = arr[right];

        int i = left-1;

        for(int j = left; j < right; j++) {

            if (arr[j] <= pivot) {

                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[right];
        arr[right] = temp;
        return i+1;
    }
}