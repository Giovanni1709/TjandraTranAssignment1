package Main.Assignment4;

public class BubbleSortThreadThreshold {
    /**
     * Sorts the array by splitting it into 2 new arrays handled by 2 separate threads recursively until below threshold and start merging upwards.
     * @param array initial array
     * @param threshold the threshold to decide whether the array still needs to split or not
     * @return int[] sorted array
     */
    public int[] sort(int[] array, int threshold) {
        BubbleSortThresholdRunnable  bstr= new BubbleSortThresholdRunnable(array, threshold);
        Thread thread = new Thread(bstr);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return bstr.getArray();
    }
}
