package org.ssglobal.training.codes.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.ssglobal.training.codes.LocatorService;
import org.ssglobal.training.codes.Point;
import org.ssglobal.training.codes.PointGeneration;

@ExtendWith(MockitoExtension.class)
public class TestPointGeneration {
	
	@Mock
	private LocatorService service;
	
	@InjectMocks
	private PointGeneration generate;
	
	@Test
	public void testCallPrivateMethodSunnyDay() {
		
		Point p1 = new Point(-10, -74);
		Point p2 = new Point(-120, -90);
		Point p3 = new Point(110, -100);
		Point p4 = new Point(110, -5);
		Point p5 = new Point(1, 1);
		Point p6 = new Point(10, 80);
		Point p7 = new Point(11, -50);
		
		given(service.generatePointWithinDistance(p1, 1)).willReturn(p1);
		given(service.generatePointWithinDistance(p1, 2)).willReturn(p2);
		given(service.generatePointWithinDistance(p1, 3)).willReturn(p3);
		given(service.generatePointWithinDistance(p1, 4)).willReturn(p4);
		given(service.generatePointWithinDistance(p1, 5)).willReturn(p5);
		given(service.generatePointWithinDistance(p1, 6)).willReturn(p6);
		given(service.generatePointWithinDistance(p1, 7)).willReturn(p7);
		
		Point actualResult1 = generate.callPrivateMethod(1);		
		Point actualResult2 = generate.callPrivateMethod(2);
		Point actualResult3 = generate.callPrivateMethod(3);
		Point actualResult4 = generate.callPrivateMethod(4);
		Point actualResult5 = generate.callPrivateMethod(5);
		Point actualResult6 = generate.callPrivateMethod(6);
		Point actualResult7 = generate.callPrivateMethod(7);
		
		assertEquals(p1, actualResult1);
		assertEquals(p2, actualResult2);
		assertEquals(p3, actualResult3);
		assertEquals(p4, actualResult4);
		assertEquals(p5, actualResult5);
		assertEquals(p6, actualResult6);
		assertEquals(p7, actualResult7);
	}

}
