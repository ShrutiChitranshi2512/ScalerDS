package com.scaler.ds.heap;

public class MaxSumAfterBNegations {

	public static void main(String[] args) {
		int[] A= {57, 3, -14, -87, 42, 38, 31, -7, -28, -61};
		int B = 10;
		solve(A, B);

	}
	
	public static int solve(int[] A, int B) {
		
		MinHeap minHeap = new MinHeap(A, A.length);
		
		int sum = 0;
		
		while(!minHeap.isSizeOne() && B > 0) {
			
			int min = minHeap.extractMin();
			if(min<0) {
				min = ~(min - 1);
			}else {
				min =(~(min - 1));
			}
			 minHeap.insertKey(min);
			B--;
		}
		while(!minHeap.isSizeOne()) {
			sum += minHeap.extractMin();
		}
		sum += minHeap.extractMin();
		
		return sum;
    }

}
