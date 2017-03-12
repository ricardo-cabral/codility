package br.com.rec.codility;

/**
 * This class helps to understand how integer is converted to binary string 
 * 
 * @author Ricardo
 *
 */
public class BitWork {
	/**
	 * All possible chars for representing a number as a String
	 */
	final static char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g',
			'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

	public static void main(String[] args) {
		System.out.println(toString(5, 2));

	}

	public static String toString(int i, int radix) {
		//radix == 2
		if (radix < Character.MIN_RADIX || radix > Character.MAX_RADIX)
			radix = 10;

		/* Use the faster version */
		if (radix == 10) {
			return String.valueOf(i);
		}

		char buf[] = new char[33];
		boolean negative = (i < 0);
		int charPos = 32;

		if (!negative) {
			i = -i;
		}

		while (i <= -radix) {
			buf[charPos--] = digits[-(i % radix)];
			i = i / radix;
		}
		buf[charPos] = digits[-i];

		if (negative) {
			buf[--charPos] = '-';
		}

		return new String(buf, charPos, (33 - charPos));
	}

}