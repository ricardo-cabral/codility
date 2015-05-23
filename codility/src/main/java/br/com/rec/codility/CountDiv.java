package br.com.rec.codility;

public class CountDiv {

	/*
	 * Write a function:
	 * 
	 * class Solution { public int solution(int A, int B, int K); }
	 * 
	 * that, given three integers A, B and K, returns the number of integers
	 * within the range [A..B] that are divisible by K, i.e.:
	 * 
	 * { i : A ≤ i ≤ B, i mod K = 0 }
	 * 
	 * For example, for A = 6, B = 11 and K = 2, your function should return 3,
	 * because there are three numbers divisible by 2 within the range [6..11],
	 * namely 6, 8 and 10.
	 * 
	 * Assume that:
	 * 
	 * A and B are integers within the range [0..2,000,000,000]; K is an integer
	 * within the range [1..2,000,000,000]; A ≤ B. Complexity:
	 * 
	 * expected worst-case time complexity is O(1); expected worst-case space
	 * complexity is O(1).
	 */

	public static void main(String[] args) {
		int a = 6;
		int b = 11;
		int k = 2;
		CountDiv c = new CountDiv();


		System.out.println((b-a+1)/k);
		System.out.println(c.solution(a, b, k));
		//A = 11, B = 345, K = 17 =
		
		//A = 101, B = 123M+, K = 10K = 12345
		System.out.println(c.solution(101, 123000000, 10000));
		
		//System.out.println(c.solution2(100, 123000000, 2));
		//System.out.println(c.solution(100, 123000000, 2));
		
		
	}

	public long solution(long a, long b, long k) {
	
			//return 1+(b-a)/k;
		if(a%k == 0)
			return (b-a) / k+1;
		else
			return (b - (a-a%k)) /k;
		
		
	}

	//solution O(B-A) - 50%
	public int solution2(int a, int b, int k) {

		int count = 0;
		for (int i = a; i <= b; i++) {
			if (i % k == 0)
				count++;
		}
		return count;
	}

	

}
