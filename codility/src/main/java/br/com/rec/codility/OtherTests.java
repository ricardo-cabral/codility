package br.com.rec.codility;

import java.util.Arrays;
import java.util.stream.Stream;

public class OtherTests {

	public static void main(String[] args) {
		int n = 1200015;
		System.out.println(Integer.toBinaryString(n));
		System.out.println(Integer.toBinaryString(n).replaceAll("0+$", ""));
		System.out.println(Arrays.toString(Integer.toBinaryString(n).replaceAll("0+$", "").split("1+")));
		Stream.of(Integer.toBinaryString(n).replaceAll("0+$", "").split("1+")).filter(a -> a != null).forEach(System.out::println);
		Stream.of(Integer.toBinaryString(n).replaceAll("0+$", "").split("1+")).filter(a -> a != null).map(String::length).forEach(System.out::println);
		System.out.println(Stream.of(Integer.toBinaryString(n).replaceAll("0+$", "").split("1+")).filter(a -> a != null).map(String::length).max(Integer::compare));
		
	}
}
