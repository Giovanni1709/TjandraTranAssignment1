package Main.Assignment5;

import java.util.concurrent.ForkJoinPool;

public class BubbleSortWithForkPool {
    /**
     * sorts the array by splitting and merging recursively utilizing RecursiveTask and ForkJoinPool
     * @param array initial array
     * @param threshold
     * @return int[] sorted array
     */
    public int[] sort(int[] array, int threshold) {
        BubbleSortTask task = new BubbleSortTask(array, threshold);
        ForkJoinPool fjp = ForkJoinPool.commonPool();

        return fjp.invoke(task);
    }
}
