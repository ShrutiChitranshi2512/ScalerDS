package com.scaler.ds.heap;

public class ProductOf3 {

	public static void main(String[] args) {
		int[] A = {1, 2, 3, 4, 5};
        solve(A);
	}
	
	public static int[] solve(int[] A) {
		
		int n= A.length;
		int[] ans = new int[n]; 
		
    MaxHeap maxheap = new MaxHeap(A.length);
		
		for(int i=0; i<n; i++) {
			maxheap.insert(A[i]);
			if(i<2) {
				ans[i] =-1;
			}else {
				long a = maxheap.extractMax();				
				long b = maxheap.extractMax();
				long c = maxheap.extractMax();
                maxheap.insert(a);
                maxheap.insert(b);
                maxheap.insert(c);
				
				ans[i] = (int) ((int) a*b*c);				
			}
		}
		return ans;
		
    }

}
