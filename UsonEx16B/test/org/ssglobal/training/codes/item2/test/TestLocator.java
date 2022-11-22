package org.ssglobal.training.codes.item2.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.ssglobal.training.codes.item2.Locator;
import org.ssglobal.training.codes.item2.LocatorService;

@ExtendWith(MockitoExtension.class)
public class TestLocator {

	@Mock
	private Locator locator;
	
	@InjectMocks
	private LocatorService service;
	
	@Test
	public void testLocate() {
		
	}
	
}
