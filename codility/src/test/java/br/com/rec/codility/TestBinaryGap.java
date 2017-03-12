package br.com.rec.codility;



import static org.junit.Assert.*;

import org.junit.Test;


public class TestBinaryGap {
	
	@Test
	public void testNegativeInteger(){
		BinaryGap binaryGap = new BinaryGap();
		
		assertEquals(binaryGap.solution(-1), 0);
	}
	
	@Test
	public void testLimitInteger(){
		BinaryGap binaryGap = new BinaryGap();
		assertEquals(binaryGap.solution(Integer.MAX_VALUE +1), 0);
	}
	
	@Test
	public void testBinaryConvertion(){
		BinaryGap gap = new BinaryGap();
		String result =  gap.convertIntToBinary(8);
		assertEquals(result.length(), 4);
	}
	
	@Test
	public void testPositiveInteger_9(){
		BinaryGap binaryGap = new BinaryGap();
		assertEquals(binaryGap.solution(9), 2);
	}
	
	@Test
	public void testPositiveInteger_529(){
		BinaryGap binaryGap = new BinaryGap();
		assertEquals(binaryGap.solution(529), 4);
	}
	
	@Test
	public void testPositiveInteger_20(){
		BinaryGap binaryGap = new BinaryGap();
		assertEquals(binaryGap.solution(20), 1);
	}
	
	@Test
	public void testPositiveInteger_15(){
		BinaryGap binaryGap = new BinaryGap();
		assertEquals(binaryGap.solution(15), 0);
	}
	
	@Test
	public void testPositiveInteger_1041(){
		BinaryGap binaryGap = new BinaryGap();
		assertEquals(binaryGap.solution(1041), 5);
	}
	
}
