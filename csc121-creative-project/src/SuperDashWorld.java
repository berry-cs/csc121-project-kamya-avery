import processing.core.PApplet;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

/**
 * Represents an interactive application where a drop of
 * water falls down from the top of the window. If the 
 * user clicks the mouse, the drop is moved over to the
 * location of the click;
 */
public class SuperDashWorld {
	
    // the position of the drop
    Player p1;
    Obstacle o1;


    public SuperDashWorld(Player p1, Obstacle o1) {
    	
        this.p1 = p1; 
        this.o1 = o1;
        
    }
    
    /** 
     * Updates the state of this world
     */
    
    public SuperDashWorld update() {
    	
        return new SuperDashWorld(p1, this.o1.update());
        
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
       
        o1.draw(p);
        
        return p;
        
    }
    
    public SuperDashWorld keyPressed(KeyEvent kev) {
    	
    	if (kev.getKeyCode() == PApplet.UP) {
    		
            return new SuperDashWorld(this.p1.update(-0.5f), this.o1);
            
    	} else if (kev.getKeyCode() == PApplet.DOWN){
    		
    		return new SuperDashWorld(this.p1.update(0.5f), this.o1);
    		
        } else {
        	
            return this;
            
        }
    	
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
    
    @Override
	public String toString() {
    	
		return "SuperDashWorld [p1=" + p1 + ", o1=" + o1 + "]";
		
	}
    
}