package com.scaler.ds.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class RunningMedian {

	public static void main(String[] args) {

		ArrayList<Integer> A = new ArrayList<>();
		A.addAll(Arrays.asList(59, 64, 10, 39));
		solve(A);

	}

	public static ArrayList<Integer> solve(ArrayList<Integer> A) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		

		if(A.size() == 1) {
			ans.add(A.get(0));
			return ans;
		}
		
		if(A.size() == 2) {
			int min = Math.min(A.get(0), A.get(1));
			ans.add(min);
			ans.add(min);
			return ans;
		}
		
		
		if (A.size() >= 3) {
			PriorityQueue<Integer> minHeap = new PriorityQueue<>();
			PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new CustomComp());
			maxHeap.offer(A.get(0) < A.get(1) ? A.get(0) : A.get(1));
			minHeap.offer(A.get(1) > A.get(0) ? A.get(1) : A.get(0));

			ans.add((int) Math.min(minHeap.peek(), maxHeap.peek()));
			ans.add(ans.get(0));

			for (int i = 2; i < A.size(); i++) {
				if (A.get(i) < maxHeap.peek() && maxHeap.size() == minHeap.size()) {
					maxHeap.offer(A.get(i));
					ans.add(maxHeap.peek());
				} else if (A.get(i) > maxHeap.peek() && maxHeap.size() == minHeap.size()) {
					minHeap.offer(A.get(i));
					ans.add(minHeap.peek());

				} else if (A.get(i) > minHeap.peek() && minHeap.size() > maxHeap.size()) {
					maxHeap.offer(minHeap.poll());
					minHeap.offer(A.get(i));
					ans.add(maxHeap.peek());
				} else if (A.get(i) > maxHeap.peek() && maxHeap.size() < minHeap.size()) {
					maxHeap.offer(A.get(i));
					ans.add(maxHeap.peek());
				} else if (A.get(i) < minHeap.peek() && maxHeap.size() > minHeap.size()) {
					minHeap.offer(A.get(i));
					ans.add(minHeap.peek());
				}else if (A.get(i) < maxHeap.peek() && maxHeap.size() < minHeap.size()) {
					maxHeap.offer(A.get(i));
					ans.add(maxHeap.peek());
				}
			}
		}
		return ans;
	}

}
