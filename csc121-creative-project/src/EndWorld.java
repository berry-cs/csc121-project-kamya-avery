import processing.core.PApplet;
import processing.core.PImage;
import processing.event.KeyEvent;

public class EndWorld implements IWorld {

	private SuperDashWorld w;
	

	public EndWorld(SuperDashWorld w) {
		super();
		this.w = w;
	}
	
	@Override
	public IWorld update() {
		
		return this;
		
	}

	@Override
	public PApplet draw(PApplet p) {
		w.draw(p);
		
		p.textSize(50);
		p.text("Game Over", 90, 200);
		p.textSize(20);
		p.text("Press 'r' to restart", 130, 250);
		
		return p;
	}
	
	public IWorld keyPressed(KeyEvent kev) {
		
		if (kev.getKey() == 'r') {
			return  new SuperDashWorld(new Player(new Posn(50, 200)), new MTLoO(), 0);
        } else {
            return this;
		}
		
	}
	
}