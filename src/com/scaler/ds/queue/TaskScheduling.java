package com.scaler.ds.queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class TaskScheduling {

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>();
		ArrayList<Integer> B = new ArrayList<>();
		A.addAll(Arrays.asList(1));
		B.addAll(Arrays.asList(1));
		solve(A, B);

	}

	public static int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
		
		Deque<Integer> task = new LinkedList<>();
		
		int cycle =0;
		
		for(int i=0; i<A.size(); i++) {
			task.add(A.get(i));			
		}
		
		int j=0;
		while(!task.isEmpty()) {
			while(j < B.size() && B.get(j) != task.peekFirst()) {
				task.addLast(task.pollFirst());
				cycle++;
			}
			
			while(j < B.size() && B.get(j) == task.peekFirst()) {
				task.pop();
				cycle++;
				j++;
			}
		}
	
		return cycle;
	}

}
