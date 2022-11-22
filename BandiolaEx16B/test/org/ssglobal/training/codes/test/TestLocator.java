package org.ssglobal.training.codes.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.ssglobal.training.codes.item4.Locator;
import org.ssglobal.training.codes.item4.LocatorService;
import org.ssglobal.training.codes.item4.Point;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class TestLocator {
	@Mock
	private LocatorService service;

	@InjectMocks
	private Locator locator;

	@ParameterizedTest
	@MethodSource("locationProvider")
	public void testLocate(Point p) {
		given(service.geoLocate(any())).willReturn(new Point(p.getX(), p.getY()));
		Point actual = locator.locate(p.getX(), p.getY());
		// since the locate() function must return absolute value of points
		// we check if the function really returns absolute value of points
		assertAll("testLocate", () -> assertTrue(actual.getX() >= 0), () -> assertTrue(actual.getY() >= 0));
	}

	private static Stream<Arguments> locationProvider() {
		return Stream.of(Arguments.of(new Point(-101, 100)), Arguments.of(new Point(20, 90)),
				Arguments.of(new Point(110, -100)), Arguments.of(new Point(10, -5)), Arguments.of(new Point(0, 0)),
				Arguments.of(new Point(-90, 90)), Arguments.of(new Point(-201, -100)));
	}
}