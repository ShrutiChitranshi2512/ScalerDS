package com.scaler.ds.tries;

import java.util.ArrayList;
import java.util.Arrays;

public class SpellingChecker {

	public static void main(String[] args) {
		ArrayList<String> A= new ArrayList<String>();
		A.addAll(Arrays.asList("hat", "cat", "rat"));
		ArrayList<String> B= new ArrayList<String>();
		B.addAll(Arrays.asList("cat", "ball"));
		solve(A,B);
		

	}
	
	 public static ArrayList<Integer> solve(ArrayList<String> A, ArrayList<String> B) {
		 TrieNode root = new TrieNode();
		 for(String s : A) {
			 insert(root, s);
		 }
		 
		 for(String s : B) {
			 checkIfContains(root, s);
		 }
		 
		return null;
	    }

	private static void checkIfContains(TrieNode root, String word) {
		TrieNode current = root;
		for(char c : word.toCharArray()) {
			if(current.child.containsKey(c)) {
					
			}
		}
		
	}

	private static void insert(TrieNode root, String word) {
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

}
