import java.util.Random;

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

        // do stuff
        for(int i = 1; i < passes + 1; i++){
            long startTime = System.currentTimeMillis();
            selectionSort(sampleArray.clone());
            long endTime = System.currentTimeMillis() - startTime;
            System.out.println("Selection sort pass #" + i + " completed in " + endTime + ".");
        }

        for(int i = 1; i < passes + 1; i++){
            long startTime = System.currentTimeMillis();
            bubbleSort(sampleArray.clone());
            long endTime = System.currentTimeMillis() - startTime;
            System.out.println("Bubble sort pass #" + i + " completed in " + endTime + ".");
        }
    }

    /**
     * Take the smallest number in array and put it in front.
     * Shuffle the rest of the numbers down by one and perform again.
     *
     * @param nums Array of Integers
     */
    private static void selectionSort(int[] nums){
        for(int i = 0; i < nums.length; i++){     // Starting point
            int smallest = 100;
            int position = 0;
            for(int j = i; j < nums.length; j++){
                if(nums[j] < smallest){
                    smallest = nums[j];
                    position = j;
                }
            }
            // Move everything down one starting from that named position
            for(int k = position; k > i; k--){
                nums[k] = nums[k - 1];
            }

            nums[i] = smallest;
        }
    }

    /**
     * Examine the first number and check to see if it is smaller than the second.
     * If it is, flip them and move on to the next number in the array. Keep checking
     * until no more flipping needs to occur.
     *
     * @param nums Array of Integers
     */
    private static void bubbleSort(int[] nums){
        boolean flippingOccured;
        do{
            flippingOccured = false;
            for(int i = 0; i < nums.length - 1; i++){
                if(nums[i] > nums[i + 1]){
                    int save = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = save;
                    flippingOccured = true;
                }
            }
        }while(flippingOccured);
    }
}
