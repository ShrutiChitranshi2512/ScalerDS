package com.scaler.ds.heap;

import java.util.ArrayList;
import java.util.Arrays;

public class ConnectRopes {

	public static void main(String[] args) {
		int[] A = {1, 2, 3, 4, 5};
		
		solve(A);

	}
	public static int solve(int[] A) {
	    
	    	int n= A.length;
	        int cost = 0; // Initialize result
	 
	        // Create a min heap of capacity equal
	        // to n and put all ropes in it
	        MinHeap minHeap = new MinHeap(A, n);
	 
	        // Iterate while size of heap doesn't become 1
	        while (!minHeap.isSizeOne()) {
	            // Extract two minimum length ropes from min heap
	            int min = minHeap.extractMin();
	            int sec_min = minHeap.extractMin();
	 
	            cost += (min + sec_min); // Update total cost
	 
	            // Insert a new rope in min heap with length equal to sum
	            // of two extracted minimum lengths
	            minHeap.insertKey(min + sec_min);
	        }
	 
	        // Finally return total minimum
	        // cost for connecting all ropes
	        return cost;
	    }

}
