package com.scaler.ds.graph;

import java.util.ArrayList;

public class CheckBipartiteGraph {

	static int maxn = 100000;
	static int[] colored = new int[maxn];
	static ArrayList<ArrayList<Integer>> adjList;

	public static void main(String[] args) {
		int A = 2;
		int[][] B = new int[][] { { 2, 8 }, { 0, 8 }, { 2, 7 }, { 0, 5 }, { 4, 8 }, { 3, 7 }, { 1, 4 }, { 7, 9 },
				{ 0, 9 }, { 2, 3 }, { 5, 8 } };

		isBipartite(A, B);

	}

	public static int isBipartite(int A, int[][] B) {

		adjList = new ArrayList<ArrayList<Integer>>(maxn);
		for (int i = 0; i < maxn; i++) {
			colored[i] = -1;
			adjList.add(new ArrayList<Integer>());
		}

		for (int[] edge : B)
			adjList.get(edge[0]).add(edge[1]);

		if (dfs(0)) {
			return 1;
		}

		return 0;
	}

	private static boolean dfs(int start) {

		colored[start] = 0;

		for (int v : adjList.get(start)) {
			if (colored[v] == -1) {
				colored[v] = (1 ^ colored[start]);
			}
			if (!dfs(v)) {
				return false;
			} else if (colored[v] == colored[start]) {
				return false;
			}
		}

		return true;
	}

}
