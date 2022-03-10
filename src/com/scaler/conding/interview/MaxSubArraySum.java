package com.scaler.conding.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MaxSubArraySum {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(2, 3, 1, 1, 1, 1, 1, 5, 3, 1, 1, 4, 8, 9);
		solve(list, 5);
		solveTwoPointer(list,5);

		// find the length of max sub array where the sum of sub array is 5?

	}

	private static void solveTwoPointer(List<Integer> A, int B) {
		
//		int sum =b
//		int maxLen = B;
//		for(i ->0 -listsize) {
//			sum += list.get(i);
//			if( A.get(i) == b && maxlen == B) {
//				maxLen =1}
//			if(sum ==B) {
//				maxlen = i+1
//			}
//			Integer prev = hm.get(sum);
//					if(prev !=null)
//maxln = Math.max(maxlen, i-prev)
//		}
//		else hm.put(sum , i);
		
	}

	private static int solve(List<Integer> list, int B) {

		List<Integer> psarr = new ArrayList<Integer>();
		int l=0,r=0;

		psarr.add(list.get(0));
		for (int i = 0; i < list.size(); i++) {
			if (i + 1 != list.size()) {
				psarr.add(psarr.get(i) + list.get(i + 1));
			}
		}
		HashMap<Integer, Integer> hm = new HashMap<>();
		
		for(int i = 0; i < psarr.size(); i++) {
			if(hm.containsKey(psarr.get(i))) {
				
				hm.put(psarr.get(i), hm.get(psarr.get(i))+1);
				l= i;
			}else {
				hm.put(psarr.get(i), 1);
			}
		}

		return 0;

	}
	
	
	//Given collection of Strings null, "yuLia", "  ", "borjA", "Ceba", "", "aleNa", "daRek", "FranK", null, "yulia" 
	//
	//Need to implement method that returns String “Alena - Borja - Ceba - Darek - Frank – Yulia" 
	//
	//public static String combine(List<String> asList) { 

}
