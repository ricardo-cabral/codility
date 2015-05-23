package br.com.rec.codility;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PermCheck {
	/*A non-empty zero-indexed array A consisting of N integers is given.

	A permutation is a sequence containing each element from 1 to N once, and only once.

	For example, array A such that:

	    A[0] = 4
	    A[1] = 1
	    A[2] = 3
	    A[3] = 2
	is a permutation, but array A such that:

	    A[0] = 4
	    A[1] = 1
	    A[2] = 3
	is not a permutation, because value 2 is missing.

	The goal is to check whether array A is a permutation.

	Write a function:

	int solution(int A[], int N);

	that, given a zero-indexed array A, returns 1 if array A is a permutation and 0 if it is not.

	For example, given array A such that:

	    A[0] = 4
	    A[1] = 1
	    A[2] = 3
	    A[3] = 2
	the function should return 1.

	Given array A such that:

	    A[0] = 4
	    A[1] = 1
	    A[2] = 3
	the function should return 0.

	Assume that:

	N is an integer within the range [1..100,000];
	each element of array A is an integer within the range [1..1,000,000,000].
	Complexity:

	expected worst-case time complexity is O(N);
	expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
	Elements of input arrays can be modified.

*/
	
	public static void main(String[] args) {
		PermCheck p = new PermCheck();
		int[] arrayPermute = new int[]{4,1,3,2};
		
		//System.out.println(p.solution(arrayPermute));
		System.out.println(p.solutionB(arrayPermute));
		
		int[] arrayNotPermute = new int[]{4,1,3};
		
		//System.out.println(p.solution(arrayNotPermute));
		System.out.println(p.solutionB(arrayNotPermute));
		
		int[] a2 = new int[]{1,2};
		
		System.out.println(p.solution(a2));
		
		int[] a3 = new int[]{1,1000000000};
		
		System.out.println(p.solution(a3));
	}

	/*
	 * my 100%
	 */
	public int solution(int[] a) {
        // write your code in Java SE 8
		if(a.length < 1 || a.length > 100000){
			return 0;
		}
		if(a.length == 1 ){
			return a[0] == 1 ? 1: 0;
		}
		//Arrays.sort(a);
		
		HashSet<Integer> countMap = new HashSet<>();
		
		for (int i = 0; i < a.length; i++) {
			if(a[i] > a.length){
				return 0;
			}
			if(countMap.contains(a[i])){
				return 0;
			}else{
				countMap.add(a[i]);
			}
		}
		
		return 1;
    }
	
	/*
	 * 100%
	 */
	public int solutionB(int[] A) {
        int[] counter = new int [A.length];
 
        for(int i= 0; i< A.length; i++){
            if (A[i] < 1 || A[i] > A.length) {
                // Out of range
                return 0;
            }
            else if(counter[A[i]-1] == 1) {
                // met before
                return 0;
            }
            else {
                // first time meet
                counter[A[i]-1] = 1;
            }
        }
        return 1;
	}
}
