package com.scaler.ds.segment_trees;

import java.util.ArrayList;

public class RangeMinimumQuery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	ArrayList<Integer> list = new ArrayList<>();

	public int[] solve(int[] A, int[][] B) {
		int[] tree = new int[A.length * 4];
		buildSegmentTree(tree, A, 0, 0, A.length - 1);
		for (int i = 0; i < B.length; i++) {
			int x = B[i][0];
			int y = B[i][1] - 1;
			int z = B[i][2];
			if (x == 0) {
				update(tree, 0, 0, A.length - 1, y, z);
			} else {
				z--;
				list.add(getMin(tree, 0, 0, A.length - 1, y, z));
			}
		}
		int[] arr = new int[list.size()];
        int k=0;
        for(Integer x : list)
            arr[k++]=x;
        return arr;
	}

	public static void buildSegmentTree(int[] tree, int[] A, int idx, int s, int e) {
		if (s == e) {
			tree[idx] = A[s];
		} else {
			int mid = (s + e) / 2;
			int l = idx * 2 + 1;
			int r = idx * 2 + 2;
			buildSegmentTree(tree, A, l, s, mid);
			buildSegmentTree(tree, A, r, mid + 1, e);
			tree[idx] = Math.min(tree[l], tree[r]);
		}

	}

	public static void update(int[] tree, int idx, int s, int e, int index, int val) {
		if (s == e) {
			tree[idx] = val;
			return;
		}
		int mid = (s + e) / 2;
		int l = idx * 2 + 1;
		int r = idx * 2 + 2;
		int lc = tree[l], rc = tree[r];
		if (index <= mid) {
			update(tree, l, s, mid, index, val);
			lc = tree[l];
		} else {
			update(tree, r, mid + 1, e, index, val);
			rc = tree[r];
		}
		tree[idx] = Math.min(lc, rc);
	}

	public static int getMin(int[] tree, int idx, int s, int e, int l, int r) {
		if (l <= s && r >= e)
			return tree[idx];
		if (l > e || r < s)
			return Integer.MAX_VALUE;
		int mid = (s + e) / 2;
		int lc = 2 * idx + 1, rc = lc + 1;
		return Math.min(getMin(tree, lc, s, mid, l, r), getMin(tree, rc, mid + 1, e, l, r));
	}

}
