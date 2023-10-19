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
		
		p.textSize(20);
		p.text("|  |", 190, 200);
		
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
