import java.util.Arrays;

public class MergeSortNotes {

    /* passes through array, left index, middle index
        and right index */

    private void merge(int arr[], int l, int m, int r){

        /* left side length */
        int lLength = m - l + 1;
        /* right side length */
        int rLength = r - m;

        /* Create temporary arrays */
        int L[] = new int[lLength];
        int R[] = new int[rLength];

        /* copy values to new temporary arrays */
        /* Left */
        for(int i = 0; i < lLength; ++i)
            L[i] = arr[l + i];
        /* Right */
        for(int j = 0; j < rLength; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temporary arrays */
        /*  i = left
            j = right
            k = new merged array */

        int i = 0, j = 0, k = l;

        /* while i < n1 and j < n2,
           if the value on the left
           is smaller or equal to the
           value on the right, add
           the left value to the
           new array "k" and increment i. */
        while(i < lLength && j < rLength){
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;

                /* else, if right side
                * is bigger, than add the
                * right value to the new array. */
            }else{
                arr[k] = R[j];
                j++;
            }

            /* k is incremented so we can add
            these new values step by step to the
            new array */
            k++;
        }

        /* These two while loops copy the
        * remaining values of the R and L arrays
        * to k in case one is empty but another
        * is not. */
        while(i < lLength){
            arr[k] = L[i];
            i++;
            k++;
        }
        while(j < rLength){
            arr[k] = R[j];
            j++;
            k++;
        }

    }

    private void sort(int arr[], int l, int r){

        if(l < r){
            int m = (l + r)/2;

            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public static void main(String args[]){

        int arr[] = {12, 11, 13, 5, 6, 7};

        System.out.println("Given Array");
        System.out.println(Arrays.toString(arr));
        System.out.println("Sorted array");
        MergeSortNotes ms = new MergeSortNotes();
        ms.sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

}