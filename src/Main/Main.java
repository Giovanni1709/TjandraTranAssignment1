package Main;

import Main.Assignment1.BubbleSort;
import Main.Assignment2.BubbleSortDivideToTwo;
import Main.Assignment3.BubbleSortTwoThreads;
import Main.Assignment4.BubbleSortThreadThreshold;
import Main.Assignment5.BubbleSortWithForkPool;

import java.util.Arrays;
import java.util.Random;

public class Main {
    private int[] numbersArray = new int[5];

    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {

        int amountOfNumbers=25000;
        for (int i = 0; i < numbersArray.length ; i++) {
            numbersArray[i] = 25000 * ((int) Math.pow(2, i));
        }

        Assignment5(1000);//change this to preferred assignment
    }

    /**
     * prints the given array
     * @param array
     */
    public void printArray(int[] array){

        for (int i = 0; i <array.length-1 ; i++) {
            System.out.print(array[i] +", ");
        }
        System.out.println(array[array.length-1]);
    }

    /**
     * generates an array of number
     * @param amountOfNumbers
     * @return int[] array with unsorted random numbers
     */
    public int[] randomArrayGenerator(int amountOfNumbers){
        Random random = new Random();
        int[] newArray = new int[amountOfNumbers];
        for (int i = 0; i < amountOfNumbers; i++) {
            newArray[i] = random.nextInt(amountOfNumbers);
        }
        return newArray;
    }

    public void Assignment1(){
        System.out.println( "Assignment 1 normal bubblesort");
        BubbleSort bubbleSort = new BubbleSort();
        for (int a = 0; a < 5 ; a++) {
            long [] results = new long[10];
            for (int i = 0; i < 10; i++) {
                int[] array = randomArrayGenerator(numbersArray[a]);
                long begin = System.currentTimeMillis();
                bubbleSort.sort(array);
                results[i] = System.currentTimeMillis() - begin;
            }

            Arrays.sort(results);

            long avg= 0;
            for (int i = 1; i < results.length - 1; i++) {
                avg += results[i];
            }

            avg = avg/8;
            System.out.println("average "+numbersArray[a]+" : " + avg + " ms.");
        }
    }

    public void Assignment2(){
        System.out.println( "Assignment 2 divide by 2 without thread bubblesort");
        BubbleSortDivideToTwo bubbleSort = new BubbleSortDivideToTwo();

        for (int a = 0; a < 5 ; a++) {
            long [] results = new long[10];
            for (int i = 0; i < 10; i++) {
                int[] array = randomArrayGenerator(numbersArray[a]);
                long begin = System.currentTimeMillis();
                bubbleSort.sort(array);
                results[i] = System.currentTimeMillis()-begin;
            }

            Arrays.sort(results);

            long avg= 0;
            for (int i = 1; i < results.length - 1; i++) {
                avg += results[i];
            }

            avg = avg/8;
            System.out.println("average "+numbersArray[a]+" : " + avg + " ms.");
        }
    }

    public void Assignment3() {
        System.out.println( "Assignment 3 divide by 2 with thread bubblesort");
        BubbleSortTwoThreads bubbleSort = new BubbleSortTwoThreads();

        for (int a = 0; a < 5 ; a++) {
            long [] results = new long[10];
            for (int i = 0; i < 10; i++) {
                int[] array = randomArrayGenerator(numbersArray[a]);
                long begin = System.currentTimeMillis();
                bubbleSort.sort(array);
                results[i] = System.currentTimeMillis()-begin;
            }

            Arrays.sort(results);

            long avg= 0;
            for (int i = 1; i < results.length - 1; i++) {
                avg += results[i];
            }

            avg = avg/8;
            System.out.println("average "+numbersArray[a]+" : " + avg + " ms.");
        }
    }

    public void Assignment4(int threshold) {
        System.out.println( "Assignment 4 divide by 2 recursively while above threshold");
        BubbleSortThreadThreshold bubbleSort = new BubbleSortThreadThreshold();

        for (int a = 0; a < 5 ; a++) {
            long [] results = new long[10];
            for (int i = 0; i < 10; i++) {
                int[] array = randomArrayGenerator(numbersArray[a]);
                long begin = System.currentTimeMillis();
                bubbleSort.sort(array,threshold);
                results[i] = System.currentTimeMillis()-begin;
            }

            Arrays.sort(results);

            long avg= 0;
            for (int i = 1; i < results.length - 1; i++) {
                avg += results[i];
            }

            avg = avg/8;
            System.out.println("average "+numbersArray[a]+" : " + avg + " ms.");
        }
    }

    public void Assignment5(int threshold) {
        System.out.println( "Assignment 5 divide by 2 recursively while above threshold with RecursiveTask and ForkJoinPool ");
        BubbleSortWithForkPool bubbleSort = new BubbleSortWithForkPool();

        for (int a = 0; a < 5 ; a++) {
            long [] results = new long[10];
            for (int i = 0; i < 10; i++) {
                int[] array = randomArrayGenerator(numbersArray[a]);
                long begin = System.currentTimeMillis();
                bubbleSort.sort(array,threshold);
                results[i] = System.currentTimeMillis()-begin;
            }

            Arrays.sort(results);

            long avg= 0;
            for (int i = 1; i < results.length - 1; i++) {
                avg += results[i];
            }

            avg = avg/8;
            System.out.println("average "+numbersArray[a]+" : " + avg + " ms.");
        }
    }
}
