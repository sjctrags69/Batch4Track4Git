package org.ssglobal.training.codes;

import org.junit.jupiter.api.Test;

public class TestXMLParse {
	
	@Test
	public void testGetAllFirstnames() {
		XMLParse parse = new XMLParse();
		parse.getAllFirstNames("./src/config/employee.xml");
	}

}
