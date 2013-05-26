import com.example.SortingAlgorithm;
import com.example.impl.*;

import java.util.Random;

/**
 * Sorting examples
 * @author Michael Garrett
 */
public class Sorting {
    public static void main(String[] args){
        final int passes = args.length > 0 && args[0] != null ? Integer.parseInt(args[0]) : 3;
        final int numbers = args.length > 1 && args[1] != null ? Integer.parseInt(args[1]) : 500;
        System.out.println("Printing the results of each sort type: ");

        int[] sampleArray = new int[numbers];
        Random random = new Random();
        for(int i = 0; i < numbers; i++){
            sampleArray[i] = random.nextInt(1000);
        }

        //System.out.println("Sample Array: " + Arrays.toString(sampleArray));

        for(int x = 1; x < 4; x++) {
            for(int i = 1; i < passes + 1; i++){
                SortingAlgorithm algorithm;
                switch (x){
                    case 1: algorithm = new SelectionSort(sampleArray.clone()); break;
                    case 2: algorithm = new BubbleSort(sampleArray.clone()); break;
                    default: algorithm = new QuickSort(sampleArray.clone());
                }

                long startTime = System.currentTimeMillis();
                algorithm.sort();
                long endTime = System.currentTimeMillis() - startTime;
                System.out.println(algorithm.name() + " pass #" + i + " completed in " + endTime + ".");
            }
        }
    }

}
