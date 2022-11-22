package org.ssglobal.training.codes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ChekcStr {
	
	private static Logger logger = LogManager.getLogger("checkstr");
	
	public ChekcStr() {
		
	}

	public String convert(String str) {
		String temp = "";
		try {
			return binarise(total(str));
		}catch(Exception e) {
			logger.info("Invalid Value !!");
		}
		return temp;
	}

	public int total(String str) {
		try {
			if (str == "")
				return 0;
			if (str.length() == 1)
				return ((int) (str.charAt(0)));
			return ((int) (str.charAt(0))) + total(str.substring(1));
		}catch(Exception e) {
			logger.info("Invalid Value !!");
		}
		return 0;
	

	}

	public String binarise(int givenstrvalue) {
		String temp = "";
		try {
			if (givenstrvalue == 0)
				return "";
			if (givenstrvalue % 2 == 1)
				return "1" + binarise(givenstrvalue / 2);
			return "0" + binarise(givenstrvalue / 2);
		}catch(Exception e) {
			logger.info("Invalid Value !!");
		}
		return temp;
	
	}
}