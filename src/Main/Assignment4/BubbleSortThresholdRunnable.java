package Main.Assignment4;

import Main.Assignment1.BubbleSort;
import Main.Assignment2.BubbleSortDivideToTwo;

public class BubbleSortThresholdRunnable implements Runnable {
    private int[] array;
    private int threshold;

    /**
     * the Runnable that splits, sorts , and merges the arrays recursively
     * @param array initial array
     * @param threshold
     */
    public BubbleSortThresholdRunnable(int[] array, int threshold){
        this.array = array;
        this.threshold = threshold;
    }
    @Override
    public void run() {
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
            BubbleSortThresholdRunnable bstr1 = new BubbleSortThresholdRunnable(arr1, threshold);
            BubbleSortThresholdRunnable bstr2 = new BubbleSortThresholdRunnable(arr2, threshold);

            Thread thread1 = new Thread(bstr1);
            Thread thread2 = new Thread(bstr2);

            thread1.start();
            thread2.start();
            try {
                thread1.join();
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            BubbleSortDivideToTwo bubbleSort = new BubbleSortDivideToTwo();
            array = bubbleSort.merge(bstr1.getArray(), bstr2.getArray());
        } else {
            BubbleSort bubbleSort = new BubbleSort();
            array= bubbleSort.sort(array);
        }
    }

    public int[] getArray() {
        return array;
    }
}
