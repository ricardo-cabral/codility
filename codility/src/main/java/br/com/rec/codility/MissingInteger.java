package br.com.rec.codility;

import java.util.Arrays;

public class MissingInteger {
/*	Write a function:

		int solution(int A[], int N);

		that, given a non-empty zero-indexed array A of N integers, returns the minimal positive integer that does not occur in A.

		For example, given:

		  A[0] = 1
		  A[1] = 3
		  A[2] = 6
		  A[3] = 4
		  A[4] = 1
		  A[5] = 2
		the function should return 5.

		Assume that:

		N is an integer within the range [1..100,000];
		each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
		Complexity:

		expected worst-case time complexity is O(N);
		expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
		Elements of input arrays can be modified.
*/
	
	public static void main(String[] args) {
		int[] arrays = new int[]{-10,3,4,6};
		MissingInteger m = new MissingInteger();
		System.out.println(m.solution(arrays));
		
		arrays = new int[]{1,3,6,4,1,2};
	}
	
	public int solution(int[] a) {
        // write your code in Java SE 8
		Arrays.sort(a);
		int lower = 1;
		for (int i : a) {
            if (i > -1 && i == lower) {
                    lower++;
            }
        }

        return lower;
	
	}

    
}
