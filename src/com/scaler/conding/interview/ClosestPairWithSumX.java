package com.scaler.conding.interview;

import java.util.ArrayList;
import java.util.Arrays;

public class ClosestPairWithSumX {

	public static void main(String[] args) {

		ArrayList<Integer> A = new ArrayList<>();
		A.addAll(Arrays.asList(-6, 28, 29, 30, 57));// -6,-3, -2, 28, 29, 30, 57
		ArrayList<Integer> ans = closestPairWithSumX(A, 54);
		ans.forEach(System.out::print);

	}

	private static ArrayList<Integer> closestPairWithSumX(ArrayList<Integer> A, int X) {
		int n = A.size();
		int i = 0, j = n - 1, firstIndx = -1, secndIndx = -1;
		int diff = Integer.MAX_VALUE;

		while (i < j) {

			int sum = A.get(i) + A.get(j);
			if (Math.abs(X - sum) < diff) {
				diff = Math.abs(X - sum);
				firstIndx = i;
				secndIndx = j;
				if (i + 1 != n && sum < X) {
					i++;
				} else if (j - 1 > -1 && sum > X) {
					j--;
				} else {
					break;
				}
			} else if (i + 1 != n && sum < X) {
				i++;
			} else if (j - 1 > -1 && sum > X) {
				j--;
			}

		}
		ArrayList<Integer> ans = new ArrayList<Integer>();
		ans.addAll(Arrays.asList(A.get(firstIndx), A.get(secndIndx)));
		return ans;

	}

}
