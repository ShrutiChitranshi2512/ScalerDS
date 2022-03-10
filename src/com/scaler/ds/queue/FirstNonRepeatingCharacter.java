package com.scaler.ds.queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingCharacter {

	public static void main(String[] args) {
		String ans =solve("iliilmbxyeukaymfoljtsonuyagzhpbjopclniiu");
		System.out.println(ans);

	}
	public static String solve(String A) {
		
		String res ="";
		Deque<Character> ans = new LinkedList<>();
		Deque<Character> dup = new LinkedList<>();
		
		for(int i=0; i<A.length(); i++) {
			if(ans.isEmpty()) {
				ans.add(A.charAt(i));
				res =res.concat(String.valueOf(A.charAt(i)));
			}
			else if(ans.peek() != A.charAt(i) && !dup.contains(ans.peekFirst())) {
				res =res.concat(String.valueOf(ans.peek()));
				if(!ans.contains(A.charAt(i))) {
				ans.add(A.charAt(i));
				}else {
				 dup.add(A.charAt(i));
				}
			}else {
				dup.add(ans.peekFirst());
				ans.pollFirst();
				if(!ans.isEmpty()) {
					while(dup.contains(ans.peekFirst())){
				      ans.pollFirst();
					}
					if(!ans.isEmpty()) {
					res =res.concat(String.valueOf(ans.peekFirst()));
					}else {
						res =res.concat("#");
					}
					
				}else {
				res =res.concat("#");	
				}
			}
			
		}
		
		return res;
    }

}
