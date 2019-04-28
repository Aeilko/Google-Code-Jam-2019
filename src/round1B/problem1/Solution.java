package round1B.problem1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		// t = number of testcases
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			int p = in.nextInt();
			int q = in.nextInt();

			// Create the grid
			short[] rows = new short[q+1];
			short[] cols = new short[q+1];

			for(int j = 0; j < p; j++){
				int x = in.nextInt();
				int y = in.nextInt();
				String d = in.next();

				if(d.equals("N")){
					for(int a = (y+1); a <= q; a++)
						rows[a]++;
				}
				else if(d.equals("S")){
					for(int a = (y-1); a >= 0; a--)
						rows[a]++;
				}
				else if(d.equals("E")){
					for(int a = (x+1); a <= q; a++)
						cols[a]++;
				}
				else if(d.equals("W")){
					for(int a = (x-1); a >= 0; a--)
						cols[a]++;
				}
			}


			int max = 0;
			int xCoord = -1;
			int yCoord = -1;
			for(int x = 0; x <= q; x++){
				for(int y = 0; y <= q; y++){
					if(rows[y]+cols[x] > max){
						max = rows[y]+cols[x];
						xCoord = x;
						yCoord = y;
					}
				}
			}

			System.out.println("Case #" + i + ": " + xCoord + " " + yCoord);
		}
	}
}