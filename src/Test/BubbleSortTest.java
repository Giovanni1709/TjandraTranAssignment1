package Test;

import Main.Assignment1.BubbleSort;
import Main.Assignment2.BubbleSortDivideToTwo;
import Main.Assignment3.BubbleSortTwoThreads;
import Main.Assignment4.BubbleSortThreadThreshold;
import Main.Assignment5.BubbleSortWithForkPool;
import Main.Main;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class BubbleSortTest {
    private Main main = new Main();
    private Random random = new Random();


    @Test
    public void testA1BubbleSort() {
        BubbleSort bubbleSort = new BubbleSort();

        //testing if bubble sort works
        int[] array = main.randomArrayGenerator(random.nextInt(100000));
        int[] initialArray = array.clone();
        Arrays.sort(initialArray);
        assertArrayEquals(initialArray, bubbleSort.sort(array), "sorting does not succeed");
    }

    @Test
    public void testA2BubbleSortDivideToTwo() {
        BubbleSortDivideToTwo bubbleSortDivideToTwo = new BubbleSortDivideToTwo();

        //testing if the sort method returns a correct sorted array
        int[] array = main.randomArrayGenerator(random.nextInt(100000));
        int[] initialArray = array.clone();
        Arrays.sort(initialArray);
        assertArrayEquals(initialArray, bubbleSortDivideToTwo.sort(array), "sorting does not succeed");

        int[] arr1 = main.randomArrayGenerator(random.nextInt(50000));
        int[] arr2 = main.randomArrayGenerator(random.nextInt(50000));
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int[] combinedArr = joinArray(arr1, arr2);
        Arrays.sort(combinedArr);
        assertArrayEquals(combinedArr, bubbleSortDivideToTwo.merge(arr1, arr2),"merge does not succeed");

    }

    @Test
    public void testA3BubbleSortTwoThreads(){
        BubbleSortTwoThreads bubbleSortTwoThreadsb = new BubbleSortTwoThreads();

        //testing if the sort method returns a correct sorted array
        int[] array = main.randomArrayGenerator(random.nextInt(100000));
        int[] initialArray = array.clone();
        Arrays.sort(initialArray);
        assertArrayEquals(initialArray, bubbleSortTwoThreadsb.sort(array), "sorting does not succeed");
    }

    @Test
    public void testA4BubbleSortThreadThreshold(){
        BubbleSortThreadThreshold bubbleSortThreadThreshold = new BubbleSortThreadThreshold();

        //testing if the sort method returns a correct sorted array
        int[] array = main.randomArrayGenerator(random.nextInt(100000));
        int[] initialArray = array.clone();
        Arrays.sort(initialArray);
        assertArrayEquals(initialArray, bubbleSortThreadThreshold.sort(array,random.nextInt(array.length)), "sorting does not succeed");
    }

    @Test
    public void testA5BubbleSortWithForkPool(){
        BubbleSortWithForkPool bubbleSortWithForkPool= new BubbleSortWithForkPool();

        //testing if the sort method returns a correct sorted array
        int[] array = main.randomArrayGenerator(random.nextInt(100000));
        int[] initialArray = array.clone();
        Arrays.sort(initialArray);
        assertArrayEquals(initialArray, bubbleSortWithForkPool.sort(array,random.nextInt(array.length)), "sorting does not succeed");
    }

    private int[] joinArray(int[] arr1, int[] arr2) {
        int[] combined = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, combined, 0, arr1.length);
        System.arraycopy(arr2,0,combined,arr1.length,arr2.length);

        return combined;
    }
}
