package org.ssglobal.training.codes.item4.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.ssglobal.training.codes.item4.Locator;
import org.ssglobal.training.codes.item4.Point;

import static org.mockito.BDDMockito.given;
@ExtendWith(MockitoExtension.class)
public class TestLocator {

	
	@Mock
	private Locator l;
	
	@Test
	public void testLocate() {
		int x = -101;
		int y = 100;
		given(l.locate(x, y)).willReturn(Point(Math.abs(x), Math.abs(y)));
		
	}
}
