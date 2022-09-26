package cpm.epicode.patterns.composite2;

import java.util.ArrayList;

import java.util.List;

public class DrawingShape implements Drowble {
	
	List<Drowble> drawbles = new ArrayList<>();
	
	
	public void add(Drowble d) {
		drawbles.add(d);
	}

	@Override
	public void drow() {
		// TODO Auto-generated method stub
    
		 for (Drowble x : drawbles) {
			x.drow();
		}
	}

}
