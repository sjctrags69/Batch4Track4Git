package org.ssglobal.training.codes.item4.test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.ssglobal.training.codes.item4.Point;
import org.ssglobal.training.codes.item4.PointGeneration;
import org.ssglobal.training.codes.item4.Utils;

@ExtendWith(MockitoExtension.class)
public class TestPointGeneration {

	@Mock
	private PointGeneration gen;

	@ParameterizedTest
	@MethodSource("createParams")
	public void testCallPrivateMethod(PointParams params) {
		// Stubbing (Given)
		int dist = params.getDist();
		Point p1 = new Point(params.getxParam() + Utils.randomDistance(dist),
				params.getyParam() + Utils.randomDistance(dist));
		given(gen.callPrivateMethod(anyInt())).willReturn(p1);

		// Execution (When)
		Point res = gen.callPrivateMethod(dist);

		assertTrue(res.getX() >= params.getxParam() - dist && res.getX() <= params.getxParam() + dist);
		assertTrue(res.getY() >= params.getyParam() - dist && res.getY() <= params.getyParam() + dist);

		// verification
		verify(gen, times(1)).callPrivateMethod(anyInt());

	}

	public static Stream<PointParams> createParams() {
		return Stream.of(new PointParams(-10, -74, 10), new PointParams(-120, -90, 10), new PointParams(110, -100, 10),
				new PointParams(110, -5, 10), new PointParams(1, 1, 10), new PointParams(10, 80, 10),
				new PointParams(11, -50, 10));
	}
}
