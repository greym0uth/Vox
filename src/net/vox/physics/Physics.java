package net.vox.physics;

import processing.core.PVector;

public class Physics {
	
	private PVector Velocity = new PVector(0, 0);
	private PVector Drag = new PVector(2, 0);
	private PVector Gravity = new PVector(0, 2);
	private boolean grounded = true;

	public Physics() {
	}

	public PVector getVelocity() {
		return this.Velocity;
	}
	
	public int getXVelocity() {
		return (int) Velocity.x;
	}
	
	public void setXVelocity(int x) {
		Velocity.x = x;
	}
	
	public int getYVelocity() {
		return (int) Velocity.y;
	}
	
	public void setYVelocity(int y) {
		Velocity.y = y;
	}

	public void setVelocity(PVector velocity) {
		Velocity = velocity;
	}
	
	public void addVelocity(PVector v) {
		Velocity.add(v);
	}

	public int getDragX() {
		return (int) Drag.x;
	}

	public PVector getGravity() {
		return Gravity;
	}

	public void setGravity(PVector gravity) {
		Gravity = gravity;
	}

	public boolean isGrounded() {
		return grounded;
	}

	public void setGrounded(boolean grounded) {
		this.grounded = grounded;
	}

}
