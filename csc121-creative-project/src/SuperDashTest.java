import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import processing.event.*;

class SuperDashTest {

	Player tp1 = new Player(new Posn(50, 200));
	
    Obstacle cw1 = new Obstacle(new Posn(100, 150));
    Obstacle cw2 = new Obstacle(new Posn(200, 150));
    Obstacle cw3 = new Obstacle(new Posn(200, 250));
    Obstacle cw4 = new Obstacle(new Posn(300, 100));
    Obstacle cw5 = new Obstacle(new Posn(100, 250));
    
    ILoO mtloo = new MTLoO();
    ILoO oL1 = new ConsLoO(this.cw1, new ConsLoO(this.cw2, new ConsLoO(this.cw3, mtloo)));
    
    @Test
    void testUpdateObstacle() {        
        
        assertEquals(new Obstacle(new Posn(99.5f, 150)), cw1.update());
        
        
        //assertEquals("[101.0, 150.0]", cw1.update().update().toString());
        
        //assertEquals("[200.0, 135.0]", cw1.mousePressed(new MouseEvent(null, 1, 0, 0, 200, 135, 0, 1)).toString());
    }

}
