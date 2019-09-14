package Assignment3;

import Assignment1.BubbleSort;

public class BubbleSortRunnable implements Runnable {
    private int[] array;

    public BubbleSortRunnable(int[] array) {
        this.array= array;
    }

    @Override
    public void run() {
        BubbleSort bubbleSort = new BubbleSort();
        array= bubbleSort.sort(array);
    }

    public int[] getArray() {
        return array;
    }
}
