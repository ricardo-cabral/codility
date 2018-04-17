package br.com.rec.codility;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Ricardo Cabral
 *
 * return the values which has not a pair element. e.g. array{1,2,3,4,1,2,3} return 4;
 */
public class OddOccurrencesInArray {

	
	
	public static int solution(int[] A, int n) {

		Map<Integer, Integer> values= new HashMap<>();
		for (int value : A) {
			if(values.containsKey(value)) {
				values.remove(value);
			}else {
				values.put(value, 1);
			}
		}
		
		return values.keySet().iterator().next().intValue();
	}
	
	/*
	 * explanation:
	 * 
	 * whenever you use XOR the repeated number will be reseted to zero
	 * 
	 * A  B  A^B
	 * 0  0   0
	 * 0  1   1
	 * 1  0   1
	 * 1  1   0
	 * 
	 * example: array {1,2,3,4,1,2,3}
	 * 
	 * element= 0    00000000
	 * array= 1      00000001
	 *               --------
	 * 0^1 = 1       00000001
	 * 
	 * element= 1    00000001
	 * array= 2      00000010
	 *               --------
	 * 1^2=3         00000011
	 * 
	 * element= 3    00000011
	 * array= 3      00000011
	 *               --------
	 * 3^3=0         00000000
	 * 
	 * element= 0    00000000
	 * array= 4      00000100
	 *               --------
	 * 0^4=4         00000100	 
	 * 
	 * element= 4    00000100
	 * array= 1      00000001
	 *               --------
	 * 4^1=5         00000101
	 * 
	 * element= 5    00000101
	 * array= 2      00000010
	 *               --------
	 * 5^2=7         00000111
	 * 	 
	 * element= 7    00000111
	 * array= 3      00000011
	 *               --------
	 * 7^3=4         00000100	 
	 * 	 
	 */
	public static int solutionUsingXor(int[] A) {
		int element = 0;
		
		for(int i =0; i < A.length; i++) {
			element ^= A[i];
		}
		
		return element;
	}
	
	
	public static void main(String[] args) {
		int[] array = new int[] {1,2,3,4,1,2,3};
		System.out.println(solutionUsingXor(array));
	}
}
