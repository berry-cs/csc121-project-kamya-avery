import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import processing.event.*;

class SuperDashTest {

    Obstacle cw1 = new Obstacle(new Posn(100, 150));
    
    @Test
    void testUpdateObstacle() {        
        
        assertEquals(new Obstacle(new Posn(99.5f, 150)), cw1.update());
        
        
        //assertEquals("[101.0, 150.0]", cw1.update().update().toString());
        
        //assertEquals("[200.0, 135.0]", cw1.mousePressed(new MouseEvent(null, 1, 0, 0, 200, 135, 0, 1)).toString());
    }

}
