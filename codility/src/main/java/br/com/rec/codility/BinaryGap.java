package br.com.rec.codility;

/**
 * refers to @see br.com.rec.codility.BitWork to understand better the
 * conversion
 * 
 * @author Ricardo
 *
 */
public class BinaryGap {
	/*
	 * A binary gap within a positive integer N is any maximal sequence of
	 * consecutive zeros that is surrounded by ones at both ends in the binary
	 * representation of N.
	 * 
	 * For example, number 9 has binary representation 1001 and contains a
	 * binary gap of length 2. 
	 * The number 529 has binary representation 1000010001 and contains two binary gaps: 
	 * one of length 4 and one of length 3. 
	 * The number 20 has binary representation 10100 and contains one
	 * binary gap of length 1. 
	 * 
	 * The number 15 has binary representation 1111 and has no binary gaps.
	 * 
	 * Write a function:
	 * 
	 * class Solution { public int solution(int N); } that, given a positive
	 * integer N, returns the length of its longest binary gap. The function
	 * should return 0 if N doesn't contain a binary gap.
	 * 
	 * For example, given N = 1041 the function should return 5, because N has
	 * binary representation 10000010001 and so its longest binary gap is of
	 * length 5.
	 * 
	 * Assume that:
	 * 
	 * N is an integer within the range [1..2,147,483,647]. Complexity:
	 * 
	 * expected worst-case time complexity is O(log(N)); expected worst-case
	 * space complexity is O(1).
	 * 
	 * 
	 * 1 - https://codility.com/demo/results/trainingEMC66P-NQH/
	 */
	private static final int BINARY_RADIX = 2;
	private static int MAX_VALUE = 2147483647;
	private static char[] digitsAllowed = new char[] { '0', '1' };

	public int solution(int n) {
		if (n < 0 || n > MAX_VALUE)
			return 0;
		
		int longestBinaryGap = 0;
		int countCurrentGap = 0;

		String result = this.convertIntToBinary(n);
		
		for (char bit : result.toCharArray()) {
			if (bit == '0'){
				countCurrentGap++;
				continue;
			}
			
			if(bit == '1'){
				if(countCurrentGap > longestBinaryGap){
					longestBinaryGap = countCurrentGap;
				}
				countCurrentGap = 0;
			}
			
		}
		return longestBinaryGap;
	}

	public String convertIntToBinary(int value) {

		char buf[] = new char[33];
		int charPos = 32;

		while (value >= BINARY_RADIX) {
			buf[charPos--] = digitsAllowed[(value % BINARY_RADIX)];
			value = value / BINARY_RADIX;
		}
		
		buf[charPos] = digitsAllowed[value];
		
		return new String(buf, charPos, (33 - charPos));
	}
}
