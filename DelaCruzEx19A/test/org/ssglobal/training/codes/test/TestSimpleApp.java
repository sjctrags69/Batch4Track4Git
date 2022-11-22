package org.ssglobal.training.codes.test;

import static org.junit.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.ssglobal.training.codes.SimpleApp;

public class TestSimpleApp {
	
	private static Logger logger = LogManager.getLogger("simpleapp");
	
	@RepeatedTest(10)
	public void testApp() {
		logger.info("testApp");
		SimpleApp app = new SimpleApp();
		assertTrue("app didn't return 1", app.returnOne() == 1);
	}
}