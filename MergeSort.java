import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        int[] arr = {1,3,6,4,8,7,9,2,5};

        System.out.println(Arrays.toString(arr));

        sort(arr, 0, arr.length-1);

        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int left, int right){

        if(left < right){

            int middle = (right+left)/2;
            sort(arr, left, middle);
            sort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }

    private static void merge(int[] arr, int left, int middle, int right){

        int[] L = new int[middle - left + 1];
        int[] R = new int[right - middle];

        for(int i = 0; i < L.length; i++)
            L[i] = arr[left + i];
        for(int j = 0; j < R.length; j++)
            R[j] = arr[(middle + 1) + j];

        int i = 0, j = 0;
        int k = left;

        while(i < L.length && j < R.length){

            if(L[i] <= R[j]){

                arr[k] = L[i];
                i++;
            } else {

                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while(i < L.length){

            arr[k] = L[i];
            i++;
            k++;
        }
        while(j < R.length) {

            arr[k] = R[j];
            j++;
            k++;
        }
    }
}