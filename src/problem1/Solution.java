package problem1;

import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args){
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		// t = number of testcases
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();

			int x = find4s(n);

			int y = n-x;

			System.out.println("Case #" + i + ": " + x + " " + y);
		}
	}

	/**
	 * Returns a number with a 1 on the same place as a 4 (245764647 => 10001010)
	 * @param n
	 * @return
	 */
	public static int find4s(int n){
		int result = 0;

		int i = 0;
		while(n > 0){
			if(n % 10 == 4){
				result += Math.pow(10, i);
			}
			i++;
			n = n/10;
		}

		return result;
	}
}