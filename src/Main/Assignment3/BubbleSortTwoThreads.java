package Main.Assignment3;

import Main.Assignment2.BubbleSortDivideToTwo;

public class BubbleSortTwoThreads {
    /**
     * Divides the array into two new arrays which will be bubble sorted separately(with threading), then merges it back again.
     * @param array initial array
     * @return int[] sorted array
     */
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

        //initiates the processes and threads, starting and joining them
        BubbleSortRunnable sortArr1 = new BubbleSortRunnable(arr1);
        BubbleSortRunnable sortArr2 = new BubbleSortRunnable(arr2);
        Thread thread1 = new Thread(sortArr1);
        Thread thread2 = new Thread(sortArr2);

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        BubbleSortDivideToTwo bubbleSort = new BubbleSortDivideToTwo();

        return bubbleSort.merge(sortArr1.getArray(), sortArr2.getArray());
    }
}
