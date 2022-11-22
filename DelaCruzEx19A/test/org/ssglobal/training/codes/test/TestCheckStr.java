package org.ssglobal.training.codes.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.ssglobal.training.codes.ChekcStr;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static  org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class TestCheckStr {
	
	@Mock
	private ChekcStr check;
	
	@Test
	public void testConvert1() {
		
		given(check.convert("")).willReturn(String.valueOf(0));
	
		int expectValue = 0;
		
		assertNotEquals(expectValue, check.convert(""));
	
	
	}
	
	@Test
	public void testConvert2() {
		
		given(check.convert(null)).willReturn(String.valueOf(0));
		
		assertNotEquals(true, check.convert(null));
		
	}
	
	@Test
	public void testConvert3() {
		
		given(check.convert("\n")).willReturn(String.valueOf(0));
		
		assertNotEquals(true, check.convert("\n"));
		
	}
	
	@Test
	public void testConvert4() {
		
		given(check.convert("Good Morning")).willReturn(String.valueOf(0));
	
		int expectValue = 0;
		
		assertNotEquals(expectValue, check.convert("Good Morning"));
	
	}
	
	@Test
	public void testConvert5() {
		
		given(check.convert("1234xml")).willReturn(String.valueOf(0));
	
		assertNotEquals(true, check.convert("1234xml"));
	
	}
	
	
}
