package com.scaler.ds.tries;

import java.util.ArrayList;

public class ShortestUniquePrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static String[] prefix(String[] A) {
		TrieNode root = new TrieNode();
		ArrayList<String> list = new ArrayList<String>();
		for (String s : A) {
			insert(root, s);
		}
		for (String s : A) {
			shortestPath(root, "", list, s);
		}
		return list.toArray(new String[0]);
	}

	

	public static void insert(TrieNode root, String word) {
		TrieNode current = root;
		for (char c : word.toCharArray()) {
			// create a new node if it doesnt exist
			current.child.putIfAbsent(c, new TrieNode());
			// increment the freq of that Character
			current.child.get(c).freq++;
			// go to the next node
			current = current.child.get(c);
		}
	}

	public static void shortestPath(TrieNode root, String word_so_far, ArrayList<String> list, String s) {
		if (root == null)
			return;
		if (root.freq == 1) {
			list.add(word_so_far);
			return;
		}
		char c = s.charAt(word_so_far.length());
		shortestPath(root.child.get(c), word_so_far + s.charAt(word_so_far.length()), list, s);
	}
}
