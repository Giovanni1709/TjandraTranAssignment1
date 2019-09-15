package Main.Assignment3;

import Main.Assignment1.BubbleSort;

public class BubbleSortRunnable implements Runnable {
    private int[] array;

    /**
     * the Runnable that will sort the array
     * @param array int[] initial array
     */
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
