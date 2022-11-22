package org.fujitsu.training.codes;

public class Algebra {
	private Mathematics math;
	
	public Algebra(Mathematics math) {
		this.math = math;
	}
	
	public int getExpression(int x, int y) {
		return  2000 + math.div(x, y) + math.div(x, y);
	}

}
