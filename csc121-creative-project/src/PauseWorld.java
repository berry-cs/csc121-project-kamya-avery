import processing.core.PApplet;
import processing.event.KeyEvent;

public class PauseWorld implements IWorld {

	SuperDashWorld w;

	public PauseWorld(SuperDashWorld w) {
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
		
		p.text("PAUSED", 200, 200);
		
		return p;
	}

	@Override
	public IWorld keyPressed(KeyEvent kev) {
		if (kev.getKey() == 'p') {
			return this.w;
		} else {
			return this;
		}
	}
	
	
	
}
