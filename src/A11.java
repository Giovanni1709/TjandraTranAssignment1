import java.time.Duration;
import java.time.Instant;

public class A11 {
    public static void assignment11() {
        Instant begin = Instant.now();

        int[] intArray = new int[25000];
        for (int i = 0; i < 25000; i++) {
            int random = (int) (Math.random() * 25000 + 1);
            intArray[i] = random;
        }

        for (int value : intArray) {
            System.out.println(value);
        }

        bubbleSort(intArray);

        for (int value : intArray) {
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
