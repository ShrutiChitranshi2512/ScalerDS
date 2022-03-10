package com.scaler.ds.binary_search;

import java.util.Arrays;
import java.util.List;

public class MinimumDifference {

	public static void main(String[] args) {
		int[][] C = { { 7, 3 }, { 2, 1 }, { 4, 9 } };

		// solve(3, 2, C);

	}

	public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {

		if (a.size() > b.size())
			return findMedianSortedArrays(b, a); // Make sure your first array is less than the second array.

		if (a.size() == 0 && b.size() == 0) {
			return 0;
		} else if (a.size() == 0) {
			if (b.size() % 2 == 0) {
				return (b.get(b.size() / 2 - 1) + b.get(b.size() / 2)) / 2.0;
			} else {
				return (b.get(b.size() / 2));
			}
		} else if (b.size() == 0) {
			if (a.size() % 2 == 0) {
				return (a.get(a.size() / 2 - 1) + a.get(a.size() / 2)) / 2.0;
			} else {
				return (a.get(a.size() / 2));
			}
		}
		int m = a.size(); // [-50, -21, -10]
		int n = b.size(); // [-50, -41, -40, -19, 5, 21, 28]
		int total = m + n;
		int low = 0;
		int high = m;
		int half = (m + n) / 2; // 10 / 2 => 5

		while (low <= high) {
			int midA = low + ((high - low) >> 1); // [-50]
			int midB = half - midA; // 5 - 1 = 4 =>[-50, -41, -40, -19, 5]
			if (midA < m && midB > 0 && b.get(midB - 1) > a.get(midA)) {
				low = midA + 1;
			} else if (midA > 0 && a.get(midA - 1) > b.get(midB)) {
				high = midA - 1;
			} else {
				double left, right;
				if (midA == 0) {
					left = b.get(midB - 1);
				} else if (midB == 0) {
					left = a.get(midA - 1);
				} else {
					left = Math.max(a.get(midA - 1), b.get(midB - 1));
				}

				if (midA == a.size()) {
					right = b.get(midB);
				} else if (midB == n) {
					right = a.get(midA);
				} else {
					right = Math.min(a.get(midA), b.get(midB));
				}

				if (total % 2 == 0) {
					return (left + right) / 2.0;
				} else {
					return right;
				}
			}
		}
		return half;
	}
}
