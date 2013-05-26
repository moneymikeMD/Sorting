package com.example.impl;

import com.example.SortingAlgorithm;

/**
 * User: Mike
 * Date: 5/26/13
 * Time: 8:24 AM
 */
public class QuickSort implements SortingAlgorithm {

    private int[] data;

    public QuickSort(int[] data){
        this.data = data;
    }

    @Override
    public int[] sort() {
        quickSort(data, 0, data.length - 1);
        return data;
    }

    /**
     * Re-arrange elements in an array by comparing values at two points. If one point is
     * larger than the value emphasised by a special pointer, then swap those values. If not,
     * move the non-emphasised point inward.
     *
     * @param nums Array of Integers
     */
    private void quickSort(int[] nums, int startPos, int endPos){
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

    @Override
    public String name() { return "Quick Sort"; }
}
