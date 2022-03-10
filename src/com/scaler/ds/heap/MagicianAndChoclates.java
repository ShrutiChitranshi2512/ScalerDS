package com.scaler.ds.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MagicianAndChoclates {

	public static void main(String[] args) {
		
   int[] B = {2147483647, 2000000014, 2147483647};
   int A = 10;
   System.out.println(nchoc(A,B));
	}
	
	static long mod = 1000000007;
    public static  int nchoc(int A, int[] B) {
        int N = B.length;
        int K = A;
        long ans = 0;
        PriorityQueue < Integer > heap = new PriorityQueue(new CustomComp());
        for (int a: B)
            heap.offer(a);
        while (K > 0) {

            //Get maximum element from the heap 
            long max_elem = (long) heap.poll();

            // Add the maximum element to the answer
            ans += max_elem;
            ans = ans % mod;
            // push the floor(A[i]/2) back to the heap.
            heap.offer((int)(max_elem / 2));
            K--;
        }
        return (int) ans;
    }
}

class CustomComp implements Comparator < Integer > {
    @Override
    public int compare(Integer a, Integer b) {
        return b - a;
    }
}

