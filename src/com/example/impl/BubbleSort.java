package com.example.impl;

import com.example.SortingAlgorithm;

/**
 * User: Mike
 * Date: 5/26/13
 * Time: 8:59 AM
 */
public class BubbleSort implements SortingAlgorithm {
    
    private int[] data;

    public BubbleSort(int[] data) {
        this.data = data;
    }

    /**
     * Examine the first number and check to see if it is smaller than the second.
     * If it is, flip them and move on to the next number in the array. Keep checking
     * until no more flipping needs to occur.
     *
     */
    @Override
    public int[] sort() {
        boolean flippingOccured;
        do{
            flippingOccured = false;
            for(int i = 0; i < data.length - 1; i++){
                if(data[i] > data[i + 1]){
                    int save = data[i];
                    data[i] = data[i + 1];
                    data[i + 1] = save;
                    flippingOccured = true;
                }
            }
        }while(flippingOccured);
        return data;
    }

    @Override
    public String name() { return "Bubble Sort"; }
}
