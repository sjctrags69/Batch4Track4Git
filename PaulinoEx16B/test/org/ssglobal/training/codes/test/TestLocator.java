package org.ssglobal.training.codes.test;

import static org.mockito.BDDMockito.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
	

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.ssglobal.training.codes.Locator;
import org.ssglobal.training.codes.LocatorService;
import org.ssglobal.training.codes.Point;

@ExtendWith(MockitoExtension.class)
public class TestLocator {
	
	@Mock
	private LocatorService service = new LocatorService();
	
	@InjectMocks
	private Locator loc = new Locator(service);
	
	@Test
	public void testLocateSunnyDay() {
		
		Point p1 = new Point(-100, 100);
		Point p2 = new Point(20, 90);
		Point p3 = new Point(110, -100);
		Point p4 = new Point(10, -5);
		Point p5 = new Point(0, 0);
		Point p6 = new Point(-90, 90);
		Point p7 = new Point(-201, -100);
					
		given(service.geoLocate(p1)).willReturn(p1);
		given(service.geoLocate(p2)).willReturn(p2);
		given(service.geoLocate(p3)).willReturn(p3);
		given(service.geoLocate(p4)).willReturn(p4);
		given(service.geoLocate(p5)).willReturn(p5);
		given(service.geoLocate(p6)).willReturn(p6);
		given(service.geoLocate(p7)).willReturn(p7);
	
		Point expectedPoint1 = p1;
		Point actualPoint1 = loc.locate(-100, 100);
		
		Point expectedPoint2 = p2;
		Point actualPoint2 = loc.locate(20, 90);
		
		Point expectedPoint3 = p3;
		Point actualPoint3 = loc.locate(110, -100);
		
		Point expectedPoint4 = p4;
		Point actualPoint4 = loc.locate(10, -5);
		
		Point expectedPoint5 = p5;
		Point actualPoint5 = loc.locate(0, 0);
		
		Point expectedPoint6 = p6;
		Point actualPoint6 = loc.locate(-90, 90);
		
		Point expectedPoint7 = p7;
		Point actualPoint7 = loc.locate(-201, -100);
		
		assertEquals(expectedPoint1, actualPoint1);
		assertEquals(expectedPoint2, actualPoint2);
		assertEquals(expectedPoint3, actualPoint3);
		assertEquals(expectedPoint4, actualPoint4);
		assertEquals(expectedPoint5, actualPoint5);
		assertEquals(expectedPoint6, actualPoint6);
		assertEquals(expectedPoint7, actualPoint7);
		
	}
	

}
