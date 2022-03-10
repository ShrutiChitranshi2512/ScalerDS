package com.scaler.ds.binary_search;

import java.util.ArrayList;
import java.util.Arrays;

public class SingleElementInSortedArray {

	public static void main(String[] args) {
				}
	
	 public int solve(int[] A) {
		 
		 int n = A.length;
			int start = 0, end = n - 1;
			while (start <= end) {

				int mid = (start + end) / 2;
				if (start == end && start == mid) {
					return A[mid];
				} else if ((mid - 1 > -1 && A[mid] != A[mid - 1]) && (mid + 1 != n && A[mid] != A[mid + 1])) {
					return A[mid];
				} else if (mid - 1 > -1 && A[mid] == A[mid - 1]) {
					if (!isPairIndexVoilated(mid - 1, mid)) {
						start = mid + 1;
					} else {
						end = mid - 1;
					}
				} else if (mid + 1 != n && A[mid] == A[mid + 1]) {
					if (!isPairIndexVoilated(mid, mid + 1)) {
						start = mid + 1;
					} else {
						end = mid - 1;
					}
				} else if (mid == 0 && isPairIndexVoilated(mid + 1, mid + 2)) {
					return A[mid];
				} else if (mid + 1 == n && isPairIndexVoilated(mid - 2, mid - 1)) {
					return A[mid];
				}
			}

			return -1;
		}

		public static boolean isPairIndexVoilated(int a, int b) {

			boolean flag = true;

			if ((a + 1) % 2 != 0 && ((b + 1) % 2 == 0)) {

				flag = false;
			}

			return flag;

		}

		public static boolean isIndexVoilated(int a, String direction) {

			boolean flag = true;

			if ((direction == "Left" && (a + 1) % 2 != 0) || (direction == "Right" && (a + 1) % 2 == 0)) {

				flag = false;
			}

			return flag;

		}

	}

