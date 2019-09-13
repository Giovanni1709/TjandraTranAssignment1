package Assignment2;

import Assignment1.BubbleSort;

public class BubbleSortDivideToTwo {
    public int[] sort(int[] array) {
        int middle = array.length / 2;
        int[] arr1 = new int[middle];
        int[] arr2 = new int[array.length - middle];

        for (int i = 0; i < middle ; i++) {
            arr1[i] = array[i];
        }

        for (int i = 0; i < array.length-middle; i++) {
            arr2[i] = array[middle + i];
        }
        BubbleSort bubbleSort = new BubbleSort();
        return merge(bubbleSort.sort(arr1),bubbleSort.sort(arr2));
    }

    public int[] merge(int[] array1, int[] array2) {
        int[] newArray = new int[array1.length + array2.length];
        int pointer = 0;
        int pointer1 = 0;
        int pointer2 = 0;
        while (pointer1 < array1.length && pointer2 < array2.length) {
            if (array1[pointer1] < array2[pointer2]) {
                newArray[pointer] = array1[pointer1];
                pointer1++;
            } else {
                newArray[pointer] = array2[pointer2];
                pointer2++;
            }
            pointer++;
        }

        if (pointer2<array2.length){
            while (pointer2 < array2.length) {
                newArray[pointer] = array2[pointer2];
                pointer2++;
                pointer++;
            }
        }else {
            while (pointer1 < array1.length) {
                newArray[pointer] = array1[pointer1];
                pointer1++;
                pointer++;
            }
        }
        return newArray;
    }
}
