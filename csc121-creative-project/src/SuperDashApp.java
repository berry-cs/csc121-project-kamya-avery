import processing.core.*;
import processing.event.*;

/**
 * Provides the scaffolding to launch a Processing application
 */
public class SuperDashApp extends PApplet {
    SuperDashWorld w;
    
    public void settings() {
        this.size(400, 400);
    }
    
    public void setup() {
    	w = new SuperDashWorld(new Player(new Posn(50, 200)), new Obstacle(new Posn(400, 100)));
    }
    
    public void draw() {
        w = w.update();
    	w.draw(this);
    }
    
    public void mousePressed(MouseEvent mev) {
    	//w = w.mousePressed(mev);
    }
    
    public void keyPressed(KeyEvent kev) {
        w = w.keyPressed(kev);
    }

    public static void main(String[] args) {
        PApplet.runSketch(new String[] { "SuperDashApp" }, new SuperDashApp());
    }
}
