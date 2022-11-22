package org.ssglobal.training.codes.item4.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.verify;

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
	private Locator loc;

	@ParameterizedTest
	@MethodSource("createParams")
	public void testLocate(PointParams params) {

		// stubbing (Given)
		Point p1 = new Point(params.getxParam(), params.getyParam());
		if (p1.getX() >= 0 && p1.getY() >= 0) {
			given(service.geoLocate(any())).willReturn(p1);
		}

		// execution (when)
		Point p = loc.locate(params.getxParam(), params.getyParam());

		int expectedPointx = Math.abs(params.getxParam());
		int expectedPointy = Math.abs(params.getyParam());

		assertEquals(expectedPointx, p.getX());
		assertEquals(expectedPointy, p.getY());

		// verification
		verify(service, atMost(1)).geoLocate(any());

	}

	public static Stream<PointParams> createParams() {
		return Stream.of(new PointParams(-101, 100, 0), new PointParams(20, 90, 0), new PointParams(110, -100, 0),
				new PointParams(10, -5, 0), new PointParams(0, 0, 0), new PointParams(-90, 90, 0),
				new PointParams(-201, -100, 0));
	}

}

class PointParams {
	private int xParam;
	private int yParam;
	private int dist;

	public PointParams(int xParam, int yParam, int dist) {

		this.xParam = xParam;
		this.yParam = yParam;
		this.dist = dist;
	}

	public int getxParam() {
		return xParam;
	}

	public int getyParam() {
		return yParam;
	}

	public int getDist() {
		return dist;
	}

}
