package com.scaler.ds.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class PathInDirectedGraph {
	static int maxn = 100009;
	static int[] visited = new int[maxn];
	static ArrayList<ArrayList<Integer>> adjList;

	public static void main(String[] args) {
		int A = 5;
		int[][] B = new int[][] { { 1, 2 }, { 4, 1 }, { 2, 4 }, { 3, 4 }, { 5, 2 }, { 1, 3 } };
		pathInDirectedGraph(A, B);
	}

	public static int pathInDirectedGraph(int A, int[][] B) {
		adjList = new ArrayList<ArrayList<Integer>>(maxn);
		for (int i = 0; i < maxn; i++) {
			visited[i] = 0;
			adjList.add(new ArrayList<Integer>());
		}

		for (int[] edge : B)
			adjList.get(edge[0]).add(edge[1]);
		if (isReachableBFS(1, A) == true)
			return 1;
		if (isReachableDFS(1, A))
			return 1;
		return 0;

	}

// using BFS
	private static boolean isReachableBFS(int start, int a) {

		if (start == a)
			return true;

		Queue<Integer> q = new ArrayDeque<>();
		q.offer(start);
		visited[start] = 1;
		while (q.size() > 0) {
			start = q.poll();
			for (int v : adjList.get(start)) {
				if (v == a)
					return true;
				if (visited[v] == 0) {
					visited[v] = 1;
					q.offer(v);
				}
			}
		}
		return false;
	}
	
	//Using DFS

	private static boolean isReachableDFS(int start, int a) {

		visited[start] = 1;
		if (start == a)
			return true;
		for (int v : adjList.get(start) ){
			if (visited[v] == 0) {				
				if (isReachableDFS(v, a))
					return true;
			}
		}

		return false;
	}

}
