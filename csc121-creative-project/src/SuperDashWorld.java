import java.util.Objects;

import processing.core.PApplet;
import processing.core.PImage;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

/**
 * Represents an interactive application where a drop of
 * water falls down from the top of the window. If the 
 * user clicks the mouse, the drop is moved over to the
 * location of the click;
 */
public class SuperDashWorld  implements IWorld {
	
    // the position of the drop
    private Player p1;
    private ILoO obs;
    private double generateRate = 0.01;  // the probability of a new obstacle appearing on each update


    public SuperDashWorld(Player p1, ILoO obs) {
		super();
		this.p1 = p1;
		this.obs = obs;
	}

	/** 
     * Updates the state of this world
     */
    public IWorld update() {
    	
    	if ( this.obs.anyCollided(p1.getLoc()) ) {
    		return new EndWorld(new SuperDashWorld(p1, obs) ,obs);
    	} else if ( Math.random() < this.generateRate ) {
    		return new SuperDashWorld(p1.update(), new ConsLoO(new Obstacle(), this.obs));
    	} else {
    		return new SuperDashWorld(p1.update(), this.obs.update().removeEscaped());
    	}
    	
    }
    
    /**
     * Renders a picture of the drop on the window
     */
    public PApplet draw(PApplet p) {
    	
    	PImage img = p.loadImage("super-hero.png");
        p.background(0,125,225);
        p.textSize(20);
        p.text("Super Dash", 160, 25);
        p.fill(255);
        p.image(img, p1.getX(p1.getLoc()), p1.getY(p1.getLoc()), 50, 40);
       
        this.obs.draw(p);
        
        return p;
        
    }
    
    public IWorld keyPressed(KeyEvent kev) {
    	
    	if (kev.getKeyCode() == PApplet.UP && p1.getLoc().getY() > 0) {
    		
    		if ( p1.getSpeed() > 0 ) {
    			p1.setSpeed(-p1.getSpeed());
    			return new SuperDashWorld(this.p1.addToSpeed(-1), this.obs);
    		} else {
    			return new SuperDashWorld(this.p1.addToSpeed(-1), this.obs);
    		}
            
    	} else if (kev.getKeyCode() == PApplet.DOWN && p1.getLoc().getY() < 400) {  // means the player is going DOWN currently
    		
    		if ( p1.getSpeed() < 0 ) {
    			p1.setSpeed(-p1.getSpeed());
    			return new SuperDashWorld(this.p1.addToSpeed(1), this.obs);
    		} else {
    			return new SuperDashWorld(this.p1.addToSpeed(1), this.obs);
    		}
    		
        } else if (kev.getKey() == 'p') {
        	
        	return new PauseWorld(this);
        
        } else if (this.obs.anyCollided(p1.getLoc())) { 
        	
        	return new EndWorld(this, obs);
        	
        } else {
        	
            return this;
            
        }
    	
    }

	@Override
	public int hashCode() {
		return Objects.hash(generateRate, obs, p1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SuperDashWorld other = (SuperDashWorld) obj;
		return Double.doubleToLongBits(generateRate) == Double.doubleToLongBits(other.generateRate)
				&& Objects.equals(obs, other.obs) && Objects.equals(p1, other.p1);
	}

	@Override
	public String toString() {
		return "SuperDashWorld [p1=" + p1 + ", obs=" + obs + ", generateRate=" + generateRate + "]";
	}
	
}