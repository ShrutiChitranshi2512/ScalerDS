package com.scaler.ds.binary_search;

public class SqrtOfInteger {

	public static void main(String[] args) {

		sqrt(2147483647);
	}

	public static int sqrt(int A) {
		
		long start =0, end = A<2?A:A/2;
		
		 while(start<=end) {
			 long mid = (start + end)/2;
			 if(mid*mid < A) {
				 if((mid+1)*(mid+1) > A) {
					 return (int)mid;
				 }
				 start =mid+1;
			 }else if(mid*mid > A) {
				 end= mid-1;
			 }else if(mid*mid == A) {
				 return (int) mid;
			 }
		 }
		
		return -1;

	}

}
