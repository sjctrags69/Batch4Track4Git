package org.ssglobal.training.codes;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FunList {
	private BufferedReader bufferedReader;

	public FunList(String filename) {
		Path path = Paths.get(filename);
		try {
			this.bufferedReader = Files.newBufferedReader(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public long countWords() {
		return this.bufferedReader.lines().map((str)->{
			   return str.split("");
		}).count();
	}

}
