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

        for(int i = 1; i < passes + 1; i++){
            long startTime = System.currentTimeMillis();
            quickSort(sampleArray.clone(), 0, sampleArray.length - 1);
            long endTime = System.currentTimeMillis() - startTime;
            System.out.println("Quick sort pass #" + i + " completed in " + endTime + ".");
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

    /**
     * Re-arrange elements in an array by comparing values at two points. If one point is
     * larger than the value emphasised by a special pointer, then swap those values. If not,
     * move the non-emphasised point inward.
     *
     * @param nums Array of Integers
     */
    private static void quickSort(int[] nums, int startPos, int endPos){
        int pnt1 = startPos;
        int pnt2 = endPos;
        boolean directionRight = true;

        if(pnt1 == pnt2 || pnt1 > pnt2) return;
        do {
            if(directionRight){
                if(nums[pnt1] > nums[pnt2]){
                    int save = nums[pnt1];
                    nums[pnt1] = nums[pnt2];
                    nums[pnt2] = save;
                    directionRight = false;         // flip pointer
                    pnt1++;                         // move outer in because we just compared it
                } else {
                    pnt2--;                         // move point inward
                }
            } else {
                if(nums[pnt1] > nums[pnt2]){
                    int save = nums[pnt1];
                    nums[pnt1] = nums[pnt2];
                    nums[pnt2] = save;
                    directionRight = true;
                    pnt2--;
                } else {
                    pnt1++;
                }
            }
        } while(pnt1 != pnt2);

        // If here, there are two sides to do quick sort on now
        // Left sublist
        quickSort(nums, startPos, pnt1);

        // Right sublist
        quickSort(nums, pnt1 + 1, endPos);

    }
}
