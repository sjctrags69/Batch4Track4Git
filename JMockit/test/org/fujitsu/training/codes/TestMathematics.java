package org.fujitsu.training.codes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Tested;
import mockit.integration.junit5.JMockitExtension;

@ExtendWith(JMockitExtension.class)
public class TestMathematics {
	
	@Tested
	private Mathematics math;
	
	@Mocked
	private Mathematics math2;
	
	
	
	@Test
	public void testSum01() {
		
		new MockUp<Mathematics>() {
			
			@Mock
			public int add(int x, int y) {
				return x + y - 100;
			}
		};
		
		int result = math.add(10, 10);
		//System.out.println(result);
		
		Assertions.assertEquals(20, result);
		
	}
	
	@Test
	public void testSum02() {
		int result = math.add(10, 10);
		Assertions.assertEquals(20, result);
	}
	
	@Test
	public void testSum03() {
		
		new MockUp<Mathematics>() {
			
			@Mock
			public void $init(int x) {
				System.out.println("Welcome to Mathematics..." + x);
			}
		};
		
		Mathematics mathLocal = new Mathematics(10);
		
	}
	
	@ParameterizedTest
	@ValueSource(ints = {10, 0, 60, 50})
	public void testDiv01(int y) {
		
		new Expectations() {
			
			{
				math2.div(anyInt, y);
				if (y == 0) {
					result = 0;
				}
				else {
					result = y;
				}
				
			}
			
			
		};
		
        System.out.println(math2.div(10, y));    
        //System.out.println(math2.div(5, y));     
		
	}
	
	
	
	@Test
	public void testDisplay01() {
		
		new Expectations() {
			
			{
				Mathematics.display();
				System.out.println(100);
			}
			
		};
		
		Mathematics.display();
	}
	
	

}





