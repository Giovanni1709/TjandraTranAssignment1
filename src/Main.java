import Assignment1.BubbleSort;
import Assignment2.BubbleSortDivideToTwo;
import Assignment3.BubbleSortTwoThreads;
import Assignment4.BubbleSortThreadThreshold;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    private int[][] numbersArray = new int[5][];

    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {

        int amountOfNumbers=25000;
        for (int i = 0; i < numbersArray.length ; i++) {
            amountOfNumbers = 25000 * ((int) Math.pow(2, i));
            numbersArray[i] = randomArrayGenerator(amountOfNumbers);
        }

        Assignment4(5000);
    }

    public void printArray(int[] array){

        for (int i = 0; i <array.length-1 ; i++) {
            System.out.print(array[i] +", ");
        }
        System.out.println(array[array.length-1]);
    }

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
        long averageDuration=0;
        for (int a = 0; a < 5 ; a++) {
            for (int i = 0; i < 10; i++) {
                long begin = System.currentTimeMillis();
                bubbleSort.sort(numbersArray[a]);
                averageDuration += System.currentTimeMillis() - begin;
            }
            averageDuration /= 10;
            System.out.println("average "+numbersArray[a].length+" : " + averageDuration + " ms.");
        }
    }

    public void Assignment2(){
        System.out.println( "Assignment 2 divide by 2 without thread bubblesort");
        BubbleSortDivideToTwo bubbleSort = new BubbleSortDivideToTwo();
        long averageDuration=0;
        for (int a = 0; a < 5 ; a++) {
            for (int i = 0; i < 10; i++) {
                long begin = System.currentTimeMillis();
                bubbleSort.sort(numbersArray[a]);
                averageDuration += System.currentTimeMillis() - begin;
            }
            averageDuration /= 10;
            System.out.println("average "+numbersArray[a].length+" : " + averageDuration + " ms.");
        }
    }

    public void Assignment3() {
        System.out.println( "Assignment 3 divide by 2 with thread bubblesort");
        BubbleSortTwoThreads bubbleSort = new BubbleSortTwoThreads();
        long averageDuration=0;
        for (int a = 0; a < 5 ; a++) {
            for (int i = 0; i < 10; i++) {
                long begin = System.currentTimeMillis();
                bubbleSort.sort(numbersArray[a]);
                averageDuration += System.currentTimeMillis() - begin;
            }
            averageDuration /= 10;
            System.out.println("average "+numbersArray[a].length+" : " + averageDuration + " ms.");
        }
    }

    public void Assignment4(int threshold) {
        System.out.println( "Assignment 4 divide by 2 recursively while above threshold");
        BubbleSortThreadThreshold bubbleSort = new BubbleSortThreadThreshold();
        long averageDuration=0;
        for (int a = 0; a < 5 ; a++) {
            for (int i = 0; i < 10; i++) {
                long begin = System.currentTimeMillis();
                bubbleSort.sort(numbersArray[a],threshold);
                averageDuration += System.currentTimeMillis() - begin;
            }
            averageDuration /= 10;
            System.out.println("average "+numbersArray[a].length+" : " + averageDuration + " ms.");
        }

    }
}
