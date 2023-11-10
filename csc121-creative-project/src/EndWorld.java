import processing.core.PApplet;
import processing.core.PImage;
import processing.event.KeyEvent;

public class EndWorld implements IWorld {

	private SuperDashWorld w;
	private Player p;
	private ILoO obs;
	

	public EndWorld(SuperDashWorld w, ILoO obs) {
		super();
		this.w = w;
		this.obs = obs;
	}
	
	@Override
	public IWorld update() {
		
		return this;
		
	}

	@Override
	public PApplet draw(PApplet p) {
		w.draw(p);
		
		p.textSize(50);
		p.text("Game Over", 100, 200);
		
		return p;
	}
	
	public IWorld keyPressed(KeyEvent kev) {
		
		if (kev.getKey() == 'r' && obs.anyCollided(p.getLoc())) {
			return  new SuperDashWorld(new Player(new Posn(50, 200)), new MTLoO(), 0);
        } else {
            return this;
		}
		
	}
	
}