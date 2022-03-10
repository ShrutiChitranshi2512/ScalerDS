package com.scaler.ds.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class OrderThem {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.addAll(Arrays.asList(5, 1, 2, 4, 3));
		solve(arr);

	}
	
	public static int solve(ArrayList<Integer> A) {
		int n=A.size();
	    Stack<Integer> s = new Stack<>();
	    int i=0,k=0;
	    while(i<n){
	        while(!s.isEmpty() && s.peek() == k+1){
	            ++k;
	            s.pop();
	        }
	    if(A.get(i)!=k+1)
	        s.push(A.get(i));
	    else
	        ++k;
	    ++i;
	    }
	    while(!s.isEmpty()  && s.peek() == k+1){
	        ++k;
	        s.pop();
	    }
	    // if all are traversed
	    if(k==n)
	        return 1;
	    // else return 0
	    return 0;
	}

}
