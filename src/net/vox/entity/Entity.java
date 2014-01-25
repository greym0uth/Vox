package net.vox.entity;

import net.vox.Vox;
import net.vox.entity.player.Player;
import net.vox.physics.Physics;
import processing.core.PApplet;
import processing.core.PVector;

public class Entity {
	
	protected PApplet h;
	
	protected Physics phys;
	
	protected PVector location;
	protected int width, height;
	private PVector start = new PVector(0, 0);
	
	protected PVector moveRightForce = new PVector(2, 0);
	protected PVector moveLeftForce = new PVector(-2, 0);
	protected PVector moveRightForceAir = new PVector(1, 0);
	protected PVector moveLeftForceAir = new PVector(-1, 0);
	
	private Entity player;
	
	protected Vox vox;
	
	public Entity() {
		phys = new Physics();
	}
	
	// Initializes Entities
	public boolean initialize(PApplet host, Vox v) {
		vox = v;
		this.h = host;
		
		player = new Player();
		player.setLocation(start).setSize(20, 40);
		
		return true;
	}
	
	// Updates entities (Must draw within here)
	public void update() {
		if (player.phys.isGrounded()) {
			if (vox.getRight())
				player.applyForce(moveRightForce);
			else if (vox.getLeft())
				player.applyForce(moveLeftForce);
			
			if (!vox.getRight() && !vox.getLeft() && player.phys.getXVelocity() > 0)
				player.applyForce(new PVector(-player.phys.getDragX(), 0));
			else if (!vox.getRight() && !vox.getLeft() && player.phys.getXVelocity() < 0)
				player.applyForce(new PVector(player.phys.getDragX(), 0));
		}
		else if (!player.phys.isGrounded()) {
			player.applyForce(phys.getGravity());
			
			System.out.println(player.phys.getYVelocity());
			
			if (vox.getRight())
				player.applyForce(moveRightForceAir);
			else if (vox.getLeft())
				player.applyForce(moveLeftForceAir);
			
			if (!vox.getRight() && !vox.getLeft() && player.phys.getXVelocity() > 0)
				player.applyForce(new PVector(-player.phys.getDragX(), 0));
			else if (!vox.getRight() && !vox.getLeft() && player.phys.getXVelocity() < 0)
				player.applyForce(new PVector(player.phys.getDragX(), 0));
		}
		
		player.update();
		
		h.rect(player.location.x, player.location.y, player.width, player.height);
	}

	// Gets location of entity
	public PVector getLocation() {
		return this.location;
	}

	// Sets location of entity
	public Entity setLocation(PVector location) {
		this.location = location;
		return this;
	}
	
	// Sets size of entity
	public Entity setSize(int w, int h) {
		this.width = w;
		this.height = h;
		return this;
	}
	
	public void applyForce(PVector v) {
		phys.addVelocity(v);
	}

}
