package com.scaler.ds.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KPlacesApart {

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>();
		A.addAll(Arrays.asList(1, 40, 2, 3));
		int B= 2;
		solve(A,B);
	}

	public static ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
		ArrayList<Integer> ans = new ArrayList<>();
		
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		
		for(int i=0; i<B+1; i++) {
			heap.offer(A.get(i));
		}
		
		ans.add(heap.poll());
		for(int i= B+1; i<A.size(); i++) {
			heap.offer(A.get(i));
			ans.add(heap.poll());
		}
		
	while(ans.size() < A.size()) {
			ans.add(heap.poll());
		}
		
		
		return ans;
    }

}

