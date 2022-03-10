package com.scaler.ds.graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottenOranges {

	static Queue<Pair> q = new ArrayDeque<Pair>();
	static int[] x = { -1, 0, 1, 0 };
	static int[] y = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		int[][] A = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		solve(A);

	}

	public static int solve(int[][] A) {

		int n = A.length, m = A[0].length;
		int[][] time = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (A[i][j] == 2) {
					time[i][j] = 0;
					q.offer(new Pair(i, j));
				} else {
					time[i][j] = -1;
				}
			}
		}
		while (!q.isEmpty()) {
			Pair pair = q.poll();
			int oldx = pair.x;
			int oldy = pair.y;
			for (int i = 0; i < x.length; i++) {
				int newx = oldx + x[i];
				int newy = oldy + y[i];
				if (newx >= 0 && newx < A.length && newy >= 0 && newy < A[0].length && time[newx][newy] == -1
						&& A[newx][newy] == 1) {
					q.offer(new Pair(newx, newy));
					time[newx][newy] = time[oldx][oldy] + 1;
				}

			}

		}

		int max = -1;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				if (time[i][j] == -1 && A[i][j] == 1) {
					return -1;
				}
				max = Integer.max(max, time[i][j]);
			}
		}
		return max;

	}

}

class Pair {
	int x, y;

	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
