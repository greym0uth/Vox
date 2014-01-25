package net.vox.entity.player;

import net.vox.entity.Entity;

public class Player extends Entity {

	public Player() {
		super();
	}
	
	// Updates player
	public void update() {
		/*
		 * move
		 * apply physics
		 * apply collisions
		 * finalize location
		 * render in Entity
		 */
		
		if (phys.getXVelocity() > 6)
			phys.setXVelocity(6);
		if (phys.getXVelocity() < -6)
			phys.setXVelocity(-6);
		
		if (phys.getYVelocity() > 16)
			phys.setYVelocity(16);
		
		location.add(phys.getVelocity());
		

	}

}
