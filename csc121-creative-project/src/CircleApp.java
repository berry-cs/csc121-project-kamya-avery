import processing.core.*;
import processing.event.*;

/**
 * Provides the scaffolding to launch a Processing application
 */
public class CircleApp extends PApplet {
    CircleWorld b1;
    Obstacle p1;
    
    public void settings() {
        this.size(400, 400);
    }
    
    public void setup() {
    	b1 = new CircleWorld(50, 200);
    	p1 = new Obstacle(400, 100);
    }
    
    public void draw() {
    	p1 = p1.update();
    	b1.draw(this);
    	p1.draw(this);
    }
    
    public void mousePressed(MouseEvent mev) {
    	//b1 = b1.mousePressed(mev);
    }
    
    public void keyPressed(KeyEvent kev) {
        b1 = b1.keyPressed(kev);
    }

    public static void main(String[] args) {
        PApplet.runSketch(new String[] { "CircleApp" }, new CircleApp());
    }
}
