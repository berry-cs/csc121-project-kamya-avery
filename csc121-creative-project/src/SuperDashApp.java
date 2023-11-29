import processing.core.*;
import processing.event.*;

/**
 * Provides the scaffolding to launch a Processing application
 */
public class SuperDashApp extends PApplet {
    IWorld w;
    
    public void settings() {
        this.size(400, 400);
    }
    
    public void setup() {
    	w = new StartWorld();
    }
    
    public void draw() {
        w = w.update();
    	w.draw(this);
    }
    
    public void keyPressed(KeyEvent kev) {
        w = w.keyPressed(kev);
    }

    public static void main(String[] args) {
        PApplet.runSketch(new String[] { "SuperDashApp" }, new SuperDashApp());
    }
}
