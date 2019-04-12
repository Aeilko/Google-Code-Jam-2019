package round0.problem3;

import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args){
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		// t = number of testcases
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			int l = in.nextInt();
			int[] cipher = new int[l];
			for(int j = 0; j < l; j++){
				cipher[j] = in.nextInt();
			}

			// Find first non-repeating number
			int index = -1;
			int prev = cipher[0];
			for(int j = 1; j < cipher.length; j++){
				if(prev != cipher[j]){
					index = j-1;
					break;
				}
				else
					prev = cipher[j];
			}

			boolean[] foundPrimes = new boolean[n+1];

			// Find primes factorization of this number.
			List<Integer> p = primeFactors(cipher[index]);
			foundPrimes[p.get(0)] = true;
			foundPrimes[p.get(1)] = true;

			// Determine which was the first prime
			int prevPrime, firstPrime;
			if(cipher[index+1] % p.get(0) == 0) {
				prevPrime = p.get(0);
				if(index%2 == 0)
					// Uneven number in list
					firstPrime = p.get(1);
				else
					firstPrime = p.get(0);
			}
			else {
				prevPrime = p.get(1);
				if(index%2 == 0)
					firstPrime = p.get(0);
				else
					firstPrime = p.get(1);
			}

			// Loop over the rest of the numbers to find the new primes
			for(int j = index+1; j < cipher.length; j++){
				int np = cipher[j]/prevPrime;
				foundPrimes[np] = true;
				prevPrime = np;
			}

			// Should have found 26 primes by now which are used. Now we should sort them so we can translate numbers to letters.
			HashMap<Integer, Character> primeToChar = new HashMap<Integer, Character>();
			for(int j = 0; j < foundPrimes.length; j++){
				if(foundPrimes[j]){
					char c = (char) (primeToChar.size()+65);
					primeToChar.put(j, c);
				}
			}
			// Now we can decrypt the ciphertext
			String plaintext = "" + primeToChar.get(firstPrime);
			prevPrime = firstPrime;
			for(int prime: cipher){
				int cp = prime/prevPrime;

				plaintext += primeToChar.get(prime/prevPrime);
				prevPrime = cp;
			}
			System.out.println("Case #" + i + ": " + plaintext);
		}
	}

	// Borrowed from https://www.vogella.com/tutorials/JavaAlgorithmsPrimeFactorization/article.html
	public static List<Integer> primeFactors(int numbers) {
		int n = numbers;
		List<Integer> factors = new ArrayList<Integer>();
		for (int i = 2; i <= n / i; i++) {
			while (n % i == 0) {
				factors.add(i);
				n /= i;
			}
		}
		if (n > 1) {
			factors.add(n);
		}
		return factors;
	}
}