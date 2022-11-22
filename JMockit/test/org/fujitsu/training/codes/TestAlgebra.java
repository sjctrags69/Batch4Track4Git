package org.fujitsu.training.codes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Mocked;
import mockit.Verifications;
import mockit.integration.junit5.JMockitExtension;

@ExtendWith(JMockitExtension.class)
public class TestAlgebra {
	
	@Injectable
	private Algebra algebra;
	
	
	@Mocked
	private Mathematics math;
	
	@BeforeEach
	public void startup() {
		Mathematics localMath = new Mathematics();
		algebra = new Algebra(localMath);
	}
	
	@Test
	public void testGetExpression01() {
		
		
		new Expectations() {
			
			{
				math.div(100, 0);
				result = 60;
			}
			
		};
		
		
		
		int result = algebra.getExpression(100, 0);
		System.out.println(result);
		Assertions.assertEquals(2120, result);
		
		
		new Verifications() {
			
			{
				math.div(100, 0);
			    maxTimes = 2;
			}
		};
		
	}
	
	@AfterEach
	public void teardown() {
		algebra = null;
	}

}
