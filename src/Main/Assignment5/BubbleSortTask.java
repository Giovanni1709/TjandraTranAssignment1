package Main.Assignment5;

import Main.Assignment1.BubbleSort;
import Main.Assignment2.BubbleSortDivideToTwo;

import java.util.concurrent.RecursiveTask;

public class BubbleSortTask extends RecursiveTask<int[]> {

    private int[] array;
    private int threshold;

    /**
     * the RecursiveTask that splits, sorts, and merges the arrays recursively
     * @param array initial array
     * @param threshold
     */
    public BubbleSortTask(int[] array, int threshold) {
        this.array = array;
        this.threshold = threshold;
    }
    @Override
    protected int[] compute() {
        if (array.length > threshold) {
            int middle = array.length / 2;
            int[] arr1 = new int[middle];
            int[] arr2 = new int[array.length - middle];

            for (int i = 0; i < middle ; i++) {
                arr1[i] = array[i];
            }

            for (int i = 0; i < array.length-middle; i++) {
                arr2[i] = array[middle + i];
            }

            //initiates the processes and threads, starting and joining them
            BubbleSortTask bst1 = new BubbleSortTask(arr1, threshold);
            bst1.fork();
            BubbleSortTask bst2 = new BubbleSortTask(arr2, threshold);
            bst2.fork();

            BubbleSortDivideToTwo bubbleSort = new BubbleSortDivideToTwo();

            array = bubbleSort.merge(bst1.join(), bst2.join());
            return array;
        } else {
            BubbleSort bubbleSort = new BubbleSort();
            array= bubbleSort.sort(array);
            return array;
        }
    }
}
