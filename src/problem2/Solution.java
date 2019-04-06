package problem2;

import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args){
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		// t = number of testcases
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			// Dimension of maze
			int n = in.nextInt();
			// Path taken by opponent
			String p = in.next();
			// My path
			String path = new String();

			// Reverse the path of my opponent.
			for(char c: p.toCharArray()){
				if(c == 'E')
					path += 'S';
				else
					path += 'E';
			}

			/*
			// If the first and last move don't match we can just start with N-1 times the different move and than N-1 times the other move
			if(p.charAt(0) != p.charAt(p.length()-1)){
				if(p.charAt(0) == 'E')
					path = getXChars(n-1, 'S') + getXChars(n-1, 'E');
				else
					path = getXChars(n-1, 'E') + getXChars(n-1, 'S');
			}
			else{
				// If not we have to cross the other line at a point where they perform the not-starting move twice
				if(p.charAt(0) == 'E'){
					// Find the double E of the other path.
					int l = findDoubleChars(p, 'S');
					path = getXChars(l, 'S') + getXChars(n-1, 'E') + getXChars(n-l-1, 'S');
				}
				else{
					int l = findDoubleChars(p, 'E');
					path = getXChars(l, 'E') + getXChars(n-1, 'S') + getXChars(n-l-1, 'E');
				}
			}*/

			System.out.println("Case #" + i + ": " + path);
		}
	}

	public static String getXChars(int x, char c){
		String result = "";
		for(int i = 0; i < x; i++){
			result += c;
		}
		return result;
	}

	/**
	 * Returns how often the char occured before it was repeated
	 * @param in
	 * @param c
	 * @return
	 */
	public static int findDoubleChars(String in, char c){
		int chars = -1;
		int charsFound = 0;
		boolean prev = false;
		for(char i: in.toCharArray()){
			if(i == c){
				if(prev) {
					chars = charsFound;
					break;
				}
				else{
					prev = true;
				}
				charsFound++;
			}
		}
		return chars;
	}
}