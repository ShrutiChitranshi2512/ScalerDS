package com.scaler.ds.queue;

import java.util.LinkedList;
import java.util.Queue;

public class PerfectNumberEvenPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      solve(4);
	}

	  public static String solve(int A) {
	        Queue < String > q = new LinkedList < String > ();
	        if (A == 1)
	            return "11";
	        else if (A == 2)
	            return "22";
	        q.add("1");
	        q.add("2");
	        int cur = 2;
	        String ans = new String();
	        while (q.size() < A) {
	            StringBuilder sb = new StringBuilder(q.peek());
	            q.remove();
	            sb.append("1");
	            q.add(sb.toString());
	            cur++;
	            if (cur == A)
	                ans = sb.toString();
	            sb.deleteCharAt(sb.length() - 1);
	            sb.append("2");
	            cur++;
	            if (cur == A)
	                ans = sb.toString();
	            q.add(sb.toString());
	        }
	        StringBuilder sb = new StringBuilder(ans);
	        return ans + sb.reverse().toString();
	    }
}
