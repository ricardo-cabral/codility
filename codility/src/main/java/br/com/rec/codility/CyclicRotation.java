package br.com.rec.codility;

import java.util.Arrays;

/**
 * 
 * @author Ricardo Cabral
 * 
 * you can rotate an array based on the k number. e.g. array = {3,8,9,7,6} and k=3 -> array={9,7,6,3,8}
 *
 */
public class CyclicRotation {

	public static int[] solution(int[] A, int k) {
		int size = A.length;
		int[] tmp = new int[size];

		if (A.length == 0) {
			return tmp;
		}

		int newPosition = k % size;
		int rest = newPosition - 1;
		int currentPosition = newPosition;

		int i = 0;
		while (i < size && currentPosition < size) {
			tmp[currentPosition] = A[i];
			i++;
			currentPosition++;
		}

		if (rest >= 0) {
			int newSize = size - newPosition;
			int count = 0;
			while (count <= rest) {

				tmp[count] = A[newSize];
				count++;
				;
				newSize++;
			}
		}

		return tmp;
	}

	public static void main(String[] args) {

		// int[] array = new int[] {3,8,9,7,6};
		int[] array = new int[] {};
		int k = 3;

		System.out.println(Arrays.toString(solution(array, k)));

	}
}
