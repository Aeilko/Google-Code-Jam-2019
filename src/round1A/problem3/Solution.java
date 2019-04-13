package round1A.problem3;

import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		// t = number of testcases
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			int N = in.nextInt();

			ArrayList<String> words = new ArrayList<String>();
			for(int j = 0; j < N; j++){
				String word = in.next();
				// Reverse words, since we want to find the longest groups of words
				word = new StringBuilder(word).reverse().toString();
				words.add(word);
			}

			Collections.sort(words);

			int r = findLongestStrings(words, true);
			System.out.println("Case #" + i + ": " + r);
		}
	}

	public static int findLongestStrings(ArrayList<String> list, boolean first){
		int result = 0;

		// Quick shortcut
		if(list.size() < 2)
			return 0;
		else if(!first && list.size() == 2)
			return 2;

		// Check each character
		char lastChar = 'A';
		ArrayList<String> tmpList = new ArrayList<String>();
		int emptyWords = 0;
		for(int i = 0; i < list.size(); i++){
			String word = list.get(i);

			if(word.charAt(0) == lastChar){
				// Current first letter equals first letter of previous word, therefore we add this to the current word list.
				if(word.length() == 1)
					emptyWords++;
				else
					tmpList.add(word.substring(1));
			}
			else{
				// First letter does not match first letter of last word, check if we have enough words to calculate something.
				if((tmpList.size()+emptyWords) > 1){
					int r = findLongestStrings(tmpList, false);
					if(r <= ((tmpList.size()+emptyWords)-2))
						r += 2;

					result += r;
				}

				// Reset this letter
				emptyWords = 0;
				lastChar = word.charAt(0);
				tmpList = new ArrayList<String>();
				if(word.length() == 1)
					emptyWords++;
				else
					tmpList.add(word.substring(1));
			}
		}

		if((tmpList.size()+emptyWords) > 1){
			int r = findLongestStrings(tmpList, false);
			if (r <= ((tmpList.size() + emptyWords) - 2))
				r += 2;

			result += r;
		}
		return result;
	}
}