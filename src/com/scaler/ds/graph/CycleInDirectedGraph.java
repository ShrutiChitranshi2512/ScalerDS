package com.scaler.ds.graph;

import java.util.ArrayList;

public class CycleInDirectedGraph {

	static int maxn = 100009;
	static int[] visited = new int[maxn];
	static int[] path = new int[maxn];
	static ArrayList<ArrayList<Integer>> adjList;

	public static void main(String[] args) {
		int A = 2;
		int[][] B = new int[][] { { 1, 2 } };
		cycleInDirectedGraph(A, B);
	}

	private static int cycleInDirectedGraph(int A, int[][] B) {
		adjList = new ArrayList<ArrayList<Integer>>(maxn);
		for (int i = 0; i < maxn; i++) {
			visited[i] = 0;
			path[i] = 0;
			adjList.add(new ArrayList<Integer>());
		}
		for (int[] edge : B)
			adjList.get(edge[0]).add(edge[1]);
		if (isCyclePresentDFS(1))
			return 1;
		return 0;
	}

	private static boolean isCyclePresentDFS(int start) {

		visited[start] =1;
		path[start] =1;
		
		for(int v : adjList.get(start)) {
			if(path[v] == 1) 
				return true;
			if(path[v] == 0 && isCyclePresentDFS(v))
				return true;
		}
		path[start] =0;
		
		return false;
	}

}
