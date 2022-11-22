package org.ssglobal.training.codes.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.ssglobal.training.codes.item4.Locator;
import org.ssglobal.training.codes.item4.LocatorService;
import org.ssglobal.training.codes.item4.Point;
import org.ssglobal.training.codes.item4.PointGeneration;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class TestPointGeneration {
	@Mock
	private LocatorService service;

	@InjectMocks
	private PointGeneration pointGen;

	@ParameterizedTest
	@MethodSource("locationProvider")
	public void testLocate(Point p) {
		given(LocatorService.generatePointWithinDistance(any(Point.class), anyInt()))
				.willReturn(new Point(p.getX(), p.getY()));
		Point actual = pointGen.callPrivateMethod(1);
		assertAll("testLocate", () -> assertTrue(actual.getX() >= 0), () -> assertTrue(actual.getY() >= 0));
	}

	private static Stream<Arguments> locationProvider() {
		return Stream.of(Arguments.of(new Point(-10, -74)), Arguments.of(new Point(-120, -90)),
				Arguments.of(new Point(110, -100)), Arguments.of(new Point(110, -5)), Arguments.of(new Point(1, 1)),
				Arguments.of(new Point(10, 80)), Arguments.of(new Point(11, -50)));
	}
}
