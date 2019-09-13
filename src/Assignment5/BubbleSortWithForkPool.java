package Assignment5;

import java.util.concurrent.ForkJoinPool;

public class BubbleSortWithForkPool {
    public int[] sort(int[] array, int threshold) {
        BubbleSortTask task = new BubbleSortTask(array, threshold);
        ForkJoinPool fjp = ForkJoinPool.commonPool();

        return fjp.invoke(task);
    }
}
