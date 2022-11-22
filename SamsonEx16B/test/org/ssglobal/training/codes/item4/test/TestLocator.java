package org.ssglobal.training.codes.item4.test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.ssglobal.training.codes.item4.Locator;
import org.ssglobal.training.codes.item4.LocatorService;
import org.ssglobal.training.codes.item4.Point;

@ExtendWith(MockitoExtension.class)
public class TestLocator {
	
	@Mock
	private LocatorService service;
	
	@InjectMocks 
	private Locator locator;
	
	private static Stream<Point> inputLocations(){
		Point p1 = new Point(-101, 100);
		Point p2 = new Point(20, 90);
		Point p3 = new Point(110, -100);
		Point p4 = new Point(10, -5);
		Point p5 = new Point(0, 0);
		Point p6 = new Point(-90, 90);
		Point p7 = new Point(-201, -100);
		return Stream.of(p1, p2, p3, p4, p5, p6, p7);
	}
	
	@ParameterizedTest
	@MethodSource("inputLocations")
	public void testLocate(Point params) {
		if (params.getX() >= 0 && params.getY() >= 0) {
			given(service.geoLocate(any())).willReturn(params);
		}
		
		Point point = locator.locate(params.getX(), params.getY());
		
		int actualX = Math.abs(point.getX());
		int actualY = Math.abs(point.getY());
		assertTrue(point.getX() == actualX && point.getY() == actualY);
	}

}
