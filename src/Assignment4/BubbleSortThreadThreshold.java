package Assignment4;

import Assignment2.BubbleSortDivideToTwo;
import Assignment3.BubbleSortRunnable;

public class BubbleSortThreadThreshold {
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
