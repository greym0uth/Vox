package net.vox;

import net.vox.entity.Entity;
import processing.core.PApplet;

public class Vox extends PApplet {
	
	private static final long serialVersionUID = -9168611845843958739L;
	
	public static Entity e;
	
	public boolean right, left;
	
	// Variable for testing if something worked
	boolean passed;
	
	public static void main(String[] args) {
		PApplet.main("net.vox.Vox");
	}
	
	public Vox() {
	}
	
	// Loads Entities, sets window size, sets window title
	public void setup() {
		e = new Entity();
		
		size(1280, 720);
		frame.setTitle("Vox Loading...");
		
		passed = e.initialize(this, this);
		if (!passed)
			System.out.println("Failed to load entities...");
	}
	
	// Limit to 60 frames, updates Entities
	public void draw() {
		frame.setTitle("Vox Frames:" + (int) (frameRate));
		background(0);
		
		e.update();
		
		frameRate(60);
	}
	
	public void keyPressed() {
		if (key == 'd' || key == 'D')
			right = true;
		if (key == 'a' || key == 'A')
			left = true;
	}
	
	public void keyReleased() {
		if (key == 'd' || key == 'D')
			right = false;
		if (key == 'a' || key == 'A')
			left = false;
	}
	
	public boolean getRight() {
		return right;
	}
	
	public boolean getLeft() {
		return left;
	}

}
