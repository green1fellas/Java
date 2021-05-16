import java.util.Arrays;

class SelectionSort
{
    private void sort(int arr[]){

        for (int i = 0; i < arr.length-1; i++)
        {
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++)
                if (arr[j] < arr[minIndex])
                    minIndex = j;

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String args[])
    {
        SelectionSort ob = new SelectionSort();
        int arr[] = {64,25,12,22,11};
        ob.sort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}