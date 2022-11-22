package org.ssglobal.training.codes.item4.test;
import static org.mockito.BDDMockito.given;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.ssglobal.training.codes.item4.Locator;

@ExtendWith(MockitoExtension.class)
public class TestPoint {
	
	@Mock
	private Locator locator;
	
	@Test
	public void testLocate() {
		given(locator.locate(-101, 100));
	}
}
