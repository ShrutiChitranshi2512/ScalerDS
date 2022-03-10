package com.scaler.ds.binary_search;

public class SearchForARange {

	public static void main(String[] args) {
		int[] A = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3,
				3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6,
				6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8,
				8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
				10 };
		int B = 10;
		searchRange(A, B);

	}

	public static int[] searchRange(final int[] A, int B) {

		int n = A.length;
		int start = 0, end = n - 1, first = -1, last = -1;
		int mid = -1;

			while (start <= end) {
				mid = (start + end) / 2;
				if (A[mid] < B) {
					start = mid + 1;
				} else if (A[mid] >= B) {
					if(A[mid] == B) {
						first = mid;
					}
					end = mid - 1;
				}
			}
			start = 0;
			end = n - 1;
			while (start <= end) {
				mid = (start + end) / 2;
				if (A[mid] <= B) {
					if(A[mid] == B) {
						last = mid;
					}
					start = mid + 1;
				} else if (A[mid] > B) {
					end = mid - 1;
				} 
			}

		int[] ans = { first, last };
		return ans;
	}

}
