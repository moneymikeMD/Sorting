package com.example.impl;

import com.example.SortingAlgorithm;

/**
 * User: Mike
 * Date: 5/26/13
 * Time: 8:56 AM
 */
public class SelectionSort implements SortingAlgorithm {
    private int[] data;

    public SelectionSort(int[] data) {
        this.data = data;
    }

    /**
     * Take the smallest number in array and put it in front.
     * Shuffle the rest of the numbers down by one and perform again.
     *
     */
    @Override
    public int[] sort() {

        for(int i = 0; i < data.length; i++){     // Starting point
            int smallest = 100;
            int position = 0;
            for(int j = i; j < data.length; j++){
                if(data[j] < smallest){
                    smallest = data[j];
                    position = j;
                }
            }
            // Move everything down one starting from that named position
            for(int k = position; k > i; k--){
                data[k] = data[k - 1];
            }

            data[i] = smallest;
        }
        
        return data;
    }

    @Override
    public String name() { return "Selection Sort"; }
}
