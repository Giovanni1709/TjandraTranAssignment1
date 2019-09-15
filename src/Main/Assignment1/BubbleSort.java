package Main.Assignment1;

public class BubbleSort {
    /**
     * Sorts the passed array with bubble sort
     * @param array initial unsorted array
     * @return int[] sorted array(ascending)
     */
    public int[] sort(int[] array) {
        boolean swapped = true;
        //runs through the array again if the array is still not sorted and stops if there is no swapping needed.
        while (swapped){
            swapped = false;
            for (int i = 0; i < array.length - 1; i++) {
                //swaps if the number before is higher than the number after
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }
        }
        return array;
    }
}
