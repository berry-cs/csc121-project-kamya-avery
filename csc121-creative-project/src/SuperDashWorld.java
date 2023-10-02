import processing.core.PApplet;
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
    Player p1;
    ILoO obs;
    double generateRate = 0.01;  // the probability of a new obstacle appearing on each update


    public SuperDashWorld(Player p1, ILoO obs) {
		super();
		this.p1 = p1;
		this.obs = obs;
	}

	/** 
     * Updates the state of this world
     */
    
    public IWorld update() {
    	if (this.obs.anyCollided( p1.getLoc() )) {
    		return this;
    	} else if (Math.random() < this.generateRate) {
    		return new SuperDashWorld(p1, new ConsLoO(new Obstacle(), this.obs));
    		
    	} else {
    		return new SuperDashWorld(p1, this.obs.update().removeEscaped());
    	}
    }
    
    /**
     * Renders a picture of the drop on the window
     */
    
    public PApplet draw(PApplet p) {
    	
        p.background(0,125,225);
        p.textSize(20);
        p.text("Super Dash", 175, 25);
        p.fill(255);
        p.square(p1.loc.getX(), p1.loc.getY(), 15);
       
        this.obs.draw(p);
        //o1.draw(p);
        
        return p;
        
    }
    
    public IWorld keyPressed(KeyEvent kev) {
    	
    	if (kev.getKeyCode() == PApplet.UP) {
    		
            return new SuperDashWorld(this.p1.update(-5f), this.obs);
            
    	} else if (kev.getKeyCode() == PApplet.DOWN){
    		
    		return new SuperDashWorld(this.p1.update(5f), this.obs);
    		
        } else if (kev.getKey() == 'p') {
        	
        	return new PauseWorld(this);
        	
        } else {
        	
            return this;
            
        }
    	
    }

	@Override
	public String toString() {
		return "SuperDashWorld [p1=" + p1 + ", obs=" + obs + "]";
	}
    
    /**
     * Produces an updated world with the position of the
     * drop updated to the location of the mouse press.
     */
    /*
     * public CircleWorld mousePressed(MouseEvent mev) {
        return new CircleWorld(mev.getX(), mev.getY());
    }
    */
    
    /**
     * Produces a string rendering of the position of the
     * drop
     */
    
    
}