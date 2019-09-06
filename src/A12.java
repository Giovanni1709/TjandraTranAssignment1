import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A12 {
    public static void assignment12() {
        Instant begin = Instant.now();

        int[] intArray = new int[75000];
        for (int i = 0; i < 75000; i++) {
            int random = (int) (Math.random() * 75000 + 1);
            intArray[i] = random;
        }

        int[] intArray2 = new int[75000];
        for (int i = 0; i < 75000; i++) {
            int random = (int) (Math.random() * 75000 + 1);
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

        System.out.println("Array list after sorting:");
        for (int value : intArray) {
            System.out.println(value);
        }
        for (int value : intArray2) {
            System.out.println(value);
        }



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
}
