package com.scaler.ds.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class AthLargestElement {

	public static void main(String[] args) {
		
		ArrayList<Integer> B = new ArrayList<>();
		B.addAll(Arrays.asList(15, 20, 99, 1));
		int A= 2;
		solve(A,B);
		

	}
	
	 public static ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
		 
		 ArrayList<Integer> ans = new ArrayList<>();

	        PriorityQueue<Integer> heap = new PriorityQueue<>();
	        
	        for(int i=0;i<A-1; i++) {
	        	ans.add(-1);
	        	heap.offer(B.get(i));
	        }
	        
	        for(int i=A-1; i<B.size(); i++) {
	        	     
	        	if(heap.peek()< B.get(i)) {
	        		heap.offer(B.get(i));
	        		if(heap.size() > A) {
	        			heap.poll();
	        		}
	        		ans.add(heap.peek());
	        	}else {
	        		ans.add(heap.peek());
	        	}
	        }
	        
			return ans; 
	    }

}
