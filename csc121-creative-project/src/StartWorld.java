import processing.core.PApplet;
import processing.event.KeyEvent;

public class StartWorld implements IWorld {

	@Override
	public IWorld update() {
		return this;
	}

	@Override
	public PApplet draw(PApplet p) {
		p.background(200);
		p.text("Press spacebar to start", 200, 200);
		return p;
	}

	@Override
	public IWorld keyPressed(KeyEvent kev) {
		if (kev.getKey() == ' ') {
			return  new SuperDashWorld(new Player(new Posn(50, 200)), new MTLoO());
		} else {
			return this;
		}
	}

}
