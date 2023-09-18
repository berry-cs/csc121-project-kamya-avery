import processing.core.PApplet;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

/**
 * Represents an interactive application where a drop of
 * water falls down from the top of the window. If the 
 * user clicks the mouse, the drop is moved over to the
 * location of the click;
 */
public class CircleWorld {
    // the position of the drop
    double x;
    double y;


    public CircleWorld(double x, double y) {
        this.x = x;
        this.y = y; 
    }
    
    /**
     * Renders a picture of the drop on the window
     */
    public PApplet draw(PApplet p) {
        p.background(0,125,225);
        p.textSize(20);
        p.text("Super Dash", 175, 25);
        p.fill(255);
        p.square((int)this.x, (int)this.y, 15);
        return p;
    }
    
    public CircleWorld keyPressed(KeyEvent kev) {
    	
    	if (kev.getKeyCode() == PApplet.UP) {
            return new CircleWorld(this.x, this.y - 5);
    	} else if (kev.getKeyCode() == PApplet.DOWN){
    		return new CircleWorld(this.x, this.y + 5);
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
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}