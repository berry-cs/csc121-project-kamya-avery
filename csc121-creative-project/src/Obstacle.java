import processing.core.*;
import processing.event.KeyEvent;

import processing.core.PApplet;

public class Obstacle {
	
	double x;
	double y;
	
	public Obstacle(double x, double y) {
        this.x = x;
        this.y = y; 
    }
	
	/**
     * Renders a picture of the drop on the window
     */
    public PApplet draw(PApplet p) {
        p.fill(255);
        p.circle((int)this.x, (int)this.y, 15);
        return p;
    }
    
    /**
     * Produces an updated world where the drop moves
     * down a little bit, if it hasn't hit the bottom
     * of the screen yet.
     */
    
    public Obstacle update() {
    	
    	if (this.x > 0) {
            return new Obstacle(this.x - .5, this.y);
        } else {
            return this;
        }
    	
    }
    
}
