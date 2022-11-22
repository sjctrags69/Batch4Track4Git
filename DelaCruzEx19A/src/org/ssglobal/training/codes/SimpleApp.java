package org.ssglobal.training.codes;

import org.apache.logging.log4j.Logger;

import org.apache.logging.log4j.LogManager;

public class SimpleApp {
	
	private static Logger logger = LogManager.getLogger("simpleapp");
	
	
	public int returnOne() {
		logger.info("Here's One!");
		return 1;
	}

	public static void main(String[] args) {
		logger.info("Hello World!");
	}
}

