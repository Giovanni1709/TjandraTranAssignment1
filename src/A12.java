import java.time.Duration;
import java.time.Instant;

public class A12 {
    public static void assignment12() {
        Instant begin = Instant.now();
        final int numberToSort = 75000;

        int[] intArray = new int[numberToSort];
        for (int i = 0; i < numberToSort; i++) {
            int random = (int) (Math.random() * numberToSort + 1);
            intArray[i] = random;
        }

        int[] intArray2 = new int[numberToSort];
        for (int i = 0; i < numberToSort; i++) {
            int random = (int) (Math.random() * numberToSort + 1);
            intArray2[i] = random;
        }

        System.out.println("Array list before sorting:");
        for (int value : intArray) {
            System.out.println(value);
        }
        for (int value : intArray2) {
            System.out.println(value);
        }

        bubbleSort(intArray);
        bubbleSort(intArray2);

        mergingarr(intArray, intArray2);

        Instant end = Instant.now();
        Duration duration = Duration.between(begin, end);
        System.out.println("It took: " + duration);
    }

    /**
     * https://www.javatpoint.com/bubble-sort-in-java
     * @param arr
     */
    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        int temp = 0;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(arr[j-1] > arr[j]){
                    //swap elements
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }


    /**
     * https://stackoverflow.com/a/48483049
     * @param x
     * @param y
     */
    public static void mergingarr(int x[], int y[]) {
        int len=x.length+y.length;
        int arr[]=new int[len];
        //create a variable j which will begin zeroth index of second array
        int j=0;
        for(int i=0; i<arr.length; i++) {
            if(i<x.length) {
                arr[i]=x[i];
            } else {
                arr[i]=y[j];
                j++;
            }
        }
        System.out.println("Array list after sorting and merging:");
        for(int i:arr) {
            System.out.println(i);
        }
    }
}
