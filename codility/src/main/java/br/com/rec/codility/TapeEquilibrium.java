package br.com.rec.codility;

import java.util.Arrays;



public class TapeEquilibrium {

	/*
	 * A non-empty zero-indexed array A consisting of N integers is given. Array
	 * A represents numbers on a tape.
	 * 
	 * Any integer P, such that 0 < P < N, splits this tape into two non-empty
	 * parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].
	 * 
	 * The difference between the two parts is the value of: |(A[0] + A[1] + ...
	 * + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|
	 * 
	 * In other words, it is the absolute difference between the sum of the
	 * first part and the sum of the second part.
	 * 
	 * For example, consider array A such that:
	 * 
	 * A[0] = 3 A[1] = 1 A[2] = 2 A[3] = 4 A[4] = 3 We can split this tape in
	 * four places:
	 * 
	 * P = 1, difference = |3 − 10| = 7 P = 2, difference = |4 − 9| = 5 P = 3,
	 * difference = |6 − 7| = 1 P = 4, difference = |10 − 3| = 7 Write a
	 * function:
	 * 
	 * int solution(int A[], int N);
	 * 
	 * that, given a non-empty zero-indexed array A of N integers, returns the
	 * minimal difference that can be achieved.
	 * 
	 * For example, given:
	 * 
	 * A[0] = 3 A[1] = 1 A[2] = 2 A[3] = 4 A[4] = 3 the function should return
	 * 1, as explained above.
	 * 
	 * Assume that:
	 * 
	 * N is an integer within the range [2..100,000]; each element of array A is
	 * an integer within the range [−1,000..1,000]. Complexity:
	 * 
	 * expected worst-case time complexity is O(N); expected worst-case space
	 * complexity is O(N), beyond input storage (not counting the storage
	 * required for input arguments). Elements of input arrays can be modified.
	 * 
	 */

	public static void main(String[] args) {
		int[] array = new int[] { 3, 1, 2, 4, 3 };

		TapeEquilibrium t = new TapeEquilibrium();
		/*System.out.println(t.solution(array));
		
		array = new int[] { -1000,1000 };
		System.out.println(t.solution(array));
		
		array = new int[] { 50, 0, 20 };
		System.out.println(t.solution(array));*/
		
		
		/*array = new int[] { 3, 1, 2, 4, 3 };
		System.out.println(t.solution100Percent(array));*/
		
		array = new int[] { -1000,1000 };
		System.out.println(t.solution100Percent(array));
		
		/*array = new int[] { 50, 0, 20 };
		System.out.println(t.solution100Percent(array));
		
		array = new int[] { -3, -10, -20, -40, -6 };
		System.out.println(t.solution100Percent(array));
		
		/*array = new int[] { 3, 1, 2, 4, 3 };
		System.out.println(t.solution(array, array.length));*/
		
		array = new int[] { -1000,1000 };
		System.out.println(t.solution(array, array.length));
		
		/*array = new int[] { 50, 0, 20 };
		System.out.println(t.solution(array, array.length));
		
		array = new int[] { -3, -10, -20, -40, -6 };
		System.out.println(t.solution(array, array.length));*/
	}

	public int solution(int[] a) {

		if(a.length == 2){
			return Math.abs(a[0]-a[1]);
		}
		int lower = Integer.MAX_VALUE;

		int sumLeft = 0;
		int sumRight = 0;

		for (int value : a) {
			sumLeft = sumLeft + value;
		}

		for (int i = a.length - 1; i >= 0; i--) {
			sumRight = sumRight + a[i];
			sumLeft = sumLeft - a[i];
			int tmp;
			
			tmp = Math.abs(sumLeft - sumRight);
			
			if (tmp < lower) {
				lower = tmp;
			}
		}

		return lower;

	}
	
	public int solution100Percent(int[] A){
		int[] sumLeftArray = new int[A.length];
		int[] sumRightArray = new int[A.length];

		
		int leftSum = 0;
		for(int i=0; i < A.length; i++){
			leftSum = leftSum + A[i];
			sumLeftArray[i] = leftSum;
		}
		/*for (int i = 0; i < sumLeftArray.length; i++) {
			System.out.println("Somas: " + sumLeftArray[i]);
		}*/

		//System.out.println("leftSum: " + leftSum);
		//System.out.println("sumLeftArray: " + Arrays.toString(sumLeftArray));
		for (int i = 0; i < sumLeftArray.length; i++) {
			sumRightArray[i] = leftSum - sumLeftArray[i];
		}
		
		//System.out.println("sumRightArray: " + Arrays.toString(sumRightArray));
		/*for (int i = 0; i < sumRightArray.length; i++) {
			System.out.println("Somas Right: " + sumRightArray[i]);
		}*/
		
		int lower = Integer.MAX_VALUE;
		for(int i=0; i < A.length; i++){
		
			//System.out.println(sumLeftArray[i] - sumRightArray[i]);
			int tmp = sumLeftArray[i] - sumRightArray[i];
			if(tmp < 0){
				//tmp =Math.abs(tmp);
				tmp = ~tmp + 1;
			}
//			System.out.println("tmp: " + tmp);
			if(tmp < lower){
				lower = tmp;
			}
		}
		/*for(int i=0; i < A.length; i++){
			
			int tmp = Math.abs(A[i] - sumLeftArray[i]);
			if(tmp < lower){
				lower = tmp;
			}
		}*/
		
		return lower;
	}
	
	int solution(int A[], int N) {
	  int sumForward=0;
	  int i, positiveVal, minDiff;
	  int tamanho = A.length-1;
	  int[] sumToP = new int[A.length], sumFromP = new int[A.length], diff = new int[A.length];
	  
	    
	     //soma todos os elementos menos o ultimo ?
	    for ( i =0 ; i <= tamanho ; i++) {
	        sumForward = sumForward + A[i];
	        sumToP[i] = sumForward;
	    }

	    //System.out.println("Array A: " + Arrays.toString(A));
	    //System.out.println("sumForward: " + sumForward);
	    //System.out.println("sumToP: " + Arrays.toString(sumToP));
	   sumForward = 0;    
	   for ( i =0 ; i <= tamanho ; i++) {
		    
	        //sumFromP[i] = sumToP[tamanho-1] + A[tamanho] - sumToP[i];
		   sumFromP[i] = sumToP[tamanho] - sumToP[i];
		   System.out.println(sumToP[tamanho] +   " - " + sumToP[i] + " = " + sumFromP[i]);
	        //System.out.println(sumToP[tamanho-1] + " + " +  A[tamanho]+ " - " + sumToP[i] + " = " + sumFromP[i]);
	    }
	    
	  // System.out.println("sumFromP: " + Arrays.toString(sumFromP));
	    for ( i =0 ; i <= tamanho ; i++) {
	        diff[i] = sumToP[i] - sumFromP[i];
	        
	        if (diff[i] < 0) {
	            positiveVal = ~diff[i] + 1;
	            diff [i] = positiveVal;
	        }
	    //    System.out.println(diff[i]);
	       
	    }
	   // System.out.println("diff: " + Arrays.toString(diff));
	    minDiff = diff[0]; 
	     for ( i =1 ; i <= tamanho ; i++) {
	    	 
	        if (diff[i] <  minDiff) {
	            minDiff = diff[i] ;
	          }
	    }
	    
	    return minDiff;
	    
	        
	}
	
	

}
