package com.scaler.ds.tries;

import java.util.HashMap;

public class TrieNode {
	HashMap<Character, TrieNode> child = new HashMap<Character, TrieNode>();
	int freq = 0;

}
