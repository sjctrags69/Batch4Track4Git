package org.ssglobal.training.codes.item4.test;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.ssglobal.training.codes.item4.LocatorService;
import org.ssglobal.training.codes.item4.Point;
import org.ssglobal.training.codes.item4.PointGeneration;
import org.ssglobal.training.codes.item4.Utils;
import static org.mockito.BDDMockito.given;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
public class TestPointGeneration {
	
	@Mock 
	private PointGeneration generator;
	
	@InjectMocks
	private LocatorService service;
	
	private static Stream<Point> input(){
		Point p1 = new Point(-10, -74);
		Point p2 = new Point(-120, -90);
		Point p3 = new Point(110, -100);
		Point p4 = new Point(110, -5);
		Point p5 = new Point(1, 1);
		Point p6 = new Point(10, 80);
		Point p7 = new Point(11, -50);
		return Stream.of(p1, p2, p3, p4, p5, p6, p7);
	}
	
	@ParameterizedTest
	@MethodSource("input")
	public void testCallPrivateMethod(Point params) {
		int d = Utils.randomDistance(50);
		Point temp = new Point(params.getX() + d, params.getY() + d);
		given(generator.callPrivateMethod(anyInt())).willReturn(temp);

		Point point = generator.callPrivateMethod(d);
		int actualX = params.getX() + d;
		int actualY = params.getY() + d;
		assertTrue(point.getX() == actualX && point.getY() == actualY);
	}
	
}
