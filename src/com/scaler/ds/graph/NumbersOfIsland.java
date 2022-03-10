package com.scaler.ds.graph;

public class NumbersOfIsland {
	static int[] x = { -1, 0, 1, 0, -1, 1, -1, 1 };
	static int[] y = { 0, -1, 0, 1, -1, 1, 1, -1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solve(int[][] A) {
		int count = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				if (A[i][j] == 1) {
					count++;
					A[i][j] = -1;
					DFS(A, i, j);
				}
			}
		}

		return count;
	}

	public static void DFS(int[][] A, int i, int j) {
		for (int k = 0; k < x.length; k++) {
			int newI = i + x[k];
			int newJ = j + y[k];
			if (newI >= 0 && newI < A.length && newJ >= 0 && newJ < A[0].length) {
				if (A[newI][newJ] == 1) {
					A[newI][newJ] = -1;
					DFS(A, newI, newJ);
				}
			}
		}
	}

}
