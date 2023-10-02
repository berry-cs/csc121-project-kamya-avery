import java.util.Objects;

import processing.core.*;
import processing.event.KeyEvent;

import processing.core.PApplet;

public class Obstacle {
	
	Posn loc;
	
	
	public Obstacle(Posn loc) {
        this.loc = loc;
    }

    /**
     * Renders a picture of the drop on the window
     */
    public PApplet draw(PApplet p) {
        p.fill(255);
        p.circle((int)this.loc.getX(), (int)this.loc.getY(), 15);
        return p;
    }
    
    /**
     * Produces an updated world where the obstacle moves
     * across the screen a little bit, if it hasn't hit 
     * the left side of the screen yet.
     */
    
    public Obstacle update() {        
    	
    	if (this.loc.getX() > 0) {
            return new Obstacle(this.loc.translate(new Posn(-0.5f, 0)));
        } else {
            return this;
        }
    	
    }

    @Override
    public int hashCode() {
        return Objects.hash(loc);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Obstacle other = (Obstacle) obj;
        return Objects.equals(loc, other.loc);
    }

    @Override
    public String toString() {
        return "Obstacle [loc=" + loc + "]";
    }
    

}
