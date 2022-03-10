package com.scaler.ds.two_pointer;

import java.util.ArrayList;
import java.util.Arrays;

public class SubarrayWithGivenSum {

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.addAll(Arrays.asList(5, 10, 20, 100, 105));
		solve(A, 110);
	}

	public static ArrayList<Integer> solve(ArrayList<Integer> A, int B) {

		int i = 0, j = i + 1;
		long sum = A.get(i);
		ArrayList<Integer> ans = new ArrayList<Integer>();

		while (i < A.size() && j < A.size()) {
			sum += A.get(j);
			if (sum < B) {
				j++;
			} else if (sum > B) {
				i++;
				j = i + 1;
				sum = A.get(i);
			} else {
				break;
			}

		}
		sum = 0;

		for (int k = i; k <= j && k< A.size(); k++) {
			sum += A.get(k);
			ans.add(A.get(k));
		}
		if (sum == B) {
			return ans;
		} else {
			ans = new ArrayList<>();
			ans.add(-1);
			return ans;
		}

	}

}
